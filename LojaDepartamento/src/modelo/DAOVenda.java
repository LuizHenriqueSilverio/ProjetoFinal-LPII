/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author luizh
 */
public class DAOVenda {

    public List<Venda> getLista() {
        return Dados.listaVendas;    
    }
    
    public boolean salvar(Venda obj) {
        if(obj.getCodVenda() ==  null){
            Integer codigo = Dados.listaVendas.size() + 1;
            obj.setCodVenda(codigo);
            Dados.listaVendas.add(obj);
        }
        return true;
    }
    
    public boolean remover(Produto obj) {
        Dados.listaVendas.remove(obj);
        return true;
    }
    
}
