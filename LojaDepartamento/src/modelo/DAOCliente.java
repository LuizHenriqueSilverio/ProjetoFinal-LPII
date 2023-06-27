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
public class DAOCliente {
    
    public List<Cliente> getListaCliente(){
        String sql = "select * from clientes";
        List<Cliente> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cliente obj = new Cliente();
                obj.setCodCliente(rs.getInt("codClientes"));
                obj.setCpf(rs.getString("cpf"));
                obj.setNome(rs.getString("nome"));
                java.sql.Date dt = rs.getDate("dataNascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataNascimento(c);
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return lista;
    }
    
    public boolean salvar(Cliente obj) {
        if(obj.getCodCliente() == null) {
            return incluir(obj);
        }else {
            return alterar(obj);
        }
    }
    
    public boolean incluir(Cliente obj) {
        String sql = "insert into clientes (cpf,nome,dataNascimento,telefone,endereco) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getCpf());
            pst.setString(2, obj.getNome());
            pst.setDate(3, new java.sql.Date(obj.getDataNascimento().getTimeInMillis()));
            pst.setString(4, obj.getTelefone());
            pst.setString(5, obj.getEndereco());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return false;
    }
    
    public boolean alterar(Cliente obj) {
        String sql = "update clientes set cpf=?, nome=?, dataNascimento=?, telefone=?, endereco=? where codClientes=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getCpf());
            pst.setString(2, obj.getNome());
            pst.setDate(3, new java.sql.Date(obj.getDataNascimento().getTimeInMillis()));
            pst.setString(4, obj.getTelefone());
            pst.setString(5, obj.getEndereco());
            pst.setInt(6, obj.getCodCliente());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não alterado!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return false;
    }
    
    public boolean remover(Cliente obj) {
        String sql = "delete from clientes where codClientes=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodCliente());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente excluído!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não excluído!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return false;
    }
    
    public Cliente localizarCliente(Integer id) {
        String sql = "select * from clientes where codClientes=?";
        Cliente obj = new Cliente();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodCliente((rs.getInt("codClientes")));
                obj.setCpf(rs.getString("cpf"));
                obj.setNome(rs.getString("nome"));
                java.sql.Date dt = rs.getDate("dataNascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataNascimento(c);
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return null;
    }
}
