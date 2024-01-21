package com.AllanCleiton.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import com.AllanCleiton.entidades.Usuario;
import com.AllanCleiton.jdbc.UsuarioDAO;


public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsuarioController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	
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
			
		}
	
	}

}
