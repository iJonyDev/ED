package EPDs.EPD5.ejemploEPD_Evaluable;

public interface IListaEnlazada2<E> {
    int size();
    boolean isEmpty();
    void addFront(E element);
    void addEnd(E element);
    void add(E element, int index) throws IndexOutOfBoundsException;
    E getElement(int index) throws IndexOutOfBoundsException, ListaVaciaException;
    void remove(int index) throws IndexOutOfBoundsException, ListaVaciaException;
    void removeEnd() throws ListaVaciaException;
    void removeFront() throws ListaVaciaException;
}
