package EPDs.EPD5;

public class Node<T> {
    private Integer elemento;
    private Node<Integer> next;

    public Node(Integer elemento) {
        this.elemento = elemento;
        this.next = null;
    }

    public Integer getElemento() {
        return elemento;
    }

    public void setElemento(Integer elemento) {
        this.elemento = elemento;
    }

    public Node<Integer> getNext() {
        return next;
    }

    public void setNext(Node<Integer> next) {
        this.next = next;
    }
}
