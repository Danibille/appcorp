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

@WebServlet("/DeletarEditoraServlet")
public class DeletarEditoraServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EditoraDao editoraDao = new EditoraDao();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Editora editora = editoraDao.buscarPorId(id);
        editoraDao.deletar(editora.getId());
        List<Editora> editoras = editoraDao.listarTodos();
        request.setAttribute("editoras", editoras);
        RequestDispatcher rd = request.getRequestDispatcher("editora/editora-listar.jsp");
        rd.forward(request, response);
    }
}
