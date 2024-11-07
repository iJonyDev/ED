package Experimentos;

public class generateRootTree {
    public static void main(String[] args) throws Exception {
        BinaryNode root  = new BinaryNode("A");
        BinaryNode node1 = new BinaryNode("B1");
        BinaryNode node2 = new BinaryNode("B2");
        BinaryNode node3 = new BinaryNode("C11");
        BinaryNode node4 = new BinaryNode("C21");
        BinaryNode node5 = new BinaryNode("C22");
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        }
}
