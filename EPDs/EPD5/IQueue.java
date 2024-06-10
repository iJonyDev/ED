package EPDs.EPD5;

public interface IQueue<E> {

    boolean buscar(E o);

    E dequeue() throws EmptyQueueException;

    void enqueue(E o);

    E front() throws EmptyQueueException;

    boolean isEmpty();

    int size();

}