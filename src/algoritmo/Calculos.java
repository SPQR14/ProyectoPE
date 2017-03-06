
package algoritmo;

import modelo.Entrada;
import java.math.*;

/**
 * 
 * @author Alberto I. Pico Lara
 */

public class Calculos extends Thread{
    
    private double [][] matrizP;
    private double [][] matrizR;
    private double [] vectorResultante;
    private double [] vector;
    private int n;
    Entrada mostrar = new Entrada();
    
    /**
     * 
     * @param n
     * @param vector
     * @param matriz 
     */
    
    public Calculos(int n, double [] vector, double [][] matriz ){
        this.n = n;
        this.vector = vector;
        this.vectorResultante = new double[vector.length];
        this.matrizP = matriz; //esta matriz conserva sus valores iniciales para las iteraciones.
        this.matrizR = new double[matriz.length][matriz.length]; //esta va a ser la matriz elevada a la n.
    }
    
    public double [][] multiplicarMatrices(double[][] a, double[][] b){
        double [][] temp = new double[a.length][b.length]; 
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                for(int z = 0; z < temp[i].length; z++){
                    temp[i][j] += a[i][z] * b[z][j];
                    amortiguarError(temp[i][j]);
                }
            }
        }
        mostrar.mostrarMatrizP(temp);
        return temp;
    }
    
    public double [][] potenciarMatriz(double [][] base){
        double [][] paso = base;
        for(int i = 1; i < n; i++){
            paso = multiplicarMatrices(paso, base);
        }
        return paso;
    }
    
    private void multiplicacionVectorPorMatriz(){
        for(int i = 0; i<vector.length; i++){
            for(int j=0; j < matrizP[i].length; j++){
                vectorResultante[i] += vector[j] * matrizR[j][i];  
            }
        }
        mostrar.mostrarPi(vectorResultante);
    }
    
    private BigDecimal amortiguarError(double cifra){
        BigDecimal err = BigDecimal.ZERO;
        BigDecimal cifraD = new BigDecimal(4).divide(new BigDecimal(8*cifra+1), 20, RoundingMode.HALF_UP);
        return cifraD;
    }

    public double[][] getMatrizR() {
        return matrizR;
    }

    public double[] getVectorResultante() {
        return vectorResultante;
    }
    
    public static int getMAX_PRIORITY() {
        return MAX_PRIORITY;
    }
    
    @Override
    public void run(){
        matrizR = potenciarMatriz(matrizP);
        multiplicacionVectorPorMatriz();
    }
    
}
