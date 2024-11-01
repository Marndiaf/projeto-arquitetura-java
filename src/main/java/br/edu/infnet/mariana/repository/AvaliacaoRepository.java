package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.utils.DatabaseConnection;
import br.edu.infnet.mariana.domain.Avaliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class AvaliacaoRepository {

    public void save(Avaliacao avaliacao) {
        String sql = "INSERT INTO Avaliacao (pessoa_id, conhecimento_id, tipo, nota) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, avaliacao.getPessoa().getId());
            stmt.setInt(2, avaliacao.getConhecimento().getId());
            stmt.setString(3, avaliacao.getTipo());
            stmt.setFloat(4, avaliacao.getNota());
            stmt.executeUpdate();
            System.out.println("Avaliação cadastrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Avaliação: " + e.getMessage());
        }
    }
}
