package EPDs.EPD2;
/*
   a) El siguiente código tiene como objetivo recorrer una lista hacia atrás. Corrija el código, ejecútelo y observe la salida.
   b) ¿Por qué no funciona como se esperaba? Solucione el problema
 */
import java.util.*;

public class E8 {
    public static void main(String[] args) {
        List l = new LinkedList();
        ListIterator it;                    // Error 1
        for (int i = 0; i < 5; i++) {       // Añadimos letras
            l.add(new Character((char) ('a' + i)));
        }
        System.out.println(l);
        it = l.listIterator(l.size() - 1);  // Error 2
        while (it.hasPrevious())
            System.out.println(it.previous().charValue());
    }
}
