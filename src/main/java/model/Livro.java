package model;

import jakarta.persistence.*;

@Entity
public class Livro extends Entidade{
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
    private String autor;
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
