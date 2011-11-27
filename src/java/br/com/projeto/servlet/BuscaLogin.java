/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luiz
 */
public class BuscaLogin extends HttpServlet{
    public void dopost(HttpServletRequest req, HttpServletResponse res){
        String nomeproduto = req.getParameter("pesquisar");
        
    }
}
