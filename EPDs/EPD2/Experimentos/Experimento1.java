package EPDs.EPD2.Experimentos;
/*
 a) Analice el siguiente código y prediga antes de ejecutarlo la salida por pantalla de cada una de sus secciones.
 b) Ejecute el código y corrobore su respuesta al apartado anterior.
 */
import java.util.ArrayList;
import java.util.List;

public class Experimento1 {
    public static void main(String[] args) {
        List<Double> l = new ArrayList<>(); // Implementamos una Lista de elementos tipo "Double"
        for (int i = 1; i <= 5; i++) // Añadimos elementos a la Lista "l"
            l.add(i * Math.PI);

        System.out.println(l);      // Mostramos la lista
        for (int i = 0; i < 5; i++) // Añadimos más elementos a la Lista "l"
            l.add(i * 2, i * Math.E);
        System.out.println(l);      // Mostramos la lista actualizada
        for (int i = 0; i < 5; i++) // Mostramos el contenido de los indices pares de la lista
            System.out.println(l.get(i * 2)); 
        for (int i = 0; i < 5; i++) // Eliminamos los elementos de los indices impares
            l.remove(i + 1);
        System.out.println(l);      // Mostramos la lista actualizada
    }
}
