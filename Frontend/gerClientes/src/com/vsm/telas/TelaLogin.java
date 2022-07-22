/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.vsm.telas;
import com.vsm.dal.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Flavio
 */
public class TelaLogin extends javax.swing.JFrame {
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null;
    
    public TelaLogin() {
        initComponents();
        conexao =  ModuloConexao.conector();
        //System.out.println(conexao);
        if (conexao != null){
            lblStatus.setText("Conectado");
        } else{
            lblStatus.setText("Desconectado");        
        }
    }

    //consultar usuario
    private void consultar(){
        String sql = "select * from tbusuario where cpf=?";
        
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtCpf.getText());
            rs=pst.executeQuery();
            
            if (rs.next()) {
                txtNome.setText(rs.getString(2));
                txtEnd.setText(rs.getString(3));
                txtNum.setText(rs.getString(4));
                txtBairro.setText(rs.getString(5));
                txtCep.setText(rs.getString(6));
                txtCidade.setText(rs.getString(7));
                txtEstado.setText(rs.getString(8));
                txtTel.setText(rs.getString(9));
                txtEmail.setText(rs.getString(10));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // adicionar usuario
    private void adicionar(){
        String sql="insert into tbusuario(cpf, nome, endereco, numero, bairro, cep, cidade, estado, telefone, email, ativo) values(?,?,?,?,?,?,?,?,?,?, ?)";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtCpf.getText());
            pst.setString(2, txtNome.getText());
            pst.setString(3, txtEnd.getText());
            pst.setString(4, txtNum.getText());
            pst.setString(5, txtBairro.getText());
            pst.setString(6, txtCep.getText());
            pst.setString(7, txtCidade.getText());
            pst.setString(8, txtEstado.getText());
            pst.setString(9, txtTel.getText());
            pst.setString(10, txtEmail.getText());
            pst.setString(11, cbAtivo.getSelectedItem().toString());
          //campos obrigatórios
            if ((txtCpf.getText().isEmpty()) || (txtNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {    
            
            
            int adicionado = pst.executeUpdate();
           
            if(adicionado>0){
                JOptionPane.showMessageDialog(null, "Usuário adicionado");
            }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Editar usuario
    private void alterar(){
        String sql="update tbusuario set nome=?, endereco=?, numero=?, bairro=?, cep=?, cidade=?, estado=?, telefone=?, email=?, ativo=? where cpf=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtEnd.getText());
            pst.setString(3, txtNum.getText());
            pst.setString(4, txtBairro.getText());
            pst.setString(5, txtCep.getText());
            pst.setString(6, txtCidade.getText());
            pst.setString(7, txtEstado.getText());
            pst.setString(8, txtTel.getText());
            pst.setString(9, txtEmail.getText());
            pst.setString(10, cbAtivo.getSelectedItem().toString());
            pst.setString(11, txtCpf.getText());
            
            
            int adicionado = pst.executeUpdate();
            if(adicionado>0){
            JOptionPane.showMessageDialog(null, "Alterado Com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void limpar(){
        txtCpf.setText(null);
        txtNome.setText(null);
        txtEnd.setText(null);
        txtNum.setText(null);
        txtBairro.setText(null);
        txtCep.setText(null);
        txtCidade.setText(null);
        txtEstado.setText(null);
        txtTel.setText(null);
        txtEmail.setText(null);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEnd = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnCad = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbAtivo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Clientes");
        setResizable(false);

        jLabel4.setText("*CPF");

        jLabel5.setText("*Nome");

        jLabel6.setText("Endereço");

        jLabel7.setText("Número");

        jLabel8.setText("Bairro");

        jLabel9.setText("Cep");

        jLabel10.setText("Estado");

        jLabel11.setText("Telefone");

        jLabel12.setText("Email");

        jLabel15.setText("Cidade");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        lblStatus.setText("Status");

        btnIncluir.setText("Consultar");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel1.setText("Ativo");

        cbAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        cbAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAtivoActionPerformed(evt);
            }
        });

        jLabel2.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCad, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIncluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCpf)
                            .addComponent(txtNome)
                            .addComponent(txtEnd)
                            .addComponent(txtNum)
                            .addComponent(txtBairro)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblStatus)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCidade)
                                    .addComponent(txtEmail)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCad)
                    .addComponent(btnIncluir)
                    .addComponent(jButton1)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(616, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        //chamando adicionar
        adicionar();
    }//GEN-LAST:event_btnCadActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        //chamando a consulta
        consultar();
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void cbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAtivoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //chamando edição
        alterar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //limpar textos
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbAtivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
