import java.util.*;

public class Experimento8 {
    public static void main(String[] args) {
        List<Character> l = new LinkedList<>();
        ListIterator<Character> it;
        for (int i = 0; i < 5; i++) { // Añadimos letras
            l.add(new Character((char) ('a' + i)));
        }
        System.out.println(l);
        it = l.listIterator(l.size());
        while (it.hasPrevious())
            System.out.println(it.previous().charValue());
        
        while (it.hasNext())
            System.out.println(it.next().charValue());
    }
}