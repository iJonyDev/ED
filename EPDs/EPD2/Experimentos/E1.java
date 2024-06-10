package EPDs.EPD2.Experimentos;
/*
 a) Analice el siguiente código y prediga antes de ejecutarlo la salida por pantalla de cada una de sus secciones.
 b) Ejecute el código y corrobore su respuesta al apartado anterior.
 */
import java.util.ArrayList;
import java.util.List;

public class E1 {
    public static void main(String[] args) {
        List<Double> l = new ArrayList<>(); 
        for (int i = 1; i <= 5; i++) 
            l.add(i * Math.PI);

        System.out.println(l);      
        for (int i = 0; i < 5; i++) 
            l.add(i * 2, i * Math.E);
        System.out.println(l);      
        for (int i = 0; i < 5; i++) 
            System.out.println(l.get(i * 2)); 
        for (int i = 0; i < 5; i++) 
            l.remove(i + 1);
        System.out.println(l);      
    }
}
