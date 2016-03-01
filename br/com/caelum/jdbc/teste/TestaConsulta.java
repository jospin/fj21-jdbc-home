package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.jdbc.conection.ConnectionFactory;

public class TestaConsulta {

	public static void main(String[] args) {
		try {
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from contatos");
			
			// executa um select
			ResultSet rs = stmt.executeQuery();
			// itera no ResultSet
			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				System.out.println("Nome: " + nome);
				System.out.println("E-mail: " + email);
				System.out.println("Endereço: " + endereco);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
