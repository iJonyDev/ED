# Tema 1: JCF (Java Collection Framework)

## **1. Introduccion**

![JFC](image.png)

### Interfaces de JFC
- **Collection**: define métodos para tratar una colección genérica de elementos
- **Set**: colección de elementos que no admite elementos repetidos
- **SortedSet**: set cuyos elementos se mantienen ordenados según el criterio establecido
- **List**: admite elementos repetidos y mantiene un orden inicial
- **Map**: conjunto de pares clave/valor, sin repetición de claves
- **SortedMap**: map cuyos elementos se mantienen ordenados según el criterio establecido

### Interfaces de Soporte
- **Iterator**: sustituye a la interfaz **Enumeration**. Dispone de métodos para recorrer una colección y para borrar elementos
- **ListIterator**: deriva de **Iterator** y permite recorrer list en ambos sentidos
- **Comparable**: declara el método **compareTo()** que permite ordenar distintas colecciones según un orden natural (**String**,**Date**,**Integer**...)
- **Comparator**: declara el método **compare()** y se utiliza en lugar de **Comparable** cuando se desea ordenar objetos no estándar o sustituir a dicha interfaz.

### Clases de propósito general: Son las implementaciones de las interfaces de la JFC.
- **HashSet**: Interfaz **Set** implementada mediante una hash table.
- **TreeSet**: Interfaz **SortedSet** implementada mediante un árbol binario ordenado
- **ArrayList**: Interfaz **List** implementada mediante un array
- **LinkedList**: Interfaz **List** implementada mediante una lista enlazada
- **Vector**: Interfaz **List**
- **Hashtable**: Interface **Map**
- **HashMap**: Interfaz **Map** implementada mediante un hash table
- **TreeMap**: Interface **SortedMap** implementada mediante un árbol binario

## **2. Interfaz Collection**

La interfaz **Collection** es implementada por los **conjuntos**(sets) y **listas** (lists). Esta interfaz, declarada en el paquete **java.util**, declara una serie de métodos generales utilizables con **Set** y **List**

### Métodos para agregar y eliminar elementos
- boolean **add**(E element): Añade un elemento a la colección, devolviendo *true* si fue posible añadirlo y *false* en caso contrario.
- boolean **remove**(Object element): Elimina un único elemento(si lo encuentra), y devuelve *true* si la colección ha sido modificada.

### Métodos para realizar consultas
- int **size**(): Devuelve el número de elementos disponibles
- boolean **isEmpty**(): Devuelve *true* si la colección está vacía
- boolean **contains**(Object element): Devuelve *true* si el elemento pertenece a la colección

### Métodos para recorrer todos los elementos
- Iterator **iterator**(): Devuelve una referencia *iterator* que permite recorrer una colección con los métodos **next()** y **hasNext()**. Permite también borrar el elemento actual con **remove()**

### Métodos para realizar varias operaciones simultáneamente
- boolean **containsAll**(Collection collection). Igual que *contains()*, pero con conjuntos de elementos.
- boolean **addAll**(Collection collection). igual que *add()*, pero añade un conjunto de datos si es posible.
- void **clear**(): Elimina todos los elementos.
- void **removeAll**(**Collection<?>** collection): Igual que *remove()*, pero elimina el conjunto de elementos que se pasa como parámetro 
- void **retainAll**(**Collection<?>** collection): Elimina todos los elementos menos los especificados por la colección pasada como parámetro.

### Otros Métodos
- boolean **equals**(Object): Implementa la igualdad o equivalencia. Retorna *true* si el objeto que llama al método es equivalente al que se pasa como parámetro. Devuelve *false* si el argumento es nulo
- int **hashCode**(): A la hora de acceder, añadir, o eliminar un objeto contenido en un hashtable, la implementación de dicha estructura invocará este método int que pueda ser utilizado en la elaboración del índice en el hashtable. Durante la ejecución de un programa este método ha de retornar el mismo int siempre que sea invocado sobre el mismo objeto. Siempre y cuando sea factible ha de ser único para cada objeto. Por ello, aunque esta implementación no es requerida, el método devuelve la dirección física del objeto en memoria.
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

