package com.AllanCleiton.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.AllanCleiton.entidades.HtmlTelas;
import com.AllanCleiton.entidades.Usuario;
import com.AllanCleiton.jdbc.UsuarioDAO;


public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HtmlTelas telas = new HtmlTelas();   
	
    public UsuarioController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Chamando metodod get!");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		ArrayList<Usuario> lista = usuarioDAO.BuscarTodos();
		
		PrintWriter html = response.getWriter();
		html.println(telas.Inicio_Tabela());
		
		for(Usuario usuario: lista) {
			html = response.getWriter();
			html.println("<tr> <!--Primeira linha-->\r\n"
		+ "                    <td class=\"coluna\">"+usuario.getId()+"</td>\r\n"
		+ "                    <td class=\"coluna2\">"+usuario.getNome()+"</td>\r\n"
		+ "                    <td class=\"coluna\">"+usuario.getLogin()+"</td>\r\n"
		+ "                </tr>");
		}
		
		html = response.getWriter();
		html.println(telas.Fim_Tabela());
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Chamando Metodo POST! ");
		
		
		String p = request.getParameter("btnsubmit");
		
		
		if (p.equals("Alterar")) {
			Usuario usuario = new Usuario();
			
			usuario.setId(Integer.parseInt(request.getParameter("txtid")));
			usuario.setNome(request.getParameter("txtnome"));
			usuario.setLogin(request.getParameter("txtlogin"));
			usuario.setSenha(request.getParameter("txtsenha"));
			
			
			//asks the DAO user to register in the database
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.Alterar(usuario);
			
			PrintWriter html = response.getWriter();
			html.println(telas.TelaAlterar());
			
		}
		
		
		if(p.equals("Cadastrar")) {
			//creates the user object and inserts the values ​​from the screen
			Usuario usuario = new Usuario();
			usuario.setNome(request.getParameter("txtnome"));
			usuario.setLogin(request.getParameter("txtlogin"));
			usuario.setSenha(request.getParameter("txtsenha"));
			
			
			//asks the DAO user to register in the database
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.Cadastrar(usuario);
			
			PrintWriter html = response.getWriter();
			html.println(telas.TelaCadastro());
		}
		
		
		if(p.equals("Excluir")) {
			//creates the user object and inserts the values ​​from the screen
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(request.getParameter("txtid")));
			usuario.setNome(request.getParameter("txtnome"));
			usuario.setLogin(request.getParameter("txtlogin"));
			usuario.setSenha(request.getParameter("txtsenha"));
			
			
			//asks the DAO user to register in the database
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.Excluir(usuario);
			
			PrintWriter html = response.getWriter();
			html.println(telas.TelaAlterar());
		}
	
	}

}
