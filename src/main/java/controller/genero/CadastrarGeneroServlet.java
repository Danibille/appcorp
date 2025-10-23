package controller.genero;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Genero;
import dao.GeneroDao;

@WebServlet("/CadastrarGenero")
public class CadastrarGeneroServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("genero");

        Genero genero = new Genero();
        genero.setGenero(nome);

        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        GeneroDao generoDao = new GeneroDao();
        if (request.getParameter("id") != null && request.getParameter("acao").equals("editar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            genero.setId(id);
            generoDao.atualizar(genero, null);
            request.setAttribute("mensagem", "Genero atualizada com sucesso!"); // Mens
        } else {
            generoDao.salvar(genero, null);
            request.setAttribute("mensagem", "Genero cadastrada com sucesso!");
        }

        RequestDispatcher rd = request.getRequestDispatcher("genero/genero-form.jsp");

        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("id") != null && request.getParameter("acao").equals("cadastrar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            GeneroDao generoDao = new GeneroDao();
            request.setAttribute("genero", generoDao.buscarPorId(id));
        }

        RequestDispatcher rd = request.getRequestDispatcher("genero/genero-form.jsp");
        rd.forward(request, response);
    }
}
