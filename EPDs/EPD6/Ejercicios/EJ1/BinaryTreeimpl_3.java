package Ejercicios.EJ1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeimpl_3<T extends Comparable<T>> implements BinaryTree_3<T> {
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
        if (current == null)
            return new Node(value);

        if(value.compareTo(current.value) < 0){
            current.left = addRecursive(current.left, value);
        }else if(value.compareTo(current.value) > 0){
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    @Override
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, T value){
        if(current == null)
            return false;
        if(value.equals(current.value))
            return true;

        return value.compareTo(current.value) < 0
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    @Override
    public Iterator<T> inOrderIterator() {
        List<T> values = new ArrayList<>();
        inOrdertraversal(root, values);
        return values.iterator();
    }

    private void inOrdertraversal(Node node, List<T> values){

    }

    @Override
    public Iterator<T> preOrderIterator() {
        List<T> values = new ArrayList<>();
        preOrderTraversal(root, values);
        return values.iterator();
    }

    private void preOrderTraversal(Node node, List<T> values){

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
