<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><meta charset="utf-8" />

        <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
        Remove this if you use the .htaccess -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Sistema Gerenciador de Ecommerce</title>
        <meta name="description" content="" />
        <meta name="generator" content="Studio 3 http://aptana.com/" />
        <meta name="author" content="Luís Fernando" />
        <meta name="viewport" content="width=device-width; initial-scale=1.0" />
        <!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references
        <link rel="shortcut icon" href="/favicon.ico" />
        <link rel="apple-touch-icon" href="/apple-touch-icon.png" /> -->
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css" />
        <link rel="stylesheet" type="text/css" href="estilos/estilo-home.css" />
        <link rel="stylesheet" type="text/css" href="estilos/reset.css" />
        <link rel="stylesheet" type="text/css" href="estilos/960.css" />
        <script type="text/javascript" src='js/jquery-1.7.1.js'></script>
        <script type="text/javascript" src='js/custom.js'></script>

    </head>
    <body>
        <div id='container-login'>
            <h4 class='login-titulo'>
                Realize seu login
            </h4>	
            <form class='form-login' title="login" method="post" action="login">
                <input type='text' name ="nomeUsuario" id="nomeUsuario" placeholder='Digite seu Login' />
                <input type='password' name="senha" id="senha" placeholder='Digite sua senha' />
                <img src="Kaptcha.jpg" alt='Kaptcha'/>
                <input type='text' name="kaptcha" id="kaptcha" placeholder='Digite os caracteres da figura acima' />
                <button type='submit' title='Login'>Login</button>
            </form>
            <span class='footer'> SGEC v.1.0 </span>
        </div>
    </body>
</html>