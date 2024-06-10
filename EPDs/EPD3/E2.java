package EPDs.EPD3;
/*
  a) Estudie el código del siguiente programa y determine el objetivo del mismo. Ejecute el programa para obtener su salida por pantalla.
  b) Explique razonadamente los motivos que provocan la salida por pantalla obtenida.
 */
import java.util.*;

public class E2 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        Set<String> s;
        l.add("yo");
        l.add("soy");
        l.add("yo");
        l.add("tu");
        l.add("eres");
        l.add("tu");
        System.out.println("l: " + l);
        s = new HashSet<>(l);
        System.out.println("s: " + s);
    }
}
