/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.ui;

import br.com.anhanguera.pos.biblioteca.controller.AutorController;
import br.com.anhanguera.pos.biblioteca.controller.EditoraController;
import br.com.anhanguera.pos.biblioteca.controller.ObraController;
import br.com.anhanguera.pos.biblioteca.controller.UtilController;
import br.com.anhanguera.pos.biblioteca.dao.UtilDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Autor;
import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author rafaelpoveda
 */
public class ObraUI extends javax.swing.JFrame {

    /**
     * Creates new form ObraUI
     */
    private boolean bEditar = false;
    private int intCodigoAutor = 0;
    private int intCodigoEditora = 0;

    public ObraUI() {
        initComponents();
        initAutor();
        initEditora();
        initCodigo();
    }
    
    public ObraUI(Obra obra){
        initComponents();
        intCodigoAutor = obra.getAutorPrincipal().getCodigoAutor();
        intCodigoEditora = obra.getEditoraObra().getCodigoEditora();
        
        initAutor();
        initEditora();
        
        txtCodigoObra.setText(Integer.toString(obra.getCodigoObra()));
        txtTituloObra.setText(obra.getTituloObra());
        txtAnoPublicacao.setText(Integer.toString(obra.getAnoPublicacao()));
        bEditar = true;
        
    }
    
    private void initAutor(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxAutor.getModel();
        model.removeAllElements();
        int count =0;
        int index = 0;
        for(Autor autor : new AutorController().selectAll()){
            model.addElement(autor.getCodigoAutor() + "-" + autor.getNomeAutor());
            
            if(autor.getCodigoAutor() == intCodigoAutor)
                index = count;
            
            count++;
        }
        
        cbxAutor.setSelectedIndex(index);
    }
    private void initEditora(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxEditora.getModel();
        List<Editora> _lstEditora = new EditoraController().selectAll();
        int count = 0;
        int index = 0;
        for(Editora editora : _lstEditora){
            model.addElement(editora.getCodigoEditora() + "-" + editora.getNomeEditora());
            
            if(editora.getCodigoEditora() == intCodigoEditora)
                index = count;
            
            count++;
        }
        
        cbxEditora.setSelectedIndex(index);
    }
    private void initCodigo(){
        int codigo = new UtilController().nextId("obra", "codigoobra");
        txtCodigoObra.setText(Integer.toString(codigo));
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
        txtCodigoObra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTituloObra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxAutor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbxEditora = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtAnoPublicacao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxSituacao = new javax.swing.JComboBox();
        btnGravar = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editora");

        jLabel1.setText("Código");

        txtCodigoObra.setEditable(false);
        txtCodigoObra.setEnabled(false);

        jLabel2.setText("Titulo");

        jLabel3.setText("Autor principal");

        cbxAutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel4.setText("Editora");

        jLabel5.setText("Ano publicação");

        txtAnoPublicacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnoPublicacaoFocusLost(evt);
            }
        });

        jLabel6.setText("Situação");

        cbxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponível", "Emprestado" }));

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(txtAnoPublicacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cbxSituacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(btnGravar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel5)
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(cbxAutor, 0, 118, Short.MAX_VALUE)
                                    .add(txtCodigoObra))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(cbxEditora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2)
                            .add(txtTituloObra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .add(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCodigoObra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtTituloObra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbxAutor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbxEditora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtAnoPublicacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbxSituacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnGravar)
                    .add(btnCancel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        int intCodigoeditora = Integer.parseInt(cbxEditora.getSelectedItem().toString().split("-")[0].trim());
        Obra obra = new Obra();
        Autor autor = new Autor();
        Editora editora = new Editora();
        obra.setTituloObra(txtTituloObra.getText());
        obra.setAnoPublicacao(Integer.parseInt(txtAnoPublicacao.getText()));
        //obra.setAnoPublicacao(UtilController.recebeNumerico(txtAnoPublicacao, "Ano de publicação."));
        obra.setSituacaoObra(cbxSituacao.getSelectedItem().toString());
        autor.setCodigoAutor(Integer.parseInt(cbxAutor.getSelectedItem().toString().split("-")[0].trim()));
        obra.setAutorPrincipal(autor);
        editora.setCodigoEditora(intCodigoeditora);
        obra.setEditoraObra(editora);
        
        if(bEditar){
            obra.setCodigoObra(Integer.parseInt(txtCodigoObra.getText()));
            
            if(new ObraController().alter(obra))
                JOptionPane.showMessageDialog(null, "Obra salva com sucesso.");
            else
                JOptionPane.showMessageDialog(null, "Nao foi possivel salvar a obra.");
            
        }
        else{
            if(new ObraController().insert(obra))
                JOptionPane.showMessageDialog(null, "Obra cadastrada com sucesso.");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a obra.");
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void txtAnoPublicacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnoPublicacaoFocusLost
//        try{
//            int valid = Integer.parseInt(txtAnoPublicacao.getText());
//            if(Integer.toString(valid).length() < 4)
//            {
//                JOptionPane.showMessageDialog(null, "Digite o ano completo no campo 'Ano de publicação'");
//                //txtAnoPublicacao.requestFocus();
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Digite apenas número no campo 'Ano de publicação'");
//        }
    }//GEN-LAST:event_txtAnoPublicacaoFocusLost

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
            java.util.logging.Logger.getLogger(ObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ObraUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGravar;
    private javax.swing.JComboBox cbxAutor;
    private javax.swing.JComboBox cbxEditora;
    private javax.swing.JComboBox cbxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAnoPublicacao;
    private javax.swing.JTextField txtCodigoObra;
    private javax.swing.JTextField txtTituloObra;
    // End of variables declaration//GEN-END:variables
}
