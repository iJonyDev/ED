package EPDs.EPD1.Experimentos;
/*Modifique el código para que c sea una colección de enteros y d sea una colección de cadenas. ¿Por qué ahora hay errores en el
código? ¿Cómo se pueden solucionar? */
import java.util.ArrayList;
import java.util.Collection;

public class E2 {
    public static void main(String[] args) {
        Collection c = new ArrayList(); // Implementa ArrayList() de Objetos Genericos
        Collection d = new ArrayList();

        for (int i = 0; i < 5; i++) { // Añadimos elementos a las colecciones
            c.add(i * 3);

            d.add(3.1416 * i);  

        }

        System.out.println("La colección c contiene: " + c);
        System.out.println("La colección d contiene: " + d);
        // Añadimos elementos de la coleccion "c" a la coleccion "d"
        d.addAll(c);
       





        System.out.println("Despues de d.addAll(c) la colección d contiene: " + d);

        d.retainAll(c);
        System.out.println("Despues de d.retainAll(c) la colección d contiene: " + d);

        d.removeAll(c);
        System.out.println("Despues de d.removeAll(c) la colección d contiene: " + d);
    }
}