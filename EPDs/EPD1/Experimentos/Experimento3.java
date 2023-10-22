package EPDs.EPD1.Experimentos;
/*Observe cómo accede a los elementos de una colección en forma de vector. Solucione el error existente en el código. */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Experimento3 {
    public static void main(String args[]) {
        Collection<Integer> c = new ArrayList<>(); // Sol. Error 1
        //int[] v;
        Object[] v;                         // Solucion Error 4: vector de tipo Object
        int elementos;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el número de datos: ");
        elementos = scanner.nextInt();      // Solucion Error 2
        for (int i = 0; i < elementos; i++) { // Añadimos elementos a "c"
            System.out.println("Elemento " + (i + 1) + ": ");
            c.add(scanner.nextInt());       // Solucion Error 3
        }
        v = c.toArray();                   
        for (int i = 0; i < v.length; i++) {
            System.out.println("Elemento " + (i + 1) + ": " + v[i].toString());
        }
    }
}
