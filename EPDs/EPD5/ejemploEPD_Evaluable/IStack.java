package EPDs.EPD5.ejemploEPD_Evaluable;

public interface IStack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    E pop() throws EmptyStackException;
    E top() throws EmptyStackException;
}
