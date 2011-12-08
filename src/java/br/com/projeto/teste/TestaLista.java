package br.com.projeto.teste;

import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.vo.Produto;
import br.com.projeto.vo.Usuario;
import java.sql.SQLException;
import java.util.List;

public class TestaLista {
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        /*UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.getLista();
        
        for(Usuario usuario : usuarios){
            System.out.println("Nome: "+usuario.getNomeUsuario());
            System.out.println("Senha: "+usuario.getSenha());
        }
        */
        ProdutoDAO dao2 = new ProdutoDAO();
        List<Produto> produtos = dao2.getLista();
        for(Produto produto : produtos){
            System.out.println("Id Produto: "+produto.getIdProduto());
            System.out.println("Nome Produto: "+produto.getNomeProduto());
            System.out.println("Valor unitario: "+produto.getValorUnitario());
            System.out.println("Quantidade em estoque: "+produto.getQtdeEstoque());
            System.out.println("Imagem do produto: "+produto.getImagem());
        }
    }
}