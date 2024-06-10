## Ejemplo de Examen Final

### Pregunta 1

Considere el siguientes árbol binario de búsqueda donde las claves son enteros y los cuadrados representan hojas únicas.
![alt text](<Screenshot 2024-06-10 at 16.43.17.png>)

a) Representar el árbol binario de búsqueda resultante de ejecutar las siguientes instrucciones.

1. Insertar un nodo con clave 56
2. Insertar un nodo con clave 8
3. Insertar un nodo con clave 32
4. Borrar el nodo con clave 45
5. Insertar un nodo con clave 12

b) Implemente en lenguaje java o pseudocódigo el algoritmo de búsqueda de una clave en un árbol binario de búsqueda.

### Pregunta 2
Considere ahora el árbol proporcionado en el problema 1 como un árbol AVL

a) Representar el árbol AVL tras ejecutar las siguientes instrucciones:

1. Insertar un nodo con clave 56
2. Insertar un nodo con clave 20
3. Borrar el nodo con clave 56
4. Insertar el nodo con clave 78
5. Insertar el nodo con clave 45

b) ¿Cual es la principal ventaja de un árbol AVL con respecto a un árbol binario de búsqueda?

### Pregunta 3

a) Proporciona un código recursivo para borrar todos los elementos de una pila.
```java
borrarElementoPila(){
    if(pila.top!=null){
        pila.pop();
        borrarElementoPila();
    }
}   
```

b) Proporciona un algoritmo, en java o pseudocódigo, para invertir el orden de los elementos de una cola. 
```java
while(!cola.isEmpty()){
    pila.push(cola.dequeue());
}
while(!pila.isEmpty()){
    cola.enqueue(pila.pop());
}
```

Suponer que la cola Q contiene un conjunto de elementos y que la pila S está vacía.

### Pregunta 4

Considere el siguiente grafo no direccionado
![alt text](<Screenshot 2024-06-10 at 18.57.15.png>)

a) Proporcione la **edge list** y la **adjacency matrix** relativas al grafo de la figura. Para la adjacency matrix se puede utilizar la estructura simplificada vista en EPD.
b) ¿Como cambian las estructuras del apartado anterior si se ejecutan las siguientes operaciones?

1. Insertar vértice 6
2. Insertar arco (5,6)
3. Insertar arco (4,6)
4. Borra vértice 6

### Pregunta 5

Dada la clase "Persona":
```java
public class Persona implements Comparable{
    String DNI, nombre;
    int edad;

    public Persona(String DNI, int edad, String nombre) {
        this.DNI = DNI;
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.DNI == null) {
            if (other.DNI != null) {
                return false;
            }
        } else if (!this.DNI.equals(other.DNI)) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.DNI);
        return hash;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
    
    @Override
    public int compareTo(Object o){
        Persona other = (Persona)o;
        return this.edad-other.edad;
    }
}
```

Escriba las siguientes salida que generaría la ejecución del siguientes código:

```java
public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        Persona p1 = new Persona("4444a",25,"Pepe");
        Persona p2 = new Persona("3333b",22,"Maria");
        Persona p3 = new Persona("2222c",27,"Juan");
        Persona p4 = new Persona("2222c",31,"Paco");
        Persona p5 = new Persona("1111d",18,"Cristina");
        
        List <Persona> lista = new ArrayList();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        
        System.out.println("Impresion 1: "+lista);
        Set <Persona> conjunto = new HashSet(lista);
        System.out.println("Impresion 2: "+conjunto.size());
        SortedSet <Persona> ss = new TreeSet(lista);
        System.out.println("Impresion 2.b: "+ conjunto);
        System.out.println("Impresion 3: "+ss);
        ss.last().setNombre("Lola");
        System.out.println("Impresion 4.a: "+ss);
        System.out.println("Impresion 4.b: "+lista);
    }
}
```