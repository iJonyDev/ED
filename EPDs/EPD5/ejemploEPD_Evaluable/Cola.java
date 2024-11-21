package EPDs.EPD5.ejemploEPD_Evaluable;

public class Cola<E> implements ICola<E>{
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public Cola() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E element) {
        Node<E> n = new Node<>(element, null);
        if (isEmpty()) {
            first = n;
        } else {
            last.next = n;
        }
        last = n;
        size++;
    }

    public E dequeue() throws IndexOutOfBoundsException, ListaVaciaException {
        if (isEmpty())
            throw new ListaVaciaException("Cola vacía");
        E element = first.element;
        first = first.next;
        if (first == null)
            last = null;
        size--;
        return element;
    }

    public E first() throws ListaVaciaException {
        if (isEmpty())
            throw new ListaVaciaException("Cola vacía");
        return first.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            sb.append(current.element).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

}
