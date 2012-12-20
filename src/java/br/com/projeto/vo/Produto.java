/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.vo;

/**
 *
 * @author luiz
 */
public class Produto {

    private int idProduto;
    private String nomeProduto;
    private double valorUnitario;
    private String imagem;
    private int qtdeEstoque;
    private int qtde;
    private double precoFinal;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nome
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nome the nome to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the qtdeEstoque
     */
    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    /**
     * @param qtdeEstoque the qtdeEstoque to set
     */
    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    /**
     * @return the valorunitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorunitario the valorunitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the precoFinal
     */
    public double getPrecoFinal() {
        return precoFinal;
    }

    /**
     * @param precoFinal the precoFinal to set
     */
    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
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