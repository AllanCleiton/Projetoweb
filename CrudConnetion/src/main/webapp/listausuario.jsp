<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Busca Usu�rio</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/styletabela.css">
</head>

<body>
    <header>
        <a id="nav" href="#">HOME</a>
        <a id="nav" href="frmusuario.html">CADASTRAR</a>
        <a id="nav" href="frmalterarusuario.html">ALTERAR</a>
        <a id="nav" href="usucontroller.do?action=list">LISTAR USUARIO</a>
    </header>
    <main>
    
        <table>
            <thead>
                <tr>
                    <th >ID</th>
                    <th>NOME</th>
                    <th>LOGIN</th>
                    <th>A��O</th>
                </tr>
            </thead> 
            <tbody>
           		<c:forEach items="${requestScope.lista}" var="usuario">
					<tr>
                        <td>${usuario.id}</td>
                        <td>${usuario.nome}</td>
                        <td>${usuario.login}</td>
                        <td>
                        	<a href ="usucontroller.do?action=excluir&id=${usuario.id}">EXCLUIR</a>|
                        	<a href ="usucontroller.do?action=alt&id=${usuario.id}">ALTERAR</a>
                        </td>
                    </tr>
				</c:forEach>
            </tbody>
        </table>
            
       
    </main>
    
</body>

</html>

