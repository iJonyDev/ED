package EPDs.EPD5;

public class Lista {
    private Node<Integer> firstNode;
    private Node<Integer> lastNode;
    private int size;

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

    public void removeFront() {
        if (firstNode != null) {
            Node<Integer> oldTop = firstNode;
            firstNode = firstNode.getNext();
            oldTop.setNext(null);
            this.size--;
        }
    }

    public void addBack(Integer newElement) {
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

    public static void main(String[] args) {
        Lista list = new Lista();

        list.addFront(1);
        list.addFront(2);
        list.addFront(3);

        System.out.println("La lista tiene " + list.getSize() + " elementos.");
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());

        list.removeFront();

        System.out.println("La lista tiene ahora " + list.getSize() + " elementos.");
        System.out.println("El primer elemento es " + list.getFront());
        System.out.println("El último elemento es " + list.getBack());
    }
    
}