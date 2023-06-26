/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gabriel Pegoraro
 */
public class Estoque {
    
    private Integer codEstoque;
    private Produto produto;
    private double quantidade;
    private String dataValidade;
    
    public Estoque(Produto produto, int qtd, String dataVal){
        this.produto = produto;
        this.quantidade = qtd;
        this.dataValidade = dataVal;
    }
         

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the dataValidade
     */
    public String getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * @return the codEstoque
     */
    public Integer getCodEstoque() {
        return codEstoque;
    }

    /**
     * @param codEstoque the codEstoque to set
     */
    public void setCodEstoque(Integer codEstoque) {
        this.codEstoque = codEstoque;
    }
    
}
