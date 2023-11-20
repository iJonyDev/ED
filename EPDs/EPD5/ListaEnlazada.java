package EPDs.EPD5;

public class ListaEnlazada {
    private Node<Integer> firstNode;
    private Node<Integer> lastNode;
    private int size;

    
    public void add(int index, Integer newElement) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice fuera de los limites");
        }
    
        if (index == 0) {
            addFront(newElement);
        } else if (index == size) {
            addEnd(newElement);
        } else {
            if (newElement != null) {
            Node<Integer> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
    
            Node<Integer> newNode = new Node<Integer>(newElement);
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
    
            this.size++;
            }
        }
    }

    public void addEnd(Integer newElement) {
        if (newElement != null) {
            Node<Integer> newNode = new Node<Integer>(newElement);
            newNode.setElemento(newElement);
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

    public void addFront(Integer newElement) {
        if (newElement != null) {
            Node<Integer> newNode = new Node<Integer>(newElement);
            newNode.setElemento(newElement);
            if (firstNode != null) {
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                newNode.setNext(null);
                firstNode = newNode;
                lastNode = newNode;
            }
            this.size++;
        }
    }

    public Integer getElement(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de los limites");
        }
    
        Node<Integer> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
    
        return currentNode.getElemento();
    }

    public boolean isEmpty(){
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
            Node<Integer> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
    
            Node<Integer> nextNode = currentNode.getNext();
            currentNode.setNext(nextNode.getNext());
            nextNode.setNext(null);
    
            this.size--;
        }
    }
    
    public void removeEnd() {
        if (lastNode != null) {
            Node<Integer> currentNode = firstNode;
            while (currentNode.getNext() != lastNode) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            lastNode = currentNode;
            this.size--;
        }
    }

    public void removeFront() {
        if (firstNode != null) {
            Node<Integer> oldTop = firstNode;
            firstNode = firstNode.getNext();
            oldTop.setNext(null);
            this.size--;
            if (firstNode == null) {
                lastNode = null;
            }
        }
    }

    public Integer getFront() {
        if (firstNode != null) {
            return firstNode.getElemento();
        } else {
            return null;
        }
    }

    public Integer getBack() {
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
        String mostarLista = "";
        Node<Integer> currentNode = firstNode;
        while (currentNode != null) {
            mostarLista += currentNode.getElemento();
            mostarLista += " ";
            currentNode = currentNode.getNext();
        }
        return mostarLista;
    }

    public static void main(String[] args) {
        ListaEnlazada list = new ListaEnlazada();

        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addEnd(6);
        list.addEnd(7);

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
        list.add(7, 6);
        System.out.println(list.toString());
        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");

        if(list.isEmpty()){
            System.out.println("La lista está vacia");
        }
    }
    
}