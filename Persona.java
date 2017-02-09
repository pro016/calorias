
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    // Atributo que almacena el nombre de la persona.
    private String nombre;
    // Atributo que indica si es hombre (true) o si es mujer (false).
    private boolean hombre;
    // Atributo que almacena el peso de la persona en kg.
    private int pesoEnKg;
    // Atributo que almacena la altura de la persona en cm.
    private int alturaEnCm;
    // Atributo que almacena la edad de la persona en años.
    private int edad;
    // Atributo que almacena las calorias ingeridas por la persona.
    private int caloriasIngeridas;
    // Atributo que indica si puede comer mas o no.
    private boolean puedeComerMas;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombre, boolean hombre, int pesoEnKg, int alturaEnCm, int edad)
    {
        this.nombre = nombre;
        this.hombre = hombre;
        this.pesoEnKg = pesoEnKg;
        this.alturaEnCm = alturaEnCm;
        this.edad = edad;
        caloriasIngeridas = 0;
        actualizarMetabolismo();
    }

    /**
     * Metodo que devuelve la cantidad de calorias que ha ingerido la persona hasta ahora.
     */
    public int getCaloriasIngeridas()
    {
        return caloriasIngeridas;
    }

    /**
     * Metodo que da de comer la comida indicada por parametro a la persona 
     * y devuelve la cantidad de calorias que tenía la comida indicada.
     */
    public int comer(Comida comida)
    {
        int caloriasComidaActual = -1;
        if(puedeComerMas){
            caloriasComidaActual = comida.getCalorias();
            caloriasIngeridas += caloriasComidaActual;
            actualizarMetabolismo();
        }else{
            System.out.println("¡Ya no tengo hambre!");
        }
        return caloriasComidaActual;
    }

    /**
     * Metodo que actualiza el atributo puedeComerMas.
     */
    public void actualizarMetabolismo()
    {
        int entero = 5;
        if(!hombre){
            entero = -161;
        }
        puedeComerMas = caloriasIngeridas <= (10*pesoEnKg)+(6*alturaEnCm)+(5*edad)+entero;
    }
}
