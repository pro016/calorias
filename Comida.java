
/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida
{
    // Atributo que almacena el nombre de la comida.
    private String nombre;
    // Atributo que almacena la cantidad de comida que se indicó.
    private int calorias;
    /**
     * Constructor for objects of class Comida
     */
    public Comida(String nombre, int calorias)
    {
        this.nombre = nombre;
        this.calorias = calorias;
    }
    
    /**
     * Devuelve el numero de calorias que tiene el alimento.
     */
    public int getCalorias()
    {
        return calorias;
    }
    
    /**
     * Devuelve el nombre del alimento.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Devuelve un String con todos los datos de la comida.
     */
    public String toString()
    {
        return nombre + ", " + calorias + " Calorias";
    }
}
