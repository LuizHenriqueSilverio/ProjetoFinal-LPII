/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author luizh
 */
public class Vendedor extends Funcionario{

    public Vendedor(String nome, String cpf, String dep, double salario) {
        super(nome, cpf, dep, salario);
    }
    @Override
    double getBonifica() {
        return super.getSalario() + 500;
    }
    
}
