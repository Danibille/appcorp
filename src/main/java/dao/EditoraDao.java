package dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import commons.ConnectionFactory;
import model.Editora;

public class EditoraDao {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public EditoraDao() {
        this.con = ConnectionFactory.getConnection();
    }

    public void inserir(Editora editora) throws SQLException{
        this.sql = ("INSERT INTO editora (nome) VALUES (?)");
        this.stmt = con.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
        this.stmt.setString(1, editora.getNome());
        this.stmt.execute();
        this.rs = this.stmt.getGeneratedKeys();
        this.rs.next();
        editora.setId(this.rs.getInt(1));
        this.stmt.close();
        this.con.close();
    }

    public List<Editora> listar() throws SQLException{
        List<Editora> editoras = new ArrayList<>();

        this.sql = "SELECT * FROM editora";
        this.stmt=this.con.prepareStatement(this.sql);
        this.rs = this.stmt.executeQuery();
        while(this.rs.next()){
            Editora editora = new Editora();
            editora.setId(this.rs.getInt("id"));
            editora.setNome(this.rs.getString("nome"));
            editoras.add(editora);
        }
        this.stmt.close();
        this.con.close();
        return editoras;
    }

    public int atualizar(Editora editora) throws SQLException{
        int linhasAfetadas = 0;
        this.sql ="UPDATE editora SET nome = ? WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setString(1, editora.getNome());
        this.stmt.setInt(2, editora.getId());
        linhasAfetadas = this.stmt.executeUpdate();

        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }

    public int deletar(int id) throws SQLException {
        int linhasAfetadas = 0;
        this.sql = "DELETE FROM editora WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setInt(1, id);
        linhasAfetadas = this.stmt.executeUpdate();
        
        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }

    public Editora listarPorId (int id) throws SQLException{
        this.sql = "SELECT * FROM editora WHERE id = ?";
        Editora editoraAlterada = null;
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setInt(1, id);
        this.rs = this.stmt.executeQuery();
        this.rs.next();
        editoraAlterada = new Editora();
        editoraAlterada.setNome(this.rs.getString("nome"));
        editoraAlterada.setId(rs.getInt("id"));
        
        this.stmt.close();
        this.con.close();
        return editoraAlterada;
    }
}
