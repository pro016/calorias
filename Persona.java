
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
    // Atributo que almacena el alimento mas calorico consumido.
    private Comida alimentoMasCalorico;

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
        alimentoMasCalorico = null;
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
            if(alimentoMasCalorico == null || comida.getCalorias() >= alimentoMasCalorico.getCalorias()){
                alimentoMasCalorico = comida;
            }
        }else{
            System.out.println("¡Ya no tengo hambre!");
        }
        return caloriasComidaActual;
    }

    /**
     * Metodo que actualiza el atributo puedeComerMas.
     */
    private void actualizarMetabolismo()
    {
        int entero = 5;
        if(!hombre){
            entero = -161;
        }
        puedeComerMas = caloriasIngeridas <= (10*pesoEnKg)+(6*alturaEnCm)+(5*edad)+entero;
    }
    
    /**
     * Permite preguntar cosas a la persona.Si no ha sobrepasado su metabolismo basal, 
     * te contestará "SI" o "NO" dependiendo de si la pregunta tiene una longitud 
     * divisible por 3 o no, respectivamente.
     * En caso de que la persona ya haya sobrepasado el metabolismo basal o en el caso 
     * de que tu pregunta contenga el nombre de la persona, responderá con la misma 
     * pregunta que le has hecho pero en mayusculas indiferentemente de la longitud 
     * de a pregunta.
     */
    public String contestar(String pregunta)
    {
        String respuesta = pregunta;
        if(pregunta.length()%3 == 0){
            respuesta = "SI";
        }else{
            respuesta = "NO";
        }
        
        if(!puedeComerMas || pregunta.contains(nombre)){
            respuesta = pregunta.toUpperCase();
        }
        System.out.println(respuesta);
        return respuesta;
    }
    
    /**
     * Imprime por pantalla y que devuelva el nombre de la comida más 
     * calórica ingerida hasta ahora por un usuario.
     */
    public Comida getAlimentoMasCaloricoConsumido()
    {
        if(alimentoMasCalorico != null){
            System.out.println(alimentoMasCalorico.getNombre());
        }else{
            System.out.println("¡Aun no he comido nada!");
        }
        return alimentoMasCalorico;
    }
}
