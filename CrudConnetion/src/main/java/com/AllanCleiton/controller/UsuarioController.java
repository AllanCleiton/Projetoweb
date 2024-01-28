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
		//MENSAGEM NO CONSOLE
		System.out.println("Chamando metodod get..");
		String action = request.getParameter("action");   //CAPTURA PARAMETRO DA TELA
		
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();   //INSTANCIANDO OBJETO DA CLASSE USUARIODAO
		
		if(action != null && action.equals("excluir")) {   //ESTRUTURA DE DECISAO PARA ACAO DO CONTROLLER
			String id = request.getParameter("id");
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			usuarioDAO.Excluir(usuario);
		}
		
		
		if(action != null && action.equals("alt")) {   //ESTRUTURA DE DECISAO PARA ACAO DO CONTROLLER
			String id = request.getParameter("id");   //CAPTURA PARAMETRO DA TELA
			Usuario usuario = usuarioDAO.BuscaPorId(Integer.parseInt(id));  //BUSCA UM REGISTRO USUARIO ATRAVEZ DO METODO BUSCA POR ID DA CLASSE USUARIODAO
			request.setAttribute("usuario", usuario);   //CRIANDO UM ATRIBUTO DENTRO DO OBJETO REQUEST COM O OBJETO USUARIO 
			
			
			RequestDispatcher saida = request.getRequestDispatcher("frmalterarusuario.jsp");    //ENCAMINHANDO PARA O JSP
			saida.forward(request, response);
		}
		
		if(action != null && action.equals("list")) {   //ESTRUTURA DE DECISAO PARA ACAO DO CONTROLLER
			ArrayList<Usuario> lista = usuarioDAO.BuscarTodos();   //CRIANDO A LISTA DE USUARIOS ATRAVEZ DO METODO BUSCAR TODOS
			
			request.setAttribute("Lista", lista);   //CRIA UM ATRIBITO DENTRO DO REQUEST COM A LISTA DE USUARIO 
			
			//ENCAMINHAMENTO PARA O JSP
			RequestDispatcher saida = request.getRequestDispatcher("listausuario.jsp");
			saida.forward(request, response);
		}
	
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
			
			ArrayList<Usuario> lista = usuarioDAO.BuscarTodos();   //CRIANDO A LISTA DE USUARIOS ATRAVEZ DO METODO BUSCAR TODOS
			
			request.setAttribute("Lista", lista);   //CRIA UM ATRIBITO DENTRO DO REQUEST COM A LISTA DE USUARIO 
			
			RequestDispatcher saida = request.getRequestDispatcher("listausuario.jsp");  //ENCAMINHAMENTO PARA O JSP
			saida.forward(request, response);
			
			
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
		
	}
}
