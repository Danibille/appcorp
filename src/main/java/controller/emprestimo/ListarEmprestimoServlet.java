package controller.emprestimo;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EmprestimoDao;
import model.Emprestimo;

@WebServlet("/ListarEmprestimos")
public class ListarEmprestimoServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        List<Emprestimo> emprestimos = emprestimoDao.listarTodos();
        request.setAttribute("emprestimos", emprestimos);
        RequestDispatcher rd = request.getRequestDispatcher("emprestimo/emprestimo-listar.jsp");
        rd.forward(request, response);
    }
}
