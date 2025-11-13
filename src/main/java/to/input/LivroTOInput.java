package to.input;

import java.io.Serializable;

import model.Livro;

public class LivroTOInput implements Serializable {
    private Integer id;
    private String titulo;
    private EditoraTOInput editora;
    private GeneroTOInput genero;
    private String autor;

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public EditoraTOInput getEditora() {
        return editora;
    }
    
    public GeneroTOInput getGenero() {
        return genero;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(EditoraTOInput editora) {
        this.editora = editora;
    }

    public void serGenero(GeneroTOInput genero) {
        this.genero = genero;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Livro build() {
        var livro = new Livro();
        livro.setId(id);
        livro.setTitulo(titulo);
        livro.setEditora(editora.build());
        livro.setGenero(genero.build());
        livro.setAutor(autor);
        return livro;
    }
}