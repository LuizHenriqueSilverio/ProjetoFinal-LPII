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
 * @author Gabriel Caproni Pegoraro
 */
public class DAOVenda {

    DAOFuncionario daoFuncionario = new DAOFuncionario();
    DAOCliente daoCliente = new DAOCliente();
    
    public List<Venda> getListaVenda(){
        String sql = "select * from funcionarios";
        List<Venda> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Venda obj = new Venda();
                obj.setCodVenda(rs.getInt("codVenda"));
                obj.setValorVenda(rs.getDouble("valorVenda"));
                
                java.sql.Date dt = rs.getDate("dataNascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                
                obj.setDataVenda(c);
                obj.setFuncionario(daoFuncionario.localizarFuncionario(rs.getInt("funcionarios_codFuncionarios")));
                obj.setCliente(daoCliente.localizarCliente(rs.getInt("clientes_codClientes")));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return lista;
    }
    
    public boolean salvar(Venda obj) {
        if(obj.getCodVenda() == null) {
            return incluir(obj);
        }else {
            return alterar(obj);
        }
    }
    
    public boolean incluir(Venda obj) {
        String sql = "insert into venda (valorVenda, dataVenda, funcionarios_codFuncionarios, clientes_codClientes) values (?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setDouble(1, obj.getValorVenda());
            pst.setDate(2, new java.sql.Date(obj.getDataVenda().getTimeInMillis()));
            pst.setInt(3, obj.getFuncionario().getCodFuncionario());
            pst.setInt(4, obj.getCliente().getCodCliente());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Venda cadastrada!");
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Venda não cadastrada!");
                return false;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return false;
    }
    
    public boolean alterar(Venda obj) {
        String sql = "update venda set valorVenda=?, dataVenda=?, funcionarios_codFuncionarios=?, clientes_codClientes=? where codVenda=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setDouble(1, obj.getValorVenda());
            pst.setDate(2, new java.sql.Date(obj.getDataVenda().getTimeInMillis()));
            pst.setInt(3, obj.getFuncionario().getCodFuncionario());
            pst.setInt(4, obj.getCliente().getCodCliente());
            pst.setInt(5, obj.getCodVenda());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Venda alterada!");
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Venda não alterada!");
                return false;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return false;
    }
    
    public boolean remover(Venda obj) {
        String sql = "delete from venda where codVenda=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodVenda());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Venda excluída!");
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Venda não excluída!");
                return false;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null , "Erro de SQL: " + e.getMessage());
        }
        return false;
    }
}
