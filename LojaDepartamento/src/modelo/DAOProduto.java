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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luizh
 */
public class DAOProduto {
       
    public List<Produto> getListaProduto(){
        String sql = "select * from produtos";
        List<Produto> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Produto obj = new Produto();
                obj.setCodProduto(rs.getInt("codProdutos"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPrecoCusto(rs.getDouble("precoCusto"));
                obj.setPrecoVenda(rs.getDouble("precoVenda"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return lista;
    }
    
    public boolean salvar(Produto obj) {
        if(obj.getCodProduto()== null) {
            return incluir(obj);
        }else {
            return alterar(obj);
        }
    }
    
        public boolean incluir(Produto obj) {
        String sql = "insert into produtos (descricao,precoCusto,precoVenda) values(?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getDescricao());
            pst.setDouble(2, obj.getPrecoCusto());
            pst.setDouble(3, obj.getPrecoVenda());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return false;
    }
        
    public boolean alterar(Produto obj) {
        String sql = "update produtos set descricao=?, precoCusto=?, precoVenda=? where codProdutos=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getDescricao());
            pst.setDouble(2, obj.getPrecoCusto());
            pst.setDouble(3, obj.getPrecoVenda());
            pst.setInt(4, obj.getCodProduto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Produto alterado!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Produto não alterado!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return false;
    }        
    
    public boolean remover(Produto obj) {
        String sql = "delete from produtos where codProdutos=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodProduto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Produto excluído!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Produto não excluído!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return false;
    }    
    
     public Produto localizarProduto(Integer id) {
        String sql = "select * from produtos where codProdutos=?";
        Produto obj = new Produto();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodProduto(rs.getInt("codProdutos"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPrecoCusto(rs.getDouble("precoCusto"));
                obj.setPrecoVenda(rs.getDouble("precoVenda"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return null;
    }
}
