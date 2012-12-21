/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.teste;

import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.vo.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luiz
 */
public class TestePesquisa {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            Produto produto = new Produto();
            produto.setNomeProduto("Revista Info");
            
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = new ArrayList<Produto>();
            
            produtos = dao.getPesquisa(produto);
            
            for (Produto produto2 : produtos) {
                System.out.println("Id Produto: " + produto2.getIdProduto());
                System.out.println("Nome Produto: " + produto2.getNomeProduto());
                System.out.println("Valor unitario: " + produto2.getValorUnitario());
                System.out.println("Quantidade em estoque: " + produto2.getQtdeEstoque());
                System.out.println("Imagem do produto: " + produto2.getImagem());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
