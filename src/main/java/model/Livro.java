package model;

import java.util.List;

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
    @OneToMany(mappedBy = "emprstimo", targetEntity = Emprestimo.class)
    private List<Emprestimo> emprestimos;

    public String getTitulo() {
        return titulo;
    }

    public Editora getEditora() {
        return editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
