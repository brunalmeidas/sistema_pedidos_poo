package com.pedidos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/sistema_pedidos";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static Connection conn = null;

	public static Connection getConnection() throws SQLException {
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			throw new SQLException("Erro de conexão " + e.getMessage());
		}
	}
}
