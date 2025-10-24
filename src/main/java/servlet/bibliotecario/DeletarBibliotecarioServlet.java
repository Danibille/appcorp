package servlet.bibliotecario;


import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BibliotecarioDao;
import model.Bibliotecario;

@WebServlet("/DeletarBibliotecario")
public class DeletarBibliotecarioServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Bibliotecario bibliotecario = bibliotecarioDao.buscarPorId(id);
        bibliotecarioDao.deletar(bibliotecario.getId());
        List<Bibliotecario> bibliotecarios = bibliotecarioDao.listarTodos();
        request.setAttribute("bibliotecarios", bibliotecarios);
        RequestDispatcher rd = request.getRequestDispatcher("bibliotecario/bibliotecario-listar.jsp");
        rd.forward(request, response);
    }
}
