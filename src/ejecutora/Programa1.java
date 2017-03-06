
package ejecutora;

import modelo.*;
import algoritmo.*;

/**
 *
 * @author Alberto I. Pico Lara
 */
public class Programa1 {

    /**
     * 
     * @param lol 
     */
    public static void main(String[] lol){
        Miscelanea.mensajeApertura();
        Entrada in = new Entrada();
        in.entrada();
        Calculos calc = new Calculos(in.getN(),in.getVectorPi(),in.getMatrizP());
        calc.start();
        Miscelanea.mostrarResultados(calc.getMatrizR(), calc.getVectorResultante());
    }
    
}
