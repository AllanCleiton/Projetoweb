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
		//doGet(request, response);
		System.out.println("Chamando Metodo POST! ");
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("txtnome"));
		usuario.setLogin(request.getParameter("txtlogin"));
		usuario.setSenha(request.getParameter("txtsenha"));
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.Cadastrar(usuario);
		
		PrintWriter  saida = response.getWriter();
		saida.println("Cadastrado");
		
		System.out.println(usuario.getNome() + usuario.getLogin() + usuario.getSenha());
	}

}
