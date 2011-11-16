package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.vo.Usuario;
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
public class UsuarioDAO {

    private Connection connection;
    static PreparedStatement stmt;

    public UsuarioDAO() throws ClassNotFoundException {
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

    public List<Usuario> getLista() {
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setNomeUsuario(rs.getString("nomeusuario"));
                usuario.setSenha(rs.getString("senha"));

                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario Login(Usuario usuario) {
        String sql = "SELECT NOMEUSUARIO, SENHA FROM USUARIO WHERE NOMEUSUARIO = ? AND SENHA = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.execute();
            stmt.close();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
