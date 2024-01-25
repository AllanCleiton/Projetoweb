<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "com.AllanCleiton.entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Busca Usuario</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="stylefrm.css">
    <style>
            table{
                background-color: #FFFFFF;
                width: 800px;
                border-collapse: collapse;
                
            }
            thead{
                background-color: #4e81bd;
                border-bottom: 2px solid rgb(255, 255, 255);
            }
           
          
            td{
                border: 1px solid rgb(255, 255, 255);
                font-size: 16px;
                border-right: 2px solid rgb(255, 255, 255);
                
            }
            th{
                border: 1px solid rgb(255, 255, 255);
                padding: 5px;
                border-right: 2px solid rgb(255, 255, 255);
                
            }
            
            tbody > tr:nth-child(2n){
                background-color: #b8cce4;
            }

            main{
               
                height: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
            }
          
 

    </style>
</head>

<body>
    <header>
        <a href="#">HOME</a>
        <a href="frmusuario.html">CADASTRAR</a>
        <a href="frmaltusuario.html">ALTERAR</a>
        <a href="frmbuscarusuario.html">PESQUISAR</a>
        <a href="frmexcluirusuario.html">EXCLUIR</a>
    </header>
    <main>
    
        <table>
            <thead>
                <tr>
                    <th >ID</th>
                    <th>NOME</th>
                    <th>LOGIN</th>
                    <th>SENHA</th>
                </tr>
            </thead> 
            <tbody>
                <%ArrayList<Usuario> lista = (ArrayList<Usuario>)request.getAttribute("Lista");
                   
                for(Usuario usuario:lista){%>
                        
                    <tr>
                        <td><%out.print(usuario.getId()) ;%></td>
                        <td><%out.print(usuario.getNome());%></td>
                        <td><%out.print(usuario.getLogin());%></td>
                        <td><%out.print(usuario.getSenha());%></td>
                    </tr>
              <%}%>    
            </tbody>
        </table>
            
       
    </main>
    
</body>

</html>
