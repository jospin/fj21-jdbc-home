package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.conection.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		
		try(Connection conn = new ConnectionFactory().getConnection()) {
			System.out.println("Conexão aberta!");
		} catch(SQLException e) {
			System.out.println(e);
		}
	}		

}
