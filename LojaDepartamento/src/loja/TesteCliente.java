/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loja;

/**
 *
 * @author Gabriel Pegoraro
 */
public class TesteCliente {
    public static void main(String[] args) {
        
       Cliente c = new Cliente("Gabriel Caproni", "123.052.236-00", 
               "29/11/2003", "(35)9 9954-0325", "Rua dos Medicos");
        System.out.println("Nome: " + c.getNome());
        System.out.println("CPF: " + c.getCPF());
        System.out.println("Data de Nascimento: " + c.getDataNascimento());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Endereco: " + c.getEndereco());
        
    }
}
