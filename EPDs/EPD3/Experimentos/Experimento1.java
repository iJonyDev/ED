package EPDs.EPD3.Experimentos;
/*
  a) Analice el código del siguiente programa. Ejecútelo para ver la salida por pantalla que genera.
  b) ¿Por qué el orden de los elementos no coincide en los dos tipos de colecciones?
  c) Varíe la iteración del bucle for para que sea creciente ¿Por qué ahora el orden coincide?
 */
import java.util.*;

public class Experimento1 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();// Elementos ordenadossegun su orden de insercion
        Set<Integer> s = new HashSet<>();   // Elementos no siguen un orden
        Iterator<Integer> it;
        for (int i = 0; i <= 20; i++) {     // c)
            l.add(i);
            s.add(i);
        }
        it = l.iterator();
        while (it.hasNext())                
            System.out.println(it.next());  // Se muestra según el óden en el que han sido aniadidos.
        System.out.println("-------------------");
        it = s.iterator();
        while (it.hasNext())
            System.out.println(it.next());  // Se muestran sin seguir un orden especifico.
    }
}
