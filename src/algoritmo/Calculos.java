package algoritmo;
public class Calculos extends Thread{
    
    private double [][] matrizP;
    private double [][] matrizR;
    private double [] vectorResultante;
    private double [] vector;
    private int n;
    
    /**
     * 
     * @param n
     * @param vector
     * @param matriz 
     */
    
    public Calculos(int n, double [] vector, double [][] matriz ){
        this.vector=vector;
        this.matrizP=matriz;
        this.matrizR = matriz;
        this.vectorResultante = new double[vector.length];
        this.n=n;
        
    }
    
    private void elevarMatriz(){
        int i = 0;
        while(i < n){
            
            i++;
        }
    }
    
    private void multiplicacionVectorPorMatriz(){
        for(int i = 0; i<vector.length; i++){
            for(int j=0; j<matrizP[i].length; j++)
            {
                vectorResultante[i] += vector[j]*matrizP[j][i];
               
            }
            //System.out.printf("%f", vector[i]);
        }
    }
    
    //vamos a elevar la matriz a la n;

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
