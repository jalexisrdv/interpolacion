/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import modelos.FormulasInterpolacion;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author jarv
 */
public class PanelInterpolacion extends javax.swing.JPanel {

    private FormulasInterpolacion formulasInterpolacion;

    /**
     * Creates new form PanelInterpolacionCuadratica
     *
     * @param formulasInterpolacion
     */
    public PanelInterpolacion(FormulasInterpolacion formulasInterpolacion) {
        initComponents();
        this.formulasInterpolacion = formulasInterpolacion;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        formulasInterpolacion.setGraphics2D(g2);
        formulasInterpolacion.setAnchoYAlto(this.getWidth(), this.getHeight());
        formulasInterpolacion.dibujaEjes();
        formulasInterpolacion.dibujar();
        //formulasInterpolacion.interpolacionGradoUno(-3, -2, 3, 4, 2);
//        formulasInterpolacion.interpolacionGradoUno(8, 25, 9.3, 32.2, 20);
//        formulasInterpolacion.interpolacionGradoUno(-1, 0, 4, 2, 1);
//        formulasInterpolacion.interpolacionGradoUno(0, 1, 2, 9, 1);
//        formulasInterpolacion.interpolacionGradoUno(1, 0, 6, 1.791759469, 2);

//formulasInterpolacion.interpolacionGradoDos(-3, 1, -1, -3, 2, 5, -2);
//        formulasInterpolacion.interpolacionGradoDos(-3, 1, -1, -3, 2, 5, 3);
//        formulasInterpolacion.interpolacionGradoDos(0, -3, 1, 0, 3, 0, 1);
//        formulasInterpolacion.interpolacionGradoDos(0, -1, 1, 3, 2, 9, 5);
        //formulasInterpolacion.interpolacionGradoDos(1, 0, 4, 1.386294361, 6, 1.791759469, 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
