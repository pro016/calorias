import java.util.ArrayList;
import java.util.Iterator;

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
    // Coleccion que almacena la comida que ha consumido el usuario.
    private ArrayList<Comida> comidaConsumida;

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
        comidaConsumida = new ArrayList<Comida>();
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
            comidaConsumida.add(comida);
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
    public String getAlimentoMasCaloricoConsumido()
    {
        String textoADevolver = null;
        if(alimentoMasCalorico != null){
            textoADevolver = alimentoMasCalorico.getNombre();
            System.out.println(textoADevolver);
        }else{
            System.out.println("¡Aun no he comido nada!");
        }
        return textoADevolver;
    }

    /**
     * Imprime por pantalla la lista de comidas ingeridas ordenadas de mayor a menor valor calórico.
     */
    public Comida[] verListadoComidasIngeridas()
    {
        ArrayList<Comida> copia = new ArrayList<Comida>();
        ArrayList<Comida> listaADevolver = new ArrayList<Comida>();
        for(Comida comida : comidaConsumida){
            copia.add(comida);
        }
        int caloriaMax = 0;
        while(copia.size() != 0){
            Comida comida = copia.get(0);
            int indexGuardado = 0;
            if(copia.size() != 1){
                int contador = 1;
                while(contador < copia.size()){
                    Comida comidaAspirante = copia.get(contador);
                    if(copia.get(indexGuardado).getCalorias() < comidaAspirante.getCalorias()){
                        indexGuardado = contador;
                    }
                    contador++;
                }
            }
            listaADevolver.add(copia.get(indexGuardado));
            System.out.println(copia.remove(indexGuardado));
        }
        if(comidaConsumida.size() == 0){
            System.out.println("Aun no he comido nada.");
        }
        Comida[] arrayADevolver = new Comida[comidaConsumida.size()];
        int contador = 0;
        for(Comida comida : listaADevolver){
            arrayADevolver[contador] = comida;
            contador++;
        }
        return arrayADevolver;
    }
}
