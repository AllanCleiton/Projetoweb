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
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";
		
		
		//build the PreparedStatement with o SQl 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Replacing SQL statement parameters 
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario cadastrado com sucesso! ");
		} catch (SQLException e) {
			
			System.out.println("Erro ao tentar cadastrar usuario. " + e.getMessage());
		}
	}
	
	public void Alterar(Usuario usuario) {
		//Mount SQL
		String sql = "update usuario set nome = ?, login = ? , senha = ? where iduse = ?";
		
		//build the PreparedStatement with o SQl 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Replacing SQL statement parameters
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
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
				Usuario usuario = new Usuario();
				
				usuario.setId(resultado.getInt("iduse"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				usuQuary.add(usuario);
				
			}
			
			
			preparador.close();
			
			System.out.println("Busca realizada com sucesso!");
		} catch (SQLException e) {
			
			System.out.println("Erro ao tentar buscar lista de usuario. >" + e.getMessage());
		}
		return usuQuary;
	}
	
	public Usuario BuscaPorId(Integer id) {
		//pointer for user start with null.
		Usuario usuario = null;
		
		String sql = "select * from usuario where iduse = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				//if exist one register in database, the user pointer is initialized
				usuario = new Usuario();
				
				usuario.setId(resultado.getInt("iduse")); 
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			}
			
			preparador.close();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return usuario;
		
	}
	
	
}
