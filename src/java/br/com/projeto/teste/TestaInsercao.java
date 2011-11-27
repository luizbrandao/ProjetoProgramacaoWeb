package br.com.projeto.teste;

import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.vo.Produto;
import br.com.projeto.vo.Usuario;

/**
 *
 * @author luiz
 */
public class TestaInsercao {

    public static void main(String args[]) {
        try {
            /*Usuario usuario = new Usuario();
            usuario.setNomeUsuario("luiz");
            usuario.setSenha("l0g4n8899$");

            UsuarioDAO dao = new UsuarioDAO();
            dao.adiciona(usuario);
            System.out.println("Gravado com sucesso!");*/
            Produto produto = new Produto();
            produto.setNomeProduto("Revista Info");
            produto.setValorUnitario(12.79);
            produto.setImagem("_img/Revista.png");
            produto.setQtdeEstoque(100);
            ProdutoDAO dao  = new ProdutoDAO();
            dao.adiciona(produto);
            System.out.println("Produto gravado com sucesso!");
            
        } catch  (Exception e){
            System.out.println("Não foi possivel inserir usuario! "+e);
        }
    }
}
