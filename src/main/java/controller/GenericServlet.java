package controller;

import jakarta.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import dao.EditoraDao;
import dao.GenericDAO;
import dao.GeneroDao;
import dao.LivroDao;
import model.Editora;
import model.Entidade;
import model.Genero;
import model.Livro;
import model.Usuario;

public abstract class GenericServlet<T extends Entidade> extends HttpServlet {

    protected GenericDAO<T> dao;
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public GenericServlet() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.dao = new GenericDAO<T>(clazz) {
        };
    }

    // método utilitário para pegar o usuário logado
    protected Usuario getUsuarioLogado(HttpServletRequest request) {
        return (Usuario) request.getSession().getAttribute("usuarioLogado");
    }

    // método abstrato que cada servlet concreto implementa
    protected abstract T preencherEntidade(HttpServletRequest request);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String acao = request.getParameter("acao");
        if (acao == null)
            acao = "listar"; // comportamento padrão
        Usuario usuario = getUsuarioLogado(request);
        String urlSubmit = request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase();
        request.setAttribute("urlSubmit", urlSubmit);

        if (usuario == null) {
            /**
             * Implementar redirecionamento para página de acesso negado. Faremos mais para
             * frente
             * response.sendRedirect("acesso-negado.jsp");
             * return;
             */
        }
        try {
            switch (acao) {
                case "deletar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.deletar(id);
                    response.sendRedirect(urlSubmit + "?acao=listar");
                    break;

                case "listar":
                    List<T> lista = dao.listarTodos();
                    request.setAttribute("lista", lista);
                    try {
                        request.getRequestDispatcher("/" + clazz.getSimpleName().toLowerCase() + "/listar.jsp")
                                .forward(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "buscar":
                    int idBuscar = Integer.parseInt(request.getParameter("id"));
                    T entidade = dao.buscarPorId(idBuscar);
                    request.setAttribute("entidade", entidade);
                    try {
                        request.getRequestDispatcher("/" + clazz.getSimpleName().toLowerCase() + "/form.jsp")
                                .forward(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "novo":
                    try {
                        // Se for o formulário de livro, carrega os editora e genero disponíveis e se for emprestimo, carrega os livros
                        if (clazz.getSimpleName().equals("Livro")) {
                            EditoraDao editoraDao = new EditoraDao();
                            List<Editora> editoras = editoraDao.listarTodos();
                            request.setAttribute("editoras", editoras);

                            GeneroDao generoDao = new GeneroDao();
                            List<Genero> generos = generoDao.listarTodos();
                            request.setAttribute("generos", generos);
                        } else if (clazz.getSimpleName().equals("Emprestimo")){
                            LivroDao livroDao = new LivroDao();
                            List<Livro> livros = livroDao.listarTodos();
                            request.setAttribute("livros", livros);
                        }
                        request.getRequestDispatcher("/" + clazz.getSimpleName().toLowerCase() + "/form.jsp")
                                .forward(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String acao = request.getParameter("acao");
        Usuario usuario = getUsuarioLogado(request);
        String urlSubmit = request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase();
        request.setAttribute("urlSubmit", urlSubmit);
        try {
            switch (acao) {
                case "cadastrar":
                    T entidade = preencherEntidade(request);
                    dao.salvar(entidade, usuario);
                    break;
                case "editar":
                    T entidadeAtualizada = preencherEntidade(request);
                    dao.atualizar(entidadeAtualizada, usuario);
                    break;
            }
            response.sendRedirect(urlSubmit + "?acao=listar");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}