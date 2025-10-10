package dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import commons.ConnectionFactory;
import model.Emprestimo;

public class EmprestimoDao {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public EmprestimoDao() {
        this.con = ConnectionFactory.getConnection();
    }

    public void inserir(Emprestimo emprestimo) throws SQLException{
        this.sql = ("INSERT INTO emprestimo (livro_id, data_emprestimo) VALUES (?,?)");
        this.stmt = con.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
        this.stmt.setInt(1, emprestimo.livro.getId());
        this.stmt.setString(2, emprestimo.getData_emprestimo());
        this.stmt.execute();
        this.rs = this.stmt.getGeneratedKeys();
        this.rs.next();
        emprestimo.setId(this.rs.getInt(1));
        this.stmt.close();
        this.con.close();
    }

    public List<Emprestimo> listar() throws SQLException{
        List<Emprestimo> emprestimos = new ArrayList<>();

        this.sql = "SELECT * FROM editora";
        this.stmt=this.con.prepareStatement(this.sql);
        this.rs = this.stmt.executeQuery();
        while(this.rs.next()){
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId(this.rs.getInt("id"));
            emprestimo.setData_emprestimo(this.rs.getString("data_emprestimo"));
            emprestimos.add(emprestimo);
        }
        this.stmt.close();
        this.con.close();
        return emprestimos;
    }

    public int atualizar(Emprestimo emprestimo) throws SQLException{
        int linhasAfetadas = 0;
        this.sql ="UPDATE emprestimo SET data_emprestimo = ? WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setString(1, emprestimo.getData_emprestimo());
        this.stmt.setInt(2, emprestimo.getId());
        linhasAfetadas = this.stmt.executeUpdate();

        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }

    public int deletar(int id) throws SQLException {
        int linhasAfetadas = 0;
        this.sql = "DELETE FROM emprestimo WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setInt(1, id);
        linhasAfetadas = this.stmt.executeUpdate();
            
        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }
}
