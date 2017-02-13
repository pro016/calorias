import java.util.ArrayList;

/**
 * Write a description of class Prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prueba
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> numeros;
    private ArrayList<Integer> numeros2;
    /**
     * Constructor for objects of class Prueba
     */
    public Prueba()
    {
        numeros = new ArrayList<Integer>();
        numeros.add(654);
        numeros.add(782);
        numeros.add(5);
        numeros.add(78);
        numeros.add(37);
        numeros.add(6547);
        numeros.add(154);
        numeros.add(8);
        numeros.add(9);
        numeros.add(10);
        numeros2 = new ArrayList<Integer>();
    }

    /**
     * 
     */
    public void aaa()
    {
        ArrayList<Integer> numerosCopia = new ArrayList<Integer>();
        for(int numero : numeros){
            numerosCopia.add(numero);
        }
        
        while(numerosCopia.size() != 0){
            int numeroMasAlto = 0;
            int posicionMasAlto = 0;
            for(int posicionActual = 0; posicionActual < numerosCopia.size(); posicionActual++){
                if(numerosCopia.get(posicionActual) > numeroMasAlto){
                    numeroMasAlto = numerosCopia.get(posicionActual);
                    posicionMasAlto = posicionActual;
                }
            }
            numeros2.add(numerosCopia.remove(posicionMasAlto));
            System.out.println(numeroMasAlto);
        }
    }
}
