package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.vo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luiz
 */
public class UsuarioDAO {

    private Connection connection;
    static PreparedStatement stmt;
    
    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO USUARIO(NOMEUSUARIO, SENHA) VALUES (?,?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario Login(Usuario usuario) {
        String nomeUsuario = usuario.getNomeUsuario();
        String senha = usuario.getSenha();
        String sql = "select * from usuario where nomeusuario ='" + nomeUsuario + "' and senha = '" + senha + "'";
        try {
            stmt = connection.prepareStatement(sql);
            
            
        }catch(Exception e){
            
        }
        return usuario;
    }
}
