
package modelo;

/**
 * @author spqr14
 */

public class Entrada extends Thread {
    
    private double [][] matrizP;
    private double [] vectorPi;
    private int m; //numero de estados, establece las dimesiones de la matriz y del vector
    private int n; //periodos a calcular
    
    private void leerM(){
        do{
            System.out.print("¿Cuántos estados?: ");
            m = Leer.leerInt(m);    
        }while(!validarInt(m));
        matrizP = new double [m][m];
        vectorPi = new double[m];
    }
    
    private void leerN(){
        do{
            System.out.print("¿Cuántos periodos?: ");
            n = Leer.leerInt(n);  
        }while(!validarInt(n));
    }

    private void leerVPi(){
        int i = 0;
        double flag = 1;
        for(i = 0; i < vectorPi.length; i++){
            vectorPi[i] = 0;
        }
        System.out.println("Ingrese el vector Pi.");
        for(i = 0; i < vectorPi.length;){
            System.out.printf("Estado %d Disponible hasta hacer 1: %f : ", i, flag);
            vectorPi[i] = Leer.leerDouble(vectorPi[i]);
            flag -= vectorPi[i];
            if(validarDouble(vectorPi[i])){
                if(flag == 0){
                    flag = 1;
                    break;
                }
                i++;
            }
        }
        if(validarVector(vectorPi)){
            mostrarPi();
        }
    }
    
    private void leerMatriz(){
        double flag = 1;
        for(int i = 0; i < matrizP.length; i++){
            for(int j = 0; j < matrizP[i].length; j++){
                matrizP[i][j] = 0;
            }
        }
        System.out.println("Ingrese la matriz de transición P.");
        for(int i = 0; i < matrizP.length; i++){
            for(int j = 0; j < matrizP[i].length;){
                System.out.printf("Transición %d,%d. Disponible hasta hacer 1: %f ",i ,j, flag);
                matrizP[i][j] = Leer.leerDouble(matrizP[i][j]);
                flag -= matrizP[i][j];
                if(validarDouble(matrizP[i][j])){
                    if(flag == 0){
                        System.out.println("Siguiente renglón.");
                        flag = 1;
                        break;
                    }
                    j++;
                }
            }
        }
        mostrarMatrizP();    
    }
     
    private boolean validarVector(double [] x){
        boolean crt = false;
        double sum = 0.0;
        for (double d : x) {
            sum += d;
        }
        if(sum == 1){
            crt = true;
        }else{
            System.out.println("El vector Pi debe sumar 1. Revise los datos e ingreselos de nuevo.");
            leerVPi();
        }
        return crt;
    }
    
    private boolean validarDouble(double x){
        boolean crt = false;
        if(x >= 0 && x <= 1){
            crt = true;
        }else{
            System.out.println("El dato ingresado es incorrecto, tiene que ser mayor a 0 y menor a 1. Ingreselo de nuevo.");
        }
        return crt;
    }
    
    private boolean validarInt(int x){
        boolean crt = false;
        if(x > 0){
            crt = true;
        }else{
            System.out.println("El dato ingresado debe ser un entero no negativo. Ingreselo de nuevo.");
        }
        return crt;
    }
    
    private void mostrarPi(){
        int i = 0;
        System.out.println("\nVector Pi:");
        System.out.print("( ");
        for (; i < vectorPi.length - 1 ; i++){
            System.out.print(vectorPi[i] + ", ");
        }
        System.out.print(vectorPi[i]);
        System.out.println(" )");
        System.out.println("");
    }
    
    private void mostrarMatrizP(){
        System.out.println("\nLa matriz P.");
        for (double[] matrizP1 : matrizP) {
            for (int j = 0; j < matrizP1.length; j++) {
                System.out.printf("%6f ", matrizP1[j]);
            }
            System.out.println("");
        }   
    }

    public double[][] getMatrizP() {
        return matrizP;
    }

    public double[] getVectorPi() {
        return vectorPi;
    }

    public int getN() {
        return n;
    }

    public static int getMAX_PRIORITY() {
        return MAX_PRIORITY;
    }
       
    @Override
    public void run(){
        leerM();
        leerN();
        leerVPi();
        leerMatriz();
    }
    
}
