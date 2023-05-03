package loja;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("*** CLIENTE ***");
        Cliente c = new Cliente("Gabriel Caproni", "123.052.236-00", 
        "29/11/2003", "(35)9 9954-0325", "Rua dos Medicos");

        System.out.println("Nome: " + c.getNome());
        System.out.println("CPF: " + c.getCpf());
        System.out.println("Data de Nascimento: " + c.getDataNascimento());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Endereco: " + c.getEndereco());
        System.out.println("");

        System.out.println("*** PRODUTO ***");
        Produto p = new Produto("SSD 240GB", 150.00, 225.00);
        
        System.out.println("Produto: " + p.getDescricao());
        System.out.println("Preco de custo: " + p.getPrecoCusto());
        System.out.println("Preco de venda: " + p.getPrecoVenda());
        
        p.setPrecoCusto(175.00);
        p.setPrecoVenda(250.00);
        System.out.println("Novo preco de custo: " + p.getPrecoCusto());
        System.out.println("Novo preco de venda: " + p.getPrecoVenda());
        System.out.println("");
        
        System.out.println("*** FUNCIONARIO ***");
        Funcionario f = new Gerente("Luiz Henrique", "123.456.789-10", "Eletrodomésticos", 2500.00);
        
        System.out.println("Nome do funcionario: " + f.getNome());
        System.out.println("CPF do funcionario: " + f.getCpf());
        System.out.println("Departamento: " + f.getDepartamento());
        System.out.println("Salario: R$" + f.getSalario());
        System.out.println("");
        
        System.out.println("*** ESTOQUE ***");
        Estoque e = new Estoque(p, 5, "Sem data de validade");
        
        System.out.println("Produto: " + e.getProduto().getDescricao());
        System.out.println("Quantidade: " + e.getQuantidade());
        System.out.println("Data de Validade: " + e.getDataValidade());
        System.out.println("");
        
        System.out.println("*** VENDA ***");
        Venda v = new Venda(c, p, 100, f, 1200, "12/03/2023");
        
        System.out.println("Cliente: " + v.getCliente().getNome());
        System.out.println("Produto: " + v.getProduto().getDescricao());
        System.out.println("Funcionario: " + v.getFuncionario().getNome());
        System.out.println("Data da Venda: " + v.getDataVenda());
        System.out.println("Quantidade: " + v.getQtd());
        System.out.println("Valor da venda: " + v.getValorVenda());
        System.out.println("");
        
        System.out.println("*** FELIZ NATAL ***");
        
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        /*Polimorfismo*/
        Gerente gerente1 = new Gerente("João", "123.456.789-00", "Vendas", 5000.00);
        Funcionario funcionario1 = new Gerente("Maria", "987.654.321-00", "Financeiro", 3000.00);

        listaFuncionarios.add(gerente1);
        listaFuncionarios.add(funcionario1);

        for (Funcionario func : listaFuncionarios) {
            System.out.println(func.getNome() + ": " + func.getBonifica());
        }
        
    }
    
}
