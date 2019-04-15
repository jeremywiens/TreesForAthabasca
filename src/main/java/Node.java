/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
 */

/**
 * A super class for all different types of nodes. Fields are null until specified. Data stored must be of type int.
 */
public class Node {

    // Immutable data of the node
    private int data;
    // The right child of this node
    private Node right;
    // The left child of this node
    private Node left;

    // If the node is in an OrderedBinaryTree, this is the number of the node when traversing the tree in order.
    private int inOrder;
    // If the node is in an OrderedBinaryTree, this is the number of the node when traversing the tree in pre-order.
    private int postOrder;
    // If the node is in an OrderedBinaryTree, this is the number of the node when traversing the tree in post-order.
    private int preOrder;

    // Used in the UnOrderedBinaryTree, this field stores the parent of this node
    private Node parent;

    /**
     * Create a node with all fields empty or null, except the data given below.
     * @param data the data stored in the node
     */
    public Node(int data){
        this.data = data;
        right = null;
        left = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }

    // Getters and setters

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getInOrder() {
        return inOrder;
    }

    public void setInOrder(int inOrder) {
        this.inOrder = inOrder;
    }

    public int getPostOrder() {
        return postOrder;
    }

    public void setPostOrder(int postOrder) {
        this.postOrder = postOrder;
    }

    public int getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(int preOrder) {
        this.preOrder = preOrder;
    }

    public int getData() {
        return data;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
