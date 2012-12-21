/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.servlet;

import br.com.projeto.dao.NotaFiscalDAO;
import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.vo.ItemNota;
import br.com.projeto.vo.NotaFiscal;
import br.com.projeto.dao.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luiz
 */
public class CartController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strAction = request.getParameter("action");


        if (strAction != null && !strAction.equals("")) {
            if (strAction.equals("add")) {
                addToCart(request);
            } else if (strAction.equals("Atualizar")) {
                updateCart(request);
            } else if (strAction.equals("Retirar")) {
                deleteCart(request);
            } else if(strAction.equals("Finalizar")){
                finalizar(request);
            }
        }
        response.sendRedirect("../carrinho.jsp");
    }

    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strItemIndex = request.getParameter("itemIndex");
        ProdutoDAO cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        try {
            if (objCartBean != null) {
                cartBean = (ProdutoDAO) objCartBean;
            } else {
                cartBean = new ProdutoDAO();
            }
            cartBean.deleteCartItem(strItemIndex);
        } catch (Exception e) {
            System.out.println("Não foi possivel deletar o produto selecionado " + e);
        }
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemIndex");

        ProdutoDAO cartBean = null;
        try {
            Object objCartBean = session.getAttribute("cart");
            if (objCartBean != null) {
                cartBean = (ProdutoDAO) objCartBean;
            } else {
                cartBean = new ProdutoDAO();
            }
            cartBean.updateCartItem(strItemIndex, strQuantity);
        } catch (Exception e) {
            System.out.println("Não foi possivel atualizar o carrinho " + e);
        }
    }

    protected void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strModelNo = request.getParameter("modelNo");
        String strPrice = request.getParameter("price");
        String strQuantity = request.getParameter("quantity");

        ProdutoDAO cartBean = null;
        try {
            Object objCartBean = session.getAttribute("cart");

            if (objCartBean != null) {
                cartBean = (ProdutoDAO) objCartBean;
            } else {
                cartBean = new ProdutoDAO();
                session.setAttribute("cart", cartBean);
            }

            cartBean.addCartItem(strModelNo, strPrice, strQuantity);
        } catch (Exception e) {
            System.out.println("Não foi possivel adicionar ao carrinho " + e);
        }
    }
    protected void finalizar(HttpServletRequest request){
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("idProduto"));
        String nome = request.getParameter("nome");
        int qtde = Integer.parseInt(request.getParameter("quantity"));
        Double precoUnitario = Double.parseDouble(request.getParameter("price"));
        Double precoFinal = Double.parseDouble(request.getParameter("precoFinal"));
        
        NotaFiscal nota = new NotaFiscal();
        nota.setNomeCliente(nome);
        NotaFiscalDAO notadao = new NotaFiscalDAO();
        notadao.adiciona(nota);
        
        ItemNota item = new ItemNota();
        item.setIdProduto(id);
        item.setQtde(qtde);
        item.setValorUnitario(precoUnitario);
        item.setValorTotal(precoFinal);
        
        notadao.adicionaItemNota(item);
        
        session.invalidate();
    }
}