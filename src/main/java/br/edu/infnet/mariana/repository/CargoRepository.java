package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.utils.DatabaseConnection;
import br.edu.infnet.mariana.domain.Cargo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class CargoRepository {

    public void save(Cargo cargo) {
        String sql = "INSERT INTO Cargo (nome, nivel) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cargo.getNome());
            stmt.setString(2, cargo.getNivel());
            stmt.executeUpdate();
            System.out.println("Cargo cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Cargo: " + e.getMessage());
        }
    }
}
