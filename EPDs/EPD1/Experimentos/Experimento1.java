package EPDs.EPD1.Experimentos;
// ¿Cómo podemos modificar el código para que la coleccion "c" sea una colección de enteros?
import java.util.*;


public class Experimento1 {
    public static void main(String[] args) {

        // Implementacion ArrayList<Integer>() que contiene Objetos Tipo Entero
        Collection<Integer> c = new ArrayList<Integer>(); 

        System.out.println("La colección tiene " + c.size() + " elementos");
        if (c.isEmpty()) {
            System.out.println("La colección está vacía");
        }

        for (int i = 0; i < 5; i++) // Añadimos elementos a la colección
            c.add(i * 3);           // metodo add() añade Objetos Tipo Entero
        System.out.println("La colección tiene " + c.size() + " elementos");
        System.out.println("La colección contiene: " + c);
    }
}