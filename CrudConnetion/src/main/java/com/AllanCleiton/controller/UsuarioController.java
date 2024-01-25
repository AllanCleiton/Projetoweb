package com.AllanCleiton.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


import com.AllanCleiton.entidades.Usuario;
import com.AllanCleiton.jdbc.UsuarioDAO;


public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public UsuarioController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Chamando metodod get!");
		
		//CRIANDO A LISTA DE USUARIOS
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<Usuario> lista = usuarioDAO.BuscarTodos();
		
		//ENCAMINHAMENTO PARA O JSP
		//COLOCANDO A LISTA DE USUARIO NO REQUEST
		request.setAttribute("Lista", lista);
		
		// ENCAMINHAR PARA O JSP
		
		RequestDispatcher saida = request.getRequestDispatcher("listausuario.jsp");
		saida.forward(request, response);;
		
	
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
			
			RequestDispatcher saida = request.getRequestDispatcher("telacadastro.jsp");
			saida.forward(request, response);
			
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
			
	
		}

	}
}
