package model;

import jakarta.persistence.*;

@Entity
public class Emprestimo extends Entidade{
    public Livro livro;
    private String data_emprestimo;
    private String data_devolução;
    //private double multa;
    
    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }
    
    public String getData_devolução() {
        return data_devolução;
    }

    //public double getMulta() {
    //    this.multa = data_atual - data_devolução;
    //    return multa;
    //}
    
}
