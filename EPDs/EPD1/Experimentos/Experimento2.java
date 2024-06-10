package EPDs.EPD1.Experimentos;

/*Modifique el código para que c sea una colección de enteros y d sea una colección de cadenas. ¿Por qué ahora hay errores en el
código? ¿Cómo se pueden solucionar? */
import java.util.*;

public class Experimento2 {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        Collection<String> d = new ArrayList<>();
        Iterator<Integer> it;
        for (int i = 0; i < 5; i++) { // Añadimos elementos a las colecciones "c" y "d"
            c.add(i * 3);
            /* d.add(3.1416 * i); */ // Error 1
            d.add(String.valueOf(3.1416 * i)); // Solucion1 Error 1
            // d.add(Double.toString(3.1416 * i)); // Solucion2 Error 1
        }

        System.out.println("La colección c contiene: " + c);
        System.out.println("La colección d contiene: " + d);
        // Añadimos elementos de la coleccion "c" a la coleccion "d"
        // d.addAll(c); // Error 2
        it = c.iterator(); // Solucion Error2: parte1
        while (it.hasNext()) // Solucion Error2: parte2
        {
            d.add(String.valueOf(it.next())); // Se añaden a 'd' como cadena los valores enteros de 'c'
        }

        System.out.println("Despues de d.addAll(c) la colección d contiene: " + d);

        d.retainAll(c);
        System.out.println("Despues de d.retainAll(c) la colección d contiene: " + d);

        d.removeAll(c);
        System.out.println("Despues de d.removeAll(c) la colección d contiene: " + d);
    }
}