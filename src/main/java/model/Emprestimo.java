package model;

public class Emprestimo {
    public int id;
    public Livro livro;
    public String data_emprestimo;
    public String data_devolução;
    public double multa = 0.3;

    public Emprestimo() {
    }

    public Emprestimo(String data_emprestimo) {
        this.setData_emprestimo(data_emprestimo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =id;
    }
    
    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }
    
    public String getData_devolução() {
        return data_devolução;
    }

    public double getMulta() {
        return multa;
    }
    
}
