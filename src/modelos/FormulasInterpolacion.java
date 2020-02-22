/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author jarv
 */
public class FormulasInterpolacion {

    private Graphics2D g2;
    private int ancho;
    private int alto;
    //SEPARACION DE LAS COORDENADAS PARA X, Y
    private double separacionCoordenadas;
    private double[] valores;
    private double b0;
    private double b1;
    private double b2;
    private double f;

    public void dibujar() {
        if (valores != null) {
            if (valores.length == 5) {
                interpolacionGradoUno(valores[0], valores[1], valores[2],
                        valores[3], valores[4]);
            } else {
                interpolacionGradoDos(valores[0], valores[1], valores[2],
                        valores[3], valores[4], valores[5], valores[6]);
            }
        }
    }
    
    public double resuelveInterpolacionGradoUno(double x0, double f0, double x1, double f1, double x) {
        f = f0 + ((f1 - f0) / (x1 - x0)) * (x - x0);
        return f;
    }
    
    public double resuelveInterpolacionGradoDos(double x0, double f0, double x1, double f1, double x2, double f2, double x) {
         b0 = f0;
         b1 = (f1 - f0) / (x1 - x0);
         b2 = (((f2 - f1) / (x2 - x1)) - ((f1 - f0) / (x1 - x0))) / (x2 - x0);
         f = b0 + b1 * (x - x0) + b2 * (x - x0) * (x - x1);
         return f;
    }

    public void interpolacionGradoUno(double x0, double f0, double x1, double f1, double x) {
        double[] valoresX = {x0, x1, x};
        double[] valoresY = {f0, f1, f};

        double valorMayorX = valorMayor(valoresX);
        double valorMayorY = valorMayor(valoresY);

        dibujaCoordenadas(valorMayorX, valorMayorY);

        dibujaLineasParaUnirCoordenadas(valoresX, valoresY);

        dibujaFuncionGradoUno(valoresX, valoresY, valorMayorX, valorMayorY);

        dibujaPuntosSobreFuncion(valoresX, valoresY);

        dibujaTextoValoresPuntos(valoresX, valoresY);
    }

    public void interpolacionGradoDos(double x0, double f0, double x1, double f1, double x2, double f2, double x) {
        double[] valoresX = {x0, x1, x2, x};
        double[] valoresY = {f0, f1, f2, f};
        double[] valoresB = {b0, b1, b2};

        double valorMayorX = valorMayor(valoresX);
        double valorMayorY = valorMayor(valoresY);

        dibujaCoordenadas(valorMayorX, valorMayorY);

        dibujaLineasParaUnirCoordenadas(valoresX, valoresY);

        dibujaFuncionGradoDos(valoresB, valoresX, valorMayorX, valorMayorY);

        dibujaPuntosSobreFuncion(valoresX, valoresY);

        dibujaTextoValoresPuntos(valoresX, valoresY);
    }

    private void dibujaCoordenadas(double valorMayorX, double valorMayorY) {
        double delta = 30;
        double mayor = Math.max(valorMayorX, valorMayorY);
        double separacionX = (ancho - delta) / mayor;
        double separacionY = (alto - delta) / mayor;
        g2.setFont(new Font("Arial", Font.PLAIN, 11));
        g2.translate(ancho / 2, alto / 2);

        // ES LA SEPARACION DE LAS COORDENADAS EN X (LAS LINEAS QUE SE DIBUJAN EN LOS EJES)
        double separacionCoordenadasXPositivo = separacionX / 2;
        double separacionCoordenadasYPositivo = separacionY / 2;
        separacionCoordenadas = Math.min(separacionCoordenadasXPositivo, separacionCoordenadasYPositivo);

        g2.setPaint(Color.RED);
        Line2D linea = new Line2D.Double();

        //LINEAS PARA EJE X
        for (double i = 1; i <= valorMayorX + 1; i++) {
            linea.setLine(separacionCoordenadas * i, -3, separacionCoordenadas * i, 3);
            g2.draw(linea);
            linea.setLine(-separacionCoordenadas * i, -3, -separacionCoordenadas * i, 3);
            g2.draw(linea);
        }

        //LINEAS PARA EJE Y
        for (double i = 1; i <= valorMayorY + 1; i++) {
            linea.setLine(-3, separacionCoordenadas * i, 3, separacionCoordenadas * i);
            g2.draw(linea);
            linea.setLine(-3, -separacionCoordenadas * i, 3, -separacionCoordenadas * i);
            g2.draw(linea);
        }
    }

