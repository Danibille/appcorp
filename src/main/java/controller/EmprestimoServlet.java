package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Emprestimo;

/**
 * Para acessar o formulário de cadastro:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=novo
 * Para listar todos os alunos:
 * http://localhost:8080/AppCorporativaWeb/livro?acao=listar
 * Para editar um aluno (supondo que o ID seja 1):
 * http://localhost:8080/AppCorporativaWeb/livro?acao=buscar&id=1
 */
@WebServlet("/emprestimo")
public class EmprestimoServlet extends GenericServlet<Emprestimo>{

    @Override
    protected Emprestimo preencherEntidade(HttpServletRequest request) {
        Emprestimo emprestimo = new Emprestimo();
        String id = request.getParameter("id");
        emprestimo.setId(id != null && !id.isEmpty() ? Integer.parseInt(id) : null);
        emprestimo.setData_emprestimo(Integer.parseInt(request.getParameter("data_emprestimo")));
        return emprestimo;
    }
}
