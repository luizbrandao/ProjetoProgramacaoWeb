<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Principal - Sistema de Gerenciamento de Ecommerce </title>
    </head>
    <body>
        Seja bem-vindo <c:out value="${sessionScope.nomeUsuario}"/>
        <h1>Escolha sua Ação</h1>
        <a href="produtos.jsp">Ver Produtos</a>
        <a href="carrinho.jsp">Visualizar Carrinho</a>
        Emitir Nota Fiscal
        Visualizar Notas
        <a href="logout.jsp">Logout</a>
    </body>
</html>