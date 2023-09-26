package EPDs.EPD1.Experimentos;
// ¿Cómo podemos modificar el código para que la sea una colección de enteros?
import java.util.*;

public class Experimento1 {

    public static void main(String[] args) {
        // Instanciamos una Coleccion de tipo List() con la implementacion ArrayList<>() que contiene 'Objetos'
        // Collection c = new ArrayList(); 

        // Instanciamos una Coleccion de tipo List() con la implementacion ArrayList<Integer>() que contiene 'Enteros'
        Collection<Integer> c = new ArrayList<Integer>(); 

        System.out.println("La colección tiene " + c.size() + " elementos");
        if (c.isEmpty()) {
            System.out.println("La colección está vacía");
        }

        for (int i = 0; i < 5; i++) // Añadimos elementos a la colección
            c.add(i * 3);

        System.out.println("La colección tiene " + c.size() + " elementos");

        System.out.println("La colección contiene: " + c);
    }
}