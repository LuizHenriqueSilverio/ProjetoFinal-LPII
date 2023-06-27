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
public class DAOFuncionario {
    
    public List<Funcionario> getListaFuncionario(){
        String sql = "select * from funcionarios";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Funcionario obj = new Funcionario();
                obj.setCodFuncionario(rs.getInt("codFuncionarios"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                
                java.sql.Date dt = rs.getDate("dataAdmissao");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataAdmissao(c);
                
                dt = rs.getDate("dataRescisao");
                c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataRescisao(c);                
                
                obj.setDepartamento(rs.getString("departamento"));
                obj.setSalario(rs.getDouble("salario"));
                obj.setCargo(rs.getString("cargo"));
                
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return lista;
    }
    
    
    public boolean salvar(Funcionario obj) {
        if(obj.getCodFuncionario() == null) {
            return incluir(obj);
        }else {
            return alterar(obj);
        }
    }
    
    public boolean incluir(Funcionario obj) {
        String sql = "insert into funcionarios (nome,cpf,dataAdmissao,dataRescisao,departamento,salario,cargo) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setDate(3, new java.sql.Date(obj.getDataAdmissao().getTimeInMillis()));
            pst.setDate(4, new java.sql.Date(obj.getDataRescisao().getTimeInMillis()));
            pst.setString(5, obj.getDepartamento());
            pst.setDouble(6, obj.getSalario());
            pst.setString(7, obj.getCargo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario cadastrado!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionario não cadastrado!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return false;
    }
    
    public boolean alterar(Funcionario obj) {
        String sql = "update funcionarios set nome=?, cpf=?, dataAdmissao=?, dataRescisao=?, departamento=?, salario=?, cargo=? where codFuncionarios=?";
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
}
