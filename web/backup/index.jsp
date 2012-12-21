<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Gerenciamento de Ecommerce - Login</title>
        <link rel="stylesheet" href="_css/estilo.css" media="screen" />
        <script type="text/javascript" src="_js/jquery.js"></script>
        <script type="text/javascript" src="_js/validate.js"></script>
        <script type="text/javascript" src="_js/validaLogin.js"></script>
    </head>
    <body>
        Bem vindo a Página de Login:
        <div id="status"><label></label></div>
        <form name="login" id="login" method="post" action="login">
            <fieldset>
                <label for="nomeUsuario">Usuario: &nbsp;</label>
                <input type="text" name ="nomeUsuario" id="nomeUsuario" size="20"/>
                <br/>
                <label for="senha">Senha: &nbsp;</label>
                <input type="password" name="senha" id="senha" size="20" /><br/>
                <img src="Kaptcha.jpg" alt="kaptcha" /><br />
                <label for="kaptcha">Código: </label>
                <input type="text" name="kaptcha" id="kaptcha" size="20"/><br/>
                <input type="submit" value="Login!"/>
            </fieldset>
        </form>
    </body>
</html>