    private void dibujaFuncionGradoUno(double[] valoresX, double[] valoresY, double valorMayorX, double valorMayorY) {
        double limiteCicloDibujarFuncion = Math.max(valorMayorX, valorMayorY);
        g2.setColor(Color.BLACK);
        Line2D linea = new Line2D.Double();
        for (double i = valoresX[0]; i <= limiteCicloDibujarFuncion; i += 0.1) {
            double fC = valoresY[0] + ((valoresY[1] - valoresY[0]) / (valoresX[1] - valoresX[0])) * (i - valoresX[0]);
            double dX = i + 0.3;
            double fC2 = valoresY[0] + ((valoresY[1] - valoresY[0]) / (valoresX[1] - valoresX[0])) * (dX - valoresX[0]);
            linea.setLine(i * separacionCoordenadas, -fC * separacionCoordenadas, dX * separacionCoordenadas, -fC2 * separacionCoordenadas);
            g2.draw(linea);
        }
    }

    private void dibujaFuncionGradoDos(double[] valoresB, double[] valoresX, double valorMayorX, double valorMayorY) {
        double limiteCicloDibujarFuncion = Math.max(valorMayorX, valorMayorY);
        g2.setColor(Color.BLACK);
        Line2D linea = new Line2D.Double();
        for (double i = valoresX[0]; i <= limiteCicloDibujarFuncion; i += 0.1) {
            double fC = valoresB[0] + valoresB[1] * (i - valoresX[0]) + valoresB[2] * (i - valoresX[0]) * (i - valoresX[1]);//OBTIENE EL VALOR Y
            double dX = i + 0.3;
            double fC2 = valoresB[0] + valoresB[1] * (dX - valoresX[0]) + valoresB[2] * (dX - valoresX[0]) * (dX - valoresX[1]);//OBTIENE EL VALOR Y, CON UN PEQUEÑO INCREMENTO, PERMITIENDO DIBUJAR LA LINEA
            linea.setLine(i * separacionCoordenadas, -fC * separacionCoordenadas, dX * separacionCoordenadas, -fC2 * separacionCoordenadas);
            g2.draw(linea);
        }
    }

    //DIBUJA LINEAS DESDE EL PUNTO A LOS EJES X, Y
    private void dibujaLineasParaUnirCoordenadas(double[] valoresX, double[] valoresY) {
        Line2D lineaUnePunto = new Line2D.Double();
        g2.setPaint(Color.BLUE);
        for (int i = 0; i < valoresX.length; i++) {
            if (i == valoresX.length - 1) {
                g2.setPaint(Color.RED);
            }
            if (valoresY[i] != 0 && valoresX[i] != 0) {
                //DIBUJA LINEAS HORIZONTALES
                lineaUnePunto.setLine(valoresX[i] * separacionCoordenadas, -valoresY[i] * separacionCoordenadas, 0, -valoresY[i] * separacionCoordenadas);
                g2.draw(lineaUnePunto);
                //DIBUJA LINEAS VERTICALES
                lineaUnePunto.setLine(valoresX[i] * separacionCoordenadas, 0, valoresX[i] * separacionCoordenadas, -valoresY[i] * separacionCoordenadas);
                g2.draw(lineaUnePunto);
            }
        }
    }

    private void dibujaTextoValoresPuntos(double[] valoresX, double[] valoresY) {
        g2.setPaint(Color.RED);
        for (int i = 0; i < valoresX.length; i++) {
            //DIBUJA TEXTO PARA EJE X
            g2.drawString(String.format("%.2f", valoresX[i]), (float) (valoresX[i] * separacionCoordenadas), 15);
            //DIBUJA TEXTO PARA EJE Y
            g2.drawString(String.format("%.2f", valoresY[i]), -25, (float) (valoresY[i] * -separacionCoordenadas));
        }
    }

    private void dibujaPuntosSobreFuncion(double[] valoresX, double[] valoresY) {
        //EL ULTIMO PUNTO REPRESENTA LA INTERPOLACION
        g2.setPaint(Color.BLUE);
        for (int i = 0; i < valoresX.length; i++) {
            if (i == valoresX.length - 1) {
                g2.setPaint(Color.RED);
            }
            g2.fillOval((int) (valoresX[i] * separacionCoordenadas) - 3, (int) (-valoresY[i] * separacionCoordenadas) - 3, 6, 6);
        }
    }

    private double valorMayor(double[] valores) {
        double valorMayor = valores[0];
        for (int i = 0; i < valores.length; i++) {
            if (valorMayor < valores[i]) {
                valorMayor = valores[i];
            }
        }
        return valorMayor;
    }

    public void dibujaEjes() {
        g2.drawLine(ancho / 2, 0, ancho / 2, alto);
        g2.drawLine(0, alto / 2, ancho, alto / 2);
    }

    public void setGraphics2D(Graphics2D g2) {
        this.g2 = g2;
    }

    public void setAnchoYAlto(int ancho, int alto) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public void setValores(double[] valores) {
        this.valores = valores;
    }

    public double[] getValores() {
        return valores;
    }

}
