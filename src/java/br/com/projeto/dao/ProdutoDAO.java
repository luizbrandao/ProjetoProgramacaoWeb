package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.vo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luiz
 */
public class ProdutoDAO {

    private Connection connection = null;
    private ArrayList CartItems = new ArrayList();
    private double OrderTotal;

    public ProdutoDAO() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = new ConnectionFactory().getConnection();
    }

    public List<Produto> getLista() {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            PreparedStatement stmt = connection.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNomeProduto(rs.getString("nomeproduto"));
                produto.setValorUnitario(rs.getDouble("valorunitario"));
                produto.setImagem(rs.getString("imagem"));
                produto.setQtdeEstoque(rs.getInt("qtdeestoque"));

                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adiciona(Produto produto) {
        try {
            String sql = "insert into produto (nomeproduto, valorunitario, imagem, qtdeestoque) values (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getValorUnitario());
            stmt.setString(3, produto.getImagem());
            stmt.setInt(4, produto.getQtdeEstoque());

            stmt.execute();
            stmt.close();
            System.out.println("Gravado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> getPesquisa(Produto produto) {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            String sql = "select * from produto where nomeproduto like ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNomeProduto(rs.getString("nomeproduto"));
                produto.setValorUnitario(rs.getDouble("valorunitario"));
                produto.setImagem(rs.getString("imagem"));
                produto.setQtdeEstoque(rs.getInt("qtdeestoque"));

                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLineItemCount() {
        return CartItems.size();
    }

    public Produto getCartItem(int iItemIndex) {
        Produto produto = null;
        if (CartItems.size() > iItemIndex) {
            produto = (Produto) CartItems.get(iItemIndex);
        }
        return produto;
    }

    public ArrayList getCartItems() {
        return CartItems;
    }

    public void setCartItems(ArrayList alCartItems) {
        this.CartItems = alCartItems;
    }

    public double getOrderTotal() {
        return OrderTotal;
    }

    public void setOrderTotal(double dblOrderTotal) {
        this.OrderTotal = dblOrderTotal;
    }

    protected void calculateOrderTotal() {
        double dblTotal = 0;
        for (int counter = 0; counter < CartItems.size(); counter++) {
            Produto cartItem = (Produto) CartItems.get(counter);
            dblTotal += cartItem.getPrecoFinal();
        }
        setOrderTotal(dblTotal);
    }

    public void deleteCartItem(String strItemIndex) {
        int iItemIndex = 0;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            CartItems.remove(iItemIndex - 1);
            calculateOrderTotal();
        } catch (NumberFormatException nfe) {
            System.out.println("Não possivel deletar o item selecionado: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public void updateCartItem(String strItemIndex, String strQuantity) {
        double precoTotal = 0.0;
        double precoUnico = 0.0;
        int qtde = 0;
        int iItemIndex = 0;
        Produto produto = null;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            qtde = Integer.parseInt(strQuantity);
            if (qtde > 0) {
                produto = (Produto) CartItems.get(iItemIndex - 1);
                precoUnico = produto.getValorUnitario();
                precoTotal = precoUnico * qtde;
                produto.setQtde(qtde);
                produto.setPrecoFinal(precoTotal);
                calculateOrderTotal();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Não foi possivel atualizar o item selecionado: " + nfe.getMessage());
            nfe.printStackTrace();
        }

    }

    public void addCartItem(String strModelNo, String strUnitCost, String strQuantity) {
        double precoTotal = 0.0;
        double precoUnico = 0.0;
        int qtde = 0;
        Produto produto = new Produto();
        try {
            precoUnico = Double.parseDouble(strUnitCost);
            qtde = Integer.parseInt(strQuantity);
            if (qtde > 0) {
                precoTotal = precoUnico * qtde;
                produto.setNomeProduto(strModelNo);
                produto.setValorUnitario(precoUnico);
                produto.setQtde(qtde);
                produto.setPrecoFinal(precoTotal);
                CartItems.add(produto);
                calculateOrderTotal();
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Não foi possivel adicionar itens ao carrinho: " + nfe.getMessage());
        }
    }
}