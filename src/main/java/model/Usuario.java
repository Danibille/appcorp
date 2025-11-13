package model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends Entidade{
    private String email;
    private String senha;
    private boolean ativo;
    private String papel;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getPapel() {
        return papel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public void setPapel(String papel) {
        this.papel = papel;
    }
    
}