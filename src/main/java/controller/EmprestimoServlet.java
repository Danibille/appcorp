package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Emprestimo;
import dao.EmprestimoDao;

@WebServlet("/Emprestimo")
public class EmprestimoServlet extends HttpServlet{
    private static final long serialVersionUID = 4L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String data_emprestimo = request.getParameter("data_emprestimo");

        Emprestimo emprestimo = new Emprestimo (data_emprestimo);

        EmprestimoDao emprestimoDao = new EmprestimoDao();
        try {
            emprestimoDao.inserir(emprestimo);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        EmprestimoDao editoraDao = new EmprestimoDao();
        List<Emprestimo> emprestimos;
        try {
            emprestimos = editoraDao.listar();
            request.setAttribute("emprestimos", emprestimos);
            RequestDispatcher rd = request.getRequestDispatcher("emprestimo-listar.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
