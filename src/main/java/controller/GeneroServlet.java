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

import model.Genero;
import dao.GeneroDao;

@WebServlet("/Genero")
public class GeneroServlet extends HttpServlet{
    private static final long serialVersionUID = 2L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String gen = request.getParameter("genero");

        Genero genero = new Genero(gen);

        GeneroDao generoDao = new GeneroDao();
        try {
            generoDao.inserir(genero);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        GeneroDao generoDao = new GeneroDao();
        List<Genero> generos;
        try {
            generos = generoDao.listar();
            request.setAttribute("generos", generos);
            RequestDispatcher rd = request.getRequestDispatcher("genero-listar.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
