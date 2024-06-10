package EPDs.EPD1.Experimentos;
/*a) Analice el siguiente código y determine el objetivo del mismo. Ejecútelo para ver el resultado. */

/*
b) Varíe el límite del bucle for de tal forma que la colección tenga 10 elementos. ¿Qué ocurre en este caso? ¿Qué significa la
excepción que se produce?
c) Realice los cambios necesarios en el código anterior para que funcione correctamente independientemente de los elementos que
contenga la colección.
d) Modifique el código anterior para no tener que hacer los castings en el bucle while. 
*/
import java.util.*;

public class Experimento6 {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        Iterator it; // Referencia al iterador

        for (int i = 1; i <= 10; i++) // Rellenamos la coleccion
            c.add(i);

        it = c.iterator(); // Obtenemos un iterador para la colección
        while (it.hasNext()) { // Mientras haya más elementos
            Integer i = (Integer) it.next();

            if (i.intValue() % 2 == 0 || i.intValue() % 3 == 0)
                it.remove();

            //if (i.intValue() % 3 == 0)
            //    it.remove();
        }

        it = c.iterator(); // Obtenemos un iterador para la colección
        while (it.hasNext()) // Mientras haya más elementos
            System.out.println((Integer) it.next()); // Imprimimos el siguiente elemento
    }
}
