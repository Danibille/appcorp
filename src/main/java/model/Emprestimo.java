package model;

import jakarta.persistence.*;

@Entity
public class Emprestimo extends Entidade{
    private Integer data_emprestimo;
    private Integer data_devolucao;
    private Livro livro;
    //private double multa;

    public Integer getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Integer data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }
    
    public Integer getData_devolucao() {
        return data_devolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    //public double getMulta() {
    //    this.multa = data_atual - data_devolução;
    //    return multa;
    //}
    
}
