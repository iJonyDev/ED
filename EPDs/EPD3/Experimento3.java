package EPDs.EPD3;

/*
   a) El siguiente programa rellena una colección ordenada con palabras y posteriormente consulta el contenido de dicha colección. Analice el código y complete los huecos que faltan.
   b) ¿Por qué la palabra “lugar” aparece en el subconjunto “Palabras desde la palabra lugar” y no en el subconjunto “Palabras hasta
la palabra lugar”?
 */
import java.util.*;

public class Experimento3 {
    public static void main(String[] args) {
        String[] palabras = { "en", "un", "lugar", "de", "la", "mancha" };
        SortedSet<String> ss = new TreeSet<String>(); // Instanciamos TreeSet<String>(), clase que implementa la
                                                      // interfaz SortedSet
        for (int i = 0; i < palabras.length; i++)
            ss.add(palabras[i]);
        System.out.println("ss: " + ss);
        System.out.println("Primera palabra: " + ss.first());
        System.out.println("Última palabra: " + ss.last());
        System.out.println("Palabras entre la letra g y la r: " + ss.subSet("g", "r"));
        System.out.println("Palabras desde la palabra \"lugar\" : " + ss.tailSet("lugar"));
        // Se muestra desde "lugar" incluyendo "lugar" hasta el final
        System.out.println("Palabras hasta la palabra \"lugar\" : " + ss.headSet("lugar"));
        // Se muestra desde el inicio hasta "lugar" excluyendo "lugar"
    }
}