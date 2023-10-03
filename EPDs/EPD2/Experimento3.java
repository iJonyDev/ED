import java.util.*;

public class Experimento3 {
    public static void main(String args[]) {
        List<Integer> l = new ArrayList<>();
        for (int i = 5; i >= 0; i--)
            l.add(i * 10);
        System.out.println("Lista: " + l);
        Collections.sort(l);
        int posicion = Collections.binarySearch(l, 20);
        if (posicion >= 0)
            System.out.println("El 20 está en la posición " + posicion + " de la lista");
        else
            System.out.println("No está el número 20 en la lista");
    }
}