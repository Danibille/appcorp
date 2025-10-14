package controller.livro;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.LivroDao;
import model.Livro;

@WebServlet("/ListarLivroServlet")
public class ListarLivroServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LivroDao LivroDao = new LivroDao();
        List<Livro> livros = LivroDao.listarTodos();
        request.setAttribute("livros", livros);
        RequestDispatcher rd = request.getRequestDispatcher("livro/listar-livro.jsp");
        rd.forward(request, response);
    }
}