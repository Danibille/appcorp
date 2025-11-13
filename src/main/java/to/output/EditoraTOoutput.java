package to.output;

import java.util.List;

import model.Editora;

public class EditoraTOoutput {
    private Integer id;
    private String nome;
    private List<LivroTOoutput> livros;

    public EditoraTOoutput(Editora editora) {
        this.id = editora.getId();
        this.nome = editora.getNome();
        if (editora.getLivros() != null) {
            this.livros = editora.getLivros().stream().map(livro -> {
                LivroTOoutput livroTO = new LivroTOoutput(livro, false, false);
                return livroTO;
            }).toList();
        }

    }

    public Integer getId() {
        return id;
    }

    public List<LivroTOoutput> getLivros() {
        return livros;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLivros(List<LivroTOoutput> livros) {
        this.livros = livros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}