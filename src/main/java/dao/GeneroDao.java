package dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import commons.ConnectionFactory;
import model.Genero;

public class GeneroDao {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public GeneroDao() {
        this.con = ConnectionFactory.getConnection();
    }

    public void inserir(Genero genero) throws SQLException{
        this.sql = "INSERT INTO genero (genero) VALUES (?)";
        this.stmt = this.con.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
        this.stmt.setString(1, genero.getGenero());
        this.stmt.execute();
        this.rs = this.stmt.getGeneratedKeys();
        this.rs.next();
        genero.setId(this.rs.getInt(1));
        this.stmt.close();
        this.con.close();
    }

    public List<Genero> listar() throws SQLException{
        List<Genero> generos = new ArrayList<>();

        this.sql = "SELECT * FROM genero";
        this.stmt=this.con.prepareStatement(this.sql);
        this.rs = this.stmt.executeQuery();
        while(this.rs.next()){
            Genero genero = new Genero();
            genero.setId(this.rs.getInt("id"));
            genero.setGenero(this.rs.getString("genero"));
            generos.add(genero);
        }
        this.stmt.close();
        this.con.close();
        return generos;
    }

    public int atualizar(Genero genero) throws SQLException{
        int linhasAfetadas = 0;
        this.sql = "UPDATE genero SET genero = ? WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setString(1, genero.getGenero());
        this.stmt.setInt(2, genero.getId());
        linhasAfetadas = this.stmt.executeUpdate();

        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }

    public int deletar(int id) throws SQLException {
        int linhasAfetadas = 0;
        this.sql = "DELETE FROM genero WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setInt(1, id);
        linhasAfetadas = this.stmt.executeUpdate();
            
        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }
}
