
package algoritmo;

import modelo.Entrada;

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
        this.vector = vector;
        this.matrizP = matriz;
        this.matrizR = matriz;
        this.vectorResultante = new double[vector.length];
        this.n=n;
    }
    
    private void elevarMatriz(){
        int x = 1;
        while(x <= n){
            for(int i = 0; i < matrizP.length; i++){
                for(int j = 0; j < matrizP[i].length;j++){
                    matrizP[i][j] += matrizR[i][j] * matrizR[j][i];
                }
            }
            mostrar.mostrarMatrizP(matrizP);
            x++;
        }
    }
    
    private void multiplicacionVectorPorMatriz(){
        for(int i = 0; i<vector.length; i++){
            for(int j=0; j<matrizP[i].length; j++)
            {
                vectorResultante[i] += vector[j]*matrizP[j][i];
               
            }
        }
        mostrar.mostrarPi(vectorResultante);
    }
    
    public double[][] getMatrizp() {
        return matrizP;
    }

    public double[] getVectorResultante() {
        return vectorResultante;
    }

    public double[] getVector() {
        return vector;
    }
        
    @Override
    public void run(){
        elevarMatriz();
        multiplicacionVectorPorMatriz();
    }
    
}
