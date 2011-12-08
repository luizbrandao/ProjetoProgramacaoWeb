/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.servlet;

import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.vo.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luiz
 */
public class PesquisaServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            String nomeproduto = req.getParameter("pesquisar");
            Produto produto = new Produto();
            produto.setNomeProduto(nomeproduto);
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> pesquisa = new ArrayList<Produto>();
            
            pesquisa = dao.pesquisar(produto);
            if(pesquisa != null){
                System.out.println("Busca realizada com sucesso");
                RequestDispatcher rd = req.getRequestDispatcher("resultadoPesquisa.jsp");
                rd.forward(req, res);
            }else{
                System.out.println("Não foi possivel realizar a busca de Produtos");
                RequestDispatcher rd = req.getRequestDispatcher("buscaProduto.jsp");
                rd.forward(req, res);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
