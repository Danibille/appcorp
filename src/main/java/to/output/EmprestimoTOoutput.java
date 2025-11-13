package to.output;

import model.Emprestimo;

public class EmprestimoTOoutput {
    private Integer id;
    private Integer data_emprestimo;
    private Integer data_devolucao;
    private LivroTOoutput livro;

    public EmprestimoTOoutput(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.data_emprestimo = emprestimo.getData_emprestimo();
        this.data_devolucao = emprestimo.getData_devolucao();
        if (emprestimo.getLivro() != null) {
            this.livro = new LivroTOoutput(emprestimo.getLivro());
        }
    }

    public EmprestimoTOoutput(Emprestimo emprestimo, boolean carregarLivro) {
        LivroTOoutput livroTO = null;
        if(carregarLivro && emprestimo.getLivro() != null){
            livroTO = new LivroTOoutput(emprestimo.getLivro());
        }
        this.id = emprestimo.getId();
        this.data_emprestimo = emprestimo.getData_emprestimo();
        this.data_devolucao = emprestimo.getData_devolucao();
        this.livro = livroTO;
    }

    public Integer getId() {
        return id;
    }

    public Integer getData_emprestimo() {
        return data_emprestimo;
    }

    public Integer getData_devolucao() {
        return data_devolucao;
    }

    public LivroTOoutput getLivro() {
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

    public void setLivro(LivroTOoutput livro) {
        this.livro = livro;
    }

}
