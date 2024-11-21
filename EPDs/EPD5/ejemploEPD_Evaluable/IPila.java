package EPDs.EPD5.ejemploEPD_Evaluable;

public interface IPila<E> {
    int size();
    boolean isEmpty();
    void push(E element);
    E pop() throws PilaVaciaExcept;
    E top() throws PilaVaciaExcept;
}
