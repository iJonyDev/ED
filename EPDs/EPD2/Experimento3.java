package EPDs.EPD2;
/*
 a) El siguiente programa busca la posición del número 20 en la lista creada en el mismo programa. Analice el código y ejecútelo
para obtener su resultado.
b) ¿Hay algún problema? ¿Por qué? Modifique el código para evitarlo.
c) Añada el código necesario para que el programa anterior imprima el mínimo y máximo número de la lista.
 */
import java.util.*;

public class Experimento3 {
    public static void main(String args[]) {
        List<Integer> l = new ArrayList<>();
        for (int i = 5; i >= 0; i--)
            l.add(i * 10);
        System.out.println("Lista: " + l);
        Collections.sort(l);// b) Ordenamos la lista para que binarySearch() pueda funcionar
        System.out.println("Lista ordenada: " + l);
        int posicion = Collections.binarySearch(l, 20);
        if (posicion >= 0)
            System.out.println("El 20 está en la posición " + posicion + " de la lista");
        else
            System.out.println("No está el número 20 en la lista");
        // c) Mostramos el minimo y el maximo de la lista
        // System.out.println("Valor minimo de la lista: " + l.get(0));
        // System.out.println("Valor maximo de la lista: " + l.get(l.size()-1));
        System.out.println("Valor minimo de la lista: " + Collections.min(l));
        System.out.println("Valor maximo de la lista: " + Collections.max(l));
    }
}