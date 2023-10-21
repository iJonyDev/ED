package EPDs.EPD3;

public interface ILinkedList<E> {
    // Agrega un nuevo elemento en la posición especificada por el índice.
    // Puede lanzar una excepción IndexOutOfBoundsException si el índice está fuera de los límites válidos.
    void add(E newElement, int index) throws IndexOutOfBoundsException;

    // Agrega un nuevo elemento al final de la lista.
    void addEnd(E newElement);

    // Agrega un nuevo elemento al frente de la lista.
    void addFront(E newElement);

    // Devuelve el elemento en la posición especificada por el índice.
    // Puede lanzar una excepción IndexOutOfBoundsException si el índice está fuera de los límites válidos.
    E getElement(int index) throws IndexOutOfBoundsException;

    // Verifica si la lista está vacía y devuelve un valor booleano.
    boolean isEmpty();

    // Elimina el elemento en la posición especificada por el índice.
    // Puede lanzar una excepción IndexOutOfBoundsException si el índice está fuera de los límites válidos.
    void remove(int index) throws IndexOutOfBoundsException;

    // Elimina el último elemento de la lista.
    void removeEnd();

    // Elimina el primer elemento de la lista.
    void removeFront();

    // Devuelve el tamaño actual de la lista.
    int size();

    // Devuelve una representación en forma de cadena de la lista.
    @Override
    String toString();
}
