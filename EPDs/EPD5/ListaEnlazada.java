package EPDs.EPD5;

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

    public boolean isEmpty() {
        return size == 0;
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
        if (lastNode != null) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
            } else {
                Node<T> currentNode = firstNode;
                while (currentNode.getNext() != lastNode) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(null);
                lastNode = currentNode;
            }
            this.size--;
        }
    }

    public void removeFront() {
        if (firstNode != null) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
            } else {
                Node<T> oldTop = firstNode;
                firstNode = firstNode.getNext();
                oldTop.setNext(null);
            }
            this.size--;
        }
    }

    public T getFront() {
        if (firstNode != null) {
            return firstNode.getElemento();
        } else {
            return null;
        }
    }

    public T getBack() {
        if (lastNode != null) {
            return lastNode.getElemento();
        } else {
            return null;
        }
    }

    public int getSize() {
        return this.size;
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

    public static void main(String[] args) {
        ListaEnlazada<Integer> list = new ListaEnlazada<>();
        int i = 0;
        while(list.size < 10){
            list.addEnd(i);
            i++;
        }

        System.out.println(list.toString());
        System.out.println("La lista tiene " + list.getSize() + " elementos.");
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

        list.removeFront();
        list.removeEnd();
        list.add(3, 5);

        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

        list.remove(2);
        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");

        list.add(3, 6);
        list.add(3, null);
        list.add(0, null);
        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");

        if (list.isEmpty()) {
            System.out.println("La lista está vacia");
        } else {
            System.out.println("La lista no esta vacia");
        }
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

        while (!list.isEmpty()) {
            list.removeEnd();
        }
        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");
        if (list.isEmpty()) {
            System.out.println("La lista está vacia");
        } else {
            System.out.println("La lista no esta vacia");
        }
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

    }

}