package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        try {
            System.out.println("Conectando ao Banco");
            /*Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            return DriverManager.getConnection("jdbc:derby://localhost:1527/projeto;create=true");*/
            //return DriverManager.getConnection("jdbc:derby:projeto;create=true");
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto","postgres", "l0g4n8899$");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}