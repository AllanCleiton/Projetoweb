package com.AllanCleiton.Testes;
import java.util.List;
import com.AllanCleiton.entidades.Usuario;
import com.AllanCleiton.jdbc.UsuarioDAO;

public class TestConexao {

	public static void main(String[] args) {
		
		testCadastrar();
		
		testAlterar();
		
		testExcluir();
		
		testBuscarTodos();
	}

	private static void testCadastrar() {
		Usuario usuario = new Usuario();
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		usuariodao.Cadastrar(usuario);
	}
	
	private static void testAlterar() {
		
		Usuario usuario = new Usuario();
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		usuario.setId(4);
		usuariodao.Alterar(usuario);
	
	}
	
	private static void testExcluir() {
		
		Usuario usuario = new Usuario();
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		usuario.setId(4);
		usuariodao.Excluir(usuario);
	
	}
	
	private static void testBuscarTodos() {
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		List<Usuario> listaResultado = usuariodao.BuscarTodos();
		
		for(Usuario u: listaResultado) {
			System.out.printf("%d | %s | %s | %s \n", u.getId(), u.getNome(), u.getLogin(), u.getSenha());
		}
		
		
	}

}