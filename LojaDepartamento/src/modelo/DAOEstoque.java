/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luizh
 */
public class DAOEstoque {
    
    DAOProduto daoProduto = new DAOProduto();

    public List<Estoque> getListaEstoque(){
        String sql = "select * from estoque";
        List<Estoque> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Estoque obj = new Estoque();
                obj.setCodEstoque(rs.getInt("codEstoque"));
                obj.setQuantidade(rs.getDouble("quantidade"));
                java.sql.Date dt = rs.getDate("dataValidade");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataValidade(c);
                obj.setLote(rs.getString("lote"));
                obj.setProduto(daoProduto.localizarProduto(rs.getInt("produtos_codProdutos")));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return lista;
    }
    
    public boolean salvar(Estoque obj) {
        if(obj.getCodEstoque() == null) {
            return incluir(obj);
        }else {
            return alterar(obj);
        }
    }

    public boolean incluir(Estoque obj) {
        String sql = "insert into estoque (quantidade,dataValidade,lote,produtos_codProdutos) values (?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setDouble(1, obj.getQuantidade());
            pst.setDate(2, new java.sql.Date(obj.getDataValidade().getTimeInMillis()));
            pst.setString(3, obj.getLote());
            pst.setInt(4, obj.getProduto().getCodProduto());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Estoque cadastrado!");
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Estoque não cadastrado!");
                return false;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return false;
    }
    
    public boolean alterar(Estoque obj) {
        String sql = "update estoque set quantidade=?, dataValidade=?, lote=?, produtos_codProdutos=? where codEstoque=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setDouble(1, obj.getQuantidade());
            pst.setDate(2, new java.sql.Date(obj.getDataValidade().getTimeInMillis()));
            pst.setString(3, obj.getLote());
            pst.setInt(4, obj.getProduto().getCodProduto());
            pst.setInt(5, obj.getCodEstoque());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Estoque alterado!");
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Estoque não alterado!");
                return false;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return false;
    }
    
    public boolean remover(Estoque obj) {
        String sql = "delete from estoque where codEstoque=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodEstoque());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Estoque excluído!");
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Estoque não excluído!");
                return false;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null , "Erro de SQL: " + e.getMessage());
        }
        return false;
    }
   
}
