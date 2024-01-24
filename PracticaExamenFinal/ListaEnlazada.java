package PracticaExamenFinal;

public class ListaEnlazada<T> {
    private Node firstNode;
    private Node lastNode;
    private int size;

    public void addFront(Persona persona) {
        if (persona != null) {
            Node nuevoNodo = new Node(persona);
            if (firstNode != null) {
                nuevoNodo.setNext(firstNode);
                firstNode = nuevoNodo;
            } else {
                firstNode = nuevoNodo;
                lastNode = nuevoNodo;
            }
            this.size++;
        }
    }

    public void addEnd(Persona persona) {
        if (persona != null) {
            Node nuevoNodo = new Node(persona);
            if (firstNode != null) {
                lastNode.setNext(nuevoNodo);
                lastNode = nuevoNodo;
            } else {
                firstNode = nuevoNodo;
                lastNode = nuevoNodo;
            }
            this.size++;
        }
    }

    public void add(int index, Persona persona) {
        if (index >= 0 && index <= size) {
            if (index == 0) {
                addFront(persona);
            } else if (index == size) {
                addEnd(persona);
            } else {
                if (persona != null) {
                    Node nuevoNodo = new Node(persona);
                    if (firstNode != null) {
                        Node nodoActual = firstNode;
                        int i = 0;
                        while (i < index) {
                            nodoActual = nodoActual.getNext();
                            i++;
                        }
                        nuevoNodo.setNext(nodoActual.getNext());
                        nodoActual.setNext(nuevoNodo);
                    }
                    this.size++;
                }
            }
        } else {
            System.out.println("Indice no valido!");
        }
    }

    public Persona getFront() {
        return (firstNode != null) ? firstNode.getPersona() : null;
    }

    public Persona getEnd() {
        return (firstNode != null) ? lastNode.getPersona() : null;
    }

    public Persona getElement(int index) {
        if (index == 0) {
            return getFront();
        } else if (index > 0 && index < size - 1) {
            Node nodoActual = firstNode;
            int i = 0;
            while (i <= index) {
                nodoActual = nodoActual.getNext();
                i++;
            }
            return nodoActual.getPersona();
        } else {
            return getEnd();
        }
    }

    public static void main(String[] args) {
        Persona p1 = new Persona("Jonathan", "Quishpe", "1111");
        Persona p2 = new Persona("Edwin", "Quishpe", "2222");
        Persona p3 = new Persona("Gladys", "Maldonado", "3333");

        ListaEnlazada<String> list = new ListaEnlazada<>();

        list.addFront(p1);
        System.out.println(list.getFront().toString());
        list.addEnd(p2);
        System.out.println(list.getEnd().toString());
        list.add(1, p3);
        System.out.println(list.getElement(1));
        System.out.println(list.size);

    }
}
