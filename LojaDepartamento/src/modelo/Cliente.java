/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author Gabriel Caproni Pegoraro
 */
public class Cliente implements Pessoa{
    
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String endereco;
    
    public Cliente(String nome, String CPF, String dataNasc, String telefone, String endereco){
        this.nome = nome;
        this.cpf = CPF;
        this.dataNascimento = dataNasc;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /**
     * @return the nome
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    @Override
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
