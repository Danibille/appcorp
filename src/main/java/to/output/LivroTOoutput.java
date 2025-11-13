package to.output;

import java.util.List;

import model.Livro;

public class LivroTOoutput {
    private Integer id;
    private String titulo;
    private EditoraTOoutput editora;
    private GeneroTOoutput genero;
    private String autor;
    private List<EmprestimoTOoutput> emprestimos;
    
    public LivroTOoutput(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        if (livro.getEditora() != null) {
            this.editora = new EditoraTOoutput(livro.getEditora());
        }
        if (livro.getGenero() != null) {
            this.genero = new GeneroTOoutput(livro.getGenero());
        }
        if (livro.getEmprestimos() != null) {
            this.emprestimos = livro.getEmprestimos().stream().map(emprestimo -> {
                EmprestimoTOoutput emprestimoTO = new EmprestimoTOoutput(emprestimo, false);
                return emprestimoTO;
            }).toList();
        }
    }

    public LivroTOoutput(Livro livro, boolean carregarEditora, boolean carregarGenero) {
        EditoraTOoutput editoraTO = null;
        GeneroTOoutput generoTO = null;
        if (carregarEditora && livro.getEditora() != null) {
            editoraTO = new EditoraTOoutput(livro.getEditora());
        }
        if (carregarGenero && livro.getGenero() != null) {
            generoTO = new GeneroTOoutput(livro.getGenero());
        }
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.editora = editoraTO;
        this.genero = generoTO;
        this.autor = livro.getAutor();
        if (livro.getEmprestimos() != null) {
            this.emprestimos = livro.getEmprestimos().stream().map(emprestimo -> {
                EmprestimoTOoutput emprestimoTO = new EmprestimoTOoutput(emprestimo, false);
                return emprestimoTO;
            }).toList();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public EditoraTOoutput getEditora() {
        return editora;
    }


    public GeneroTOoutput getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public List<EmprestimoTOoutput> getEmprestimos() {
        return emprestimos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(EditoraTOoutput editora) {
        this.editora = editora;
    }

    public void setGenero(GeneroTOoutput genero) {
        this.genero = genero;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEmprestimos(List<EmprestimoTOoutput> emprestimos) {
        this.emprestimos = emprestimos;
    }
}