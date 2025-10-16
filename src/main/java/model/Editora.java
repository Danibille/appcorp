package model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Editora extends Entidade{
    private String nome;
    @OneToMany(mappedBy = "editora", targetEntity = Livro.class)
    private List<Livro> livros;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
