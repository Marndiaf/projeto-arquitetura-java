package br.edu.infnet.mariana.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:sqlserver://localhost;databaseName=gestao_equipes;encrypt=false;";
	private static final String USER = "sa";
	private static final String PASSWORD = "123456";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
