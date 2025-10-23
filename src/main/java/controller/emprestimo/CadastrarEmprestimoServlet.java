package controller.emprestimo;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.LivroDao;
import dao.EmprestimoDao;
import model.Livro;
import model.Emprestimo;


@WebServlet("/CadastrarEmprestimo")
public class CadastrarEmprestimoServlet extends HttpServlet {
private static final long serialVersionUID = 5L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Integer data_emprestimo = Integer.parseInt(request.getParameter("data_emprestimo"));;
        Integer idLivro = Integer.parseInt(request.getParameter("livroId"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setData_emprestimo(data_emprestimo);

        LivroDao livroDao = new LivroDao();
        Livro livro = livroDao.buscarPorId(idLivro);
        emprestimo.setLivro(livro);


        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        EmprestimoDao emprestimoDao = new EmprestimoDao();

        emprestimoDao.salvar(emprestimo, null);

        RequestDispatcher rd = request.getRequestDispatcher("emprestimo/cadastro-sucesso.jsp");

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("id") != null && request.getParameter("acao").equals("cadastrar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            EmprestimoDao emprestimoDao = new EmprestimoDao();
            request.setAttribute("emprestimo", emprestimoDao.buscarPorId(id));
        }

        LivroDao livroDao = new LivroDao();
        List<Livro> livros;

        livros = livroDao.listarTodos();
        request.setAttribute("livros", livros);

        RequestDispatcher rd = request.getRequestDispatcher("emprestimo/emprestimo-form.jsp");
        rd.forward(request, response);
    }
}
