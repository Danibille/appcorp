package to.input;

import java.io.Serializable;

import model.Emprestimo;

public class EmprestimoTOInput implements Serializable{
    private Integer id;
    private Integer data_emprestimo;
    private Integer data_devolucao;
    private LivroTOInput livro;

    public Integer getId() {
        return id;
    }

    public Integer getData_emprestimo() {
        return data_emprestimo;
    }

    public Integer getData_devolucao() {
        return data_devolucao;
    }

    public LivroTOInput getLivro() {
        return livro;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setData_emprestimo(Integer data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public void setData_devolucao(Integer data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public void setLivro(LivroTOInput livro) {
        this.livro = livro;
    }

    public Emprestimo build() {
        var emprestimo = new Emprestimo();
        emprestimo.setId(id);
        emprestimo.setData_emprestimo(data_emprestimo);
        emprestimo.setLivro(livro.build());
        return emprestimo;
    }
}
