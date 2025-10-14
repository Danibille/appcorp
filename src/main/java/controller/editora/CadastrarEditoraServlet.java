package controller.editora;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EditoraDao;
import model.Editora;

@WebServlet("/CadastrarEditoraServlet")
public class CadastrarEditoraServlet extends HttpServlet {
    private static final long serialVersionUID = 4L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("nome");

        Editora editora = new Editora();
        editora.setNome(nome);

        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        EditoraDao editoraDao = new EditoraDao();
        if (request.getParameter("id") != null && request.getParameter("acao").equals("editar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            editora.setId(id);
            editoraDao.atualizar(editora, null);
            request.setAttribute("mensagem", "Editora atualizada com sucesso!"); // Mens
        } else {
            editoraDao.salvar(editora, null);
            request.setAttribute("mensagem", "Editora cadastrada com sucesso!");
        }

        RequestDispatcher rd = request.getRequestDispatcher("editora/editora-form.jsp");

        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("id") != null && request.getParameter("acao").equals("cadastrar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            EditoraDao editoraDAO = new EditoraDao();
            request.setAttribute("editora", editoraDAO.buscarPorId(id));
        }

        RequestDispatcher rd = request.getRequestDispatcher("editora/editora-form.jsp");
        rd.forward(request, response);
    }
}
