package to.input;

import java.io.Serializable;

import model.Bibliotecario;

public class BibliotecarioTOInput implements Serializable {
    private Integer id;
    private String nome;
    private String email;

    public BibliotecarioTOInput() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bibliotecario build() {
        var bibliotecario = new Bibliotecario();
        bibliotecario.setId(id);
        bibliotecario.setNome(nome);
        bibliotecario.setEmail(email);
        return bibliotecario;
    }
}
