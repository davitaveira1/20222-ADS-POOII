/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Control.controlaProdutos;
import Control.controlaProdutosDAO;
import Model.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi
 */
public class TelaGestaoProdutos extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String modo, nome, novoNome;
    int linha, codigo, estoque, novoEstoque, qtd, novaQtd;
    double preco, novoPreco;

    List<Produto> lista = new ArrayList<>();

    Produto p;
    Produto produtoListaExistente;

    controlaProdutosDAO controlaProdutoBD = new controlaProdutosDAO();

    /**
     * Creates new form TelaGestaoClientes
     */
    public TelaGestaoProdutos() {
        initComponents();
        modo = "inicio";
        manipularInterface();

        preencherTabelaBD();


        /*
        modelo.addRow(new Object[]{1, "Pizza", 67, 11.68});
        modelo.addRow(new Object[]{2, "Coca-cola 2Lt", 122, 6.40});
        modelo.addRow(new Object[]{3, "Detergente", 50, 1.45});
        modelo.addRow(new Object[]{4, "Amaciante 1Lt", 34, 5.20});
         */
 /*
        codigo = controlaProdutos.ultimoCodigo(lista);
        Produto p1 = new Produto(codigo, "Pizza", 67, 11.68);
        controlaProdutos.adicionar(lista, p1);
        codigo = controlaProdutos.ultimoCodigo(lista);
        Produto p2 = new Produto(codigo, "Coca-cola 2Lt", 122, 6.40);
        controlaProdutos.adicionar(lista, p2);
        codigo = controlaProdutos.ultimoCodigo(lista);
        Produto p3 = new Produto(codigo, "Detergente", 50, 1.45);
        controlaProdutos.adicionar(lista, p3);
        codigo = controlaProdutos.ultimoCodigo(lista);
        Produto p4 = new Produto(codigo, "Amaciante 1Lt", 34, 5.20);
        controlaProdutos.adicionar(lista, p4);

        controlaProdutos.imprimir(lista);
         */
    }

    public void preencherTabelaBD() {
        getTableModel();

        //limpar a tabela
        modelo.setNumRows(0);
        controlaProdutoBD.rs = controlaProdutoBD.selecionarProdutos();

        try {
            while (controlaProdutoBD.rs.next()) {
                modelo.addRow(new Object[]{
                    controlaProdutoBD.rs.getInt(1),
                    controlaProdutoBD.rs.getString(2),
                    controlaProdutoBD.rs.getInt(3),
                    controlaProdutoBD.rs.getDouble(4)

                });
            }
        } catch (Exception e) {
        }
    }

    public void getTableModel() {
        modelo = (DefaultTableModel) tb_prod.getModel();
    }

    public void manipularInterface() {
        switch (modo) {
            case "cancelar":
                bt_prod_buscar.setEnabled(true);
                c_prod_codigo.setText("");
                c_prod_codigo.setEnabled(true);

                c_prod_codigo.requestFocus();

                bt_prod_novo.setEnabled(true);
                bt_prod_editar.setEnabled(false);
                bt_prod_excluir.setEnabled(false);

                c_prod_nome.setEnabled(false);
                c_prod_estoque.setEnabled(false);
                c_prod_preco.setEnabled(false);

                bt_prod_salvar.setEnabled(false);
                bt_prod_cancelar.setEnabled(false);

                break;
            case "inicio":

                bt_prod_novo.setEnabled(true);
                bt_prod_editar.setEnabled(false);
                bt_prod_excluir.setEnabled(false);

                bt_prod_buscar.setEnabled(true);
                c_prod_codigo.setText("");
                c_prod_codigo.setEnabled(true);
                c_prod_codigo.requestFocus();

                c_prod_nome.setEnabled(false);
                c_prod_estoque.setEnabled(false);
                c_prod_preco.setEnabled(false);

                bt_prod_salvar.setEnabled(false);
                bt_prod_cancelar.setEnabled(false);
                break;

            case "novo":

                bt_prod_novo.setEnabled(false);
                bt_prod_editar.setEnabled(false);
                bt_prod_excluir.setEnabled(false);

                bt_prod_buscar.setEnabled(false);
                c_prod_codigo.setEnabled(false);
                c_prod_nome.setEnabled(true);
                //c_prod_nome.requestFocus();
                c_prod_estoque.setEnabled(true);
                c_prod_preco.setEnabled(true);

                bt_prod_salvar.setEnabled(true);
                bt_prod_cancelar.setEnabled(true);
                break;

            case "linhaTabelaSelecionada":
                bt_prod_novo.setEnabled(true);
                bt_prod_editar.setEnabled(true);
                bt_prod_excluir.setEnabled(true);

                bt_prod_buscar.setEnabled(false);
                c_prod_codigo.setEnabled(false);
                c_prod_nome.setEnabled(false);
                c_prod_estoque.setEnabled(false);
                c_prod_preco.setEnabled(false);

                bt_prod_salvar.setEnabled(false);
                bt_prod_cancelar.setEnabled(true);
                break;

            case "editar":
                bt_prod_novo.setEnabled(false);
                bt_prod_editar.setEnabled(false);
                bt_prod_excluir.setEnabled(false);

                c_prod_nome.setEnabled(true);
                c_prod_estoque.setEnabled(true);
                c_prod_preco.setEnabled(true);

                bt_prod_salvar.setEnabled(true);
                bt_prod_cancelar.setEnabled(true);
                break;

            case "buscar":
                bt_prod_novo.setEnabled(true);
                bt_prod_editar.setEnabled(false);
                bt_prod_excluir.setEnabled(true);

                c_prod_nome.setEnabled(false);
                c_prod_estoque.setEnabled(false);
                c_prod_preco.setEnabled(false);

                bt_prod_salvar.setEnabled(true);
                bt_prod_cancelar.setEnabled(true);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Modo inválido!!");
        }
    }

    public void limparCampos() {
        c_prod_nome.setText("");
        c_prod_estoque.setText("");
        c_prod_preco.setText("");
        c_prod_codigo.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_prod = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        bt_prod_novo = new javax.swing.JButton();
        bt_prod_editar = new javax.swing.JButton();
        bt_prod_excluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_prod_nome = new javax.swing.JTextField();
        c_prod_estoque = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_prod_preco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_prod_codigo = new javax.swing.JTextField();
        bt_prod_buscar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        bt_prod_salvar = new javax.swing.JButton();
        bt_prod_cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tb_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Estoque", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_prodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_prod);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Produtos", jPanel1);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        bt_prod_novo.setText("Novo");
        bt_prod_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_prod_novoActionPerformed(evt);
            }
        });
        jPanel3.add(bt_prod_novo);

        bt_prod_editar.setText("Editar");
        bt_prod_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_prod_editarActionPerformed(evt);
            }
        });
        jPanel3.add(bt_prod_editar);

        bt_prod_excluir.setText("Excluir");
        bt_prod_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_prod_excluirActionPerformed(evt);
            }
        });
        jPanel3.add(bt_prod_excluir);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Estoque:");

        jLabel3.setText("Preço:");

        jLabel4.setText("Código:");

        bt_prod_buscar.setText("Buscar");
        bt_prod_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_prod_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_prod_nome)
                            .addComponent(c_prod_estoque)
                            .addComponent(c_prod_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_prod_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(bt_prod_buscar)))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_prod_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_prod_buscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_prod_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_prod_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(c_prod_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bt_prod_salvar.setText("Salvar");
        bt_prod_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_prod_salvarActionPerformed(evt);
            }
        });
        jPanel5.add(bt_prod_salvar);

        bt_prod_cancelar.setText("Cancelar");
        bt_prod_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_prod_cancelarActionPerformed(evt);
            }
        });
        jPanel5.add(bt_prod_cancelar);

        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_prod_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_prod_novoActionPerformed
        // TODO add your handling code here:
        modo = "novo";
        manipularInterface();
        //preencher campo código automaticamente
        try {
            controlaProdutoBD.rs.last();
            codigo = controlaProdutoBD.rs.getInt(1) + 1;
            JOptionPane.showMessageDialog(null, "Codigo novo: " + codigo);

        } catch (Exception e) {
        }

        c_prod_codigo.setText(String.valueOf(codigo));

        c_prod_nome.setText("");
        c_prod_estoque.setText("");
        c_prod_preco.setText("");
        c_prod_nome.requestFocus();


    }//GEN-LAST:event_bt_prod_novoActionPerformed

    private void bt_prod_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_prod_editarActionPerformed
        // TODO add your handling code here:
        modo = "editar";
        manipularInterface();


    }//GEN-LAST:event_bt_prod_editarActionPerformed

    private void bt_prod_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_prod_cancelarActionPerformed
        // TODO add your handling code here:
        modo = "cancelar";
        manipularInterface();
        limparCampos();
    }//GEN-LAST:event_bt_prod_cancelarActionPerformed

    private void bt_prod_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_prod_salvarActionPerformed
        // TODO add your handling code here:
        if (modo == "editar") {
            linha = tb_prod.getSelectedRow();

            codigo = Integer.valueOf(c_prod_codigo.getText());
            novoNome = c_prod_nome.getText();
            novoEstoque = Integer.valueOf(c_prod_estoque.getText());
            novoPreco = Double.valueOf(c_prod_preco.getText());

            modelo.setValueAt(codigo, linha, 0);
            modelo.setValueAt(novoNome, linha, 1);
            modelo.setValueAt(novoEstoque, linha, 2);
            modelo.setValueAt(novoPreco, linha, 3);

            /*
            //buscar objeto na lista
            produtoListaExistente = controlaProdutos.buscarProduto(lista, codigo - 1);
            //editar objeto na lista
            produtoListaExistente.setNome(novoNome);
            produtoListaExistente.setQuantidade(novoEstoque);
            produtoListaExistente.setPreco(novoPreco);
            //imprimir lista
            controlaProdutos.imprimir(lista);
             */
            //criar produto
            p = new Produto(codigo, novoNome, novoEstoque, novoPreco);

            //alterar no BD
            controlaProdutoBD.alterarProduto(p);

            //ajuste de interface            
            modo = "linhaTabelaSelecionada";
            manipularInterface();

        }

        if (modo == "novo") {
            codigo = Integer.valueOf(c_prod_codigo.getText());
            novoNome = c_prod_nome.getText();
            novoEstoque = Integer.valueOf(c_prod_estoque.getText());
            novoPreco = Double.valueOf(c_prod_preco.getText());
            //modelo.addRow(new Object[]{codigo, novoNome, novoEstoque, novoPreco});

            //montar objeto
            p = new Produto(codigo, novoNome, novoEstoque, novoPreco);
            //adicionar na lista            
            //controlaProdutos.adicionar(lista, p);

            //adicionar no BD
            controlaProdutoBD.inserirProduto(p);

            preencherTabelaBD();

            //ajuste de interface
            modo = "inicio";
            manipularInterface();
            limparCampos();

        }

    }//GEN-LAST:event_bt_prod_salvarActionPerformed

    private void bt_prod_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_prod_excluirActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o produto " + c_prod_nome.getText(), "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {

            linha = tb_prod.getSelectedRow();

            //removendo da lista
            int linhaProduto = 0;
            codigo = Integer.valueOf(c_prod_codigo.getText());

            //percorrer a tabela para encontrar a linha do produto
            int nroLinhasTabela = tb_prod.getRowCount();
            for (int i = 0; i < nroLinhasTabela; i++) {
                System.out.println("Campo codigo tb: " + tb_prod.getValueAt(i, 0) + " codigo form: " + codigo);
                if (tb_prod.getValueAt(i, 0).equals(codigo)) {
                    linhaProduto = i;
                    System.out.println("Linha do produto: " + linhaProduto);
                }
            }

            //controlaProdutos.excluir(lista, linhaProduto);
            //excluir do BD
            controlaProdutoBD.excluirProduto(codigo);

            //removendo da tabela
            modelo.removeRow(linha);
            //manipular interface
            modo = "inicio";
            manipularInterface();
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Produto não foi excluído!");
        }
    }//GEN-LAST:event_bt_prod_excluirActionPerformed

    private void tb_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_prodMouseClicked
        // TODO add your handling code here:
        modo = "linhaTabelaSelecionada";
        manipularInterface();

        linha = tb_prod.getSelectedRow();

        getTableModel();
        codigo = (int) modelo.getValueAt(linha, 0);
        nome = (String) modelo.getValueAt(linha, 1);
        estoque = (int) modelo.getValueAt(linha, 2);
        preco = (double) modelo.getValueAt(linha, 3);

        c_prod_codigo.setText(Integer.toString(codigo));
        c_prod_nome.setText(nome);
        c_prod_estoque.setText(Integer.toString(estoque));
        c_prod_preco.setText(Double.toString(preco));

    }//GEN-LAST:event_tb_prodMouseClicked

    private void bt_prod_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_prod_buscarActionPerformed
        modo = "buscar";
        manipularInterface();
        c_prod_codigo.requestFocus();

        //percorrer a tabela para encontrar a linha do produto
        int linhaProduto = 0;
        codigo = Integer.valueOf(c_prod_codigo.getText());
        //System.out.println("Linhas tb:" + tb_prod.getRowCount());
        int nroLinhasTabela = tb_prod.getRowCount();
        for (int i = 0; i < nroLinhasTabela; i++) {
            //System.out.println("Campo codigo tb: "+tb_prod.getValueAt(i,0)+" codigo form: "+codigo);
            if (tb_prod.getValueAt(i, 0).equals(codigo)) {
                linhaProduto = i;
                //System.out.println("Linha do produto: "+linhaProduto);
            }
        }

        //codigo = Integer.valueOf(c_prod_codigo.getText());
        tb_prod.setRowSelectionInterval(linhaProduto, linhaProduto);

        //buscar objeto na lista
        //produtoListaExistente = controlaProdutos.buscarProduto(lista, linhaProduto);
        //buscar produto do BD
        try {

            controlaProdutoBD.rs = controlaProdutoBD.selecionarProduto(codigo);
            controlaProdutoBD.rs.next();
            //preencher formulário
            c_prod_nome.setText(controlaProdutoBD.rs.getString(2));
            c_prod_estoque.setText(Integer.toString(controlaProdutoBD.rs.getInt(3)));
            c_prod_preco.setText(Double.toString(controlaProdutoBD.rs.getDouble(4)));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }


    }//GEN-LAST:event_bt_prod_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("===================");
        //imprimir lista
        controlaProdutos.imprimir(lista);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGestaoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGestaoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGestaoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGestaoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGestaoProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_prod_buscar;
    private javax.swing.JButton bt_prod_cancelar;
    private javax.swing.JButton bt_prod_editar;
    private javax.swing.JButton bt_prod_excluir;
    private javax.swing.JButton bt_prod_novo;
    private javax.swing.JButton bt_prod_salvar;
    private javax.swing.JTextField c_prod_codigo;
    private javax.swing.JTextField c_prod_estoque;
    private javax.swing.JTextField c_prod_nome;
    private javax.swing.JTextField c_prod_preco;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tb_prod;
    // End of variables declaration//GEN-END:variables
}
