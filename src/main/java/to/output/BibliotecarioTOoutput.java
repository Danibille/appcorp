package to.output;

import model.Bibliotecario;

public class BibliotecarioTOoutput {
    private Integer id;
    private String nome;
    private String email;

    public BibliotecarioTOoutput(Bibliotecario bibliotecario) {
        this.id = bibliotecario.getId();
        this.nome = bibliotecario.getNome();
        this.email = bibliotecario.getEmail();
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
    
}
