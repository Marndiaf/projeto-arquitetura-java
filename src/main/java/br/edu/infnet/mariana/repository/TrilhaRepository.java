package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.utils.DatabaseConnection;
import br.edu.infnet.mariana.domain.Trilha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class TrilhaRepository {

    public void save(Trilha trilha) {
        String sql = "INSERT INTO Trilha (nome, descricao, ativa) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trilha.getNome());
            stmt.setString(2, trilha.getDescricao());
            stmt.setBoolean(3, trilha.getAtiva());
            stmt.executeUpdate();
            System.out.println("Trilha cadastrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Trilha: " + e.getMessage());
        }
    }
}
