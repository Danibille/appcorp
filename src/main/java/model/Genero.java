package model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Genero extends Entidade{
    private String genero;
    @OneToMany(mappedBy = "editora", targetEntity = Livro.class)
    private List<Livro> livros;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
