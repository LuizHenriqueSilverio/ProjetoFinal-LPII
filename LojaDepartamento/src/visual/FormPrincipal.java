/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author luizh
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCidade = new javax.swing.JMenuItem();
        menuFuncionario = new javax.swing.JMenuItem();
        menuEstoque = new javax.swing.JMenuItem();
        menuFuncionarios = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenu();
        menuVendas = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Downloads\\fashion.png")); // NOI18N
        jLabel1.setText("jLabel1");

        barraMenu.setBackground(new java.awt.Color(0, 153, 153));
        barraMenu.setBorder(new javax.swing.border.MatteBorder(null));

        menuCadastro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 51, 0)));
        menuCadastro.setForeground(new java.awt.Color(0, 204, 204));
        menuCadastro.setText("Cadastro");

        menuCidade.setText("Clientes");
        menuCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCidadeActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCidade);

        menuFuncionario.setText("Produtos");
        menuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuFuncionario);

        menuEstoque.setText("Estoque");
        menuEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstoqueActionPerformed(evt);
            }
        });
        menuCadastro.add(menuEstoque);

        menuFuncionarios.setText("Funcionários");
        menuFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionariosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuFuncionarios);

        barraMenu.add(menuCadastro);

        menuVenda.setBorder(new javax.swing.border.MatteBorder(null));
        menuVenda.setForeground(new java.awt.Color(0, 204, 204));
        menuVenda.setText("Vendas");

        menuVendas.setText("Cadastro");
        menuVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVendasActionPerformed(evt);
            }
        });
        menuVenda.add(menuVendas);

        barraMenu.add(menuVenda);

        menuAjuda.setBorder(new javax.swing.border.MatteBorder(null));
        menuAjuda.setForeground(new java.awt.Color(0, 204, 204));
        menuAjuda.setText("Ajuda");

        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuSobre);

        barraMenu.add(menuAjuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        JOptionPane.showMessageDialog(null, "Sistema de Cadastro\nDireitos Reservados\nVersão 1.0");
    }//GEN-LAST:event_menuSobreActionPerformed

    private void menuCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCidadeActionPerformed
        //this: chama a partir deste form
        //true: Modal: sobrepõe o ofrm principal e não deixa acessá-lo
        FormCliente form = new FormCliente(this, true);
        form.setLocationRelativeTo(null);
        // form.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        form.setResizable(false);
        form.setVisible(true);
    }//GEN-LAST:event_menuCidadeActionPerformed

    private void menuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionarioActionPerformed
        FormProduto form = new FormProduto(this, true);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setVisible(true);
    }//GEN-LAST:event_menuFuncionarioActionPerformed

    private void menuEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstoqueActionPerformed
        FormEstoque form = new FormEstoque(this, true);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setVisible(true);
    }//GEN-LAST:event_menuEstoqueActionPerformed

    private void menuFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionariosActionPerformed
        FormFuncionario form = new FormFuncionario(this, true);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setVisible(true);
    }//GEN-LAST:event_menuFuncionariosActionPerformed

    private void menuVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVendasActionPerformed
        FormVenda form = new FormVenda(this, true);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setVisible(true);
    }//GEN-LAST:event_menuVendasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               FormPrincipal form = new FormPrincipal();
               form.setLocationRelativeTo(null);
               form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCidade;
    private javax.swing.JMenuItem menuEstoque;
    private javax.swing.JMenuItem menuFuncionario;
    private javax.swing.JMenuItem menuFuncionarios;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JMenu menuVenda;
    private javax.swing.JMenuItem menuVendas;
    // End of variables declaration//GEN-END:variables
}
