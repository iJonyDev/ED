package EPDs.EPD1.Experimentos;
// ¿Cómo podemos modificar el código para que la coleccion "c" sea una colección de enteros?
import java.util.ArrayList;
import java.util.Collection;

public class E1 {
    public static void main(String[] args) {

        // implementacion ArrayList() que contiene 'Objetos' Genéricos
        Collection c = new ArrayList(); 

        System.out.println("La colección tiene " + c.size() + " elementos");
        if (c.isEmpty()) {
            System.out.println("La colección está vacía");
        }

        for (int i = 0; i < 5; i++) // Añadimos elementos a la colección
            c.add(i * 3);           // metodo add() añade Objetos Genéricos
        System.out.println("La colección tiene " + c.size() + " elementos");
        System.out.println("La colección contiene: " + c);
    }
}
