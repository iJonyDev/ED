package EPDs.EPD5;
// Experimento 4
public interface IPila<E> {
    boolean isEmpty();

    E pop() throws PilaVaciaException; // PilaVaciaException se lanza si la pila está vacía

    void push(E o);

    int size();

    String toString();

    E top() throws PilaVaciaException;
}
// ¿Por qué se pueden lanzar las dos excepciones? ¿Por qué, al contrario de lo que se ha visto en clase de teoría, el método push no lanza ninguna excepción?