## **3. Iteradores**
Los objetos de tipo iterador permiten recorrer colecciones. Disponen de un conjunto de métodos que permiten avanzar sobre la
colección y obtener los objetos de ésta durante un recorrido para su tratamiento. 

Existen dos interfaces declaradas en el JCF:

- **java.util.Iterator**, que dispone de <u> métodos para recorrer una colección y para borrar elementos </u>
- **java.util.ListIterator**, que permite
<u> recorrer una lista en ambos sentidos </u>, siendo éste segundo descendiente del primero.

###  3.1 Interfaz Iterator

**Iterator** sustituye a ***Enumeration***, utilizada en versiones anteriores (JDK 1.1). 
- Similar a un “puntero”
que señala un elemento de una colección, que denominamos elemento actual, y es capaz de pasar al siguiente elemento para así recorrer dicha colección.

Iterator proporciona sólo tres métodos:
```java
public interface Iterator<E>
{
public boolean hasNext();
public E next();
public void remove(); //opcional
}
```
- ***hasNext()***: 
    * Devuelve ***true*** si hay un elemento siguiente en la colección. 
    * Usa un puntero interno que inicialmente apunta al primer elemento.

- ***next()***: 
    * Devuelve una referencia al siguiente elemento en la colección 
    * Es el método utilizado para acceder a los elementos de una colección. 
    * Lanza NoSuchElementException si se invoca un número de veces superior al número de elementos existentes en la colección.

- ***remove()***: 
    * Elimina de la colección el último elemento devuelto por el método next. 
    * Solo puede ser llamado una vez por cada llamada a next, y siempre después de éste.
    * Es la única forma segura de eliminar un elemento mientras se está recorriendo una colección.
    * Eleva **IllegalEstateException** si no se cumplen las condiciones expuestas para la llamada
    * Eleva **UnsupportedOperationException** si la implementación de este interfaz no incluyó este método (ya que es opcional).

La interfaz **Collection** dispone de un método denominado **iterator()**, que devuelve un Iterator situado antes del primer elemento de la colección, (es decir, si it es un iterador, **it.next() devolverá el primer elemento**).

- El método **iterator()** es utilizado **para inicializar los iteradores antes de comenzar el recorrido** de la colección. 

```java
// Recorrido básico (sin utilizar genéricos)
Iterator it = colección.iterator();
while (it.hasNext())
{
    Tipo obj = (<Casting>)it.next();
    TRATAR obj
}

// Recorrido básico (con genéricos)
for (Iterator<TIPO> it = colección.iterator(); it.hasNext();) {
    TIPO elemento = it.next();
    TRATAR elemento;
}
```

Donde **<span style="color:rgb(1, 200, 100)">TIPO</span>** es un tipo no primitivo, por ejemplo Integer.
- **Si no utilizamos los genéricos** tenemos que hacer un **casting** para poder utilizar los *métodos de los objetos
contenidos en la colección*, ya que en ese caso, estaremos trabajando con objetos de tipo Objects.


Supongamos implementadas la **clase Persona** y la **interfaz Empleado** para hacer un recorrido de Personas sin genéricos:

```java
public interface Empleado{
    public String getNombre();
    public String getApellidos();
    public int getEdad();
}
public class Persona implements Comparable, Empleado{
    private String nombre, apellidos;
    private int edad;
    public Persona(String n, String a, int e){ ... }
    < Aquí irían el resto de métodos >
}

//Recorrido de una colección de Personas sin genéricos.
public class TestIterator{
    public static void main(String args[]){
        List c = new ArrayList();
        // Inicializa la lista c
        c.add(new Persona("Pepe", "Lopez Perez", 25));
        c.add(new Persona("Lola", "Lopez Aguilar", 23));
        c.add(new Persona("Pepe", "Lopez Perez", 21));
        c.add(new Persona("Antonio", "Lopez Perez", 25));
        c.add(new Persona("Alicia", "Sanchez Olmo", 21));
        // Recorrido: Imprime la lista elemento a elemento
        Iterator it = c.iterator();
        while(it.hasNext())
            System.out.println((Persona)it.next());
        // Recorrido: Incrementa en 1 la edad de todas las personas
            System.out.println("Incrementar en 1 la edad de todas las personas------");
        it=c.iterator();
        while(it.hasNext())
        {

            Persona p = (Persona) it.next();
            p.setEdad(p.getEdad()+1);

        }
        // Recorrido: Vuelve a imprimir la lista elemento a elemento
        it = c.iterator();
        while(it.hasNext())
            System.out.println((Persona)it.next());

    }
}
```

