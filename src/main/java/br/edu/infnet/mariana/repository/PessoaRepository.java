package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.utils.DatabaseConnection;
import br.edu.infnet.mariana.domain.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {

    public void save(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa (nome) VALUES (?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.executeUpdate();
            System.out.println("Pessoa cadastrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Pessoa: " + e.getMessage());
        }
    }
}

