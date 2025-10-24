package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Genero;

/**
 * Para acessar o formulário de cadastro:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=novo
 * Para listar todos os alunos:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=listar
 * Para editar um aluno (supondo que o ID seja 1):
 * http://localhost:8080/AppCorporativaWeb/livro?acao=buscar&id=1
 */
@WebServlet("/genero")
public class GeneroServlet extends GenericServlet<Genero>{

    @Override
    protected Genero preencherEntidade(HttpServletRequest request) {
        Genero genero = new Genero();
        String id = request.getParameter("id");
        genero.setId(id != null && !id.isEmpty() ? Integer.parseInt(id) : null);
        genero.setGenero(request.getParameter("nome"));
        return genero;
    }
}
