<%@page import="java.util.ArrayList" %>
<%@page import= "com.AllanCleiton.entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Busca Usuario</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/styletabela.css">
</head>

<body>
    <header>
        <a id="nav" href="#">HOME</a>
        <a id="nav" href="frmusuario.html">CADASTRAR</a>
        <a id="nav" href="frmalterarusuario.html">ALTERAR</a>
        <a id="nav" href="usucontroller.do">LISTAR USUARIO</a>
    </header>
    <main>
    
        <table>
            <thead>
                <tr>
                    <th >ID</th>
                    <th>NOME</th>
                    <th>LOGIN</th>
                    <th>AÇÃO</th>
                </tr>
            </thead> 
            <tbody>
                <%ArrayList<Usuario> lista = (ArrayList<Usuario>)request.getAttribute("Lista");
                   
                for(Usuario usuario:lista){%>
                        
                    <tr>
                        <td><%out.print(usuario.getId());%></td>
                        <td><%=usuario.getNome()%></td>
                        <td><%=usuario.getLogin()%></td>
                        <td><a href ="usucontroller.do?action=excluir&id=<%=usuario.getId()%>">EXCLUIR</a></td>
                    </tr>
              <%}%>    
            </tbody>
        </table>
            
       
    </main>
    
</body>

</html>

