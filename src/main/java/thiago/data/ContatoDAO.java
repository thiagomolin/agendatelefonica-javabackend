/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiago.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thiago.controllers.ContatoController;
import thiago.infra.ConexaoJDBC;
import thiago.infra.ConexaoMariaDBJDBC;

/**
 *
 * @author PCM1
 */
public class ContatoDAO {

    private final ConexaoJDBC conexao;

    public ContatoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoMariaDBJDBC();
    }

    public Long inserir(Contato contato) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlInsert = "INSERT INTO contatos (nome, telefone, celular, endereco) VALUES (?, ?, ?, ?); SELECT LAST_INSERT_ID();";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlInsert);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getCelular());
            stmt.setString(4, contato.getEndereco());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getLong(0);
            }

            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

        return id;
    }

    public int alterar(Contato contato) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE contatos SET nome = ?, telefone = ?, celular = ?, endereco = ? WHERE id = ?";
        int linhasAfetadas = 0;

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone().toString());
            stmt.setString(3, contato.getCelular());
            stmt.setString(4, contato.getEndereco());
            stmt.setLong(5, contato.getId());

            linhasAfetadas = stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

        return linhasAfetadas;
    }

    public int excluir(long id) throws SQLException, ClassNotFoundException {
        int linhasAlfetadas = 0;
        String sqlQuery = "DELETE FROM contatos WHERE id = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, id);
            linhasAlfetadas = stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

        return linhasAlfetadas;
    }

    public Contato selecionar(long id) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM contatos WHERE id = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return parser(rs);
            }
        } catch (SQLException e) {
            throw e;
        }

        return null;
    }
    
    public List<Contato> listar() throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM contatos ORDER BY id";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();

            List<Contato> contatos = new ArrayList<>();

            while (rs.next()) {
                contatos.add(parser(rs));
            }

            return contatos;
        } catch (SQLException e) {
            throw e;
        }
    }

    private Contato parser(ResultSet resultSet) throws SQLException {
        Contato c = new Contato();

        c.setId(resultSet.getLong("id"));
        c.setNome(resultSet.getString("nome"));
        c.setTelefone(resultSet.getString("telefone"));
        c.setCelular(resultSet.getString("celular"));
        c.setEndereco(resultSet.getString("endereco"));

        return c;
    }

}
