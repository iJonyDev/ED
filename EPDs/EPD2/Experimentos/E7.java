package EPDs.EPD2.Experimentos;
/*
  El siguiente programa proviene de sustituir la clase Numero por la clase Integer en el experimento 4 y la aplicación del orden
  definido anteriormente. Ejecute dicho programa ¿Cuál es la razón de la excepción?
 */
import java.util.*;

public class E7 {
        public static void main(String[] args) {
        List l = new ArrayList();
        Iterator it;
        for (int i = 0; i < 10; i++)
            l.add(new Integer((int) (Math.random() * 100)));
        System.out.println("Antes de ordenar:");
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Integer) it.next());
            if (it.hasNext())
                System.out.print(", ");
        }
        System.out.println("\nDespués de ordenar:");
        Collections.sort(l, new ComparadorNumero()); // El ComparadorNumero() no puede hacer el casting de Interger al tipo de la Clase Numero.
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Integer) it.next());
            if (it.hasNext())
                System.out.print(", ");
        }
    }
}
