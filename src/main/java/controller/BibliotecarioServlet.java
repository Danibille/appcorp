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

import model.Bibliotecario;
import dao.BibliotecarioDao;

@WebServlet("/Bibliotecario")
public class BibliotecarioServlet extends HttpServlet{
    private static final long serialVersionUID = 5L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        Bibliotecario bibliotecario = new Bibliotecario(nome, email);

        BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
        try {
            bibliotecarioDao.inserir(bibliotecario);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
        List<Bibliotecario> bibliotecarios;
        try {
            bibliotecarios = bibliotecarioDao.listar();
            request.setAttribute("bibliotecarios", bibliotecarios);
            RequestDispatcher rd = request.getRequestDispatcher("bibliotecario-listar.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
