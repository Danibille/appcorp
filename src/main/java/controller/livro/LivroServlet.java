package controller.livro;

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
import model.Genero;
import model.Livro;
import dao.LivroDao;

@WebServlet("/Livros")
public class LivroServlet extends HttpServlet{
    private static final long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        Editora editora = new Editora(request.getParameter("editora"));
        Genero genero = new Genero(request.getParameter("genero"));
        String autor = request.getParameter("autor");

        Livro livro = new Livro(titulo, editora, genero, autor);

        LivroDao livroDao = new LivroDao();
        try {
            livroDao.inserir(livro);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        LivroDao livroDao = new LivroDao();
        List<Livro> livros;
        try {
            livros = livroDao.listar();
            request.setAttribute("livros", livros);
            RequestDispatcher rd = request.getRequestDispatcher("livro-listar.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
