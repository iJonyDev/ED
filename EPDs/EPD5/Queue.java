package EPDs.EPD5;

public class Queue implements IQueue<Integer> {
    private Node<Integer> firstNode;
    private Node<Integer> lastNode;
    private int size;

    @Override
    public boolean buscar(Integer o) {
        Node<Integer> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.getElemento().equals(o)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public void enqueue(Integer element) {
        Node<Integer> newNode = new Node<>(element);
        if (isEmpty()) {
            lastNode.setNext(newNode);
            lastNode = newNode;
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
        size++;
    }

    public Integer dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía");
        }
        Integer element = firstNode.getElemento();
        firstNode = firstNode.getNext();
        size--;
        if (isEmpty()) {
            lastNode = null;
        }
        return element;
    }

    @Override
    public Integer front() throws EmptyQueueException {
        if (firstNode == null) {
            throw new EmptyQueueException("La cola esta vacia");
        } else {
            Integer elemento = firstNode.getElemento();
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
