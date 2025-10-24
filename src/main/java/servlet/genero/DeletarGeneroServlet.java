package servlet.genero;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Genero;
import dao.GeneroDao;

@WebServlet("/DeletarGenero")
public class DeletarGeneroServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneroDao generoDao = new GeneroDao();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Genero genero = generoDao.buscarPorId(id);
        generoDao.deletar(genero.getId());
        List<Genero> generos = generoDao.listarTodos();
        request.setAttribute("generos", generos);
        RequestDispatcher rd = request.getRequestDispatcher("genero/genero-listar.jsp");
        rd.forward(request, response);
    }
}
