package EPDs.EPD1.Experimentos;
/*Observe cómo se obtiene un iterador para una colección y cómo se recorren los elementos de ésta
haciendo uso de él. */
import java.util.*;

public class E4 {
    
    public static void main(String[] args) {
        Collection c = new ArrayList();
        Iterator it; // Referencia al iterador

        for (int i = 1; i <= 5; i++) // Rellenamos la coleccion
            c.add(i);

            
        it = c.iterator(); // Obtenemos un iterador para la colección
        while (it.hasNext()) // Mientras haya más elementos
            System.out.println((Integer) it.next()); // Imprimimos el siguiente elemento
    }
}