package model;

import jakarta.persistence.*;

@Entity
public class Bibliotecario extends Entidade{
    private String nome;
    private Usuario usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    public Usuario getUsuario() {
        return usuario;
    }
}
