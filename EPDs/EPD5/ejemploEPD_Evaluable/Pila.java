package EPDs.EPD5.ejemploEPD_Evaluable;

public class Pila<E> implements IPila<E>{
    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> top;
    private int size;

    public Pila(){
        this.top = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E element) {
        Node<E> n = new Node<>(element, top);
        top = n;
        size++;
    }

    @Override
    public E pop() throws PilaVaciaExcept {
        if(isEmpty())
            throw new PilaVaciaExcept("Pila vacia");
        E element = top.element;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public E top() throws PilaVaciaExcept {
        if(isEmpty())
            throw new PilaVaciaExcept("Pila vacia");
        return top.element;
    }


}
