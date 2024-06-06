# Tema 1: JCF (Java Collection Framework)

## **1. Introduccion**

![JFC](image.png)

### Interfaces de la JFC
- **Collection**: define métodos para tratar una colección genérica de elementos
- **Set**: colección de elementos que no admite elementos repetidos
- **SortedSet**: set cuyos elementos se mantienen ordenados según el criterio establecido
- **List**: admite elmentos repetidos y mantiene un orden inicial
- **Map**: conjunto de pares clave/valor, sin repetición de claves
- **SortedMap**: map cuyos elementos se mantienen ordenados según el criterio establecido

### Interfaces de Soporte
- **Iterator**: sustituye a la interfaz **Enumeration**. Dispone de métodos para recorrer una colección y para borrar elementos
- **ListIterator**: deriva de **Iterator** y permite recorrer list en ambos sentidos
- **Comparable**: declara el método **compareTo()** que permite ordenar distintas colecciones según un orden natural (**String**,**Date**,**Integer**...)
- **Comparator**: declara el método **compare()** y se utiliza en lugar de **Comparable** cuando se desea ordenar objetos no estandar o sustituir a dicha interfaz.

### Clases de propósito general: Son las implementaciones de las interfaces de la JFC.
- HashSet: Interfaz Set implemetada mediante una hash table.
- TreeSet: Interfaz SortedSet implementada mediante un árbol binario ordenado
- ArrayList: Interfaz List implementada mediante un array
- LinkedList: Interfaz List implementada mediante una lista enlazada
- Vector: Interfaz List
- Hashtable: Interface Map
- HashMap: Interfaz Map implementada mediante un hash table
- TreeMap: Interface SortedMap implementada mediante un árbol binario

## **2. Interfaz Collection**

La inferfaz **Collection** es implementada por los **conjuntos**(sets) y **listas** (lists). Esta interfaz, declarada en el paquete **java.util**, declara una serie de métodos generales utilizables con **Set** y **List**

### Métodos para agregar y eleminar elementos
- boolean **add**(E element): Añade un elemento a la coleccion, devolviendo *true* si fue posible añadirlo y *false* en caso contrario.
- boolean **remove**(Object element): Elimina un único elemento(si lo encuentra), y devuelve *true* si la colleccion ha sido modificada.

### Métodos para realizar consultas
- int **size**(): Devuelve el nuemro de elemntos disponibles
- boolean **isEmpty**(): Devuelve *true* si la coleccion está vacía
- boolean **contains**(Object element): Devuelve *true* si el elemento pertenece a la colección

### Métodos para recorrer todos los elementos
- Iterator **iterator**(): Devuelve una referencia *iterator* que permite recorrer una colección con los métodos **next()** y **hasNext()**. Permite tambien borrar el elemento actual con **remove()**

### Métodos para realizar varias operaciones simultaneamente
- boolean **containsAll**(Collection collection). Igual que *contains()*, pero con conjuntos de elementos.
- boolean **addAll**(Collection collection). igual que *add()*, pero añade un conjunto de datos si es posible.
- void **clear**(): Elimina todos los elementos.
- void **removeAll**(**Collection<?>** collection): Igual que *revove()*, pero elemina el conjunto de elementos que se pasa como parámetro 
- void **retainAll**(**Collection<?>** collection): Elimina todos los elementos menos los especificados por la coleccion pasada como parámetro.

### Otros Métodos
- boolean **equals**(Object): Implementa la igualdad o equivalencia. Retorna *true* si el objeto que llama al método es equivalente al que se pasa comoparámetro. Devuelve *false* si el arguemento es nulo
- int **hashCode**(): A la hora de acceder, añadir, o eliminar un objeto contenido en un hashtable, la implementacion de dicha estructura invocará este método int que pueda ser utilizado en la eleboración del índice en el hashtable. Durante la ejecución de un programa este método ha de retornar el mismo int simepre que sea invocado sobre el miemo objeto. Simepre y cuando sea factible ha de ser único para cada objeto. Por ello, aunque esta implementación no es requerida, el método devuelve la direcion física del objeto en memoria.
- Object[] **toArray**(): Permite convertir una colección en un array

### Ejemplo 1:
```java
import java.util.*; // Para usar los elementos del JCF
public class Ppal {
    public static void main(String[] args) {
        int i;
        // Colección c1
        Collection<Integer> c1 = new ArrayList<>();
        c1.add(10); // Es equivalente a c1.add(new Integer(10));
        c1.add(20);
        c1.add(30);
        c1.add(40);
        c1.add(50);
        c1.add(60);
        // Colección c2 – como una lista
        List<Integer> c2 = new ArrayList<>();
        for (i = 1; i <= 6; i++) {
            c2.add((i * 10));
        }
        // Recorrido de colecciones como tablas – NO ES LO RECOMENDADO
        System.out.println("La colección 1 tiene " + c1.size() + " elementos");
        Object[] t = c1.toArray();
        for (i = 0; i < t.length; i++) {
            System.out.println("Elem " + i + ": " + (Integer) t[i]);
        }
        System.out.println("La colección 2 tiene " + c2.size() + " elementos");
        Object[] t2 = c2.toArray();
        for (i = 0; i < t2.length; i++) {
            System.out.println("Elem " + i + ": " + (Integer) t2[i]);
        }
        c2.remove(new Integer(20));
        // Comparación de colecciones
        if (c1.equals(c2)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son distintas");
        }
        if (c1.containsAll(c2)) {
            System.out.println("c2 contenida en c1");
        } else {
            System.out.println("c2 no contenida en c1");
        }
    }
}
```
