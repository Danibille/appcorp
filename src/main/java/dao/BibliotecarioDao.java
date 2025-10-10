package dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import commons.ConnectionFactory;
import model.Bibliotecario;

public class BibliotecarioDao {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public BibliotecarioDao(){
        this.con = ConnectionFactory.getConnection();
    }

    public void inserir(Bibliotecario bibliotecario) throws SQLException{
        this.sql = "INSERT INTO bibliotecario (nome, email) VALUES (?,?)";
        this.stmt = this.con.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
        this.stmt.setString(1, bibliotecario.getNome());
        this.stmt.setString(2, bibliotecario.getEmail());
        this.stmt.execute();
        this.rs = this.stmt.getGeneratedKeys();
        this.rs.next();
        bibliotecario.setId(this.rs.getInt(1));
        this.stmt.close();
        this.con.close();
    }

    public List<Bibliotecario> listar() throws SQLException{
        List<Bibliotecario> bibliotecarios = new ArrayList<>();

        this.sql = "SELECT * FROM bibliotecario";
        this.stmt = this.con.prepareStatement(this.sql);
        this.rs = this.stmt.executeQuery();
        while(this.rs.next()){
            Bibliotecario bibliotecario = new Bibliotecario();
            bibliotecario.setNome(this.rs.getString("nome"));
            bibliotecario.setEmail(this.rs.getString("email"));
            bibliotecarios.add(bibliotecario);
        }
        this.stmt.close();
        this.con.close();
        return bibliotecarios;
    }

    public int atualizar(Bibliotecario bibliotecario) throws SQLException{
        int linhasAfetadas = 0;
        this.sql = "UPDATE bibliotecario SET nome = ? email = ? WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setString(1, bibliotecario.getNome());
        this.stmt.setString(2, bibliotecario.getEmail());
        this.stmt.setInt(3, bibliotecario.getId());
        linhasAfetadas = this.stmt.executeUpdate();

        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }

    public int deletar(int id) throws SQLException {
        int linhasAfetadas = 0;
        this.sql = "DELETE FROM bibliotecario WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setInt(1, id);
        linhasAfetadas = this.stmt.executeUpdate();
        
        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }
}
