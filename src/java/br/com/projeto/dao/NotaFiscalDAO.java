/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.vo.ItemNota;
import br.com.projeto.vo.NotaFiscal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author luiz
 */
public class NotaFiscalDAO {

    Connection connection;

    public NotaFiscalDAO() {
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void adiciona(NotaFiscal nota) {
        try {
            String sql = "insert into nota values(nextval('seq_nota'),?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nota.getNomeCliente());
            stmt.setDate(2, new Date(nota.getDataEmissao().getTime()));
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                ItemNota item = new ItemNota();
                item.setIdNota(rs.getInt(1));
            }
            stmt.close();
            System.out.println("nota gerada com sucesso");
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void adicionaItemNota(ItemNota item) {
        try {
            String sql = "insert into itemNota values (?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getIdNota());
            stmt.setInt(2, item.getIdProduto());
            stmt.setInt(3, item.getQtde());
            stmt.setDouble(4, item.getValorUnitario());
            stmt.setDouble(5, item.getValorTotal());
            stmt.execute();
            stmt.close();
            System.out.println("item nota gravado com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}