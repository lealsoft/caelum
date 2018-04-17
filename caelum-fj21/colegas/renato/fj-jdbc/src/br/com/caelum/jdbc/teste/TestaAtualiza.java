package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAtualiza {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Renato Carrara");
		contato.setEmail("rcarrara@caelum.com.br");
		contato.setEndereco("R. num 1");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId(6L);

		ContatoDAO dao = new ContatoDAO();
		dao.altera(contato);
		
		System.out.println("Gravado!");
		
	}
}
