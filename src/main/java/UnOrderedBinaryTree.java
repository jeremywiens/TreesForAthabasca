/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)

 This class answers question 1 in the methods below.
  */
import java.util.Random;

/**
 * UnOrderedBinaryTree extends OrderedBinaryTree with a new add method adding nodes in a random order,
 * also has functionality that when given nodeX, find the next preOder, postOrder or inOrder node
 */
public class UnOrderedBinaryTree extends OrderedBinaryTree {

    // Used to randomly select how nodes are added to the tree
    private Random random;

    /**
     * Create an empty UnOrderedBinaryTree
     */
    public UnOrderedBinaryTree(){
        super();
        random = new Random();
    }

    /**
     * Add a node to the binary tree
     *
     * @param value integer value of the node
     * @return the created node from the given value
     */
    public Node add(int value) {
        Node node = new Node(value);
        node.setParent(null);
        addRandom(node);
        return node;
    }

    /**
     * Add the node to the binary tree
     *
     * @param node the node to be added to the tree
     * @return the given node
     */
    public Node add(Node node){
        addRandom(node);
        return node;
    }

    /**
     * add the given node randomly to the binary tree
     * @param node node to be added
     */
    private void addRandom(Node node){
        if(size == 0){
            size++;
            root = node;
            return;
        }

        size++;
        Node current = root;

        while(node.getParent() == null){ // Iterate till the nodes parent is defined
            if(random.nextBoolean()){ //Traverse to the left
                if(current.getLeft() == null){
                    current.setLeft(node);
                    node.setParent(current);
                } else {
                    current = current.getLeft();
                }

            } else { // Traverse to the right
                if(current.getRight() == null){
                    current.setRight(node);
                    node.setParent(current);
                } else {
                    current = current.getRight();
                }
            }
        }
    }

    /**
     * @param x node to start search from
     * @return the node after x according to pre-Ordering
     */
    public Node preOrderNext(Node x){

        if(x.getLeft() != null){
            return x.getLeft();
        } else {
            Node parent = x.getParent();
            if(parent == null) return null;
            if(x == parent.getLeft()){
                while(parent != null && parent.getRight() == null) parent = parent.getParent();
                if(parent == null) return null;
                return parent.getRight();
            } else {
                Node temp = parent;
                parent = parent.getParent();
                while(parent != null && temp != parent.getLeft()){ // while temp is not left child of parent
                    temp = parent;
                    parent = parent.getParent();
                }
                if(parent == null) return null;
                return parent.getRight();
            }
        }
    }

    /**
     * @param x node to start search from
     * @return the node after x according to post-Ordering
     */
    public Node postOrderNext(Node x){

        Node parent = x.getParent();

        if(parent == null) return null;

        if(parent.getRight() == null || x == parent.getRight()) return parent;
        Node temp = parent.getRight();

        while(temp.getLeft() != null || temp.getRight() != null) { //Go left as far as possible and right if necessary
            while (temp.getLeft() != null) temp = temp.getLeft();
            if(temp.getRight() != null) temp = temp.getRight();
        }
        return temp;
    }

    /**
     * @param x node to start search from
     * @return the node after x according to in-Ordering
     */
    public Node inOrderNext(Node x){

        if(x.getRight() != null){
            Node temp = x.getRight();
            while(temp.getLeft() != null) temp = temp.getLeft();
            return temp;
        } else {
            Node parent = x.getParent();
            if(parent == null) return null;
            if(x == parent.getLeft()) return parent; // If x was left child, return x's parent
            Node temp = parent;
            parent = parent.getParent();
            while(parent != null && temp != parent.getLeft()){ // while temp is not left child of parent
                temp = parent;
                parent = parent.getParent();
            }
            return parent;
        }
    }
}
