<%-- 
    Document   : ShoppingCart
    Created on : 09/12/2011, 20:31:58
    Author     : luiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" scope="session" class="br.com.projeto.dao.ProdutoDAO" />

<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Produtos - Projeto de Programação Web</title>
    </head>
    <body>
        <p>
            Esse é o seu carrinho de compras!!
        </p>
        <p>
            <a href="produtos.jsp" mce_href="produtos.jsp">Lista de Produtos</a>
        </p>
        <table width="75%" border="1">
            <tr bgcolor="#CCCCCC"> 
                <td>
                    <strong>
                        <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                        Nome do Produto
                        </font>
                    </strong>
                </td>
                <td>
                    <strong>
                        <font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantidade</font>
                    </strong>
                </td>
                <td>
                    <strong>
                        <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                        Preço Unitário
                        </font>
                    </strong>
                </td>
                <td>
                    <strong>
                        <font size="2" face="Verdana, Arial, Helvetica, sans-serif">Total</font>
                    </strong>
                </td>
            </tr>

            <c:if test="${cart.lineItemCount==0}">
                <tr>
                    <td colspan="4">
                        <font size="2" face="Verdana, Arial, Helvetica, sans-serif"/>
                        - Você ainda não possui produtos no carrinho-
                        <br/>
                    </td>
                </tr>
            </c:if>
            <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter"> 
                <form name="item" method="POST" action="servlet/CartController">
                    <tr> 
                        <td>
                            <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
<<<<<<< HEAD
                            <input type="hidden" name="idProduto" value="<c:out value="${cartItem.idProduto}"/>"/>
=======
>>>>>>> f500da3c50c30c7f5d248ecb9bdab36f4a285770
                            <c:out value="${cartItem.nomeProduto}"/>
                            <input type="hidden" name="modelNo" value="<c:out value="${cartItem.nomeProduto}"/>" />
                            <br/>
                            </font>
                        </td>
                        <td>
                            <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                            <input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/>'/>
                            <input type='text' name="quantity" value='<c:out value="${cartItem.qtde}"/>' size='2'/>
                            <input type="submit" name="action" value="Atualizar"/>
                            <br/>
                            <input type="submit" name="action" value="Retirar"/>
                            </font>
                        </td>
                        <td>
                            <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
<<<<<<< HEAD
                            R$<c:out value="${cartItem.valorUnitario}"/>
                            <input type="hidden" name="precoUnitario" value="<c:out value="${cartItem.valorUnitario}"/>"/>
=======
                            $<c:out value="${cartItem.valorUnitario}"/>
>>>>>>> f500da3c50c30c7f5d248ecb9bdab36f4a285770
                            </font>
                        </td>
                        <td>
                            <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
<<<<<<< HEAD
                            R$<c:out value="${cartItem.precoFinal}"/>
                            <input type="hidden" name="precoFinal" value="<c:out value="${cartItem.valorUnitario}"/>"/>
                            </font>
                        </td>
                    </tr>
                    <input type="hidden" name="action" value="finish"/>
                    <input type="submit" name="finalizar compra" value="Finalizar"/>
=======
                            $<c:out value="${cartItem.precoFinal}"/>
                            </font>
                        </td>
                    </tr>
>>>>>>> f500da3c50c30c7f5d248ecb9bdab36f4a285770
                </form>
            </c:forEach> 
            <tr> 
                <td colspan="2"> </td>
                <td> </td>
                <td>
                    <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                    Subtotal: $<c:out value="${cart.orderTotal}"/>
                    </font>
                </td>
            </tr>
        </table>
<<<<<<< HEAD

=======
>>>>>>> f500da3c50c30c7f5d248ecb9bdab36f4a285770
    </body>
</html>