/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpolacion;

import java.awt.Dimension;
import javax.swing.JFrame;
import vistas.Ventana;

/**
 *
 * @author jarv
 */
public class Interpolacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana f = new Ventana();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300, 100, 800, 600);
        f.setMinimumSize(new Dimension(800, 600));
        f.setVisible(true);
    }
    
}
