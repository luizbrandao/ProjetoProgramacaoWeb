package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            System.out.println("Conectado ao Banco");
            return DriverManager.getConnection("jdbc:derby://localhost:1527/projeto;create=true");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}