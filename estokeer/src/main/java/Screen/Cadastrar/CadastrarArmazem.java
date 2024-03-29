/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Screen.Cadastrar;

import Entities.LocalArmazenado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import persistencia.HibernateUtil;
/**
 *
 * @author ve743
 */
public class CadastrarArmazem extends javax.swing.JDialog {
    
    private LocalArmazenado armazem = new LocalArmazenado();
    private List<LocalArmazenado> listaArmazem = new ArrayList<>();
    /**
     * Creates new form CadastrarArmazem
     */
    public CadastrarArmazem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        InputNome = new javax.swing.JTextField();
        BtnCadastrar = new javax.swing.JButton();
        cAtivo = new javax.swing.JRadioButton();
        cInativo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel1.setText("Cadastrar Armazem");

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel2.setText("nome:");

        InputNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNomeActionPerformed(evt);
            }
        });

        BtnCadastrar.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(cAtivo);
        cAtivo.setText("Ativo");

        buttonGroup1.add(cInativo);
        cInativo.setText("Inativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cInativo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InputNome))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(588, 588, 588)
                        .addComponent(BtnCadastrar)))
                .addContainerGap(440, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cAtivo)
                    .addComponent(cInativo))
                .addGap(18, 18, 18)
                .addComponent(BtnCadastrar)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1282, 799));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InputNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputNomeActionPerformed

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
        String mensagem = "";
        if (InputNome.getText().equals("")) {
            mensagem = mensagem + "O campo nome é obrigatório!";
        }
        if (cAtivo.getText().equals("") || cInativo.getText().equals("") ) {
            if (!mensagem.equals("")) {
                mensagem = mensagem + "\n";
            }
            mensagem = mensagem + "O campo status é obrigatório!";
        }
        if (!mensagem.equals("")) {
            JOptionPane.showMessageDialog(null, mensagem);
        } else {

            armazem.setNome(InputNome.getText());
            if(cAtivo.isSelected() == true){
                armazem.setStatus("ATIVO");
            }else{
                armazem.setStatus("INATIVO");
            }
            
           

            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().merge(armazem);
            HibernateUtil.commitTransaction();
            HibernateUtil.closeSession();

            armazem = new LocalArmazenado();
            CleanButtons();
        }
    }//GEN-LAST:event_BtnCadastrarActionPerformed

    public void CleanButtons() {
        InputNome.setText("");
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
            java.util.logging.Logger.getLogger(CadastrarArmazem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarArmazem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarArmazem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarArmazem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarArmazem dialog = new CadastrarArmazem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JTextField InputNome;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cAtivo;
    private javax.swing.JRadioButton cInativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