La salida de este programa es:
```
Lopez Perez, Pepe (25)
Lopez Aguilar, Lola (23)
Lopez Perez, Pepe (21)
Lopez Perez, Antonio (25)
Sanchez Olmo, Alicia (21)
Incrementar en 1 la edad de todas las personas------
Lopez Perez, Pepe (26)
Lopez Aguilar, Lola (24)
Lopez Perez, Pepe (22)
Lopez Perez, Antonio (26)
Sanchez Olmo, Alicia (22)
Process Exit...
```
**Ejemplo**: Eliminar elementos de una colección de Empleados. Este ejemplo es realizado usando la interfaz Empleado en vez de la
clase Persona para rellenar la colección. En este caso, pretendemos borrar todos los empleados de la colección cuya edad sea
superior a 24 años.
```java
public class TestIterator2{
    public static void main(String args[]){
        List c = new ArrayList();
        // Inicializa la lista c
        Empleado e1 = new Persona("Pepe", "Lopez Perez", 25);
        Empleado e2 = new Persona("Lola", "Lopez Aguilar", 23);
        Empleado e3 = new Persona("Pepe", "Lopez Perez", 21);
        Empleado e4 = new Persona("Antonio", "lopez Perez", 25);
        Empleado e5 = new Persona("Alicia", "Sanchez Olmo", 21);
        c.add(e1); c.add(e2); c.add(e3); c.add(e4); c.add(e5);
        // Recorrido: Imprime la lista elemento a elemento
        Iterator it = c.iterator();
        while(it.hasNext())
            System.out.println((Empleado)it.next());
        // Recorrido: Elimina los mayores de 24 años
        System.out.println("Quitar los Empleados mayores de 24 años------");
        it=c.iterator();
        while(it.hasNext())
        {

            Empleado e = (Empleado) it.next();
            if(e.getEdad()>24)
                it.remove(); // Forma correcta de eliminar

        }
        // Recorrido: Vuelve a imprimir la lista elemento a elemento
        it = c.iterator();
        while(it.hasNext())
            System.out.println((Persona)it.next());

    }
}
```

La salida de este programa es:
```
Lopez Perez, Pepe (25)
Lopez Aguilar, Lola (23)
Lopez Perez, Pepe (21)
lopez Perez, Antonio (25)
Sanchez Olmo, Alicia (21)
Quitar los Empleados mayores de 24 años------
Lopez Aguilar, Lola (23)
Lopez Perez, Pepe (21)
Sanchez Olmo, Alicia (21)
Process Exit...
```

En el código anterior, es **importante** darse cuenta que **para eliminar** un elemento, se **usa** el método **remove del iterador y no de la lista**. No hay
que añadir o borrar elementos de una colección usando los métodos de la colección mientras estamos iterando sobre ella.

Por ejemplo, **el siguiente código no es correcto**, y, al ejecutarse, lanza una excepción ConcurrentModificationException.
```java
import java.util.ArrayList;
import java.util.Iterator;
public class Borrar {
    public static void main(String args[]) {
        ArrayList<String> books = new ArrayList<String>();
        String aBook = "PhP";
        books.add("C");
        books.add("Java");
        books.add("Cobol");
        books.add(aBook);
        for (Iterator<String> iterator = books.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
            //books.add("C++");
            books.remove(aBook);
        }
    }
}
```
**Con un iterador podemos hacer cosas que no se pueden hacer con un for extendido**, como por ejemplo borrar elementos mientras
estamos iterando sobre una colección, y, cómo veremos en la siguiente sección, a veces con un iterador podemos empezar el bucle
desde cualquier punto de una colección, y en cualquier dirección.

### 3.2. Interfaz ListIterator

