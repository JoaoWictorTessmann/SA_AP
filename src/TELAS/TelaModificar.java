/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import TELAS.TelaLista;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author Usuario
 */
public class TelaModificar extends javax.swing.JFrame {

    public TelaModificar() {
        initComponents();

    }
    private TelaLista telaLista; // referência da tela principal

    public TelaModificar(TelaLista telaLista) {
        initComponents();
        this.telaLista = telaLista;
        bloquearCamposModificacao();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Tela Modificar Pedido");
        // Garantir tamanho antes de escalar
        setSize(500, 600); // ou setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);//Centralizar na tela
        setLayout(null); // necessário para posicionamento manual
        jlbModif.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 30));
        jlbModif.setForeground(Color.WHITE);
        jlbClient.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 20));
        jlbClient.setForeground(Color.WHITE);
        jlbDesc.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 20));
        jlbDesc.setForeground(Color.WHITE);
        jlbModCar.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 15));
        jlbModCar.setForeground(Color.WHITE);
        jlbPlac.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 20));
        jlbPlac.setForeground(Color.WHITE);
        jlbValor.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 20));
        jlbValor.setForeground(Color.WHITE);
        jlbTempo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 20));
        jlbTempo.setForeground(Color.WHITE);
        
        jtfModSolicitarID.setOpaque(false);
        jtfModSolicitarID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModSolicitarID.setForeground(java.awt.Color.WHITE);
        jtfModSolicitarID.setBorder(new RoundedBorder(20));
        jtfModSolicitarID.setBackground(Color.BLACK);
        jtfModSolicitarID.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jbtModConfirmarID.setContentAreaFilled(true); // tira o fundo branco
        jbtModConfirmarID.setBorderPainted(false);     // tira a borda
        jbtModConfirmarID.setForeground(java.awt.Color.WHITE);
        jbtModConfirmarID.setOpaque(false);            // permite transparência
        jbtModConfirmarID.setFont(new Font("SansSerif", Font.BOLD, 20)); // ou outro tamanho
        jbtModConfirmarID.setBackground(new Color(10, 20, 40));

        jtfModNomeCliente.setOpaque(false);
        jtfModNomeCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModNomeCliente.setForeground(java.awt.Color.WHITE);
        jtfModNomeCliente.setBorder(new RoundedBorder(20));
        jtfModNomeCliente.setBackground(Color.BLACK);
        jtfModNomeCliente.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModDescricao.setOpaque(false);
        jtfModDescricao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModDescricao.setForeground(java.awt.Color.WHITE);
        jtfModDescricao.setBorder(new RoundedBorder(20));
        jtfModDescricao.setBackground(Color.BLACK);
        jtfModDescricao.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModModeloVei.setOpaque(false);
        jtfModModeloVei.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModModeloVei.setForeground(java.awt.Color.WHITE);
        jtfModModeloVei.setBorder(new RoundedBorder(20));
        jtfModModeloVei.setBackground(Color.BLACK);
        jtfModModeloVei.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModPlaca.setOpaque(false);
        jtfModPlaca.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModPlaca.setForeground(java.awt.Color.WHITE);
        jtfModPlaca.setBorder(new RoundedBorder(20));
        jtfModPlaca.setBackground(Color.BLACK);
        jtfModPlaca.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModValor.setOpaque(false);
        jtfModValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModValor.setForeground(java.awt.Color.WHITE);
        jtfModValor.setBorder(new RoundedBorder(20));
        jtfModValor.setBackground(Color.BLACK);
        jtfModValor.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModTempoEst.setOpaque(false);
        jtfModTempoEst.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModTempoEst.setForeground(java.awt.Color.WHITE);
        jtfModTempoEst.setBorder(new RoundedBorder(20));
        jtfModTempoEst.setBackground(Color.BLACK);
        jtfModTempoEst.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jbtModificarPedido.setContentAreaFilled(true); // tira o fundo branco
        jbtModificarPedido.setBorderPainted(false);     // tira a borda
        jbtModificarPedido.setOpaque(false);            // permite transparência
        jbtModificarPedido.setForeground(java.awt.Color.WHITE);
        jbtModificarPedido.setFont(new Font("SansSerif", Font.BOLD, 30)); // ou outro tamanho
        jbtModificarPedido.setBackground(new Color(10, 20, 40));
        
        jbtVoltarMod.setContentAreaFilled(true); // tira o fundo branco
        jbtVoltarMod.setBorderPainted(false);     // tira a borda
        jbtVoltarMod.setOpaque(false);            // permite transparência
        jbtVoltarMod.setForeground(java.awt.Color.WHITE);
        jbtVoltarMod.setFont(new Font("SansSerif", Font.BOLD, 30)); // ou outro tamanho
        jbtVoltarMod.setBackground(new Color(10, 20, 40));

        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telamodificar");

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
    
    private void habilitarCamposModificacao() {
        jtfModNomeCliente.setEditable(true);
        jtfModNomeCliente.setBackground(Color.BLACK);
        jtfModDescricao.setEditable(true);
        jtfModDescricao.setBackground(Color.BLACK);
        jtfModModeloVei.setEditable(true);
        jtfModModeloVei.setBackground(Color.BLACK);
        jtfModPlaca.setEditable(true);
        jtfModPlaca.setBackground(Color.BLACK);
        jtfModValor.setEditable(true);
        jtfModValor.setBackground(Color.BLACK);
        jtfModTempoEst.setEditable(true);
        jtfModTempoEst.setBackground(Color.BLACK);
        jbtModificarPedido.setEnabled(true);
    }

    private void bloquearCamposModificacao() {
        jtfModNomeCliente.setEditable(false);
        jtfModNomeCliente.setBackground(Color.GRAY);
        jtfModDescricao.setEditable(false);
        jtfModDescricao.setBackground(Color.GRAY);
        jtfModModeloVei.setEditable(false);
        jtfModModeloVei.setBackground(Color.GRAY);
        jtfModPlaca.setEditable(false);
        jtfModPlaca.setBackground(Color.GRAY);
        jtfModValor.setEditable(false);
        jtfModValor.setBackground(Color.GRAY);
        jtfModTempoEst.setEditable(false);
        jtfModTempoEst.setBackground(Color.GRAY);
        jbtModificarPedido.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtModificarPedido = new javax.swing.JButton();
        jtfModValor = new javax.swing.JTextField();
        jtfModTempoEst = new javax.swing.JTextField();
        jtfModPlaca = new javax.swing.JTextField();
        jtfModModeloVei = new javax.swing.JTextField();
        jtfModDescricao = new javax.swing.JTextField();
        jtfModNomeCliente = new javax.swing.JTextField();
        jbtModConfirmarID = new javax.swing.JButton();
        jtfModSolicitarID = new javax.swing.JTextField();
        jlbModif = new javax.swing.JLabel();
        jlbClient = new javax.swing.JLabel();
        jlbDesc = new javax.swing.JLabel();
        jlbModCar = new javax.swing.JLabel();
        jlbPlac = new javax.swing.JLabel();
        jlbValor = new javax.swing.JLabel();
        jlbTempo = new javax.swing.JLabel();
        jbtVoltarMod = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtModificarPedido.setText("Modificar Pedido");
        jbtModificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModificarPedidoActionPerformed(evt);
            }
        });

        jtfModTempoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfModTempoEstActionPerformed(evt);
            }
        });

        jtfModNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfModNomeClienteActionPerformed(evt);
            }
        });

        jbtModConfirmarID.setText("Confirmar ID");
        jbtModConfirmarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModConfirmarIDActionPerformed(evt);
            }
        });

        jtfModSolicitarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfModSolicitarIDActionPerformed(evt);
            }
        });

        jlbModif.setText("Modificar Pedido");

        jlbClient.setText("Cliente");

        jlbDesc.setText("Descrição");

        jlbModCar.setText("Modelo do Carro");

        jlbPlac.setText("Placa");

        jlbValor.setText("Valor");

        jlbTempo.setText("Tempo Estimado");

        jbtVoltarMod.setText("Voltar");
        jbtVoltarMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbModCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfModValor)
                                            .addComponent(jtfModModeloVei)
                                            .addComponent(jtfModSolicitarID)
                                            .addComponent(jtfModNomeCliente)
                                            .addComponent(jlbValor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jbtModConfirmarID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jtfModDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfModPlaca)
                                                .addComponent(jtfModTempoEst, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(9, 9, 9)))
                                    .addComponent(jlbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbPlac, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbModif, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbtModificarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtVoltarMod, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jlbModif, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModSolicitarID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtModConfirmarID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfModDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbModCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbPlac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModModeloVei, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfModPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfModValor)
                    .addComponent(jtfModTempoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtModificarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtVoltarMod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfModTempoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModTempoEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModTempoEstActionPerformed

    private void jtfModSolicitarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModSolicitarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModSolicitarIDActionPerformed

    private void jbtModConfirmarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModConfirmarIDActionPerformed
        try {
            int idSolicitado = Integer.parseInt(jtfModSolicitarID.getText().trim());

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {
                String sql = "SELECT * FROM servicos WHERE id_servico = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idSolicitado);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String status = rs.getString("status_servico");

                    if (!"PENDENTE".equalsIgnoreCase(status)) {
                        new TelaErroAdd("Este pedido não pode ser modificado.<br>Status atual: " + status).setVisible(true);
                        jtfModSolicitarID.setText("");
                        jtfModSolicitarID.requestFocus();
                        bloquearCamposModificacao();
                        return;
                    }

                    // Status é PENDENTE → libera os campos e preenche os dados
                    habilitarCamposModificacao();

                    String cliente = rs.getString("nome_cliente");
                    String descricao = rs.getString("descricao");
                    String modelo = rs.getString("modelo_carro");
                    String placa = rs.getString("placa");
                    double valor = rs.getDouble("valor");
                    String tempoEstimado = rs.getString("tempo_estimado"); // nome correto da coluna

                    // 👇 Formata o valor como moeda brasileira
                    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                    String valorFormatado = formatoMoeda.format(valor); // Ex: R$ 100,00

                    jtfModNomeCliente.setText(cliente);
                    jtfModDescricao.setText(descricao);
                    jtfModModeloVei.setText(modelo);
                    jtfModPlaca.setText(placa);
                    jtfModValor.setText(valorFormatado);
                    jtfModTempoEst.setText(String.valueOf(tempoEstimado));

                } else {
                    new TelaErroAdd("ID não encontrado.").setVisible(true);
                    jtfModSolicitarID.setText("");
                    jtfModSolicitarID.requestFocus();
                    bloquearCamposModificacao();
                }

            }

        } catch (NumberFormatException e) {
            new TelaErroAdd("Digite um número válido para o ID.").setVisible(true);
            jtfModSolicitarID.setText("");
            jtfModSolicitarID.requestFocus();
            bloquearCamposModificacao();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
            bloquearCamposModificacao();
        }

    }//GEN-LAST:event_jbtModConfirmarIDActionPerformed

    private void jbtModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModificarPedidoActionPerformed
        try {
            int idSolicitado = Integer.parseInt(jtfModSolicitarID.getText().trim());

            // Captura dos dados como texto
            String cliente = jtfModNomeCliente.getText().trim();
            String descricao = jtfModDescricao.getText().trim();
            String modelo = jtfModModeloVei.getText().trim();
            String placa = jtfModPlaca.getText().trim();
            String textoValor = jtfModValor.getText().trim();
            String textoTempo = jtfModTempoEst.getText().trim();

            // Validação dos campos
            if (cliente.isEmpty()) {
                new TelaErroAdd("O campo 'Cliente' não pode estar vazio.").setVisible(true);
                return;
            }
            if (descricao.isEmpty()) {
                new TelaErroAdd("O campo 'Descrição' não pode estar vazio.").setVisible(true);
                return;
            }
            if (modelo.isEmpty()) {
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
            if (textoTempo.isEmpty()) {
                new TelaErroAdd("O campo 'Tempo Estimado' não pode estar vazio.").setVisible(true);
                return;
            }

            // Conversão segura do valor
            double valor;
            try {
                String valorLimpo = textoValor.replace("R$", "").replace(".", "").replace(",", ".").trim();
                valor = Double.parseDouble(valorLimpo);
            } catch (NumberFormatException e) {
                new TelaErroAdd("Valor inválido. Digite o numero inteiro.").setVisible(true);
                return;
            }

            // Tempo agora é texto livre
            String tempo = textoTempo;

            // Atualização no banco
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {
                String sql = "UPDATE servicos SET nome_cliente = ?, descricao = ?, modelo_carro = ?, placa = ?, valor = ?, tempo_estimado = ? WHERE id_servico = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cliente);
                stmt.setString(2, descricao);
                stmt.setString(3, modelo);
                stmt.setString(4, placa);
                stmt.setDouble(5, valor);
                stmt.setString(6, tempo); //  agora como texto
                stmt.setInt(7, idSolicitado);

                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    new TelaAddSucesso("Pedido Modificado Com Sucesso!").setVisible(true);
                    telaLista.carregarPedidos();
                    this.dispose();
                } else {
                    new TelaErroAdd("Nenhum pedido foi modificado. Verifique o ID.").setVisible(true);
                }
            }

        } catch (NumberFormatException e) {
            new TelaErroAdd("ID inválido.").setVisible(true);
        } catch (SQLException e) {
            new TelaErroAdd("Erro ao modificar pedido: " + e.getMessage()).setVisible(true);
        }

    }//GEN-LAST:event_jbtModificarPedidoActionPerformed

    private void jtfModNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModNomeClienteActionPerformed

    private void jbtVoltarModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarModActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarModActionPerformed

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
            java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtModConfirmarID;
    private javax.swing.JButton jbtModificarPedido;
    private javax.swing.JButton jbtVoltarMod;
    private javax.swing.JLabel jlbClient;
    private javax.swing.JLabel jlbDesc;
    private javax.swing.JLabel jlbModCar;
    private javax.swing.JLabel jlbModif;
    private javax.swing.JLabel jlbPlac;
    private javax.swing.JLabel jlbTempo;
    private javax.swing.JLabel jlbValor;
    private javax.swing.JTextField jtfModDescricao;
    private javax.swing.JTextField jtfModModeloVei;
    private javax.swing.JTextField jtfModNomeCliente;
    private javax.swing.JTextField jtfModPlaca;
    private javax.swing.JTextField jtfModSolicitarID;
    private javax.swing.JTextField jtfModTempoEst;
    private javax.swing.JTextField jtfModValor;
    // End of variables declaration//GEN-END:variables
}
