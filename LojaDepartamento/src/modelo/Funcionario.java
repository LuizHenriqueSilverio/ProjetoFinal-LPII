/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.Transient;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author luizh
 */
public class Funcionario implements Pessoa{
    
    Integer codFuncionario;
    private String nome;
    private String cpf;
    private Calendar dataAdmissao;
    private Calendar dataRescisao;
    private String departamento;
    private String cargo;
    private double salario;
    
    public Funcionario() {
        
    }

    public Funcionario(String nome, String cpf, String dep, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.departamento = dep;
        this.salario = salario;
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
     * @return the dataAdmissao
     */
    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    /**
     * @return the dataRescisao
     */
    public Calendar getDataRescisao() {
        return dataRescisao;
    }

    /**
     * @param dataRescisao the dataRescisao to set
     */
    public void setDataRescisao(Calendar dataRescisao) {
        this.dataRescisao = dataRescisao;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void bonifica(double aumento){
       this.salario = salario + aumento;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the codFuncionario
     */
    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }
    
    @Transient
    public String getAdmissaoFormatado() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataAdmissao.getTime());
    }
    
    @Transient
    public String getRescisaoFormatado() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataRescisao.getTime());
    }
    
    @Override
    public String toString() {
        return nome + "; CPF: " + cpf;
    }
}
