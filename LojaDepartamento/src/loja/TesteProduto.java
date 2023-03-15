/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author luizh
 */
public class TesteProduto {
    public static void main(String[] args) {
        Produto p = new Produto("SSD 240GB", 150.00, 225.00);
        
        System.out.println("Produto: " + p.getDescricao());
        System.out.println("Preco de custo: " + p.getPrecoCusto());
        System.out.println("Preco de venda: " + p.getPrecoVenda());
        
        p.setPrecoCusto(175.00);
        p.setPrecoVenda(250.00);
        System.out.println("Novo preco de custo: " + p.getPrecoCusto());
        System.out.println("Novo preco de venda: " + p.getPrecoVenda());
    }
}
