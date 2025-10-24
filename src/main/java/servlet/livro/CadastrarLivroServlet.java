package servlet.livro;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EditoraDao;
import dao.GeneroDao;
import dao.LivroDao;
import model.Editora;
import model.Genero;
import model.Livro;

@WebServlet("/CadastrarLivro")
public class CadastrarLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String titulo = request.getParameter("titulo");
        Integer idEditora = Integer.parseInt(request.getParameter("editoraId"));
        Integer idGenero = Integer.parseInt(request.getParameter("generoId"));
        String autor = request.getParameter("autor");

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);

        EditoraDao editoraDao = new EditoraDao();
        Editora editora = editoraDao.buscarPorId(idEditora);
        livro.setEditora(editora);

        GeneroDao generoDao = new GeneroDao();
        Genero genero = generoDao.buscarPorId(idGenero);
        livro.setGenero(genero);

        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        LivroDao livrodao = new LivroDao();

        livrodao.salvar(livro, null);

        RequestDispatcher rd = request.getRequestDispatcher("livro/cadastro-sucesso.jsp");

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("id") != null && request.getParameter("acao").equals("cadastrar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            LivroDao livroDao = new LivroDao();
            request.setAttribute("livro", livroDao.buscarPorId(id));
        }

        EditoraDao editoraDao = new EditoraDao();
        List<Editora> editoras;

        editoras = editoraDao.listarTodos();
        request.setAttribute("editoras", editoras);
        
        GeneroDao generoDao = new GeneroDao();
        List<Genero> generos;

        generos = generoDao.listarTodos();
        request.setAttribute("generos", generos);

        RequestDispatcher rd = request.getRequestDispatcher("livro/livro-form.jsp");
        rd.forward(request, response);
    }
}