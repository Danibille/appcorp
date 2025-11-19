package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Editora;

/**
 * Para acessar o formulário de cadastro:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=novo
 * Para listar todos os alunos:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=listar
 * Para editar um aluno (supondo que o ID seja 1):
 * http://localhost:8080/AppCorporativaWeb/livro?acao=buscar&id=1
 */
@WebServlet("/editora")
public class EditoraServlet extends GenericServlet<Editora> {

    @Override
    protected Editora preencherEntidade(HttpServletRequest request) {
        Editora editora = new Editora();
        String id = request.getParameter("id");
        editora.setId(id != null && !id.isEmpty() ? Integer.parseInt(id) : null);
        editora.setNome(request.getParameter("nome"));
        return editora;
    }
}