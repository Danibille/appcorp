package model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends Entidade{

    
    private String email;
    private String senha;
    private boolean ativo;
    private String papel;

    // Getters e Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}