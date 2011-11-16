package br.com.projeto.teste;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.vo.Usuario;
import java.util.List;

public class TestaLista {
    public static void main(String args[]) throws ClassNotFoundException{
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.getLista();
        
        for(Usuario usuario : usuarios){
            System.out.println("Nome: "+usuario.getNomeUsuario());
            System.out.println("Senha: "+usuario.getSenha());
        }
    }
}
