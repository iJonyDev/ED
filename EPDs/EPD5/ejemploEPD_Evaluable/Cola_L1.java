package EPDs.EPD5.ejemploEPD_Evaluable;

public class Cola_L1<E> implements ICola<E> {
    private ListaEnlazada3<E> lista = new ListaEnlazada3<E>();

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        lista.addEnd(element);
    }

    @Override
    public E dequeue() throws IndexOutOfBoundsException, ListaVaciaException {
        if(isEmpty())
            throw new ListaVaciaException("Cola Vacia");
        E element = lista.getElement(0);
        lista.remove(0);
        return element;
    }

    @Override
    public E first() throws ListaVaciaException {
        if(isEmpty())
            throw new ListaVaciaException("Cola Vacia");
        return lista.getElement(0);
    }   


}
