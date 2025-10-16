package dao;

import model.Livro;

public class LivroDao extends GenericDAO<Livro>{

    public LivroDao() {
        super(Livro.class);
    }
}
