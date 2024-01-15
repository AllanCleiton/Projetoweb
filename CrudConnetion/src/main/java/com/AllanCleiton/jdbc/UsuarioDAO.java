 package com.AllanCleiton.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.AllanCleiton.entidades.Usuario;

public class UsuarioDAO {
	private Connection con = Conexao.getConnection();
	
	public void Cadastrar(Usuario usuario) {
		//Mount SQL
		String sql = "insert into usuario (nome,login,senha) values (?,?,MD5(?))";
		
		//build the PreparedStatement with o SQl 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Replacing SQL statement parameters 
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario cadastrado com sucesso!");
		} catch (SQLException e) {
			
			System.out.println("Erro ao tentar cadastrar usuario." + e.getMessage());
		}
	}
	
	
	public void Alterar(Usuario usuario) {
		//Mount SQL
		String sql = "update usuario set login = ? , senha = ? where iduse = ?";
		
		//build the PreparedStatement with o SQl 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Replacing SQL statement parameters
		
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			preparador.setInt(3, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario alterado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar alterar usuario. >" + e.getMessage());
		}
	}
	
	
	public void Excluir(Usuario usuario) {
		//Mount SQL
		String sql = "delete from usuario where iduse = ?";
		
		//build the PreparedStatement with o SQl 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Replacing SQL statement parameters
		
			preparador.setInt(1, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario excluido com sucesso!");
		} catch (SQLException e) {
			
			System.out.println("Erro ao tentar excluir usuario. >" + e.getMessage());
		}
	}
	
	public ArrayList<Usuario> BuscarTodos() {
		
		ArrayList<Usuario> usuQuary = new ArrayList<>();
		
		String sql = "select * from usuario";
		
		//build the PreparedStatement with o SQl 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Usuario usu = new Usuario();
				
				usu.setId(resultado.getInt("iduse"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				
				usuQuary.add(usu);
				
			}
			
			
			preparador.close();
			
			System.out.println("Busca realizada com sucesso!");
		} catch (SQLException e) {
			
			System.out.println("Erro ao tentar buscar lista de usuario. >" + e.getMessage());
		}
		return usuQuary;
	}
	
}
