package com.AllanCleiton.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancocjweb1","postgres","postgres");
			System.out.println("Conectado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Nao pode conectar " + e.getMessage());
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado!");
			
		}
		
		return con;
	}
}
