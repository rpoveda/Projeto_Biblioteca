/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.ui;

import br.com.anhanguera.pos.biblioteca.controller.ExemplarController;
import br.com.anhanguera.pos.biblioteca.entidade.Exemplar;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafaelpoveda
 */
public class PesquisaExemplarUI extends javax.swing.JFrame {

    /**
     * Creates new form PesquisaExemplarUI
     */
    public PesquisaExemplarUI() {
        initComponents();
        initTable(new ExemplarController().selectAll());
        tblExemplar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void initTable(List<Exemplar> lstExemplar){
        DefaultTableModel model = (DefaultTableModel)tblExemplar.getModel();
        model.setNumRows(0);
        for(Exemplar exemplar : lstExemplar){
            model.addRow(new Object[]{exemplar.getCodigoExemplar(), exemplar.getObra().getCodigoObra(), exemplar.getDataAquisicaoExemplar(), exemplar.getObra().getTituloObra(), exemplar.getSituacaoExemplar()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblExemplar = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodObra = new javax.swing.JTextField();
        txtCodExemp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitObra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        cbxSituacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblExemplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Exemp.", "Codigo Obra", "Data Aquisicao", "Titulo", "Situacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExemplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExemplarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblExemplar);

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel1.setText("Cod. obra");

        jLabel2.setText("Cod. Exemplar");

        jLabel3.setText("Titulo obra");

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        cbxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Disponível", "Emprestado" }));

        jLabel4.setText("Situacao");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtCodObra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtCodExemp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtTitObra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 191, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4)
                            .add(cbxSituacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 24, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(btnRemover)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnEditar))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, btnFiltrar))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCodObra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtCodExemp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtTitObra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbxSituacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnFiltrar)
                .add(9, 9, 9)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 27, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnEditar)
                    .add(btnRemover))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblExemplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExemplarMouseClicked
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
    }//GEN-LAST:event_tblExemplarMouseClicked

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Deseja excluir o exemplar selecionado?") == JOptionPane.YES_OPTION){
            int intCodigoExemplar = (Integer)tblExemplar.getModel().getValueAt(tblExemplar.getSelectedRow(), 0);
            int intCodigoObra = (Integer)tblExemplar.getModel().getValueAt(tblExemplar.getSelectedRow(), 1);
            if(new ExemplarController().delete(intCodigoExemplar, intCodigoObra)){
                JOptionPane.showMessageDialog(null, "Exemplar deletado com sucesso.");
                initTable(new ExemplarController().selectAll());
            }else
                JOptionPane.showMessageDialog(null, "Nao foi possivel deletar o exemplar");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int intCodigoExemplar = (Integer)tblExemplar.getModel().getValueAt(tblExemplar.getSelectedRow(), 0);
        int intCodigoObra = (Integer)tblExemplar.getModel().getValueAt(tblExemplar.getSelectedRow(), 1);
        Exemplar exemplar = new Exemplar();
        Obra obra = new Obra();
        obra.setCodigoObra(intCodigoObra);
        exemplar.setCodigoExemplar(intCodigoExemplar);
        exemplar.setObra(obra);
        
        ExemplarUI exemplarUI = new ExemplarUI(new ExemplarController().select(exemplar).get(0));
        exemplarUI.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        Exemplar exemplar = new Exemplar();
        Obra obra = new Obra();
        try{ exemplar.setCodigoExemplar(Integer.parseInt(txtCodExemp.getText()));  }catch(Exception e){}
        try{ obra.setCodigoObra(Integer.parseInt(txtCodObra.getText()));}catch(Exception e){}
        obra.setTituloObra(txtTitObra.getText());
        if(cbxSituacao.getSelectedIndex() != 0)
            exemplar.setSituacaoExemplar(cbxSituacao.getSelectedItem().toString());
        exemplar.setObra(obra);
        
        initTable(new ExemplarController().select(exemplar));
    }//GEN-LAST:event_btnFiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaExemplarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaExemplarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaExemplarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaExemplarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PesquisaExemplarUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cbxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblExemplar;
    private javax.swing.JTextField txtCodExemp;
    private javax.swing.JTextField txtCodObra;
    private javax.swing.JTextField txtTitObra;
    // End of variables declaration//GEN-END:variables
}
