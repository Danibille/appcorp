package model;

public class Bibliotecario {
    public int id;
    public String nome;
    private Usuario usuario;

    public Bibliotecario() {
    }

    public Bibliotecario(String nome, String email) {
        this.setNome(nome);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
