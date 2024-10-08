package EPDs.EPD5;

public class Node<T> {
    private T elemento;
    private Node<T> next;

    public Node(T elemento) {
        this.elemento = elemento;
        this.next = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
