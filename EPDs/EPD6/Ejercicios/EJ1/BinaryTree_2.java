package Ejercicios.EJ1;

import java.util.Iterator;

public interface BinaryTree_2<T> {
    void add(T value);
    boolean contains(T value);
    Iterator<T> inOrderIterator();
    Iterator<T> preOrderIterator();
    Iterator<T> postOrderIterator();
}
