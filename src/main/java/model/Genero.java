package model;


public class Genero extends Entidade{
  
    public int id;
    public String genero;
    
    public Genero() {
    }

    public Genero(String genero) {
        this.setGenero(genero);;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
