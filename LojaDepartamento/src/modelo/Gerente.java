/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gabriel Pegoraro
 */
    public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf, String dep, double salario) {
        super(nome, cpf, dep, salario);
    }
    
    @Override
    public double getBonifica(){
     return super.getSalario() + 1000;
    }
}
