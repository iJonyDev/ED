
package EPDs.EPD5;
// Experimento 1
public interface ILinkedList<E> {
    void add(E newElement, int index) throws IndexOutOfBoundsException;

    void addEnd(E newElement);

    void addFront(E newElement);

    E getElement(int index) throws IndexOutOfBoundsException;

    boolean isEmpty();

    void remove(int index) throws IndexOutOfBoundsException;

    void removeEnd();

    void removeFront();

    int size();

    @Override
    String toString();

}
// ¿Por qué se puede lanzar la excepción IndexOutOfBoundsException?
// Porque se intenta acceder a un índice que no existe en la lista.
