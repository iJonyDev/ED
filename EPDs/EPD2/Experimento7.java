import java.util.*;

public class Experimento7 {
    public static void main(String[] args) {
        List l = new ArrayList();
        Iterator it;
        for (int i = 0; i < 10; i++)
            l.add(new Integer((int) (Math.random() * 100)));
        System.out.println("Antes de ordenar:");
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Integer) it.next());
            if (it.hasNext())
                System.out.print(", ");
        }
        System.out.println("\nDespués de ordenar:");
        Collections.sort(l, new ComparadorNumero());
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Integer) it.next());
            if (it.hasNext())
                System.out.print(", ");
        }
    }
}
