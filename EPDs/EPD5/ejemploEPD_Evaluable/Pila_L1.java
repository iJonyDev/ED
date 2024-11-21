package EPDs.EPD5.ejemploEPD_Evaluable;

public class Pila_L1<E> implements IPila_L1<E> {
    private ListaEnlazada3<E> lista = new ListaEnlazada3<>();

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public void push(E element) {
        lista.addFront(element);
    }

    @Override
    public E pop() throws IndexOutOfBoundsException, ListaVaciaException {
        E element = lista.getElement(0);
        lista.remove(0);
        return element;
    }

    @Override
    public E top() throws ListaVaciaException {
        return lista.getElement(0);
    }


}
