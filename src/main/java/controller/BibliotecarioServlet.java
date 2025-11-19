package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Bibliotecario;

/**
 * Para acessar o formulário de cadastro:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=novo
 * Para listar todos os alunos:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=listar
 * Para editar um aluno (supondo que o ID seja 1):
 * http://localhost:8080/AppCorporativaWeb/livro?acao=buscar&id=1
 */
@WebServlet("/bibliotecario")
public class BibliotecarioServlet extends GenericServlet<Bibliotecario>{
    
    @Override
    protected Bibliotecario preencherEntidade(HttpServletRequest request) {
        Bibliotecario bibliotecario = new Bibliotecario();
        String id = request.getParameter("id");
        bibliotecario.setId(id != null && !id.isEmpty() ? Integer.parseInt(id) : null);
        bibliotecario.setNome(request.getParameter("nome"));
        bibliotecario.setEmail(request.getParameter("email"));
        return bibliotecario;
    }
}
