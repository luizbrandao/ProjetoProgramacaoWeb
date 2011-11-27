<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<jsp:useBean id="dao" class="br.com.projeto.dao.ProdutoDAO"/>
<h2>Lista do produtos cadastrados</h2>
<form method="post" action="buscaLogin" id="buscaProduto" name="buscaProduto">
    <p>
        <label for="pesquisar">Pesquisar: &nbsp;</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
    <input type="submit" value="Buscar"/>
</form>
<table border="1">
    <thead>
        <tr>
            <td>ID</td>
            <td>Nome</td>
            <td>Valor Unitário</td>
            <td>Imagem</td>
            <td>Estoque</td>
            <td>Ações</td>
        </tr>
    </thead>
    <tbody>
        <!-- percorre contatos montando as linhas da tabela -->

        <c:forEach var="produto" items="${dao.lista}">
            <tr>
                <td>${produto.idProduto}</td>
                <td>${produto.nomeProduto}</td>
                <td>${produto.valorUnitario}</td>
                <td>${produto.imagem}</td>
                <td>${produto.qtdeEstoque}</td>
                <td>
                    <a href="#"><img src="_img/edit.png" width="16" height="16" /></a>
                    <a href="#"><img src="_img/delete.png" width="16" height="16"/></a>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>
