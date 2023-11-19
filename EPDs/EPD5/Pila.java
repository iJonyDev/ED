package EPDs.EPD5;

public interface Pila<E> {
    boolean isEmpty();

    E pop() throws PilaVaciaException;

    void push(E o);

    int size();

    String toString();

    E top() throws PilaVaciaException;
}
