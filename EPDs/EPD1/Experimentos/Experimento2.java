package EPDs.EPD1.Experimentos;
import java.util.*;

public class Experimento2 {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        Collection d = new ArrayList();

        for (int i = 0; i < 5; i++) { // Añadimos elementos a las colecciones
            c.add(i * 3);
            d.add(3.1416 * i);
        }

        System.out.println("La colección c contiene: " + c);
        System.out.println("La colección d contiene: " + d);
        for (Collection<Integer> iterator : d) {
            
        }
        d.addAll(c);
        System.out.println("Despues de d.addAll(c) la colección d contiene: " + d);

        d.retainAll(c);
        System.out.println("Despues de d.retainAll(c) la colección d contiene: " + d);

        d.removeAll(c);
        System.out.println("Despues de d.removeAll(c) la colección d contiene: " + d);
    }
}
