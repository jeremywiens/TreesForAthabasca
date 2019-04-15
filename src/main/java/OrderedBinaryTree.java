/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)

 This class is answers question 5 in the below methods.
 */

/**
 * OrderedBinaryTree extends Binary tree with functionality to assign the ordering of each node in the tree.
 */
public class OrderedBinaryTree extends BinaryTree {

    // Used to keep track of the current number for each kind of ordering
    protected int count = 0;

    /**
     * Create an empty OrderedBinaryTree
     */
    public OrderedBinaryTree(){
        super();
    }

    /**
     * Assign the numbers of ordering to each node in the tree according to the in-Order definition
     */
    public void inOrderNumber(){
        count = 0;
        if(root != null){
        inOrder(root);
        }
    }

    /**
     * Recursively order numbers starting at Node x according to the in-Order definition
     * @param x node to start ordering at
     */
    protected void inOrder(Node x){

        if(x.getLeft() != null)
            inOrder(x.getLeft());

        x.setInOrder(count++);

        if(x.getRight() != null)
            inOrder(x.getRight());

        return;

    }

    /**
     * Assign the numbers of ordering to each node in the tree according to the pre-Order definition
     */
    public void preOrderNumber(){
        count = 0;
        if(root != null) {
            preOrder(root);
        }
    }

    /**
     * Recursively order numbers starting at Node x according to the pre-Order definition
     * @param x node to start ordering at
     */
    protected void preOrder(Node x){

        x.setPreOrder(count++);

        if(x.getLeft() != null)
            preOrder(x.getLeft());

        if(x.getRight() != null)
            preOrder(x.getRight());

        return;
    }

    /**
     * Assign the numbers of ordering to each node in the tree according to the post-Order definition
     */
    public void postOrderNumber(){
        count = 0;
        if(root != null) {
            postOrder(root);
        }
    }

    /**
     * Recursively order numbers starting at Node x according to the post-Order definition
     * @param x node to start ordering at
     */
    protected void postOrder(Node x){
        if(x.getLeft() != null)
            postOrder(x.getLeft());

        if(x.getRight() != null)
            postOrder(x.getRight());

        x.setPostOrder(count++);
    }
}
