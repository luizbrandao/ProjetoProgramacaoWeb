<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        Bem vindo a Página de Login:
        <form name="login" method="post" action="login">
            <label for="nomeUsuario">Usuario: &nbsp;</label>
            <input type="text" name ="nomeUsuario" id="nomeUsuario" /><br/>
            <label for="senha">Senha: &nbsp;</label>
            <input type="password" name="senha" id="senha" /><br/>
            <img src="Kaptcha.jpg" alt="kaptcha" /><br />
            <label for="kaptcha">Código: </label>
            <input type="text" name="kaptcha" id="kaptcha"/><br/>
            <input type="submit" value="Login!"/>
        </form>
    </body>
</html>