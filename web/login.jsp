<%-- 
    Document   : login
    Created on : 18/10/2011, 19:00:06
    Author     : luiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        Bem vindo a Página de Login:
        <form name="realizaLogin" method="post" action="">
            Usuario: <input type="text" id="nomeUsuario" value=""/><br/>
            Senha <input type="text/password" id="senha" value=""/>
            <input type="submit" value="Login!"/>
        </form>
    </body>
</html>
