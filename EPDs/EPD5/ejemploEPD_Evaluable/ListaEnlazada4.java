package EPDs.EPD5.ejemploEPD_Evaluable;

public class ListaEnlazada4<E> implements IListaEnlazada2<E>{
    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> first;
    private int size;

    public ListaEnlazada4(){
        this.first = null;
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
    public void addFront(E element) {
        Node<E> n = new Node<>(element, first);
        first = n;
        size++;
    }

    @Override
    public void addEnd(E element) {
        Node<E> n = new Node<>(element, null);
        if(isEmpty()){
            first = n;
        }else{
            Node<E> current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = n;
        }
        size++;
            
    }

    @Override
    public void add(E element, int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("msg");
        if(index == 0){
            addFront(element);
        }else{
            Node<E> current = first;
            for(int i = 0; i < index -1; i++){
                current = current.next;
            }
            Node<E> n = new Node<>(element, current.next);
            current.next = n;
            index++;
        }
    }

    @Override
    public E getElement(int index) throws IndexOutOfBoundsException, ListaVaciaException {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("msg");
        if(isEmpty())
            throw new ListaVaciaException("msg");
        Node<E> current = first;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.element;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException, ListaVaciaException {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("msg");
        if(isEmpty())
            throw new ListaVaciaException("msg");
        if(index == 0){
            removeFront();
        }else{
            Node<E> current = first;
            for(int i = 0; i < index -1; i++){
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    @Override
    public void removeEnd() throws ListaVaciaException {
        if(isEmpty())
            throw new ListaVaciaException("msg");
        if(size == 1){
            first = null;
        }else{
            Node<E> current = first;
            while(current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    @Override
    public void removeFront() throws ListaVaciaException {
        if(isEmpty())
            throw new ListaVaciaException("msg");
        first = first.next;
    }
}
