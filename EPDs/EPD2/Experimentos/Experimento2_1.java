package EPDs.EPD2.Experimentos;

import java.util.*;

public class Experimento2_1 {
    public static void main(String[] args) {
        List<Integer> l, m;
        l = new ArrayList<>();
        
        for (int i = 0; i < 5; i++)
            l.add(i);
        System.out.println("l: " + l);
        // Método copy() usado correctamemte
        m = new ArrayList<Integer>(Collections.nCopies(l.size(), (Integer) null));
        Collections.copy(m, l); 
        System.out.println("m: " + m);
    }
}

