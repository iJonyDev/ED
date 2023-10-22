package EPDs.EPD2;
/*
  a) La respuesta está en la clase Numero.java
  b) Ejecute el siguiente programa y compruebe el funcionamiento del método sort y de la aplicación del orden natural definido para la clase.
 */
import java.util.*;

public class Experimento4 {
    public static void main(String[] args) {
        List<Numero> l = new ArrayList<>(); // Referencia a Lista de Tipo Entero
        Iterator<Numero> it;                // Referencia a Iterador Tipo Entero
        for (int i = 0; i < 10; i++)
            l.add(new Numero());
        System.out.println("Antes de ordenar:");
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Numero) it.next());
            if (it.hasNext())
                System.out.print(", ");
        }
        System.out.println("\nDespués de ordenar:");
        Collections.sort(l);
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Numero) it.next());
            if (it.hasNext())
                System.out.print(", ");
        }
    }

}