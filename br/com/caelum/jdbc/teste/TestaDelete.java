package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;

public class TestaDelete {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		dao.delete(1);

	}

}
