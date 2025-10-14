package model;

import jakarta.persistence.*;

@Entity
public class Genero extends Entidade{
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
