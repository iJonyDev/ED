package EPDs.EPD2.Experimentos;
/*
   a) El siguiente código tiene como objetivo recorrer una lista hacia atrás. Corrija el código, ejecútelo y observe la salida.
   b) ¿Por qué no funciona como se esperaba? Solucione el problema
 */
import java.util.*;

public class Experimento8 {
    public static void main(String[] args) {
        List l = new LinkedList<>();
        ListIterator<Character> it;     // Sol. Error 1
        for (int i = 0; i < 5; i++) {   // Añadimos letras
            l.add(new Character((char) ('a' + i)));
        }
        System.out.println(l);
        it = l.listIterator(l.size());  // Sol. Error 2
        while (it.hasPrevious())
            System.out.println(it.previous().charValue());
    // Para volver a imprimir la lista hacia atras hay que reiniciar el iterador
        // it = l.listIterator(l);
        while (it.hasNext())
            System.out.println(it.next().charValue());
    }
}