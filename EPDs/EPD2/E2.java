package EPDs.EPD2;
/*
a) Estudie el código del siguiente programa. Su objetivo es copiar los elementos de una lista en otra. Ejecútelo para ver el
resultado.
b) ¿Por qué no funciona el programa? Proporcione una solución para que el programa realice su cometido.
 */
import java.util.*;

public class E2 {
    public static void main(String[] args) {
        List<Integer> l, m;
        l = new ArrayList<>();
        m = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            l.add(i);
        System.out.println("l: " + l);
        Collections.copy(m, l);             // Error: Este metodo no funciona asi
        System.out.println("m: " + m);
    }
}