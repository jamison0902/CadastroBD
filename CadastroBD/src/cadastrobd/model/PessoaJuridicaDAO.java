/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author jsq
 */
import cadastrobd.util.ConectorBD;
import cadastrobd.util.SequenceManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    public PessoaJuridica getPessoa(int idPessoa) throws SQLException, Exception {
        String sql = "SELECT b.idPessoa, b.nome, b.logradouro, b.cidade, b.estado, b.telefone, b.email, a.cnpj FROM PessoaJuridica a INNER JOIN Pessoa b ON  a.idPessoa = b.idPessoa WHERE b.idPessoa = ?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            try (ResultSet resultSet = ConectorBD.getSelect(statement)) {
                if (resultSet.next()) {
                    return extractPessoaJuridica(resultSet);
                }
            }
        }
        return null;
    }

    public List<PessoaJuridica> getPessoas() throws SQLException, Exception {
        List<PessoaJuridica> pessoas = new ArrayList<>();
        String sql = "SELECT b.idPessoa, b.nome, b.logradouro, b.cidade, b.estado, b.telefone, b.email, a.cnpj FROM PessoaJuridica a INNER JOIN Pessoa b ON  a.idPessoa = b.idPessoa";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql);
             ResultSet resultSet = ConectorBD.getSelect(statement)) {
            while (resultSet.next()) {
                pessoas.add(extractPessoaJuridica(resultSet));
            }
        }
        return pessoas;
    }

    public void incluir(PessoaJuridica pessoaJuridica) throws SQLException, Exception {
        int idPessoa = SequenceManager.getValue("PessoaSequence");
        String sql = "INSERT INTO Pessoa (idPessoa, nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            statement.setString(2, pessoaJuridica.getNome());
            statement.setString(3, pessoaJuridica.getLogradouro());
            statement.setString(4, pessoaJuridica.getCidade());
            statement.setString(5, pessoaJuridica.getEstado());
            statement.setString(6, pessoaJuridica.getTelefone());
            statement.setString(7, pessoaJuridica.getEmail());
            statement.executeUpdate();
        }

        sql = "INSERT INTO PessoaJuridica (idPessoa, cnpj) VALUES (?, ?)";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            statement.setString(2, pessoaJuridica.getCnpj());
            statement.executeUpdate();
        }
    }

    public void alterar(PessoaJuridica pessoaJuridica) throws SQLException, Exception {
        String sql = "UPDATE Pessoa SET nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=? WHERE idPessoa=?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setString(1, pessoaJuridica.getNome());
            statement.setString(2, pessoaJuridica.getLogradouro());
            statement.setString(3, pessoaJuridica.getCidade());
            statement.setString(4, pessoaJuridica.getEstado());
            statement.setString(5, pessoaJuridica.getTelefone());
            statement.setString(6, pessoaJuridica.getEmail());
            statement.setInt(7, pessoaJuridica.getIdPessoa());
            statement.executeUpdate();
        }

        sql = "UPDATE PessoaJuridica SET cnpj=? WHERE idPessoa=?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setString(1, pessoaJuridica.getCnpj());
            statement.setInt(2, pessoaJuridica.getIdPessoa());
            statement.executeUpdate();
        }
    }

    public void excluir(int idPessoa) throws SQLException, Exception {
        String sql = "DELETE FROM PessoaJuridica WHERE idPessoa=?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            statement.executeUpdate();
        }

        sql = "DELETE FROM Pessoa WHERE idPessoa=?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            statement.executeUpdate();
        }
    }

    private PessoaJuridica extractPessoaJuridica(ResultSet resultSet) throws SQLException {
        int idPessoa = resultSet.getInt("idPessoa");
        String nome = resultSet.getString("nome");
        String logradouro = resultSet.getString("logradouro");
        String cidade = resultSet.getString("cidade");
        String estado = resultSet.getString("estado");
        String telefone = resultSet.getString("telefone");
        String email = resultSet.getString("email");
        String cnpj = resultSet.getString("cnpj");
        return new PessoaJuridica(idPessoa, nome, logradouro, cidade, estado, telefone, email, cnpj);
    }
}
