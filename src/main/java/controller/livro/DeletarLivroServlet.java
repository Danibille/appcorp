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

@WebServlet("/DeletarLivroServlet")
public class DeletarLivroServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LivroDao livroDao = new LivroDao();
        Integer id = Integer.parseInt(request.getParameter("id"));
        livroDao.deletar(id);
        List<Livro> livros = livroDao.listarTodos();
        request.setAttribute("livros", livros);
        RequestDispatcher rd = request.getRequestDispatcher("livro/livro-listar.jsp");
        rd.forward(request, response);
    }
}

