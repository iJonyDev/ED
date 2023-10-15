package EBs.Ejemplo;

import java.util.HashSet;
import java.util.Set;

public class Ejemplo1 {
    public static void main(String[] args) {
        Set<Integer> conjunto = new HashSet<>();
        conjunto.add(10);
        conjunto.add(20);
        conjunto.add(5);
        conjunto.add(13);
        System.out.println(conjunto.add(50));
        System.out.println(conjunto.add(20));
        conjunto.add(20);
        System.out.println(conjunto + " size: " + conjunto.size());
        conjunto.remove(13);
        System.out.println(conjunto + " size: " + conjunto.size());
    }
}
