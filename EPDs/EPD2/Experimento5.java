package EPDs.EPD2;

import java.util.*;

public class Experimento5{
    public static void main(String[] args) {
        Collection<Persona> c = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            c.add(new Persona(i * 10));
        System.out.println("Edades: " + c);
        System.out.println("Maxima edad: " + Collections.max(c));
        System.out.println("Minima edad: " + Collections.min(c));
    }
}