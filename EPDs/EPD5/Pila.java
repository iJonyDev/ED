package EPDs.EPD5;

public class Pila implements IPila {
    private Node<Integer> firstNode;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object pop() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("La pila está vacía");
        }
        Integer element = firstNode.getElemento();
        firstNode = firstNode.getNext();
        size--;
        return element;
    }

    @Override
    public void push(Object o) {
        Node<Integer> newNode = new Node<>((Integer) o);
        newNode.setNext(firstNode);
        firstNode = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object top() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("La pila está vacía");
        }
        return firstNode.getElemento();
    }
}
