package controller.editora;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EditoraDao;
import model.Editora;

@WebServlet("/ListarEditorasServlet")
public class ListarEditoraServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EditoraDao editoraDao = new EditoraDao();
        List<Editora> editoras = editoraDao.listarTodos();
        request.setAttribute("editoras", editoras);
        RequestDispatcher rd = request.getRequestDispatcher("editora/editora-listar.jsp");
        rd.forward(request, response);
    }
}
