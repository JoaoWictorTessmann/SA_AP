/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import DAO.Cons_Servico;
import TELAS.TelaLista;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableModel;


public class TelaAdicionar extends javax.swing.JFrame {

    /**
     * Creates new form TelaAdicionar
     */
    public TelaAdicionar() {
        initComponents();
    }
    private TelaLista telaLista; // referência da tela principal

    public TelaAdicionar(TelaLista telaLista) {
        initComponents();
        this.telaLista = telaLista;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600); // ou setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);//Centralizar na tela
        setLayout(null); // necessário para posicionamento manual
        setResizable(false);
        setTitle("Tela Adicionar Pedido");
        jlbAddSer.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 24));
        jlbAddSer.setForeground(Color.WHITE);
        jlbNomCli.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        jlbNomCli.setForeground(Color.WHITE);
        jlbDesc.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        jlbDesc.setForeground(Color.WHITE);
        jlbModCarAdd.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        jlbModCarAdd.setForeground(Color.WHITE);
        jlbPlacaAdd.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        jlbPlacaAdd.setForeground(Color.WHITE);
        jlbValorAdd.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        jlbValorAdd.setForeground(Color.WHITE);
        jlbTempAdd.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        jlbTempAdd.setForeground(Color.WHITE);

        jtfAddNomeCliente.setOpaque(false);
        jtfAddNomeCliente.setBorder(new RoundedBorder(20));
        jtfAddNomeCliente.setBackground(Color.BLACK);
        jtfAddNomeCliente.setForeground(java.awt.Color.WHITE);
        jtfAddNomeCliente.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        jtfAddDescricao.setOpaque(false);
        jtfAddDescricao.setBorder(new RoundedBorder(20));
        jtfAddDescricao.setBackground(Color.BLACK);
        jtfAddDescricao.setForeground(java.awt.Color.WHITE);
        jtfAddDescricao.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        jtfAddModeloVei.setOpaque(false);
        jtfAddModeloVei.setBorder(new RoundedBorder(20));
        jtfAddModeloVei.setBackground(Color.BLACK);
        jtfAddModeloVei.setForeground(java.awt.Color.WHITE);
        jtfAddModeloVei.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        jtfAddPlaca.setOpaque(false);
        jtfAddPlaca.setBorder(new RoundedBorder(20));
        jtfAddPlaca.setBackground(Color.BLACK);
        jtfAddPlaca.setForeground(java.awt.Color.WHITE);
        jtfAddPlaca.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        jtfAddValor.setOpaque(false);
        jtfAddValor.setBorder(new RoundedBorder(20));
        jtfAddValor.setBackground(Color.BLACK);
        jtfAddValor.setForeground(java.awt.Color.WHITE);
        jtfAddValor.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        jtfAddTempoEst.setOpaque(false);
        jtfAddTempoEst.setBorder(new RoundedBorder(20));
        jtfAddTempoEst.setBackground(Color.BLACK);
        jtfAddTempoEst.setForeground(java.awt.Color.WHITE);
        jtfAddTempoEst.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        jbtAdicionarPedido.setBackground(new Color(20, 40, 60)); // Azul escuro (RGB)
        jbtAdicionarPedido.setContentAreaFilled(true); // tira o fundo branco
        jbtAdicionarPedido.setBorderPainted(false);     // tira a borda
        jbtAdicionarPedido.setForeground(java.awt.Color.WHITE);
        jbtAdicionarPedido.setOpaque(false);            // permite transparência
        jbtAdicionarPedido.setFont(new Font("SansSerif", Font.BOLD, 25)); // ou outro tamanho
        
        jbtVoltarAdd.setBackground(new Color(20, 40, 60)); // Azul escuro (RGB)
        jbtVoltarAdd.setContentAreaFilled(true); // tira o fundo branco
        jbtVoltarAdd.setBorderPainted(false);     // tira a borda
        jbtVoltarAdd.setForeground(java.awt.Color.WHITE);
        jbtVoltarAdd.setOpaque(false);            // permite transparência
        jbtVoltarAdd.setFont(new Font("SansSerif", Font.BOLD, 25)); // ou outro tamanho

        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telaadicionar");

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

        jbtAdicionarPedido = new javax.swing.JButton();
        jtfAddValor = new javax.swing.JTextField();
        jtfAddTempoEst = new javax.swing.JTextField();
        jtfAddPlaca = new javax.swing.JTextField();
        jtfAddModeloVei = new javax.swing.JTextField();
        jtfAddDescricao = new javax.swing.JTextField();
        jtfAddNomeCliente = new javax.swing.JTextField();
        jlbAddSer = new javax.swing.JLabel();
        jlbNomCli = new javax.swing.JLabel();
        jlbDesc = new javax.swing.JLabel();
        jlbModCarAdd = new javax.swing.JLabel();
        jlbPlacaAdd = new javax.swing.JLabel();
        jlbValorAdd = new javax.swing.JLabel();
        jlbTempAdd = new javax.swing.JLabel();
        jbtVoltarAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtAdicionarPedido.setText("Adicionar Pedido");
        jbtAdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionarPedidoActionPerformed(evt);
            }
        });

        jtfAddTempoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAddTempoEstActionPerformed(evt);
            }
        });

        jtfAddNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAddNomeClienteActionPerformed(evt);
            }
        });

        jlbAddSer.setText("Adicionar Serviço");

        jlbNomCli.setText("Nome do Cliente:");

        jlbDesc.setText("Descrição:");

        jlbModCarAdd.setText("Modelo Do Carro:");

        jlbPlacaAdd.setText("Placa:");

        jlbValorAdd.setText("Valor:");

        jlbTempAdd.setText("Tempo Estimado:");

        jbtVoltarAdd.setText("Voltar");
        jbtVoltarAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtVoltarAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtAdicionarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtfAddDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfAddModeloVei, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAddNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbModCarAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPlacaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbValorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfAddValor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfAddTempoEst, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jlbTempAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jtfAddPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jlbAddSer, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jlbAddSer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfAddNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jtfAddDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbModCarAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfAddModeloVei, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbPlacaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfAddPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbValorAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbTempAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAddValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAddTempoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAdicionarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtVoltarAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAddTempoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAddTempoEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAddTempoEstActionPerformed

    private void jbtAdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionarPedidoActionPerformed
        String cliente = jtfAddNomeCliente.getText().trim();
        String descricao = jtfAddDescricao.getText().trim();
        String modeloCarro = jtfAddModeloVei.getText().trim();
        String placa = jtfAddPlaca.getText().trim();
        String textoValor = jtfAddValor.getText().replace("R$", "").replace(",", ".").trim();
        String tempoEstimado = jtfAddTempoEst.getText().trim(); // Ex: "10 Horas", "3 Dias"

        double valor;

        // Validação de campos obrigatórios
        if (cliente.isEmpty()) {
            new TelaErroAdd("O campo 'Cliente' não pode estar vazio.").setVisible(true);
            return;
        }

        if (descricao.isEmpty()) {
            new TelaErroAdd("O campo 'Descrição' não pode estar vazio.").setVisible(true);
            return;
        }

        if (modeloCarro.isEmpty()) {
            new TelaErroAdd("O campo 'Modelo do Carro' não pode estar vazio.").setVisible(true);
            return;
        }

        if (placa.isEmpty()) {
            new TelaErroAdd("O campo 'Placa' não pode estar vazio.").setVisible(true);
            return;
        }

        if (textoValor.isEmpty()) {
            new TelaErroAdd("O campo 'Valor' não pode estar vazio.").setVisible(true);
            return;
        }

        if (tempoEstimado.isEmpty()) {
            new TelaErroAdd("O campo 'Tempo Estimado' não pode estar vazio.").setVisible(true);
            return;
        }

        // Conversão segura apenas do valor
        try {
            valor = Double.parseDouble(textoValor);
        } catch (NumberFormatException e) {
            new TelaErroAdd("Valor inválido. Use apenas números.").setVisible(true);
            return;
        }

        // Criação do objeto Cons_Servico
        Cons_Servico pedido = new Cons_Servico(cliente, descricao, modeloCarro, tempoEstimado, placa, valor);

        // Envio para o banco
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_autopaint", "root", "")) {
            String sql = "INSERT INTO servicos (nome_cliente, descricao, modelo_carro, placa, valor, tempo_estimado) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pedido.getCliente());
            stmt.setString(2, pedido.getDescricao());
            stmt.setString(3, pedido.getModeloCarro());
            stmt.setString(4, pedido.getPlaca());
            stmt.setDouble(5, pedido.getValor());
            stmt.setString(6, pedido.getTempoEstimado()); // já formatado

            stmt.executeUpdate();

            telaLista.carregarPedidos();
            this.dispose();
            TelaAddSucesso sucesso = new TelaAddSucesso("Pedido adicionado com sucesso!");
            sucesso.setVisible(true);

        } catch (SQLException e) {
            new TelaErroAdd("Erro ao adicionar pedido: " + e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_jbtAdicionarPedidoActionPerformed

    private void jtfAddNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAddNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAddNomeClienteActionPerformed

    private void jbtVoltarAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarAddActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarAddActionPerformed

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
        java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new TelaAdicionar().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtAdicionarPedido;
    private javax.swing.JButton jbtVoltarAdd;
    private javax.swing.JLabel jlbAddSer;
    private javax.swing.JLabel jlbDesc;
    private javax.swing.JLabel jlbModCarAdd;
    private javax.swing.JLabel jlbNomCli;
    private javax.swing.JLabel jlbPlacaAdd;
    private javax.swing.JLabel jlbTempAdd;
    private javax.swing.JLabel jlbValorAdd;
    private javax.swing.JTextField jtfAddDescricao;
    private javax.swing.JTextField jtfAddModeloVei;
    private javax.swing.JTextField jtfAddNomeCliente;
    private javax.swing.JTextField jtfAddPlaca;
    private javax.swing.JTextField jtfAddTempoEst;
    private javax.swing.JTextField jtfAddValor;
    // End of variables declaration//GEN-END:variables
}
