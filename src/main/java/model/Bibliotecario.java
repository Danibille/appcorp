package model;

import jakarta.persistence.*;

@Entity
public class Bibliotecario extends Usuario{
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
