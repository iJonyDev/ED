package EPDs.EPD1.Experimentos;
import java.util.*;

public class Experimento5 {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        Iterator it; // Referencia al iterador

        for (int i = 1; i <= 10; i++) // Rellenamos la coleccion
            c.add(i);

        it = c.iterator(); // Obtenemos un iterador para la colección
        Integer j = 0;
        while (it.hasNext()) { // Mientras haya más elementos
            Integer i = (Integer) it.next();
            if (it.hasNext()) {
                j = (Integer) it.next();
            } else {
                j = 0;
            }

            System.out.println(i.intValue() + j.intValue()); // Imprimimos la suma
        }
    }
}
