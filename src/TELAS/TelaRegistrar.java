/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import DAO.ImagemTelas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import java.security.MessageDigest;
import java.sql.Connection;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author Usuario
 */
public class TelaRegistrar extends javax.swing.JFrame {

    /**
     * Creates new form TelaRegistrar
     */
    public TelaRegistrar() {
        initComponents();
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telaregistro");
        // Garantir tamanho antes de escalar
        setSize(600, 750); // ou setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);//Centralizar na tela
        setLayout(null); // necessário para posicionamento manual
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Tela de Registro");
        jlbTitulo.setFont(new Font("SansSerif", Font.BOLD, 40));
        jlbNome.setFont(new Font("SansSerif", Font.BOLD, 20));
        jlbEmail.setFont(new Font("SansSerif", Font.BOLD, 20));
        jlbSenha.setFont(new Font("SansSerif", Font.BOLD, 20));
        jlbTipo.setFont(new Font("SansSerif", Font.BOLD, 15));
        
        jcbTipo.setModel(new DefaultComboBoxModel<>(new String[]{"Administrador", "Colaborador"}));
        jtfNomeUsu.setBorder(new RoundedBorder(20));
        jtfNomeUsu.setFont(new Font("SansSerif", Font.BOLD, 25));
        jtfEmail.setBorder(new RoundedBorder(20));
        jtfEmail.setFont(new Font("SansSerif", Font.BOLD, 25));
        jpfSenhaRegistro.setBorder(new RoundedBorder(20));
        jpfSenhaRegistro.setFont(new Font("SansSerif", Font.BOLD, 25));
        
        jbtSalvar.setContentAreaFilled(true); // tira o fundo branco
        jbtSalvar.setBorderPainted(false);     // tira a borda
        jbtSalvar.setOpaque(false);            // permite transparência
        jbtSalvar.setFont(new Font("SansSerif", Font.BOLD, 40)); // ou outro tamanho
        jbtSalvar.setForeground(java.awt.Color.WHITE); // cor branca ou como a cor do fundo
        jbtSalvar.setBackground(new Color(20, 40, 60));
        
        jbtVolta.setContentAreaFilled(true); // tira o fundo branco
        jbtVolta.setBorderPainted(false);     // tira a borda
        jbtVolta.setOpaque(false);            // permite transparência
        jbtVolta.setFont(new Font("SansSerif", Font.BOLD, 25)); // ou outro tamanho
        jbtVolta.setForeground(java.awt.Color.WHITE); // cor branca ou como a cor do fundo
        jbtVolta.setBackground(new Color(20, 40, 60));
        
        if (imagemOriginal != null) {
            // Escala a imagem de acordo com a tela
            Image imagem = imagemOriginal.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            JLabel fundo = new JLabel(new ImageIcon(imagem));
            fundo.setBounds(0, 0, getWidth(), getHeight());

            // Adiciona a imagem atrás dos componentes
            getContentPane().add(fundo);
            getContentPane().setComponentZOrder(fundo, getContentPane().getComponentCount() - 1);
        } else {
            System.out.println("Imagem de fundo não encontrada.");
        }
    }
    
    class RoundedBorder extends AbstractBorder {

        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(10, 10, 10, 10); // Espaçamento interno
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(10, 10, 10, 10);
            return insets;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtSalvar = new javax.swing.JButton();
        jtfNomeUsu = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jpfSenhaRegistro = new javax.swing.JPasswordField();
        jcbTipo = new javax.swing.JComboBox<>();
        jlbNome = new javax.swing.JLabel();
        jlbEmail = new javax.swing.JLabel();
        jlbSenha = new javax.swing.JLabel();
        jlbTipo = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jbtVolta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtSalvar.setText("Salvar");
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoActionPerformed(evt);
            }
        });

        jlbNome.setText("Nome:");

        jlbEmail.setText("Email:");

        jlbSenha.setText("Senha:");

        jlbTipo.setText("Função:");

        jlbTitulo.setText("Registro de Usuário");

        jbtVolta.setText("Voltar");
        jbtVolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfSenhaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jlbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jlbSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfNomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jcbTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jbtVolta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(297, Short.MAX_VALUE)
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfNomeUsu)
                    .addComponent(jlbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfEmail)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpfSenhaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtVolta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        String nome = jtfNomeUsu.getText();
        String email = jtfEmail.getText();
        String senha = new String(jpfSenhaRegistro.getPassword());
        String tipo = jcbTipo.getSelectedItem().toString();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || tipo.isEmpty()) {
            new TelaErroAdd("Preencha todos os campos!").setVisible(true);
            return;
        }

        String senhaCriptografada = criptografarSenha(senha);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "");
            String sql = "INSERT INTO usuarios (nome, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senhaCriptografada);
            stmt.setString(4, tipo);

            stmt.executeUpdate();
            this.dispose();
            TelaAddSucesso sucesso = new TelaAddSucesso("Usuario Cadastrado com Sucesso!");
            sucesso.setVisible(true);
            con.close();
            
        } catch (Exception e) {
            new TelaErroAdd("Erro ao registrar: " + e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jbtVoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltaActionPerformed

    

public static String criptografarSenha(String senha) {
    return BCrypt.hashpw(senha, BCrypt.gensalt());
}

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JButton jbtVolta;
    private javax.swing.JComboBox<String> jcbTipo;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbNome;
    private javax.swing.JLabel jlbSenha;
    private javax.swing.JLabel jlbTipo;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPasswordField jpfSenhaRegistro;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNomeUsu;
    // End of variables declaration//GEN-END:variables
}
