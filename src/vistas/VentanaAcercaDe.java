/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

/**
 *
 * @author nayel
 */
public class VentanaAcercaDe extends javax.swing.JDialog  {

    /** Creates new form VentanaAcercaDe
     * @param parent
     * @param modal */
    public VentanaAcercaDe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentro = new javax.swing.JScrollPane();
        panelEditor = new javax.swing.JEditorPane();
        panelSur = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelEditor.setEditable(false);
        panelEditor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        try {
            panelEditor.setPage(getClass().getResource("/recursos/AcercaDe.html"));
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        panelCentro.setViewportView(panelEditor);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        panelSur.add(botonAceptar);

        getContentPane().add(panelSur, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
      this.setVisible(false);
    }//GEN-LAST:event_botonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JScrollPane panelCentro;
    private javax.swing.JEditorPane panelEditor;
    private javax.swing.JPanel panelSur;
    // End of variables declaration//GEN-END:variables

}
