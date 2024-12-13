

import java.util.Iterator;

import java.util.Collection;

public interface BinaryTree {
    int size(); // Number of nodes
    boolean isEmpty();  // True if the tree is empty
    Iterator elementsInOrder(); // Iterator of elements 
    Iterator elementsPreOrder();  
    Iterator elementsPostOrder();   
    Iterator nodesInOrder();    // Iterator of nodes
    Iterator nodesPreOrder();
    Iterator nodesPostOrder();
    BinaryNode root();  // Returns the root of the tree
    BinaryNode parent(BinaryNode node); // Returns the parent of a node
    Collection children(BinaryNode node);   // Returns the children of a node
    boolean isInternal(BinaryNode node);    // True if the node is internal
    boolean isExternal(BinaryNode node);    // True if the node is external
    boolean isRoot(BinaryNode node);    // True if the node is the root
    BinaryNode left(BinaryNode node);      // Returns the left child of a node
    BinaryNode right(BinaryNode node);   // Returns the right child of a node
    boolean hasLeft(BinaryNode node);   // True if the node has a left child
    boolean hasRight(BinaryNode node);  // True if the node has a right child
}
