/*
  Author: Jeremy Wiens
  Date: April. 1, 2019
  Assignment #2 (Comp 272 - Athabasca University)

  Answer for question 2 is shown below, see method: isOrdered()
 */

/**
 * This is a reduced version of a Binary tree. This class only contains methods to
 * add to the tree (which add elements in order) and a method to ensure that
 * the tree is in an ordered state.
 */
public class BinaryTree {

    // Keeps track of number of elements in the tree
    protected int size;
    // The root of the tree, all elements can be accessed starting at the root
    protected Node root;

    /**
     * Create an empty binary tree
     */
    public BinaryTree(){
        root = null;
        size = 0;
    }

    /**
     * From https://www.baeldung.com/java-binary-tree
     *
     * Consumes a raw integer, creates a node, and adds this node to the binary
     * tree in order.
     *
     * @param value The number to be added to the binary tree
     * @return the created node
     */
    public Node add(int value) {
        Node node = new Node(value);
        size++;
        root = addRecursive(root, node);
        return node;
    }

    /**
     * From https://www.baeldung.com/java-binary-tree
     *
     * Recursively add the node to the binary tree.
     *
     * @param current is the node to compare with. If the given node is greater that current,
     *                the given node will be added to the left, if it is less, the given node
     *                will be added to the left of current.
     * @param node    the node to be added to the binary tree.
     * @return        return current, unless current is null, then return the given node.
     */
    private Node addRecursive(Node current, Node node) {
        int value = node.getData();

        if (current == null) return node;

        if (value < current.getData()) {
            current.setLeft(addRecursive(current.getLeft(), node));
        } else if (value > current.getData()) {
            current.setRight(addRecursive(current.getRight(), node));
        } else {
            // value already exists
            size--;
            return current;
        }
        return current;
    }

    /**
     * Check if for each node, the child to the left has a lower value, and the child to the
     * right has a greater value.
     *
     * @return whether or not the binary tree meets the ordering requirements
     */
    public boolean isOrdered(){return isOrdered(root, Integer.MIN_VALUE, Integer.MAX_VALUE);}

    /**
     * Recursively check each node, that it matches the ordering requirements all the way down the tree.
     *
     * @param x   The current node to check
     * @param min The minimum number this node can be
     * @param max The maximum number this node can be
     * @return    whether or not this node and all of its children meet the ordering requirements.
     */
    private boolean isOrdered(Node x, int min, int max) {
        if ( x == null) {
            return true;
        }
        if (x.getData() < min || x.getData() > max) {
            return false;
        }

        return (isOrdered(x.getLeft(), min, x.getData() - 1)
                && isOrdered(x.getRight(), x.getData() + 1, max));
    }
}
