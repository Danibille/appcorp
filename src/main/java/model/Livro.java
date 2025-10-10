package model;

import jakarta.persistence.*;

@Entity
public class Livro extends Entidade{
    public String titulo;
    @ManyToOne
    @JoinColumn(name = "editora_id")
    public Editora editora;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    public Genero genero;
    public String autor;

    public Livro() {
    }

    public Livro(String titulo, Editora editora, Genero genero, String autor) {
        this.setTitulo(titulo);
        this.editora = editora;
        this.genero = genero;
        this.setAutor(autor);
    }
    
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
