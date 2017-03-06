
package modelo;

/**
 *
 * @author Alberto I. Pico Lara
 */
public class Miscelanea {
    
    public Miscelanea(){   
    }
    
    public static void mensajeApertura(){
        System.out.println("Sistema operativo: "+System.getProperty("os.name"));
        System.out.println("Arquitectura del sistema: "+System.getProperty("os.arch"));
        System.out.println("Versión del sistema: "+System.getProperty("os.version"));
        if("amd64".equals(System.getProperty("os.arch"))){
            System.out.println("Ok...");
            System.out.println("Bienvenido.");
        }
        System.out.println("***********************************************************************");
        System.out.println("***************************** Equipo 8. *******************************");
        System.out.println("");
    }
    
}
