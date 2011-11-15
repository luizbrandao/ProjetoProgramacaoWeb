package br.com.projeto.servlet;

import br.com.projeto.vo.Usuario;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luiz
 */
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNomeUsuario(req.getParameter("nomeUsuario"));
            usuario.setSenha(req.getParameter("senha"));
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
