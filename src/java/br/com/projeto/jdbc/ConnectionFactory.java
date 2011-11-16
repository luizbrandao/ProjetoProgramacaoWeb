package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException{
        try {
            System.out.println("Conectado ao Banco");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return DriverManager.getConnection("jdbc:derby://localhost:1527/projeto;create=true");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}