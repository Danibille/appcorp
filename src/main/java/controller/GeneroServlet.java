package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Genero;

@WebServlet("/Genero")
public class GeneroServlet extends GenericServlet<Genero>{

    protected Genero preencherEntidade(HttpServletRequest request){
        Genero genero = new Genero();
        genero.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        genero.setGenero(request.getParameter("nome"));
        return genero;
    }
    
}
