 package com.AllanCleiton.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AllanCleiton.entidades.Usuario;

public class UsuarioDAO {
	private Connection con = Conexao.getConnection();
	
	public void Cadastrar(Usuario usuario) {
		//Monta SQL
		String sql = "insert into usuario (nome,login,senha) values (?,?,MD5(?))";
		
		//Constroi o PreparedStatement com o SQl 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Subistituindo os parametros da instrucao SQl
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario cadastrado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao tentar cadastrar usuario." + e.getMessage());
		}
	}
	
}
