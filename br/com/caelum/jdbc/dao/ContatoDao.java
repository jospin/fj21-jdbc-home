package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import br.com.caelum.jdbc.conection.ConnectionFactory;
import br.com.caelum.jdbc.exception.DaoException;
import br.com.caelum.jdbc.model.Contato;

public class ContatoDao {
	private Connection conn;

	public ContatoDao() {
		this.conn = new ConnectionFactory().getConnection();

	}

	public void insert(Contato contato) {

		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + "values (?,?,?,?)";

		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()));
			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException("insert");
		}

	}
	
	public void update(Contato contato){
		String sql = "UPDATE contatos SET "
				+ "nome=?,email=?,endereco=?,dataNascimento=?"
				+ " WHERE id=?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
		
			stmt.close();
			
			System.out.println("Contato atualizado!");
			
		} catch(SQLException e) {
			throw new DaoException("update");
		}
		
	}
	
	public void delete(long id) {
		String sql = "DELETE FROM contatos WHERE id=?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			System.out.println("Contato apagado!");
		} catch(SQLException e) {
			throw new DaoException("delete");
		}
	}
	
	public Contato getContato(long id) {
		Contato c = new Contato();
		String sql = "SELECT * FROM contatos where id=?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			
			ResultSet rs = stmt.executeQuery();
			
		} catch(SQLException e) {
			throw new DaoException("getContato");
		}
		return c;
	}
	 
	public List getLista() {
		
		List<Contato> contatos = new LinkedList<>();
		try{
			String sql = "select * from contatos";
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new DaoException("getLista");
		}
		return contatos;
	}

}
