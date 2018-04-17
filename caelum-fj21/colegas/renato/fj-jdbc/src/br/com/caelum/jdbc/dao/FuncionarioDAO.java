package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDAO {
	private Connection connection;

	public FuncionarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funci) {
		String sql = "insert into funcionarios " + "(nome,usuario,senha)"
				+ " values (?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funci.getNome());
			stmt.setString(2, funci.getUsuario());
			stmt.setString(3, funci.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Funcionario> getLista(){
		try{
			List<Funcionario> f = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Funcionario func = new Funcionario();
				func.setId(rs.getLong("id"));
				func.setNome(rs.getString("nome"));
				func.setUsuario(rs.getString("usuario"));
				func.setSenha(rs.getString("senha"));
				
				f.add(func);
			}
			stmt.close();
			return f;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}