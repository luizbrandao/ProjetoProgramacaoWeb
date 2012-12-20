<%-- 
    Document   : modelList
    Created on : 09/12/2011, 20:31:46
    Author     : luiz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<jsp:useBean id="dao" class="br.com.projeto.dao.ProdutoDAO"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos - Sistema de Gerenciamento de Ecommerce </title>
    </head>
    <body>
        Seja Bem vindo <c:out value="${usuario.nomeUsuario}"/>!
        <p>
            Lista de Produtos
        </p>
        <a href="carrinho.jsp" mce_href="carrinho.jsp">Ver Carrinho de Compras</a>
        <p/>    
        <!-- percorre contatos montando as linhas da tabela -->
        <c:forEach var="produto" items="${dao.lista}">
            <div>
                <form method="POST" action="servlet/CartController">
                    <fieldset>
                        Id do Produto: ${produto.idProduto}<br/>
                        Nome do Produto: ${produto.nomeProduto}<br/>
                        <input type="hidden"  name="modelNo" value="${produto.nomeProduto}"/>
                        ValorUnitario: ${produto.valorUnitario}<br/>
                        <input type="hidden" name="price" value="${produto.valorUnitario}"/>
                        Quantidade: <input type="text" size="2" value="1" name="quantity"/><br/>
                        Imagem do Produto: <a href="${produto.imagem}"></a><br/>
                        Quantidade em Estoque: ${produto.qtdeEstoque}<br/>
                        <input type="hidden" name="action" value="add"/>
                        <input type="submit" name="addToCart" value="Adicionar ao Carrinho"/>
                    </fieldset>
                </form>
            </div>
        </c:forEach>
    </body>
</html>