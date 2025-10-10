package controller.livro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.EditoraDao;
import dao.GeneroDao;
import dao.LivroDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Editora;
import model.Genero;
import model.Livro;

@WebServlet("/CadastroLivro")
public class CadastroLivroServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        LivroDao livroDao = new LivroDao();
        EditoraDao editoraDao = new EditoraDao();
        //GeneroDao generoDao = new GeneroDao();
        //List<Genero> generos;
        List<Editora> editoras;
        try {
            editoras = editoraDao.listar();
            request.setAttribute("editoras", editoras);
            //generos = generoDao.listar();
            //request.setAttribute("generos", generos);
            RequestDispatcher rd = request.getRequestDispatcher("livroform.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("id") != null && request.getParameter("acao").equals("cadastrar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            LivroDAO livroDAO = new LivroDAO();
            request.setAttribute("livro", livroDAO.buscarPorId(id));

        }

        EditoraDAO editoraDAO = new EditoraDAO();
        List<Editora> editoras;

        editoras = editoraDAO.listarTodos();
        request.setAttribute("editoras", editoras);
        RequestDispatcher rd = request.getRequestDispatcher("livro/form-livro.jsp");
        rd.forward(request, response);
    }*/
}
