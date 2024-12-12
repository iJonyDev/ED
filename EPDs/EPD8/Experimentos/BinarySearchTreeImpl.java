import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTreeImpl implements BinarySearchTree {
    private BinaryNode root;
    private Comparator<Object> comparator;

    public BinarySearchTreeImpl(Comparator<Object> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    @Override
    public void addElement(Object element) {
        root = addRecursive(root, element);
    }

    private BinaryNode addRecursive(BinaryNode node, Object element) {
        if (node == null) {
            return new BinaryNode(element);
        }

        if (comparator.compare(element, node.getElement()) < 0) {
            node.left = addRecursive(node.left, element);
        } else if (comparator.compare(element, node.getElement()) > 0) {
            node.right = addRecursive(node.right, element);
        }

        return node;
    }

    @Override
    public Object removeElement(Object element) {
        root = removeRecursive(root, element);
        return element;
    }

    private BinaryNode removeRecursive(BinaryNode node, Object element) {
        if (node == null) {
            return null;
        }

        if (comparator.compare(element, node.getElement()) < 0) {
            node.left = removeRecursive(node.left, element);
        } else if (comparator.compare(element, node.getElement()) > 0) {
            node.right = removeRecursive(node.right, element);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.element = findMin(node.right);
            node.right = removeRecursive(node.right, node.getElement());
        }

        return node;
    }

    @Override
    public void removeAllOcurrences(Object element) {
        while (find(element)) {
            removeElement(element);
        }
    }

    @Override
    public Object removeMin() {
        if (root == null) {
            return null;
        }
        Object min = findMin(root);
        root = removeRecursive(root, min);
        return min;
    }

    @Override
    public Object removeMax() {
        if (root == null) {
            return null;
        }
        Object max = findMax(root);
        root = removeRecursive(root, max);
        return max;
    }

    @Override
    public Object findMin() {
        if (root == null) {
            return null;
        }
        return findMin(root);
    }

    private Object findMin(BinaryNode node) {
        return node.left == null ? node.getElement() : findMin(node.left);
    }

    @Override
    public Object findMax() {
        if (root == null) {
            return null;
        }
        return findMax(root);
    }

    private Object findMax(BinaryNode node) {
        return node.right == null ? node.getElement() : findMax(node.right);
    }

    @Override
    public boolean find(Object elementToFind) {
        return findRecursive(root, elementToFind);
    }

    private boolean findRecursive(BinaryNode node, Object elementToFind) {
        if (node == null) {
            return false;
        }

        if (comparator.compare(elementToFind, node.getElement()) == 0) {
            return true;
        }

        return comparator.compare(elementToFind, node.getElement()) < 0
                ? findRecursive(node.left, elementToFind)
                : findRecursive(node.right, elementToFind);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator elementsInOrder() {
        List<Object> elements = new ArrayList<>();
        inOrderTraversal(root, elements);
        return elements.iterator();
    }

    private void inOrderTraversal(BinaryNode node, List<Object> elements) {
        if (node != null) {
            inOrderTraversal(node.left, elements);
            elements.add(node.getElement());
            inOrderTraversal(node.right, elements);
        }
    }

    @Override
    public Iterator elementsPreOrder() {
        List<Object> elements = new ArrayList<>();
        preOrderTraversal(root, elements);
        return elements.iterator();
    }

    private void preOrderTraversal(BinaryNode node, List<Object> elements) {
        if (node != null) {
            elements.add(node.getElement());
            preOrderTraversal(node.left, elements);
            preOrderTraversal(node.right, elements);
        }
    }

    @Override
    public Iterator elementsPostOrder() {
        List<Object> elements = new ArrayList<>();
        postOrderTraversal(root, elements);
        return elements.iterator();
    }

    private void postOrderTraversal(BinaryNode node, List<Object> elements) {
        if (node != null) {
            postOrderTraversal(node.left, elements);
            postOrderTraversal(node.right, elements);
            elements.add(node.getElement());
        }
    }

    @Override
    public int size() {
        return sizeRecursive(root);
    }

    @Override
    public Iterator nodesInOrder() {

    }

    @Override
    public Iterator nodesPreOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nodesPreOrder'");
    }

    @Override
    public Iterator nodesPostOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nodesPostOrder'");
    }

    @Override
    public Experimentos.BinaryNode root() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'root'");
    }

    @Override
    public Experimentos.BinaryNode parent(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parent'");
    }

    @Override
    public Collection children(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'children'");
    }

    @Override
    public boolean isInternal(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInternal'");
    }

    @Override
    public boolean isExternal(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExternal'");
    }

    @Override
    public boolean isRoot(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRoot'");
    }

    @Override
    public Experimentos.BinaryNode left(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'left'");
    }

    @Override
    public Experimentos.BinaryNode right(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'right'");
    }

    @Override
    public boolean hasLeft(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasLeft'");
    }

    @Override
    public boolean hasRight(Experimentos.BinaryNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasRight'");
    }
}