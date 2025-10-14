package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Emprestimo;

@WebServlet("/Emprestimo")
public class EmprestimoServlet extends HttpServlet{
    protected Emprestimo preencherEntidade(HttpServletRequest request){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        emprestimo.setData_emprestimo(request.getParameter("nome"));
        return emprestimo;
    }
}
