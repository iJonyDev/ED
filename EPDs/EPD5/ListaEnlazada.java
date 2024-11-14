package EPDs.EPD5;
// Clase que implementa una lista enlazada
public class ListaEnlazada<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    

    public void add(int index, T newElement) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice fuera de los limites");
        }

        if (index == 0) {
            addFront(newElement);
        } else if (index == size) {
            addEnd(newElement);
        } else {
            if (newElement != null) {
                Node<T> currentNode = firstNode;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }
                Node<T> newNode = new Node<T>(newElement);
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
                this.size++;
            }
        }
    }

    public void addEnd(T newElement) {
        if (newElement != null) {
            Node<T> newNode = new Node<T>(newElement);
            if (firstNode != null) {
                lastNode.setNext(newNode);
                lastNode = newNode;
            } else {
                firstNode = newNode;
                lastNode = newNode;
            }
            this.size++;
        }
    }
    // Experimento 2
    // ¿Cómo se logra que el nuevo nodo se inserte al principio de la lista?
    // Se crea un nuevo nodo y se le asigna el nodo que estaba al principio de la lista como su siguiente nodo.
    public void addFront(T newElement) {
        if (newElement != null) {
            Node<T> newNode = new Node<T>(newElement);
            if (firstNode != null) {
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                firstNode = newNode;
                lastNode = newNode;
            }
            this.size++;
        }
    }



    public T getElement(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Indice fuera de los limites");
        }

        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getElemento();
    }

    public T getFront() {
        return (firstNode != null) ? firstNode.getElemento() : null;
    }

    public T getBack() {
        return (lastNode != null) ? lastNode.getElemento() : null;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String listStatus() {
        return (isEmpty() == true) ? "La lista está vacia" : "La lista no esta vacia";
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de los limites");
        }

        if (index == 0) {
            removeFront();
        } else if (index == size - 1) {
            removeEnd();
        } else {
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            Node<T> nextNode = currentNode.getNext();
            currentNode.setNext(nextNode.getNext());
            nextNode.setNext(null);

            this.size--;
        }
    }

    public void removeEnd() {
        if (firstNode != null) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
            } else {
                Node<T> nodoActual = firstNode;
                while (nodoActual.getNext() != lastNode) {
                    nodoActual = nodoActual.getNext();
                }
                nodoActual.setNext(null);
                lastNode = nodoActual;
            }
            this.size--;
        }
    }
    // Experimento 3
    // ¿En qué línea del código se borra el primer nodo?
    public void removeFront() {
        if (firstNode != null) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
            } else {
                Node<T> oldFirstNode = firstNode;
                firstNode = firstNode.getNext();
                oldFirstNode.setNext(null); // Se borra el primer nodo en esta línea
            }
            this.size--;
        }
    }

    @Override
    public String toString() {
        String lista = "";
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            lista += currentNode.getElemento();
            lista += " ";
            currentNode = currentNode.getNext();
        }
        return lista;
    }

}