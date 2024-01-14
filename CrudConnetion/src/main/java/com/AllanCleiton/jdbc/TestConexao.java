package com.AllanCleiton.jdbc;
import com.AllanCleiton.entidades.Usuario;
public class TestConexao {

	public static void main(String[] args) {
		Usuario usuario = new Usuario("laura","laurinha","001");
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		usuariodao.Cadastrar(usuario);

	}

}
