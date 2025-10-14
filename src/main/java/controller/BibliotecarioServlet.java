package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Bibliotecario;

@WebServlet("/Bibliotecario")
public class BibliotecarioServlet extends GenericServlet<Bibliotecario>{

    protected Bibliotecario preencherEntidade(HttpServletRequest request){
        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        bibliotecario.setNome(request.getParameter("nome"));
        return bibliotecario;
    }
}
