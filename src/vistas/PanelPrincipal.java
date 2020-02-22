/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author jarv
 */
public class PanelPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        initComponents();
    }

    /**
     * @return the panelCentro
     */
    public javax.swing.JPanel getPanelCentro() {
        return panelCentro;
    }

    /**
     * @return the panelOeste
     */
    public javax.swing.JPanel getPanelOeste() {
        return panelOeste;
    }
    
    /**
     * @return the panelSur
     */
    public javax.swing.JPanel getPanelSur() {
        return panelSur;
    }
    
    public javax.swing.JLabel getEtiquetaModelo() {
        return etiquetaModelo;
    }
    
    public void escribe(String modelo){
        this.modeloMatematico.setText(modelo);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSur = new javax.swing.JPanel();
        etiquetaModelo = new javax.swing.JLabel();
        modeloMatematico = new javax.swing.JTextField();
        panelCentro = new javax.swing.JPanel();
        panelOeste = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 20));
        setLayout(new java.awt.BorderLayout());

        panelSur.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelo Matematico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18))); // NOI18N
        panelSur.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        etiquetaModelo.setText("Modelo:");
        panelSur.add(etiquetaModelo);

        modeloMatematico.setColumns(30);
        panelSur.add(modeloMatematico);

        add(panelSur, java.awt.BorderLayout.SOUTH);

        panelCentro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grafica", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18))); // NOI18N
        panelCentro.setLayout(new java.awt.BorderLayout());
        add(panelCentro, java.awt.BorderLayout.CENTER);

        panelOeste.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Introduce Valores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18))); // NOI18N
        add(panelOeste, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaModelo;
    private javax.swing.JTextField modeloMatematico;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelOeste;
    private javax.swing.JPanel panelSur;
    // End of variables declaration//GEN-END:variables

   

}
