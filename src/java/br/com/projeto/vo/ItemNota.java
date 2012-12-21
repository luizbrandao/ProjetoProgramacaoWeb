/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.vo;

/**
 *
 * @author luiz
 */
public class ItemNota {

    private int idNota;
    private int idProduto;
    private int qtde;
    private double valorUnitario;
    private double valorTotal;

    /**
     * @return the idNota
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

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

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}