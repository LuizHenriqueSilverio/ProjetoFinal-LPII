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
public class DAOProduto {
       
    public List<Produto> getLista() {
        return Dados.listaProduto;    
    }
    
    public boolean salvar(Produto obj) {
        if(obj.getCodProduto()==  null){
            Integer codigo = Dados.listaProduto.size() + 1;
            obj.setCodProduto(codigo);
            Dados.listaProduto.add(obj);
        }
        return true;
    }
    
    public boolean remover(Produto obj) {
        Dados.listaProduto.remove(obj);
        return true;
    }
    
}
