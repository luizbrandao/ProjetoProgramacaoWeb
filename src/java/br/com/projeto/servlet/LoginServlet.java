package br.com.projeto.servlet;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.vo.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luiz
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            Usuario usuarioLogin = new Usuario();
            Usuario usuario = new Usuario();
            String user = req.getParameter("nomeUsuario");
            String password = req.getParameter("senha");
            if (!"".equals(user) && !"".equals(password)) {
                usuario.setNomeUsuario(user);
                usuario.setSenha(password);
                UsuarioDAO dao = new UsuarioDAO();
                usuarioLogin = dao.Login(usuario);
                String kaptchaExpected = (String) req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
                String kaptchaReceived = req.getParameter("kaptcha");

                if (kaptchaReceived
                        == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)) {
                    System.out.println("Erro no Kaptcha!");
                } else {
                    if (usuarioLogin != null) {
                        System.out.println("Login realizado com sucesso");
                        RequestDispatcher rd = req.getRequestDispatcher("/principal.jsp");
                        rd.forward(req, res);
                    } else {
                        System.out.println("Login inválido!");
                        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                        rd.forward(req, res);
                    }
                }
            } else {
                System.out.print("Não foi possivel realizar o login!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}