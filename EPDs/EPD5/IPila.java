package EPDs.EPD5;

public interface IPila<E> {
    boolean isEmpty();

    E pop() throws PilaVaciaException;

    void push(E o);

    int size();

    String toString();

    E top() throws PilaVaciaException;
}
