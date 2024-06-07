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

## **4. Interfaces Comparable y Comparator**

Estas infercaces están orientadas a mantener ordenadas las colecciones (**listas**,**sets** y **maps**) que deben mantener un orden. Para ello dispone delas interfaces **java.lang.Comparable** y **java.util.Comparator** (obsérvese que pertenecen a packages diferentes).

### 4.1. Interfaz Comparable
Se dice que las clases que implementan esta interfaz cuentan con un “orden natural”. Este orden es total es decir, que siempre han de poder ordenarse dos objetos cualesquiera de la clase que implementa esta interfaz. La interfaz Comparable declara el método compareTo() de la siguiente forma:

```java
    public int compareTo(T obj)
```
que compara su argumento implícito con el que se le pasa por parámetro. Este método devuelve un entero 
<u> negativo , cero o positivo </u>
según el argumento implícito (this) sea <u> anterior , igual o posterior </u> al objeto obj., respectivamente.

**Si se redefine**, el método **compareTo()** <u> debe ser programado con cuidado </u>: es muy necesario que sea <u> coherente con el método </u> **equals()** y <u> que cumpla la propiedad transitiva </u> .(Si X<Y y Y<Z => X<Z) 

Las **listas y las tablas** <u>cuyos elementos implementan **Comparable** </u> pueden ser **ordenadas con** los métodos **Collections.sort()** y **Arrays.sort()** <u>sin necesidad de un
Comparator</u>

- Si ObjArray es una matriz, puede ser ordenada mediante Arrays.sort(ObjArray).
- Si ObjList es una Lista, puede ser ordenada mediante Collections.sort(ObjList), o se puede buscar un objeto obj mediante Collections.binarySearch(ObjList, obj).
- Se puede usar como un elemento dentro de un TreeSet.


**Ejemplo (Ordenación de una Lista usando Comparable)**. 

La interfaz Empleado es implementada por la clase Persona, que a su vez implementa la interfaz Comparable (redefiniendo compareTo). Así, **compareTo()** <u> define la ordenación natural </u> de las personas, siendo ésta <u> por apellidos, nombre y edad </u>.

```java
// Empleado.java
public interface Empleado {
    public String getNombre();
    public String getApellidos();
    public int getEdad();
    // No se añade compareTo, ya que está declarado en la interfaz Comparable
}

// Persona.java
public class Persona implements Empleado, Comparable {
    private String nombre, apellidos;
    private int edad;

    public Persona(String n, String a, int e) { 
        nombre = n; 
        apellidos = a; 
        edad = e;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public boolean equals(Object o) {
        if(!(o instanceof Persona)) {
            return false;
        } else {
            Persona p = (Persona)o;
            return p.nombre.equals(nombre) && p.apellidos.equals(apellidos) && p.edad == edad; //son enteros int
        }
    }

    public String toString() {
        return apellidos + ", " + nombre + " (" + edad +")" ;
    }

    public int compareTo(Object o) {
        Persona p = (Persona)o; //Eleva ClassCastException si o no es una Persona
        int cmp = apellidos.compareTo(p.apellidos); //Primero por apellidos
        if (cmp == 0) {
            cmp = nombre.compareTo(p.nombre); //Segundo por nombre
            if (cmp == 0) {
                cmp = edad - p.edad; // Finalmente por edad
            }
        }
        return cmp;
    }
}

//TestEmpleado.java
import java.util.*;

public class TestEmpleado {
    public static void main(String args[]) {
        List c = new ArrayList();
        Empleado e1 = new Persona("Pepe", "Lopez Perez", 25);
        Empleado e2 = new Persona("Lola", "Lopez Aguilar", 23);
        Empleado e3 = new Persona("Pepe", "Lopez Perez", 21);
        Empleado e4 = new Persona("Antonio", "lopez Perez", 25);
        Empleado e5 = new Persona("Alicia", "Sanchez Olmo", 21);
        c.add(e1); 
        c.add(e2); 
        c.add(e3); 
        c.add(e4); 
        c.add(e5);
        //Compara dos Empleados
        if(((Persona)e1).compareTo((e2)) > 0) { // MUY IMPORTANTE EL CASTING
            System.out.println(e1 + " es mayor que " + e2);
        } else {
            System.out.println(e1 + " es menor o igual que " + e2);
        }
        //Imprime la lista original
        System.out.println("Lista Original:");
        System.out.println(c);
        //Ordena e imprime la lista ordenada según la ordenación natural de Persona
        System.out.println("Ordenación:");
        Collections.sort(c); //Ordena
        System.out.println(c);
    }
}
```

