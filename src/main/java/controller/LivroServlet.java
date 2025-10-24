package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Livro;

/**
 * Para acessar o formulário de cadastro:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=novo
 * Para listar todos os alunos:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=listar
 * Para editar um aluno (supondo que o ID seja 1):
 * http://localhost:8080/AppCorporativaWeb/livro?acao=buscar&id=1
 */
@WebServlet("/livro")
public class LivroServlet extends GenericServlet<Livro> {

    @Override
    protected Livro preencherEntidade(HttpServletRequest request) {
        Livro livro = new Livro();
        String id = request.getParameter("id");
        livro.setId(id != null && !id.isEmpty() ? Integer.parseInt(id) : null);
        livro.setTitulo(request.getParameter("titulo"));
        livro.setAutor(request.getParameter("autor"));
        return livro;
    }
}
