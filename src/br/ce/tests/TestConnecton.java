package br.ce.tests;

import java.sql.SQLException;

import br.ce.util.ConexaoUtil;

public class TestConnecton {
	public static void main(String []args) {
		ConexaoUtil conn = new ConexaoUtil();
		try {
			conn.getConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
