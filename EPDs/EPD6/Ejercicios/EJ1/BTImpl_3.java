package Ejercicios.EJ1;

import java.util.Iterator;

public class BTImpl_3<T extends Comparable<T>> implements BT_3<T> {
    private class Node{
        T value;
        Node left;
        Node right;

        Node(T value){
            this.value = value;
        }
    }
    private Node root;

    @Override
    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, T value){
        return current;
    }

    @Override
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, T value){
        return false;
    }

    @Override
    public Iterator<T> inOrderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inOrderIterator'");
    }

    @Override
    public Iterator<T> preOrderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preOrderIterator'");
    }

    @Override
    public Iterator<T> postOrderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postOrderIterator'");
    }

}
