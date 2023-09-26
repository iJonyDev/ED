package EPDs.EPD1.Experimentos;
import java.util.*;
import poo.io.IO;

public class Experimento3 {
    public static void main(String args[]) {
        Collection c = new ArrayList();
        int[] v;
        int elementos;

        System.out.println("Introduzca el número de datos: ");
        elementos = (int) IO.readLine();

        for (int i = 0; i < elementos; i++) {
            System.out.println("Elemento " + (i + 1) + ": ");
            c.add((int) IO.readNumber());
        }

        v = c.toArray(); //toArray devuele un array de objetos
        for (int i = 0; i < v.length; i++)
            System.out.println("Elemento " + (i + 1) + ": " + v[i].toString());
    }
}
