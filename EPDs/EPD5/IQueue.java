package EPDs.EPD5;

public interface IQueue<E> {

    boolean buscar(E o);

    E dequeue() throws EmptyQueueException; // EmptyQueueException se lanza si la cola está vacía

    void enqueue(E o);

    E front() throws EmptyQueueException;

    boolean isEmpty();

    int size();

}

// ¿Por qué se pueden lanzar las dos excepciones? 
// ¿Cómo se podría implementar el método buscar? 
//  Usando un iterador para recorrer la cola y comparar cada elemento con el objeto que se busca.