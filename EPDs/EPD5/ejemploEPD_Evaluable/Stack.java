package EPDs.EPD5.ejemploEPD_Evaluable;

public class Stack<E> implements IStack<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }
    }

    private Node<E> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(E e) {
        Node<E> n = new Node<>(e, top);
        top = n;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Stack is empty");
        E e = top.getElement();
        top = top.getNext();
        size--;
        return e;
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Stack is empty");
        return top.getElement();
    }

}
