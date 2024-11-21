package EPDs.EPD5.ejemploEPD_Evaluable;

public class Queue<E> implements IQueue<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;

        }
    }
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;


    @Override
    public boolean buscar(E o) {
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element.equals(o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("La cola está vacía");
        E element = firstNode.element;
        firstNode = firstNode.next;
        size--;
        if (isEmpty())
            lastNode = null;
        return element;
    }

    @Override
    public void enqueue(E o) {
        Node<E> newNode = new Node<>(o, null);
        if (!isEmpty()) {
            lastNode.next = newNode;
            lastNode = newNode;
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
        size++;
    }

    @Override
    public E front() throws EmptyQueueException {
        if (firstNode == null) {
            throw new EmptyQueueException("La cola esta vacia");
        } else {
            E elemento = firstNode.element;
            return elemento;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
}
