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

    public ProdutoDAO() throws SQLException, ClassNotFoundException {
        connection = new ConnectionFactory().getConnection();
    }

    public List<Produto> getLista() throws SQLException {
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
}