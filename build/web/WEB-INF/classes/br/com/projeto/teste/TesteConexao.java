package br.com.projeto.teste;

import br.com.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String args[]) throws ClassNotFoundException {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            System.out.println("Conexão aberta!");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}