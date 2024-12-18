package EPDs.EPD5;

public class Queue<E> implements IQueue<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    @Override
    public boolean buscar(E o) {
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.getElemento().equals(o)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (!isEmpty()) {
            lastNode.setNext(newNode);
            lastNode = newNode;
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
        size++;
    }

    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía");
        }
        E element = firstNode.getElemento();
        firstNode = firstNode.getNext();
        size--;
        if (isEmpty()) {
            lastNode = null;
        }
        return element;
    }

    @Override
    public E front() throws EmptyQueueException {
        if (firstNode == null) {
            throw new EmptyQueueException("La cola esta vacia");
        } else {
            E elemento = firstNode.getElemento();
            return elemento;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;

    }

    @Override
    public int size() {
        return this.size;
    }

}
