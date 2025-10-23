package controller.genero;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Genero;
import dao.GeneroDao;

@WebServlet("/ListarGenero")
public class ListarGeneroServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneroDao generoDao = new GeneroDao();
        List<Genero> generos = generoDao.listarTodos();
        request.setAttribute("generos", generos);
        RequestDispatcher rd = request.getRequestDispatcher("livro/listar-livro.jsp");
        rd.forward(request, response);
    }
}
