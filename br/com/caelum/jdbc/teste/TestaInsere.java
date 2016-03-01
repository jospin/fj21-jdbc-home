package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato c = new Contato();
		c.setNome("Lucien Jospin");
		c.setEmail("lucien.carbonare@gmail.com");
		c.setEndereco("Av Sargento Geraldo Santa'ana, 1100");
		Calendar nascimento = Calendar.getInstance();
		nascimento.set(1978, 2, 8);
		c.setDataNascimento(nascimento);
		
		ContatoDao bd = new ContatoDao();
		bd.insert(c);
		
		System.out.println("Contato gravado");
		

	}

}