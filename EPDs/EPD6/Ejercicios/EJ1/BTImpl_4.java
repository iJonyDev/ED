package Ejercicios.EJ1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BTImpl_4<T extends Comparable<T>> implements BT_4<T> {
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
        List<T> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return values.iterator();
    }

    private void inOrderTraversal(Node node, List<T> values){

    }

    @Override
    public Iterator<T> preOrderIterator() {
        List<T> values = new ArrayList<>();
        preOrdertraversal(root, values);
        return values.iterator();
    }

    private void preOrdertraversal(Node node, List<T> values){

    }

    @Override
    public Iterator<T> postOrderIterator() {
        List<T> values = new ArrayList<>();
        postOrderTraversal(root, values);
        return values.iterator();
    }

    private void postOrderTraversal(Node node, List<T> values){

    }

}
