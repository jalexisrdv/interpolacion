/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import modelos.FormulasInterpolacion;
import vistas.PanelCampos;
import vistas.PanelPrincipal;
import vistas.Ventana;
import vistas.VentanaAcercaDe;

/**
 *
 * @author jarv
 */
public class OyenteMultiple implements ActionListener {

    private final FormulasInterpolacion interpolacion;
    private final Ventana ventana;
    private boolean banderaF = false;
    PanelPrincipal panelPrincipal;

    public OyenteMultiple(FormulasInterpolacion interpolacion, Ventana ventana) {
        this.interpolacion = interpolacion;
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent componente = (JComponent) e.getSource();
        PanelCampos panelCampos = ventana.getPanelCampos();
        switch (componente.getName()) {
            case "gradoDos":
                panelCampos.getCampoX2().setEnabled(true);
                panelCampos.getCampoX2().setBackground(Color.WHITE);
                panelCampos.getCampoF2().setEnabled(true);
                panelCampos.getCampoF2().setBackground(Color.WHITE);
                panelCampos.getCampoF().setEnabled(false);
                panelCampos.getCampoF().setBackground(null);
                panelCampos.getCampoF().setText("");
                break;
            case "gradoUno":
                panelCampos.getCampoX2().setEnabled(false);
                panelCampos.getCampoX2().setBackground(null);
                panelCampos.getCampoF2().setEnabled(false);
                panelCampos.getCampoF2().setBackground(null);
                panelCampos.getCampoF().setEnabled(false);
                panelCampos.getCampoF().setBackground(null);
                panelCampos.getCampoF().setText("");
                break;
            case "calcular":
                double x0 = 0;
                double f0 = 0;
                double x1 = 0;
                double f1 = 0;
                double x2 = 0;
                double f2 = 0;
                double x = 0;
                double f = 0;
                String gradoSeleccionado = panelCampos.getGrupoGrados().getSelection().getActionCommand();
                if (gradoSeleccionado.equals("gradoUno")) {
                    x0 = Double.parseDouble(panelCampos.getCampoX0().getText());
                    f0 = Double.parseDouble(panelCampos.getCampoF0().getText());
                    x1 = Double.parseDouble(panelCampos.getCampoX1().getText());
                    f1 = Double.parseDouble(panelCampos.getCampoF1().getText());
                    x = Double.parseDouble(panelCampos.getCampoX().getText());
                    double[] valores = {x0, f0, x1, f1, x};
                    f = interpolacion.resuelveInterpolacionGradoUno(x0, f0, x1, f1, x);
                    banderaF = true;
                    //--------------Aqui se escribe el modelo matematico de Grado uno
                    double resultadoDivision1=((f1 - f0) / (x1 - x0));
                    double resultadoDivision2=((f1 - f0) / (x1 - x0)) * x0;
                    double noInfinito=x1-x0;
                    String modelo="";// modelo completo = "F = "+Double.toString(f0)+ " + "+ Double.toString(resultadoDivision1)+"x - "+Double.toString(resultadoDivision2);
                    if(f0==0){modelo="F = ("+ Double.toString(resultadoDivision1)+"x) + ("+Double.toString(resultadoDivision2)+")";}
                    if(x0==0){modelo = "F =("+f0+")+("+ Double.toString(resultadoDivision1)+"x)";}
                    if(resultadoDivision1==0){modelo= "F = ("+Double.toString(f0)+")";}
                    if(f0==0 && resultadoDivision1==0){modelo= "F = 0";}
                    if(f0==0 && x0==0){ modelo = "F =("+resultadoDivision1+"x)";}
                    if(noInfinito==0){ modelo = "F =("+f0+")";}
                    if(f0!=0 && resultadoDivision1!=0 && x0!=0 && noInfinito!=0){modelo="F = ("+Double.toString(f0)+ ") + ("+ Double.toString(resultadoDivision1)+"x) + ("+Double.toString(resultadoDivision2)+")"; }
                    ventana.escribeModelo(""); //Deja en blanco el TextField
                    ventana.escribeModelo(modelo);//Escribe el modelo
                    
                    interpolacion.setValores(valores);
                }
                if (gradoSeleccionado.equals("gradoDos")) {
                    x0 = Double.parseDouble(panelCampos.getCampoX0().getText());
                    f0 = Double.parseDouble(panelCampos.getCampoF0().getText());
                    x1 = Double.parseDouble(panelCampos.getCampoX1().getText());
                    f1 = Double.parseDouble(panelCampos.getCampoF1().getText());
                    x2 = Double.parseDouble(panelCampos.getCampoX2().getText());
                    f2 = Double.parseDouble(panelCampos.getCampoF2().getText());
                    x = Double.parseDouble(panelCampos.getCampoX().getText());
                    double[] valores = {x0, f0, x1, f1, x2, f2, x};
                    f = interpolacion.resuelveInterpolacionGradoDos(x0, f0, x1, f1, x2, f2, x);
                    banderaF = true;
                    //-----------------Aqui escribe el modelo matematico de Grado dos
                    double b0 = f0;
                    double b1 = (f1 - f0) / (x1 - x0);
                    double b2 = (((f2 - f1) / (x2 - x1)) - ((f1 - f0) / (x1 - x0))) / (x2 - x0);
                    double b1X0= b1*(-x0);
                    double b2X1= b2*(-x1);
                    double b2X0= b2*(-x0);
                    double b2X0X1= b2*(x0*x1);
                    double bX=b1+b2X1+b2X0;
                    double bNormal=b0+b1X0+b2X0X1;
                    //System.out.println("F=("+b2+"x^2)+("+bX+"x)+("+bNormal+")");
                    String modelo="";//modelo completo=F(x)= ("+b0+")+("+b1+"x)+("+b1X0+")+("+b2+"x^2)+("+b2X1+"x)+("+b2X0+"x)+("+b2X0X1+")"
                    if(b2==0){modelo = "F(x) =("+bX+"x)+("+bNormal+")";}
                    if(bX==0){modelo = "F(x) =("+b2+"x^2)+("+bNormal+")";}
                    if(bNormal==0){modelo = "F(x) =("+b2+"x^2)+("+bX+"x)";}
                    if(b2!=0 && bX!=0 && bNormal!=0){modelo = "F=("+b2+"x^2)+("+bX+"x)+("+bNormal+")";}              
                    ventana.escribeModelo(""); //Deja en blanco el TextField
                    ventana.escribeModelo(modelo);//Escribe el modelo
                    //System.out.println("F(x)= ("+b0+")+("+b1+"x)+("+b1X0+")+("+b2+"x^2)+("+b2X1+"x)+("+b2X0+"x)+("+b2X0X1+")");
                    interpolacion.setValores(valores);
                }
                /*Se pone como verdadero cuando f se ha calculado*/
                if (banderaF) {
                    panelCampos.getCampoF().setEnabled(true);
                    panelCampos.getCampoF().setBackground(Color.WHITE);
                    panelCampos.getCampoF().setText(String.format("%.6f", f));
                }
                ventana.getPanelInterpolacion().repaint();
                break;
            case "opcionSalir":
                System.exit(0);
                break;
            case "opcionAcercaDe":
                VentanaAcercaDe dialogo = new VentanaAcercaDe(ventana, true);
                dialogo.setSize(600, 400);
                int dX = ventana.getX() + ventana.getWidth() / 2 - dialogo.getWidth() / 2;
                int dY = ventana.getY() + 100;
                dialogo.setLocation(dX, dY);
                dialogo.setVisible(true);
        }
    }

}
