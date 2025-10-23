package controller.bibliotecario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BibliotecarioDao;
import model.Bibliotecario;

@WebServlet("/CadastrarBibliotecario")
public class CadastrarBibliotecarioServlet extends HttpServlet {
    private static final long serialVersionUID = 4L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("nome");

        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setNome(nome);

        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
        if (request.getParameter("id") != null && request.getParameter("acao").equals("editar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            bibliotecario.setId(id);
            bibliotecarioDao.atualizar(bibliotecario, null);
            request.setAttribute("mensagem", "Bibliotecario atualizada com sucesso!"); // Mens
        } else {
            bibliotecarioDao.salvar(bibliotecario, null);
            request.setAttribute("mensagem", "Bibliotecario cadastrada com sucesso!");
        }

        RequestDispatcher rd = request.getRequestDispatcher("bibliotecario/bibliotecario-form.jsp");

        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("id") != null && request.getParameter("acao").equals("cadastrar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
            request.setAttribute("bibliotecario", bibliotecarioDao.buscarPorId(id));
        }

        RequestDispatcher rd = request.getRequestDispatcher("bibliotecario/bibliotecario-form.jsp");
        rd.forward(request, response);
    }
}
