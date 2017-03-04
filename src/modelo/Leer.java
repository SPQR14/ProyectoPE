
package modelo;

import java.io.*;

/**
 *
 * @author SPQR14
 */
public class Leer {
    
    private static String s;
    private static InputStreamReader r = new InputStreamReader(System.in);
    private static BufferedReader in = new BufferedReader(r);
    
    public Leer(){
    }
    
    public static double leerDouble(double x){
        try{
            s = in.readLine();
            x = Double.parseDouble(s);
        }catch(IOException e){
            System.out.println("Error: " +e.getMessage());
            leerDouble(x);
        }finally{    
        }
        return x;
    }
    
    public static int leerInt(int x){
        try{
            s = in.readLine();
            x = Integer.parseInt(s);
        }catch(IOException e){
            System.out.println("Error: " +e.getMessage());
        }finally{
        }
        return x;
    }
    
}
