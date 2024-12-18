package EPDs.EPD5.ejemploEPD_Evaluable;

public interface ICola<E> {
    int size();
    boolean isEmpty();
    void enqueue(E element);
    E dequeue() throws IndexOutOfBoundsException, ListaVaciaException, ColaVaciaExcept;
    E first() throws ListaVaciaException, ColaVaciaExcept;
}
