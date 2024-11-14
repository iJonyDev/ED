package Ejercicios.EJ1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {
    private class Node {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    @Override
    public void add(T value) {
        root = addRecursive(root, value); 
    
    }

    private Node addRecursive(Node current, T value) { // Motodo recursivo para agregar un valor al arbol
        if (current == null) {  // Si el nodo actual es nulo, se crea un nuevo nodo con el valor
            return new Node(value);
        }

        if (value.compareTo(current.value) < 0) {   // Si el valor es menor al valor del nodo actual, se agrega a la izquierda
            current.left = addRecursive(current.left, value);   // Se llama al metodo recursivo con el nodo izquierdo
        } else if (value.compareTo(current.value) > 0) {    // Si el valor es mayor al valor del nodo actual, se agrega a la derecha
            current.right = addRecursive(current.right, value); // Se llama al metodo recursivo con el nodo derecho
        }

        return current; // Se retorna el nodo actual
    }

    @Override
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, T value) {
        if (current == null) {
            return false;
        }

        if (value.equals(current.value)) {  // Si el valor es igual al valor del nodo actual, se retorna verdadero
            return true;
        }

        return value.compareTo(current.value) < 0   // Si el valor es menor al valor del nodo actual, se llama al metodo recursivo con el nodo izquierdo
                ? containsRecursive(current.left, value)    // Se retorna el resultado de la llamada recursiva
                : containsRecursive(current.right, value);  // Si el valor es mayor al valor del nodo actual, se llama al metodo recursivo con el nodo derecho
    }

    @Override
    public Iterator<T> inOrderIterator() {
        List<T> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return values.iterator();
    }

    private void inOrderTraversal(Node node, List<T> values) {
        if (node != null) {
            inOrderTraversal(node.left, values);
            values.add(node.value);
            inOrderTraversal(node.right, values);
        }
    }

    @Override
    public Iterator<T> preOrderIterator() {
        List<T> values = new ArrayList<>();
        preOrderTraversal(root, values);
        return values.iterator();
    }

    private void preOrderTraversal(Node node, List<T> values) {
        if (node != null) {
            values.add(node.value);
            preOrderTraversal(node.left, values);
            preOrderTraversal(node.right, values);
        }
    }

    @Override
    public Iterator<T> postOrderIterator() {
        List<T> values = new ArrayList<>();
        postOrderTraversal(root, values);
        return values.iterator();
    }

    private void postOrderTraversal(Node node, List<T> values) {
        if (node != null) {
            postOrderTraversal(node.left, values);
            postOrderTraversal(node.right, values);
            values.add(node.value);
        }
    }
}
