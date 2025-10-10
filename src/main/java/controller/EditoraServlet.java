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

import model.Editora;
import dao.EditoraDao;

@WebServlet("/Editora")
public class EditoraServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");

        Editora editora = new Editora (nome);

        EditoraDao editoraDao = new EditoraDao();
        try {
            editoraDao.inserir(editora);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        EditoraDao editoraDao = new EditoraDao();
        List<Editora> editoras;
        try {
            editoras = editoraDao.listar();
            request.setAttribute("editoras", editoras);
            RequestDispatcher rd = request.getRequestDispatcher("editora-listar.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
