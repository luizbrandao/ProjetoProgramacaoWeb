<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="dao" class="br.com.projeto.dao.UsuarioDAO"/>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Nome</td>
        <td>Email</td>
        <td>Endereço</td>
        <td>Data de Nascimento</td>
        <td>Ações</td>
    </tr>
    <!-- percorre contatos montando as linhas da tabela -->
    <c:forEach var="usuario" items="${dao.lista}">
        <tr>
            <td>${usuario.idUsuario}</td>
            <td>${usuario.nomeUsuario}</td>
            <td>${usuario.senha}</td>
        </tr>
    </c:forEach>
</table>