package EPDs.EPD5.ejemploEPD_Evaluable;

public interface IQueue<E> {

    
    boolean isEmpty();
    
    int size();
    
    void enqueue(E o);
    
    E dequeue() throws EmptyQueueException; // EmptyQueueException se lanza si la cola está vacía
    
    E front() throws EmptyQueueException;
    
    boolean buscar(E o);
    

}

// ¿Por qué se pueden lanzar las dos excepciones? 
// ¿Cómo se podría implementar el método buscar? 
//  Usando un iterador para recorrer la cola y comparar cada elemento con el objeto que se busca.