package EPDs.EPD3.Experimentos;

import java.util.*;

public class MainE4 {
    public static void main(String[] args) {
        List<IPersona> PList = new ArrayList<>();

        PList.add(new Persona("12345678A", "Juan", 25));
        PList.add(new Persona("87654321B", "Ana", 30));
        PList.add(new Persona("56781234C", "Luis", 20));
        PList.add(new Persona("12345678A", "Carlos", 28)); // Mismo DNI que Juan
        PList.add(new Persona("87654321B", "Maria", 22));  // Mismo DNI que Ana

        // Ordenar la lista por el orden natural (DNI)
        Collections.sort(PList);

        // Imprimir la lista ordenada
        for (IPersona persona : PList) {
            System.out.println(persona);
        }
        
        System.out.println("--------------------");
        Set<IPersona> PSet = new HashSet<>();
        PSet.addAll(PList);
        
        // Imprimir conjunto sin seguir un orden
        for (IPersona persona : PSet) {
            System.out.println(persona);
        }

        System.out.println("--------------------");
        SortedSet<IPersona> PSSet = new TreeSet<>();
        PSSet.addAll(PList);

        // Imprimir conjunto ordenado
        for (IPersona persona : PSSet) {
            System.out.println(persona);
        }
    }
}
