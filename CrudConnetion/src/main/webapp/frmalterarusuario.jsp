<%@page import= "com.AllanCleiton.entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar usuário</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/stylefrm.css">
</head>

<body>
	
	<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
	%>
	
    <header>
        <a id="nav" href="#">HOME</a>
        <a id="nav" href="frmusuario.html">CADASTRAR</a>
        <a id="nav" href="frmalterarusuario.jsp">ALTERAR</a>
        <a id="nav" href="usucontroller.do?action=list">LISTAR USUÁRIO</a>
    </header>

    <form action="usucontroller.do" method="post" autocomplete="off" style="margin-top: 0%;">
        <h1 style="color: aliceblue; ">Alterar usuário</h1>
        
        <div id="div01">
            <div id="divL">
                <label style="color: aliceblue;">ID: </label>
                <label style="color: aliceblue;">Nome: </label>
                <label style="color: aliceblue;">Login: </label>
                <label style="color: aliceblue;">Senha: </label>
            </div>
            <div>
                <input type="text" name="txtid" value="<%=usuario.getId() %>">
                <input type="text" name="txtnome" value="<%=usuario.getNome() %>">
                <input type="text" name="txtlogin" value="<%=usuario.getLogin() %>">
              	<input type="password" name="txtsenha" value="<%=usuario.getSenha() %>">
            </div>
        </div>
        
        <div id="sub01"><input type="submit" name="btnsubmit" value="Alterar" id="sub02" ></div>
    </form>

</body>

</html>