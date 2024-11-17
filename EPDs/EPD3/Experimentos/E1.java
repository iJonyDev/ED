package EPDs.EPD3.Experimentos;

/*
  a) Analice el código del siguiente programa. Ejecútelo para ver la salida por pantalla que genera.
  b) ¿Por qué el orden de los elementos no coincide en los dos tipos de colecciones?
  c) Varíe la iteración del bucle for para que sea creciente ¿Por qué ahora el orden coincide?
 */
import java.util.*;

public class E1 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        Iterator<Integer> it;
        for (int i = 5; i >= 1; i--) {
            l.add(i);
            s.add(i);
        }
        it = l.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        System.out.println("-------------------");
        it = s.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
