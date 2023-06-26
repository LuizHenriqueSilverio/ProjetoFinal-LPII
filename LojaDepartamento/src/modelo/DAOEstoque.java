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
public class DAOEstoque {

    public List<Estoque> getLista() {
        return Dados.listaEstoque;    
    }
    
    public boolean salvar(Estoque obj) {
        if(obj.getCodEstoque() ==  null){
            Integer codigo = Dados.listaEstoque.size() + 1;
            obj.setCodEstoque(codigo);
            Dados.listaEstoque.add(obj);
        }
        return true;
    }
    
    public boolean remover(Estoque obj) {
        Dados.listaEstoque.remove(obj);
        return true;
    }
    
}
