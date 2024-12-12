package EPDs.EPD5.ejemploEPD_Evaluable;

public class Cola1<E> implements ICola<E>{
    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public Cola1(){
        first = null;
        last = null;
        size = 0;
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
    public void enqueue(E element) {
        Node<E> n = new Node<>(element, null);
        if(isEmpty()){
            first = n;
        }else{
            last.next = n;
        }
        last = n;
        size++;
    }

    @Override
    public E dequeue() throws IndexOutOfBoundsException, ListaVaciaException, ColaVaciaExcept{
        if(isEmpty())
            throw new ColaVaciaExcept("Cola Vacia");
        E element = first.element;
        first = first.next;
        if (first == null)
            last = null;
        size--;
        return element;
    }

    @Override
    public E first() throws ListaVaciaException, ColaVaciaExcept {
        if(isEmpty())
            throw new ColaVaciaExcept("Cola Vacia");
        return first.element;
    }
    
}
