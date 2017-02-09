
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
     * 
     */
    public int getCalorias()
    {
        return calorias;
    }
}
