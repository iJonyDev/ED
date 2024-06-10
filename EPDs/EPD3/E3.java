package EPDs.EPD3;

/*
   a) El siguiente programa rellena una colección ordenada con palabras y posteriormente consulta el contenido de dicha colección. Analice el código y complete los huecos que faltan.
   b) ¿Por qué la palabra “lugar” aparece en el subconjunto “Palabras desde la palabra lugar” y no en el subconjunto “Palabras hasta
la palabra lugar”?
 */
import java.util.SortedSet;

public class E3 {
    public static void main(String[] args){
String[] palabras = {"en","un","lugar","de","la","mancha"};
SortedSet<String> ss= new ____________;
for(int i=0;i<palabras.length;i++)
ss.add(palabras[i]);
System.out.println("ss: " + ss);
System.out.println("Primera palabra: " + _________);
System.out.println("Última palabra: " + _________);
System.out.println("Palabras entre la letra g y la r: " + _________);
System.out.println("Palabras desde la palabra \"lugar\" : " + _________);
System.out.println("Palabras hasta la palabra \"lugar\" : " + _________);
}
}