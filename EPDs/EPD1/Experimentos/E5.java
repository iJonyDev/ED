package EPDs.EPD1.Experimentos;
/*a) Analice el siguiente código que imprime la suma de los pares de elementos de una colección. Observe la forma en la que se
obtienen los elementos de la colección, usando un casting. Ejecute el código para ver el resultado. */

/*b) Cambie el límite del bucle for para que la colección tenga 11 elementos en lugar de 10. ¿De dónde proviene la excepción que se
produce? ¿Qué significa? */

/*c) Modifique el código anterior para que funcione correctamente independientemente del número de elementos de la colección, de
tal forma que se ignore a los elementos no pareados. */

/*d) Modifique el código anterior de tal forma que no sea necesario hacer los castings en bucle que implementa el recorrido de la
colección. */

import java.util.*;

public class E5 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        Iterator it; 

        for (int i = 1; i <= 10; i++) // Rellenamos la coleccion
            c.add(i);

        it = c.iterator(); // Obtenemos un iterador para la colección


        while (it.hasNext()) { // Mientras haya más elementos
            Integer i = (Integer) it.next();
            Integer j = (Integer) it.next(); // b) Error 1: si no hay elementos que recorrer y se intenta iterar se lanzara "java.util.NoSuchElementException"
            System.out.println(i.intValue() + j.intValue()); // Imprimimos la suma
        }
    }
}
