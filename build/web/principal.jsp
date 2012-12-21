<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
        Remove this if you use the .htaccess -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Produtos</title><meta name="description" content="" />
        <meta name="generator" content="Studio 3 http://aptana.com/" />
        <meta name="author" content="LuÃ­s Fernando" />
        <meta name="viewport" content="width=device-width; initial-scale=1.0" />
        <!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
        <link rel="shortcut icon" href="/favicon.ico" />
        <link rel="apple-touch-icon" href="/apple-touch-icon.png" />
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css" />
        <link rel="stylesheet" type="text/css" href="estilos/reset.css" />
        <link rel="stylesheet" type="text/css" href="estilos/960.css" />
        <link rel="stylesheet" type="text/css" href="estilos/text.css" />

        <script type="text/javascript" src='js/jquery-1.7.1.js'></script>
        <script type="text/javascript" src='js/custom.js'>
        </script>
    </head>
    <body>
        <div id="admin-bar">
            <div class='container_12'>
                <div class='grid_12' id="admin-bar-container">	
                    <a href="index.jsp" id="home" title="Página Inicial"> Página Inicial </a> Ola, Fulano 
                    <a href="logout.jsp" class="logout-btn"> Logout </a>
                </div>
            </div>
        </div>
        <div class='container_12' id='opcao-home'>
            <div class='grid_12'>
                <h3 class='titulo-geral'>Sistema de Gerenciamento de Ecommerce</h3>
            </div>
            <div class='grid_3'>
                <span class='oque'>O que você deseja fazer?</span>
            </div>
            <div class='grid_2'>
                <a href="produtos.jsp" class='opcoes'>Listar produtos </a>
            </div>
            <div class='grid_2'>
                <a href="carrinho.jsp" class='opcoes'>Visualizar Carrinho </a>
            </div>
            <div class='grid_2'>
                <a href="#" class='opcoes'>Emitir Nota fiscal</a>
            </div>
            <div class='grid_2'>
                <a href="#" class='opcoes'>Visualizar notas </a>
            </div>
        </div>
    </body>
</html>