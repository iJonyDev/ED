public interface BinarySearchTree extends BinaryTree {
    void addElement(Object element); 
    Object removeElement(Object element);
    void removeAllOcurrences(Object element);
    Object removeMin();
    Object removeMax();
    Object findMin();
    Object findMax();
    boolean find(Object elementToFind);
}