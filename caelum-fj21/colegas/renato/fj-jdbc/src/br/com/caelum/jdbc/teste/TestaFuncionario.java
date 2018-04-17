package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionario {
	public static void main(String[] args) {
		Funcionario funci = new Funcionario();
		funci.setNome("Renato");
		funci.setUsuario("RRR");
		funci.setSenha("123456");
		
		FuncionarioDAO fDAO = new FuncionarioDAO();
		fDAO.adiciona(funci);
		System.out.println("Funcionário "+ funci.getNome() + " adicionado");
		
		List <Funcionario> funcionarios = fDAO.getLista();
		
		for (Funcionario f: funcionarios){
			System.out.println("id: " + f.getId());
			System.out.println("nome: " + f.getNome());
			System.out.println("usuário: " + f.getUsuario());
			System.out.println("senha: " + f.getSenha());
		}
	}
}