- **Tipo especial de iterador** (deriva de la interfaz Iterator) **sólo** es **válido para recorrer listas (List)**, nunca Collection, Set o
SortedSet.

- **Añade métodos a Iterator** para iterar hacia atrás, para insertar o remplazar durante la iteración y para obtener la posición
del puntero interno.

- La interfaz **List** *incorpora dos métodos para asignar* o *inicializar* un **ListIterator**: 
    * El método **ListIterator()** de una lista *devuelve un ListIterator cuyo puntero es cero*. 
    * El método **ListIterator(int)** *posiciona el puntero en el índice int*.

Los métodos de la interfaz ***ListIterator*** son los siguientes:
```java
public interfaz ListIterator<E> extends Iterator<E>
{
    public void add(E e);
    public boolean hasNext();
    public boolean hasPrevious();
    public E next();
    public int nextIndex();
    public E previous();
    public int previousIndex();
    public void remove();
    public void set(E e);
}
```
- **hasNext()**: devuelve un ***true*** si hay un siguiente elemento.

- **hasPrevious()**: devuelve un ***true*** si el elemento actual tiene anterior.

- **next()**: 
    * Devuelve el elemento en cuyo índice se halla el puntero y avanza una posición el valor del mismo. 
    * **La primera vez** que se invoca sobre el objeto retornado por el método ListIterator() **devuelve el primer elemento** de la lista. 
    * Cuando se invoca sobre el objeto retornado por ***ListIterator(int)**
        + Devuelve el elemento de índice ***int**. 
        + Si ***int*** fuera el tamaño de la lista o si la iteración ha alcanzado el final de la lista, lanzaría la excepción NoSuchElementException.

- **previous()**: 
    * Devuelve el elemento situado inmediatamente antes de la posición actual del iterador y resta uno a su valor(retrocede en la lista). 
    * Cuando es invocado sobre el objeto devuelto por ListIterator() lanza NoSuchElementException. 
        + Si se llama sobre el objeto devuelto por ListIterator(int) devuelve el objeto situado en el índice int-1. 
    *También lanza NoSuchMethodException si la iteración ha alcanzado el principio de la lista.

- **nextIndex()**: devuelve el índice del elemento que sería retornado por la próxima llamada a next().

- **previousIndex()**: devuelve el índice del elemento que sería retornado por la próxima llamada a previous()

- **remove()**:
    * **Elimina** de la lista el último elemento retornado por next() o previous()
    * **Sólo puede ser llamado una vez por cada llamada a next() o previous()**, y sólo si no se invocó add() o remove() después. 
    * Los índices de los elementos posteriores son decrementados en uno. 
    * ***UnsupportedOperationException*** si la implementación de este interfaz no incorporó este método
    * ***IllegalStateException*** si next o previous no fueron llamados, o bien se invocó add o remove tras la última llamada a next o previous.

- **add(E e)**: 
    * **Inserta** el objeto en la lista en la posición actual del puntero y aumenta en uno su valor. 
    * **La siguiente llamada a next() quedaría sin afectar, pero previous() devolvería el elemento recién insertado**
    * Los valores de los **índices** de **elementos posteriores** son **incrementados en uno** 
    * No es necesario haber invocado a next o previous con anterioridad.
    * **UnsupportedOperationException**, si la implementación de este interfaz no incorporó este método
    * **ClassCastException**, si el tipo de este objeto impidió su adición a una lista
    * **IllegalStateException**, si este objeto infringe alguna restricción al ser añadido a una Collection.

- **set(E e)** :
    * **Remplaza** el último elemento producido por next o previous por el objeto especificado. 
    * **Puede ser invocado varias veces sin necesidad de llamar nuevamente a next o previous**, siempre y cuando no aparezcan add o remove entre dichas llamadas. 
    * **UnsupportedOperationException**, si la implementación de este interfaz no incorporó este método
    * **ClassCastException**, si el tipo de este objeto impidió su adición a una lista
    * **IllegalStateException**, si este objeto infringe alguna restricción que impida su adicción a la lista, o bien, next o previous no fueron llamados, o lo fueron pero después de la invocación a add o remove.