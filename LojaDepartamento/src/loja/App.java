package loja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuizHenriqueSilverio e gabrielcaproni
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c = new Cliente("Gabriel Caproni", "123.052.236-00", 
        "29/11/2003", "(35)9 9954-0325", "Rua dos Medicos");

        System.out.println("Nome: " + c.getNome());
        System.out.println("CPF: " + c.getCPF());
        System.out.println("Data de Nascimento: " + c.getDataNascimento());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Endereco: " + c.getEndereco());
        System.out.println("");

        
        Produto p = new Produto("SSD 240GB", 150.00, 225.00);
        
        System.out.println("Produto: " + p.getDescricao());
        System.out.println("Preco de custo: " + p.getPrecoCusto());
        System.out.println("Preco de venda: " + p.getPrecoVenda());
        
        p.setPrecoCusto(175.00);
        p.setPrecoVenda(250.00);
        System.out.println("Novo preco de custo: " + p.getPrecoCusto());
        System.out.println("Novo preco de venda: " + p.getPrecoVenda());
        System.out.println("");
        
        Funcionario f = new Funcionario("Luiz Henrique", "123.456.789-10", "Eletrodomésticos", 2500.00);
        
        System.out.println("Nome do funcionario: " + f.getNome());
        System.out.println("CPF do funcionario: " + f.getCpf());
        System.out.println("Departamento: " + f.getDepartamento());
        System.out.println("Salario: R$" + f.getSalario());
        System.out.println("");
        
        Estoque e = new Estoque(p, 5, "Sem data de validade");
        
        System.out.println("Produto: " + e.getProduto().getDescricao());
        System.out.println("Quantidade: " + e.getQuantidade());
        System.out.println("Data de Validade: " + e.getDataValidade());
        
    }
    
}
