package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Editora;

@WebServlet("/Editora")
public class EditoraServlet extends GenericServlet<Editora>{

    protected Editora preencherEntidade(HttpServletRequest request){
        Editora editora = new Editora();
        editora.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        editora.setNome(request.getParameter("nome"));
        return editora;
    }
}
