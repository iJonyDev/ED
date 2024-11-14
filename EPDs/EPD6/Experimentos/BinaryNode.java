package Experimentos;

public class BinaryNode { 
    Object element; // Element contained in the node
    BinaryNode left;    // Left child
    BinaryNode right;   // Right child

    public BinaryNode(Object ele) { 
        this.element = ele; // Element contained in the node    
        this.left = null; 
        this.right = null;
    }

    public BinaryNode(Object ele, BinaryNode l, BinaryNode r) {
        this.element = ele; // Element contained in the node
        this.left = l;    // Left child
        this.right = r;  // Right child
    }
}
