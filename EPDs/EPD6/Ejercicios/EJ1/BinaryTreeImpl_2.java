package Ejercicios.EJ1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeImpl_2<T extends Comparable<T>> implements BinaryTree_2<T> {
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
        if(current == null)
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
        inOrderTraversal(root, values);
        return values.iterator();
    }

    private void inOrderTraversal(Node node, List<T> values){
        if(node != null){
            inOrderTraversal(node.left, values);
            values.add(node.value);
            inOrderTraversal(node.right, values);
        }
    }

    @Override
    public Iterator<T> preOrderIterator() {
        List<T> values = new ArrayList<>();
        preOrdertraversal(root, values);
        return values.iterator();    
    }

    private void preOrdertraversal(Node node, List<T> values){
        if(node != null){
            values.add(node.value);
            preOrdertraversal(node.left, values);
            preOrdertraversal(node.right, values);
        }
    }

    @Override
    public Iterator<T> postOrderIterator() {
        List<T> values = new ArrayList<>();
        postOrdertraversal(root, values);
        return values.iterator();    
    }

    private void postOrdertraversal(Node node, List<T> values){
        if(node != null){
            postOrdertraversal(node.left, values);
            postOrdertraversal(node.right, values);
            values.add(node.value);
        }
    }

}
