package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.utils.DatabaseConnection;
import br.edu.infnet.mariana.domain.Conhecimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class ConhecimentoRepository {

    public void save(Conhecimento conhecimento) {
        String sql = "INSERT INTO Conhecimento (nome, trilha_id) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, conhecimento.getNome());
            stmt.setInt(2, conhecimento.getTrilha().getId());
            stmt.executeUpdate();
            System.out.println("Conhecimento cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Conhecimento: " + e.getMessage());
        }
    }
}
