package EPDs.EPD5;

public class Queue implements IQueue<Integer> {
    private Node<Integer> firstNode;
    private Node<Integer> lastNode;
    private int size;

    @Override
    public boolean buscar(Integer o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
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
    public Object front() throws EmptyQueueException {
        if(firstNode == null){
            throw new UnsupportedOperationException("La cola esta vacia");
        }else{
            Object objeto = firstNode.getElemento();
            return objeto;
        }  
    }

    @Override
    public boolean isEmpty() {
        if( size == 0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public int size() {
        return this.size;
    }
    
}
