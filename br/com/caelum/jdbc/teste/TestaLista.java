package br.com.caelum.jdbc.teste;


import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		List<Contato> lista = dao.getLista();
		for(Contato contato : lista) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("E-mail: " + contato.getEmail());
			String dataFormatada = new SimpleDateFormat("dd/MM/yyyy")
					.format(new Date(contato.getDataNascimento()));
			System.out.println("Nascimento: " + dataFormatada);
		}

	}

}
