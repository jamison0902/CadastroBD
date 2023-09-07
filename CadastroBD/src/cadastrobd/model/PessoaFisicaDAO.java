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

public class PessoaFisicaDAO {
    public PessoaFisica getPessoa(int idPessoa) throws SQLException, Exception {
        String sql = "SELECT b.idPessoa, b.nome, b.logradouro, b.cidade, b.estado, b.telefone, b.email, a.cpf FROM PessoaFisica a INNER JOIN Pessoa b ON  a.idPessoa = b.idPessoa WHERE b.idPessoa = ?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            try (ResultSet resultSet = ConectorBD.getSelect(statement)) {
                if (resultSet.next()) {
                    return extractPessoaFisica(resultSet);
                }
            }
        }
        return null;
    }

    public List<PessoaFisica> getPessoas() throws SQLException, Exception {
        List<PessoaFisica> pessoas = new ArrayList<>();
        String sql = "SELECT b.idPessoa, b.nome, b.logradouro, b.cidade, b.estado, b.telefone, b.email, a.cpf FROM PessoaFisica a INNER JOIN Pessoa b ON  a.idPessoa = b.idPessoa";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql);
             ResultSet resultSet = ConectorBD.getSelect(statement)) {
            while (resultSet.next()) {
                pessoas.add(extractPessoaFisica(resultSet));
            }
        }
        return pessoas;
    }

    public void incluir(PessoaFisica pessoaFisica) throws SQLException, Exception {
        int idPessoa = SequenceManager.getValue("PessoaSequence");
        String sql = "INSERT INTO Pessoa (idPessoa, nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            statement.setString(2, pessoaFisica.getNome());
            statement.setString(3, pessoaFisica.getLogradouro());
            statement.setString(4, pessoaFisica.getCidade());
            statement.setString(5, pessoaFisica.getEstado());
            statement.setString(6, pessoaFisica.getTelefone());
            statement.setString(7, pessoaFisica.getEmail());
            statement.executeUpdate();
        }

        sql = "INSERT INTO PessoaFisica (idPessoa, cpf) VALUES (?, ?)";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setInt(1, idPessoa);
            statement.setString(2, pessoaFisica.getCpf());
            statement.executeUpdate();
        }
    }

    public void alterar(PessoaFisica pessoaFisica) throws SQLException, Exception {
        String sql = "UPDATE Pessoa SET nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=? WHERE idPessoa=?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setString(1, pessoaFisica.getNome());
            statement.setString(2, pessoaFisica.getLogradouro());
            statement.setString(3, pessoaFisica.getCidade());
            statement.setString(4, pessoaFisica.getEstado());
            statement.setString(5, pessoaFisica.getTelefone());
            statement.setString(6, pessoaFisica.getEmail());
            statement.setInt(7, pessoaFisica.getIdPessoa());
            statement.executeUpdate();
        }

        sql = "UPDATE PessoaFisica SET cpf=? WHERE idPessoa=?";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql)) {
            statement.setString(1, pessoaFisica.getCpf());
            statement.setInt(2, pessoaFisica.getIdPessoa());
            statement.executeUpdate();
        }
    }

    public void excluir(int idPessoa) throws SQLException, Exception {
        String sql = "DELETE FROM PessoaFisica WHERE idPessoa=?";
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

    public PessoaFisica extractPessoaFisica(ResultSet resultSet) throws SQLException {
        int idPessoa = resultSet.getInt("idPessoa");
        String nome = resultSet.getString("nome");
        String logradouro = resultSet.getString("logradouro");
        String cidade = resultSet.getString("cidade");
        String estado = resultSet.getString("estado");
        String telefone = resultSet.getString("telefone");
        String email = resultSet.getString("email");
        String cpf = resultSet.getString("cpf");
        return new PessoaFisica(idPessoa, nome, logradouro, cidade, estado, telefone, email, cpf);
    }
}

