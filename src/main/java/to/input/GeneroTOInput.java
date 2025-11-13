package to.input;

import java.io.Serializable;

import model.Genero;

public class GeneroTOInput implements Serializable{
    private Integer id;
    private String genero;

    public GeneroTOInput() {
    }

    public Integer getId() {
        return id;
    }

    public String getGenero() {
        return genero;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Genero build() {
        var gen = new Genero();
        gen.setId(id);
        gen.setGenero(genero);
        return gen;
    }
}
