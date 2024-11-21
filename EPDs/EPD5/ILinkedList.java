
package EPDs.EPD5;

import EPDs.EPD5.ejemploEPD_Evaluable.ListaVaciaExcept;

// Experimento 1
public interface ILinkedList<E> {

    int size();
    
    boolean isEmpty();

    void addEnd(E newElement);
    
    void addFront(E newElement);

    void add(E newElement, int index) throws IndexOutOfBoundsException;

    E getElement(int index) throws IndexOutOfBoundsException, ListaVaciaExcept;

    void remove(int index) throws IndexOutOfBoundsException, ListaVaciaExcept;

    void removeEnd() throws ListaVaciaExcept;

    void removeFront() throws ListaVaciaExcept;
    
    @Override
    String toString();

}
// ¿Por qué se puede lanzar la excepción IndexOutOfBoundsException?
// Porque se intenta acceder a un índice que no existe en la lista.
