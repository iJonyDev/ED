package Ejercicios.EJ1;

import java.util.Iterator;

public class BTImpl_1<T extends Comparable<T>> implements BT_1<T> {
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
        root = addRecursive(null, value);
    }

    private Node addRecursive(Node current, T value ){
        return current;
    }

    @Override
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
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
