/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author luizh
 */
public class VendasProdutos {
    private Integer codVendasProdutos;
    private Venda venda;
    private Produto produtos;
    private double quantidade;

    /**
     * @return the codVendasProdutos
     */
    public Integer getCodVendasProdutos() {
        return codVendasProdutos;
    }

    /**
     * @param codVendasProdutos the codVendasProdutos to set
     */
    public void setCodVendasProdutos(Integer codVendasProdutos) {
        this.codVendasProdutos = codVendasProdutos;
    }

    /**
     * @return the venda
     */
    public Venda getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    /**
     * @return the produtos
     */
    public Produto getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
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
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.codVendasProdutos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendasProdutos other = (VendasProdutos) obj;
        if (!Objects.equals(this.codVendasProdutos, other.codVendasProdutos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código da Venda: " + venda.getCodVenda();
    }
    
}
