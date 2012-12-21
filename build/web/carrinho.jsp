<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" scope="session" class="br.com.projeto.dao.ProdutoDAO" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />

        <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
        Remove this if you use the .htaccess --><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

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
                    <a href="index.jsp" id="home" title="Página Inicial"> Página Inicial </a> Olá, Fulano 
                    <a href="logout.jsp" class="logout-btn"> Logout </a>
                </div>
            </div>
        </div>
        <div class='container_12' id='opcao-home'>
            <div class='grid_12'>
                <h3 class='titulo-geral'>Sistema de Gerenciamento de Ecommerce <br />  <small>Carrinho de Compras</small>
            </div>
            <table width="75%" border="1">
                <tr > 
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
                                <c:out value="${cartItem.valorUnitario}"/>
                                </font>
                            </td>
                            <td>
                                <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                                $<c:out value="${cartItem.precoFinal}"/>
                                </font>
                            </td>
                        </tr>
                        <input type="hidden" name="action" value="finish"/>
                        <input type="submit" name="finalizar compra" value="Finalizar" />
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
        </div>
    </body>
</html>