La salida de este programa es:
```
Lopez Perez, Pepe (25) es mayor que Lopez Aguilar, Lola (23)
Lista Original:
[Lopez Perez, Pepe (25), Lopez Aguilar, Lola (23), Lopez Perez, Pepe (21), lopez Perez,
Antonio (25), Sanchez Olmo, Alicia (21)]
Ordenación:
[Lopez Aguilar, Lola (23), Lopez Perez, Pepe (21), Lopez Perez, Pepe (25), Sanchez Olmo,
Alicia (21), lopez Perez, Antonio (25)]
```

*Nótese que tras la ordenación, la persona “lopez Perez, Antonio (25)” es la última al comenzar su apellido por minúscula.*

**Si querremos utilizar genéricos**, entonces hay que modificar el código anterior de la siguiente forma:

```java
public interface IEmpleado extends Comparable<IEmpleado> {
    String getApellidos();
    int getEdad();
    String getNombre();
}

public class Persona implements IEmpleado {
    private String nombre, apellidos;
    private int edad;

    public Persona(String n, String a, int e) {
        nombre = n;
        apellidos = a;
        edad = e;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Persona)) {
            return false;
        } else {
            Persona p = (Persona) o;
            return p.nombre.equals(nombre)
                && p.apellidos.equals(apellidos)
                && p.edad == edad; //son enteros int
        }
    }

    public String toString() {
        return apellidos + ", " + nombre + " (" + edad + ")";
    }

    public int compareTo(IEmpleado p) {
        int cmp = apellidos.compareTo(p.getApellidos()); //Primero por apellidos
        if (cmp == 0) {
            cmp = nombre.compareTo(p.getNombre()); //Segundo por nombre
            if (cmp == 0) {
                cmp = edad - p.getEdad(); // Finalmente por edad
            }
        }
        return cmp;
    }
}

import java.util.*;

public class TestEmpleado {
    public static void main(String args[]) {
        List<IEmpleado> c = new ArrayList<>();
        IEmpleado e1 = new Persona("Pepe", "Lopez Perez", 25);
        IEmpleado e2 = new Persona("Lola", "Lopez Aguilar", 23);
        IEmpleado e3 = new Persona("Pepe", "Lopez Perez", 21);
        IEmpleado e4 = new Persona("Antonio", "lopez Perez", 25);
        IEmpleado e5 = new Persona("Alicia", "Sanchez Olmo", 21);
        c.add(e1);
        c.add(e2);
        c.add(e3);
        c.add(e4);
        c.add(e5);
        //Compara dos Empleados
        if (e1.compareTo((e2)) > 0) { //AHORA NO HACE FALTA EL CASTING
            System.out.println(e1 + " es mayor que " + e2);
        } else {
            System.out.println(e1 + " es menor o igual que " + e2);
        }
        //Imprime la lista original
        System.out.println("Lista Original:");
        System.out.println(c);
        //Ordena e imprime la lista ordenada según la ordenación natural de Persona
        System.out.println("Ordenación:");
        Collections.sort(c); //Ordena
        System.out.println(c);
    }
}
```

