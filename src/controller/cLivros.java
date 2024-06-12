package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mLivros;

public class cLivros {
    public void cadastrar(mLivros modelL) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO livros (fk_editoras_id_editora, fk_autores_id_autor, titulo, descricao, ano) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, modelL.getEditora().getId_editora());
            stmt.setInt(2, modelL.getAutor().getId_autor());
            stmt.setString(3, modelL.getTitulo());
            stmt.setString(4, modelL.getDescricao());
            stmt.setInt(5, modelL.getAno());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cLivros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<mLivros> listar() {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mLivros> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM livros");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mLivros modelL = new mLivros();
                modelL.setId_livro(rs.getInt("id_livro"));
                modelL.setTitulo(rs.getString("Titulo"));

                lista.add(modelL);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cLivros.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public List<mLivros> pesquisar(String texto) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mLivros> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * From livros WHERE nome like ?");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mLivros modelL = new mLivros();
                modelL.setId_livro(rs.getInt("id_livro"));
                modelL.setTitulo(rs.getString("Titulo"));

                lista.add(modelL);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cLivros.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }
}
