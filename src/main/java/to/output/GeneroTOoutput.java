package to.output;

import java.util.List;

import model.Genero;

public class GeneroTOoutput {
    private Integer id;
    private String genero;
    private List<LivroTOoutput> livros;

    public GeneroTOoutput(Genero genero) {
        this.id = genero.getId();
        this.genero = genero.getGenero();
        if (genero.getLivros() != null) {
            this.livros = genero.getLivros().stream().map(livro -> {
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

    public String getGenero() {
        return genero;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLivros(List<LivroTOoutput> livros) {
        this.livros = livros;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
