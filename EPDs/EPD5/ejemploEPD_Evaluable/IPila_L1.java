package EPDs.EPD5.ejemploEPD_Evaluable;

public interface IPila_L1<E> {
    int size();
    boolean isEmpty();
    void push(E element);
    E pop() throws IndexOutOfBoundsException, ListaVaciaException;
    E top() throws ListaVaciaException;
}
