package br.ce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/db_reservas";
	private static final String DB_USER = "halyson";
	private static final String DB_PWD = "@Admin123#";
	private Connection conn = null;
	
		
	public ConexaoUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		try {
			
			this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			System.out.println("Connectado!");
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
