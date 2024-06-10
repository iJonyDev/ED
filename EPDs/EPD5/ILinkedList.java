
package EPDs.EPD5;

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
