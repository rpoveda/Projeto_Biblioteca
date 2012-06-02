/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.ui;

import br.com.anhanguera.pos.biblioteca.controller.AutorController;
import br.com.anhanguera.pos.biblioteca.controller.EditoraController;
import br.com.anhanguera.pos.biblioteca.controller.ObraController;
import br.com.anhanguera.pos.biblioteca.entidade.Autor;
import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafaelpoveda
 */
public class PesquisaObraUI extends javax.swing.JFrame {

    /**
     * Creates new form PesquisaObraUI
     */
    public PesquisaObraUI() {
        initComponents();
        intiTable(new ObraController().selectAll());
        initComboAutor();
        initComboEditora();
        
        tblObra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void intiTable(List<Obra> _lstObra){
        DefaultTableModel model = (DefaultTableModel) tblObra.getModel();
        model.setRowCount(0);
        
        for(Obra obra : _lstObra){
            model.addRow(new Object[]{obra.getCodigoObra(), obra.getTituloObra(), obra.getAnoPublicacao(), obra.getSituacaoObra(), obra.getAutorPrincipal().getNomeAutor(), obra.getEditoraObra().getNomeEditora()});
        }
        
    }
    
    private void initComboAutor(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxAutor.getModel();
        List<Autor> _lstAutor = new AutorController().selectAll();
        model.addElement(null);
        for(Autor autor : _lstAutor)
            model.addElement(autor.getCodigoAutor() + "-" + autor.getNomeAutor());
    }
    
    private void initComboEditora(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxEditora.getModel();
        List<Editora> _lstEditora = new EditoraController().selectAll();
        model.addElement(null);
        for(Editora editora : _lstEditora){
            model.addElement(editora.getCodigoEditora() + "-" + editora.getNomeEditora());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObra = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAnoPublicacao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxSituacao = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbxAutor = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbxEditora = new javax.swing.JComboBox();
        btnFiltro = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Obra");

        tblObra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título", "Ano Publ.", "Situação", "Autor", "Editora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblObra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblObraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblObra);

        jLabel2.setText("Código");

        jLabel3.setText("Título");

        jLabel4.setText("Ano publição");

        jLabel5.setText("Situação");

        cbxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Disponível", "Emprestado" }));

        jLabel6.setText("Autor");

        jLabel7.setText("Editora");

        btnFiltro.setText("Filtrar");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel2)
                                        .add(27, 27, 27)
                                        .add(jLabel3))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel5)
                                        .add(87, 87, 87)
                                        .add(jLabel6)))
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(cbxSituacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cbxAutor, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(txtCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(txtTitulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(cbxEditora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(btnFiltro))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel4)
                                    .add(layout.createSequentialGroup()
                                        .add(5, 5, 5)
                                        .add(txtAnoPublicacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jLabel7))
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(btnRemover)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnEditar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtTitulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtAnoPublicacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbxSituacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbxAutor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbxEditora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnFiltro))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnEditar)
                    .add(btnRemover)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        Obra obra = new Obra();
        Autor autor = new Autor();
        Editora editora = new Editora();
        
        //codigo editora
        if(cbxEditora.getSelectedIndex() != 0){
        int intCodigoEditora = Integer.parseInt(cbxEditora.getSelectedItem().toString().split("-")[0]);
        editora.setCodigoEditora(intCodigoEditora);
        }
        
        //codigo autor
        if(cbxAutor.getSelectedIndex() != 0){
        int intCodigoAutor = Integer.parseInt(cbxAutor.getSelectedItem().toString().split("-")[0]);
        autor.setCodigoAutor(intCodigoAutor);
        }
        
        obra.setAutorPrincipal(autor);
        obra.setEditoraObra(editora);
        
        if(!txtCodigo.getText().equals(""))
            obra.setCodigoObra(Integer.parseInt(txtCodigo.getText()));
        if(!txtAnoPublicacao.getText().equals(""))
            obra.setAnoPublicacao(Integer.parseInt(txtAnoPublicacao.getText()));
        obra.setTituloObra(txtTitulo.getText());
        if(cbxSituacao.getSelectedIndex() != 0)
            obra.setSituacaoObra(cbxSituacao.getSelectedItem().toString());
        
        
        intiTable(new ObraController().select(obra));
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void tblObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObraMouseClicked
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
    }//GEN-LAST:event_tblObraMouseClicked

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int intCodigoObra = (Integer)tblObra.getModel().getValueAt(tblObra.getSelectedRow(), 0);
        
        if(new ObraController().delete(intCodigoObra))
        {
            JOptionPane.showMessageDialog(null, "Obra deletada com sucesso");
            intiTable(new ObraController().selectAll());
        }else
            JOptionPane.showMessageDialog(null, "Nao foi possivel deletar a obra.");
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Obra obra = new Obra();
        int intCodigoObra = (Integer)tblObra.getModel().getValueAt(tblObra.getSelectedRow(), 0);
        
        obra.setCodigoObra(intCodigoObra);
        obra.setAutorPrincipal(new Autor());
        obra.setEditoraObra(new Editora());
        
        ObraUI obraUI = new ObraUI(new ObraController().select(obra).get(0));
        obraUI.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(PesquisaObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PesquisaObraUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cbxAutor;
    private javax.swing.JComboBox cbxEditora;
    private javax.swing.JComboBox cbxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblObra;
    private javax.swing.JTextField txtAnoPublicacao;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
