
package modelo;

/**
 *
 * @author Alberto I. Pico Lara
 */
public class Miscelanea {
    
    public Miscelanea(){   
    }
    
    public static void mensajeApertura(){
        System.out.println("Sistema operativo: "+System.getProperty("os.name").toUpperCase());
        System.out.println("Arquitectura del sistema: "+System.getProperty("os.arch").toUpperCase());
        System.out.println("Versión del sistema: "+System.getProperty("os.version").toUpperCase());
        if("amd64".equals(System.getProperty("os.arch"))){
            System.out.println("Ok...");
            System.out.println("Bienvenido.");
        }
        System.out.println("***********************************************************************");
        System.out.println("***************************** Equipo 8. *******************************");
        System.out.println("");
    }
    
    /**
     *
     * @param matrizP
     * @param vectorPi
     */
    public static void mostrarResultados(double [][] matrizP, double [] vectorPi ){
        //aqui van a imprimirse los resultados Ejemplo: probabilidad de ir del estado 0 al estado 4
        //System.out.println("Probabilidad de ir del estado 0 al estado 4 es:" +matrizP[0][4]);
    }
    
}
