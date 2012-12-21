/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

/**
 *
 * @author luiz
 */
public class ItemCarrinho {
    private String produto;
    private int qtde;

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
