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
import model.Genero;
import model.Livro;

public class LivroDao {
    /*private Connection con = null;
    private String sql = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public LivroDao() {
        this.con = ConnectionFactory.getConnection();
    }

    public void inserir(Livro livro) throws SQLException {
        this.sql = ("INSERT INTO livro (titulo, editora_id, genero_id, autor) VALUES (?,?,?,?)");
        this.stmt = con.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
        this.stmt.setString(1, livro.getTitulo());
        this.stmt.setInt(2, livro.getEditora().getId());
        this.stmt.setInt(3, livro.getGenero().getId());
        this.stmt.setString(4, livro.getAutor());
        this.stmt.execute();
        this.rs = this.stmt.getGeneratedKeys();
        this.rs.next();
        livro.setId(this.rs.getInt(1));
        this.stmt.close();
        this.con.close();
    }

    public List<Livro> listar() throws SQLException {
        List<Livro> livros = new ArrayList<>();

        this.sql = "SELECT l.id, l.titulo, e.nome AS editora, g.genero AS genero, l.autor FROM livro l JOIN editora e ON (l.editora_id = e.id) JOIN genero g ON (l.genero_id = g.id)";
        this.stmt = this.con.prepareStatement(this.sql);
        this.rs = this.stmt.executeQuery();
        while (this.rs.next()) {
            Livro livro = new Livro();
            Editora editora = new Editora();
            Genero genero = new Genero();
            livro.setId(this.rs.getInt("id"));
            livro.setTitulo(this.rs.getString("titulo"));
            editora.setNome(this.rs.getString("editora"));
            livro.setEditora(editora);
            genero.setGenero(this.rs.getString("genero"));
            livro.setGenero(genero);
            livro.setAutor(this.rs.getString("autor"));
            livros.add(livro);
        }
        this.stmt.close();
        this.con.close();
        return livros;
    }

    public int atualizar(Livro livro) throws SQLException {
        int linhasAfetadas = 0;
        this.sql = "UPDATE livro SET titulo = ?, enditora_id = ?, genero_id = ? autor = ? WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setString(1, livro.getTitulo());
        this.stmt.setInt(2,livro.getEditora().getId());
        this.stmt.setInt(3, livro.getGenero().getId());
        this.stmt.setString(4, livro.getAutor());
        this.stmt.setInt(5, livro.getId());
        linhasAfetadas = this.stmt.executeUpdate();

        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }

    public int deletar(int id) throws SQLException {
        int linhasAfetadas = 0;
        this.sql = "DELETE FROM livro WHERE id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setInt(1, id);
        linhasAfetadas = this.stmt.executeUpdate();

        this.stmt.close();
        this.con.close();
        return linhasAfetadas;
    }

        public Livro listarPorId(int id) throws SQLException {
        this.sql = "SELECT l.id, l.titulo, e.nome AS editora, g.genero AS genero, l.autor FROM livro l JOIN editora e ON (l.editora_id = e.id) JOIN genero g ON (l.genero_id = g.id) WHERE l.id = ?";
        this.stmt = this.con.prepareStatement(this.sql);
        this.stmt.setInt(1, id);
        this.rs = this.stmt.executeQuery();
        this.rs.next();
        Livro livroAlterado = new Livro();
        Editora editora = new Editora();
        Genero genero = new Genero();
        livroAlterado.setId(this.rs.getInt("id"));
        livroAlterado.setTitulo(this.rs.getString("titulo"));
        editora.setNome(this.rs.getString("editora"));
        livroAlterado.setEditora(editora);
        genero.setGenero(this.rs.getString("genero"));
        livroAlterado.setGenero(genero);
        livroAlterado.setAutor(this.rs.getString("autor"));
        livroAlterado.setId(rs.getInt("id"));

        this.stmt.close();
        this.con.close();
        return livroAlterado;
    }*/
    
}