### 4.2. Interfaz Comparator
**Si** una clase ya tiene un criterio de ordenación natural (interfaz Comparable) y **se desea tener un criterio de ordenación diferente**, por
ejemplo descendente o dependiente de otros campos, es necesario crear una clase que implemente dicho criterio. Esta clase, que se
denomina comparador, es independiente de la clase objeto de la ordenación y deberá <u>implementar la interfaz</u> **Comparator** del
paquete **java.util**. <u>Un comparador es por tanto una clase que define un criterio de ordenación de otras clases</u>.

La interfaz **Comparator** <u>declara el método</u> **compare()** en la forma:
```java
public int compare(T o1, T o2);
```

Así, la <u>clase comparadora deberá implementar</u> la interfaz **Comparator**, y por tanto el método **compare()**, de la siguiente forma **(si no
utilizamos genéricos)**:

```java
public class MiComparador implements Comparator<TIPO>{
    public int compare(TIPO o1, TIPO o2){
        <implementación del criterio de comparación>
    }
}
```

El método **compare()** <u>devuelve un entero negativo, cero o positivo según</u> *su primer argumento* <u>sea anterior, igual o posterior</u> *al
segundo* (**así asegura un orden ascendente**). 

La implementación debe asegurar que:
- **Signo** (compare(x,y) debe ser igual a - signo(compare(y,x)) para todas las x, y. 
    * Implica que compare(x, y) lanzará una excepción solo si compare(y, x) la lanza.
- La **relación es transitiva**: compare(x,y) > 0 && compare(y,z) > 0 
    * Implican compare(x z) > 0.
- **compare(x,y)==0** 
    * Implica signo(compare(x,z)==sgn(compare(y,z)) para todo z. 
    * Este método <u>*lanzará*</u> la excepción **ClassCastException** <u>si el tipo de los argumentos impide la comparación</u> por este Comparator.

Es muy **importante** que **compare()** <u>sea compatible con el método **equals()**</u> de los objetos que hay que mantener ordenados. Su implementación debe cumplir unas condiciones similares a las de compareTo().

Casos de uso:

- *Como argumento a un constructor* **TreeSet o TreeMap** (con la idea de que las mantengan ordenadas de acuerdo con dicho
comparador).
- En los métodos de **ordenación** 
    * Collections.sort(List, Comparator)
    * Arrays.sort(Object[], Comparator)
- En los métodos de **búsqueda** 
    * Collections.binarySearch(List, Object, Comparator)
    * Arrays.binarySearch(List, Object, Comparator)

**Ejemplo (Ordenación de una lista usando Comparator)**.
Se añaden dos comparadores para hacer diferentes ordenaciones, en concreto:

- **ComparadorIgnoraMayMin**, cuyo método compare() compara dos Personas con el mismo criterio que compareTo() del ejemplo anterior, sólo que en este caso no se distinguen mayúsculas y minúsculas
- **ComparadorEdad**, que usa la edad como criterio de comparación entre personas (si son de la misma edad, compara por apellidos y nombre).

```java
//ComparadorIgnoraMayMin
import java.util.*;
class ComparadorIgnoraMayMin implements Comparator {
    public int compare(Object o1, Object o2) {
        Persona p1 = (Persona)o1; //Eleva ClassCastException si o1 no es Persona
        Persona p2 = (Persona)o2; //Eleva ClassCastException si o2 no es Persona
        //Es igual que compareTo de Persona pero usando compareToIgnoreCase()
        int cmp = p1.getApellidos().compareToIgnoreCase(p2.getApellidos());
        if (cmp == 0){
            cmp = p1.getNombre().compareToIgnoreCase(p2.getNombre());
            if (cmp == 0){
                cmp = p1.getEdad() - p2.getEdad();
            }
        }
        return cmp;

    }
}
```
**O con genéricos**:

```java
import java.util.*;
class ComparadorIgnoraMayMin implements Comparator<IEmpleado> {
    public int compare(IEmpleado p1, IEmpleado p2) {
        //Es igual que compareTo de Persona pero usando compareToIgnoreCase()
        int cmp = p1.getApellidos().compareToIgnoreCase(p2.getApellidos());
        if (cmp == 0){
            cmp = p1.getNombre().compareToIgnoreCase(p2.getNombre());
            if (cmp == 0){
                cmp = p1.getEdad() - p2.getEdad();
            }
        }
        return cmp;

    }
}

// ComparadorEdad.java
import java.util.*;
class ComparadorEdad implements Comparator {
    public int compare(Object o1, Object o2) {
        Persona p1 = (Persona)o1; //Eleva ClassCastException si o1 no es Persona
        Persona p2 = (Persona)o2; //Eleva ClassCastException si o2 no es Persona
        int cmp = p1.getEdad() - p2.getEdad(); //Primero por edad
        if (cmp == 0)
        {
            cmp = p1.getApellidos().compareTo(p2.getApellidos());//Luego por apellidos
            if (cmp == 0)
            {
                cmp = p1.getNombre().compareTo(p2.getNombre()); //finalmente por nombre
            }
        }
        return cmp;

    }
}
// TestEmpleadoComparators.java

import java.util.*;
public class TestEmpleadoComparators{
    public static void main(String args[]){
    List c = new ArrayList();
    Empleado e1 = new Persona("Pepe", "Lopez Perez", 25);
    Empleado e2 = new Persona("Lola", "lopez Aguilar", 23);
    Empleado e3 = new Persona("Pepe", "Lopez Perez", 21);
    Empleado e4 = new Persona("Antonio", "Lopez Perez", 25);
    Empleado e5 = new Persona("Alicia", "Sanchez Olmo", 21);
    c.add(e1); c.add(e2); c.add(e3); c.add(e4); c.add(e5);
    //Imprime Lista Original
    System.out.println("Lista Original:");
    System.out.println(c);

    //Ordenación natural (Comparable de Persona)

    System.out.println("Ordenación Natural (Comparable):");
    Collections.sort(c);
    System.out.println(c);
    //Ordenación sin diferenciar entre Mayúsculas y Minúsculas (Comparator)
    System.out.println("Ordenación Natural sin MayMin (Comparator):");
    Collections.sort(c, new ComparadorIgnoraMayMin());
    System.out.println(c);
    //Ordenación por Edad (Comparator)
    System.out.println("Ordenación por edad(Comparator):");
    Collections.sort(c, new ComparadorEdad());
    System.out.println(c);
    }
}
```

La salida de este programa es:
```
Lista Original:
[Lopez Perez, Pepe (25), lopez Aguilar, Lola (23), Lopez Perez, Pepe (21), Lopez Perez,
Antonio (25), Sanchez Olmo, Alicia (21)]
Ordenación Natural (Comparable):
[Lopez Perez, Antonio (25), Lopez Perez, Pepe (21), Lopez Perez, Pepe (25), Sanchez Olmo,
Alicia (21), lopez Aguilar, Lola (23)]
Ordenación Natural sin MayMin (Comparator):
[lopez Aguilar, Lola (23), Lopez Perez, Antonio (25), Lopez Perez, Pepe (21), Lopez Perez,
Pepe (25), Sanchez Olmo, Alicia (21)]
Ordenación por edad(Comparator):
[Lopez Perez, Pepe (21), Sanchez Olmo, Alicia (21), lopez Aguilar, Lola (23), Lopez Perez,
Antonio (25), Lopez Perez, Pepe (25)]
Process Exit...
```

### 4.3. ¿Cuándo usar Comparable y Comparator?

- Usaremos **Comparable** <u>para definir el orden natural</u> de una clase C, entendiendo por orden natural aquel que se utilizará
normalmente o simplemente por convenio. Así, diremos que los objetos de clase C son comparables.

- Por otro lado, <u>implementaremos nuevas clases (C1 ... Cn) que extiendan el interfaz</u> **Comparator** por cada <u>ordenación</u> nueva que necesitemos <u>distinta a la natural</u> para la clase C. Así tendremos una “librería de comparadores” (C1 ... Cn) para la clase C.

## **5. Utilidades para objetos contenedores**: Clase java.util.Collections

La <u>clase Collections (no confundir con la interfaz Collection, en singular)</u> es una clase que <u>define un buen número de métodos static</u>
con diversas finalidades. 

Dado que son estáticos, la llamada a dichos métodos es: **Collections.metodo(argumentos)** 
- Todos los métodos aquí expuestos retornan o toman <u>como argumentos una</u> **List**, **excepto max y min** que toman <u>como argumento una Collection)</u>

### 5.1. Ordenación
```java
public static void sort(List);
public static void sort(List, Comparator);
```

### 5.2. Inversión del Orden

```java
public static void reverse(List);
public static Comparator reverseOrder();
```

El métodos **reverse(List)** <u>ordena la lista en el sentido inverso de la posición actual de sus elementos</u> (independiente del valor de los
elementos).**No realiza una ordenación descendente**.

El método **reverseOrder()** <u>devuelve un Comparator</u> que **introduce una ordenación inversa** a la <u>impuesta por el orden natural</u> de un
contenedor de objetos que implementan el interfaz Comparable. 

- El **Comparator** devuelto <u>implementa el método</u> **compare()** de forma
que **devuelve el resultado de compareTo() cambiado de signo**. 

Puede utilizarse donde se espere un Comparator, por ejemplo:
```C++
Arrays.sort(list, Collections.reverseOrder());
````

### 5.3 Búsqueda
```java
public static int binarySearch(List list, T key);
public static int binarySearch(List list, T key, Comparator comparator);
```

- **Buscan** el objeto en la lista **y devuelven la posición** (int) de tal objeto (resultado 0 o positivo).
- **Si no está** en la lista 
    * **Devuelve** (-(**pos_mayor**)-1), donde **pos_mayor** es la <u>posición del primer elemento en la lista mayor que el buscado</u>
    * **O el tamaño de la lista** <u>si el elemento buscado es el mayor de todos</u>.

La **lista debe estar ordenada de forma ascendente**. Esto puede lograrse con un <u>orden natural</u> para el primer método, como por ejemplo **sort(List)**; **o** bien **usando** un **Comparator** para el segundo método: **sort(List,Comparator)**. Los resultados no son especificados si la lista esta desordenada. No se asegura cuál será el elemento devuelto si existen duplicados. 

Lanzan la excepción **ClassCastException** <u>si algún elemento en la lista tiene un tipo que impide su comparación</u>.

### 5.4. Copiar Lista
```java
public static void copy(List, List);
```
- **Copia** los <u>elementos del segundo argumento en el primero</u>. 
    * Si el tamaño del destino es mayor que el de la fuente, los restantes elementos no se ven afectados. 
- **IndexOutOfBoundsException** <u>si el tamaño del destino es menor que el de la fuente</u>
- **UnsupportedOperationException** <u>si el iterator de la lista no soporta la operación set</u>.

### 5.5. Rellenar una Lista
```java
public static void fill(List list, T object);
```
- **Remplaza** <u>todos los elementos de la lista por el objeto especificado</u>. 
- No modifica el tamaño de la lista. 
- Se ejecuta en un tiempo lineal.
- **UnsupportedOperationException** <u>si el iterator de la lista no soporta la operación set</u>.

### 5.6. Máximos y Mínimos
```java
public static Object max(Collection);
public static Object max(Collection, Comparator);
public static Object min(Collection);
public static Object min(Collection, Comparator);
```
- **Devuelven** el objeto que en la colección especificada sea el **menor, o el mayor de todos**, de <u>acuerdo al orden natural</u> (establecido por Comparable) de tales objetos, o según el Comparator especificado.

### 5.7. Constantes
```java
public static final java.util.List EMPTY_LIST;
public static final java.util.Set EMPTY_SET;
public static final java.util.Map EMPTY_MAP;
```
Existen tres constantes (campos estáticos finales) de tipo List y Set que son inicializados para contener un objeto vacío del tipo correspondiente. Sus nombres son **EMPTY_LIST**, **EMPTY_SET** y **EMPTY_MAP**. Sirven para representar contenedores vacíos.

**Ejemplo**:
```java
import java.util.*;
public class TestCollections {
public static void main(String args[]) {
    List<IEmpleado> c = new ArrayList<>();
    int pos;
    IEmpleado e1 = new Persona("Pepe", "Lopez Perez", 25);
    IEmpleado e2 = new Persona("Lola", "lopez Aguilar", 23);
    IEmpleado e3 = new Persona("Pepe", "Lopez Perez", 21);
    IEmpleado e4 = new Persona("Antonio", "Lopez Perez", 25);
    IEmpleado e5 = new Persona("Alicia", "Sanchez Olmo", 21);
    c.add(e1);
    c.add(e2);
    c.add(e3);
    c.add(e4);
    c.add(e5);
    //Imprime Lista Original
    System.out.println("Lista Original:");
    System.out.println(c);
    //Ordenación natural (Comparable de Persona) y Búsqueda
    System.out.println("Ordenación Natural (Comparable) y Búsqueda:");
    Collections.sort(c); //Ordenación natural usando Comparable
    System.out.println(c);
    pos = Collections.binarySearch(c, e4);
    System.out.println("Búsqueda: La posición de <" + e4 + "> es " + pos);
    //Ordenación por Edad (Comparator) y Búsqueda
    System.out.println("Ordenación por edad y búsqueda:");
    Collections.sort(c, new ComparadorEdad());//Ordenación usando
    ComparadorEdad
    System.out.println(c);
    pos = Collections.binarySearch(c, e4, new ComparadorEdad());
    System.out.println("Búsqueda: La posición de <" + e4 + "> es " + pos);
    //Máximo y mínimo
    IEmpleado eMax = Collections.max(c, new ComparadorEdad());
    IEmpleado eMin =Collections.min(c, new ComparadorEdad());
    System.out.println("Empleado más viejo: " + eMax);
    System.out.println("Empleado más joven: " + eMin);
    }
}
```

## **6. Clase Arrays (ampliación)**
Esta clase es **muy parecida a la case *Collections*** vista anteriormente, por lo que sus métodos los veremos con menor nivel de detalle. La invocación a tales métodos también es similar: **Arrays.metodo(argumentos)**

### 6.1. Tratar Matriz como Lista
```java
public static <T> List<T> asList(T[]);
```
**Retorna una vista** (no una copia) <u>de la matriz pasada como argumento implícito</u>, que puede ser manipulada como si fuera una lista.
- Como dicha lista es respaldada por una matriz **no pueden agregarse o eliminarse elementos** a ella. 
- <u>Cualquier modificación estructural</u> (del número de elementos) provoca **UnsupportedOperationException** <u>debido a la no implementación de los métodos opcionales del interfaz List en la lista retornada</u>.
-  El **resto de cambios** en la lista **son reflejados en la matriz y viceversa**.

### 6.2. Métodos similares a los de Collections
```java
public static void sort(tipoPrimitivo[]);
public static void sort(tipoPrimitivo[], Comparator);
public static void sort(Object[]);
public static void sort(Object[], Comparator);
public static int binarySearch(tipoPrimitivo[], unPrimitivo);
public static int binarySearch(Object[], Object);
public static int binarySearch(Object[], Object, Comparator);
public static void fill(tipoPrimitivo[], unPrimitivo);
public static void void fill(tipoprimitivo[], int fromIndex,
int toIndex, unPrimitivo);
public static void void fill(Object[], Object);
public static void void fill( Object[], int fromIndex, int toIndex, Object);
```

## **7. Clase java.lang.Math**

La case **Math** del <u>paquete estándar</u> **java.lang** <u>contiene métodos estáticos para realizar operaciones matemáticas básicas</u> como
exponencial, logaritmos, raiz cuadrada, funciones trigonométricas, etc. La invocación a tales métodos o constantes es similar a los de
*Collections y Arrays*: **Math.metodo(\<argumentos>)**

Los miembros más interesantes de esta clase son:
```java 
public final class java.lang.Math {
    // Constantes
    public static final double E;
    public static final double PI;
    // Funciones trigonométricas
    double sin(double);
    double cos(double);
    double tan(double);
    double asin(double);
    double acos(double);
    double atan(double);
    double toRadians(double);
    double toDegrees(double);
    // Funciones básicas
    double exp(double);
    double log(double);
    double log10(double);
    double sqrt(double);
    double ceil(double);
    double floor(double);
    double pow(double, double);
    <int/long/float/double> abs(<int/long/float/double>);
    <int/long/float/double> max(<int/long/float/double>, <int/long/float/double>);
    <int/long/float/double> max(<int/long/float/double>, <int/long/float/double>);
    < . . . >
}
```

## **8. Genéricos**
Desde el JSE 1.5 , todas las interfaces del JCF utilizan genéricos, resultando de esta forma parametrizadas con respecto a la clase a
la cual pertenecen los objetos gestionados por la colección.
Por ejemplo, la declaración de la interfaz Collection es la siguiente:
```java
public interface Collection<E> .....
```

La **\<E>** dice que la interfaz es **genérica** (y E indica una clase genérica, que será definida en fase de declaración de la colección).

- <u>Cuando se declara una instancia de Collection se puede</u> (y es aconsejable hacerlo) <u>declarar el tipo de los objetos contenido en
la colección</u> (por ejemplo, colecciones de cadenas, o números de teléfono, etc.).
```java
Collection<String> agendaTel;
```

Especificando el tipo damos la **posibilidad** al compilador **de verificar** (en tiempo de compilación) **que el tipo del objeto insertado** en la
colección **sea correcto**, reduciendo de tal forma errores que podrían darse en tiempo de ejecución.

Consideramos el siguiente código:
```java
ArrayList strLista = new ArrayList();
ArrayList intLista = new ArrayList();
```

Podemos suponer por el nombre de los objetos ArrayList que el primero contendrá cadenas, mientras que el segundo almacenará enteros, (pero lo suponemos sólo por el nombre).

Sin embargo, no es así, ya que **ambos objetos podrán trabajar con
cualquier tipo de dato**, ya que ArrayList trabaja con Object y este tipo de dato permite cualquier tipo de datos no primitivo,
como *Integer, String, Float o Double, etc...*

Ahora consideramos el siguiente **código que utiliza genéricos**:

```java
ArrayList<String> strLista = new ArrayList<String>();
ArrayList<Integer> intLista = new ArrayList<Integer>();
```
<u>Ahora hemos especificado que</u> **strLista trabajará con cadenas** de caracteres y **intLista con enteros**, <u>sólo con agregar
entre corchetes el tipo de dato</u>. 
- El compilador lanzará un error si intentamos asignar al objeto un dato que no cumpla con su norma.

Podremos hacer:

```java
strLista.add("Cadena 1 para strLista");
strLista.add("cadena 2 para strLista");
```
pero no:
```java
strLista.add(3);
```

**Mientras que el compilador hubiera aceptado la última línea de código** si se hubiese creado strLista y intLista con la primera versión, o sea sin genéricos.

Las **ventajas principales** de usar genéricos son:
- El **compilador** <u>no aceptará que se agregue ningún tipo de dato distinto al especificado</u> en la instanciación de la clase.
- **No** es **necesario** añadir los **castings** que eran indispensables para recuperar los datos homogéneos de una colección
Object.
- Se mantiene un **mayor control sobre la colección**

Lo **genéricos son particularmente útiles con los iteradores**, ya que de esta forma no tenemos que hacer ningún casting.

**Por ejemplo**, suponiendo tener una interfaz **IPersona**, y una clase **Persona** que la implemente, podemos definir una lista de
personas y recorrerla de la siguiente forma:

```java
IPersona p1 = new Persona("123456", "Roberto", 30);
IPersona p2 = new Persona("111111", "Patricia", 23);
IPersona p3 = new Persona("222222", "Jesus", 34);
IPersona p4 = new Persona("333333", "Alicia", 29);
List<IPersona> listaPersonas = new ArrayList<IPersona>();
listaPersonas.add(p1);
listaPersonas.add(p2);
listaPersonas.add(p3);
listaPersonas.add(p4);
for (Iterator<IPersona> it = listaPersonas.iterator(); it.hasNext();) {
IPersona persona = it.next();
System.out.println(persona);
}
```

De esta forma no tenemos que hacer **ningún casting**, y nos **aseguramos** que nuestra lista sólo podrá **contener objetos que
pertenezcan a una clase** que **implementa la interfaz IPersona**.

**También podemos utilizar los genéricos para definir tipos genéricos** en la definición de clases. 

Por ejemplo, considere esta clase:
```java
public class Contenedor {
    private Object elemento;

    public Object get() { 
        return elemento; 
    }

    public void set(Object elemento) { 
        this.elemento = elemento; 
    }
}
```
Los métodos de esta clase <u>aceptan o devuelven un Object</u>, por lo cual podemos utilizar cualquier cosa, menos un tipo primitivo.
<u>No hay forma de verificar como se utiliza la clase en tiempo de compilación</u>. 
- Una parte del código <u>podría utilizar el método set
pasándole un Integer</u> y <u>suponer que el método get devuelva un objeto de tipo Integer</u>. 
- **Sin embargo**, <u>otra parte del código
podría suponer que el método get devuelva un String</u>, resultando en un error en tiempo de ejecución.

Una **clase genérica** se define utilizando el **siguiente formato**:
```java
class name<T1, T2, ..., Tn> { /* ... */ }
```

La **sección de tipos de parámetros**, delimitada por **<>**, sigue el nombre de la clase. Especifica el tipo de parámetros, **llamados
también variables de tipo, T1, T2, ..., y Tn**.

```java
/**
* Versión genérica de la clase Contenedor.
* @param <T> el tipo de valor que será almacenado
*/
public class Contenedor<T> {
    // T significa "Tipo"
    private T t;
    public void set(T t) { 
        this.t = t; 
    }
    public T get() { 
        return t; 
    }
}
```
Como podemos observar, <u>todas las ocurrencias de **Object** se han remplazado con **T**</u>. 
- **Una variable de tipo puede ser cualquier tipo no primitivo** que especificamos: cualquier clase, interfaz, o incluso otra variable de tipo. 
- Se puede utilizar la <u>misma estructura para definir interfaces genéricas</u>.

Por convención, los nombres de variables de tipo son letras mayúsculas. Los tipos de parámetros más utilizados son:

- E - Elemento (utilizado extensivamente en JCF)
- K - Clave
- N - Número
- T - Tipo
- V - Valor
- S,U,V etc. - segundo, tercer, cuarto tipo

<u>Para utilizar la clase genérica Contenedor</u> en nuestro código, tenemos que hacer una invocación de tipo genérico, que reemplaza T con un valor concreto, por ejemplo Integer:
```java
Contenedor<Integer> contenedorEnteros;
```

Podemos pensar que una <u>invocación de tipo genérico es parecida a una invocación de un método ordinario</u>, sólo que en vez de
pasar un argumento al método, pasamos un argumento de tipo — Integer en este caso — a la misma clase Contenedor.

<u>Como cualquiera declaración de variable</u>, **el código anterior no crea un nuevo objeto Contenedor**, <u>simplemente declara que
contenedorEnteros contendrá una referencia a un</u> *"Contenedor de Integer"*, que es como se lee
**Contenedor\<Integer>.**

Para **instanciar esta clase**, utilizamos, como siempre, la palabra clave new, pero ahora ponemos \<Integer> entre el nombre de clase y las paréntesis:
```java
Contenedor<Integer> contenedorEnteros = new Contenedor<Integer>();
```
o, desde Java SE 7, simplemente:
```java
Contenedor<Integer> contenedorEnteros = new Contenedor<>();
```