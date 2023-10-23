package EPDs.EPD2.Experimentos;
/*
 a) El siguiente programa busca la posición del número 20 en la lista creada en el mismo programa. Analice el código y ejecútelo
para obtener su resultado.
b) ¿Hay algún problema? ¿Por qué? Modifique el código para evitarlo.
c) Añada el código necesario para que el programa anterior imprima el mínimo y máximo número de la lista.
 */
import java.util.*;

public class E3 {
    public static void main(String args[]) {
        List<Integer> l = new ArrayList<>();
        for (int i = 5; i >= 0; i--)
            l.add(i * 10);
        System.out.println("Lista: " + l);
        
        // Error: El método binarySearch() funciona si la lista NO está ordenada
        int posicion = Collections.binarySearch(l, 20);
        if (posicion >= 0)
            System.out.println("El 20 está en la posición " + posicion + " de la lista");
        else
            System.out.println("No está el número 20 en la lista");
    }
}
