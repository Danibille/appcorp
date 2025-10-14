package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import model.Livro;

@WebServlet("/Livros")
public class LivroServlet extends GenericServlet<Livro>{

    protected Livro preencherEntidade(HttpServletRequest request){
        Livro livro = new Livro();
        livro.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        livro.setTitulo(request.getParameter("titulo"));
        livro.setEditora(request.getParameter("editora"));
        livro.setGenero(request.getParameter("genero"));
        livro.setAutor(request.getParameter("autor"));
        return livro;
    }
}
