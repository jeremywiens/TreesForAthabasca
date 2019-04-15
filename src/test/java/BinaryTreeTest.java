/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
 */

import static org.junit.Assert.*;
import org.junit.Test;

/** Testing for question 2*/
public class BinaryTreeTest {
    @Test
    public void test(){
        BinaryTree tree = new BinaryTree();

        Node node1 = tree.add(12);
        tree.add(7);
        tree.add(9);
        Node node2 =  tree.add(18);
        tree.add(25);

        assertTrue(tree.isOrdered()); //This binary tree will add items in order

        node1.setLeft(node2); // This ordering can be manually overrided

        assertFalse(tree.isOrdered());
    }

    @Test
    public void test1() {
        BinaryTree tree = new BinaryTree();

        Node node1 = tree.add(12);
        tree.add(7);
        tree.add(20);
        tree.add(3);
        tree.add(9);
        tree.add(18);
        tree.add(25);
        tree.add(26);
        tree.add(22);
        tree.add(10);
        tree.add(15);
        tree.add(8);

        assertTrue(tree.isOrdered());
        tree.add(15);
        assertTrue(tree.isOrdered()); //Value is not added if it already exists in the tree
        node1.setLeft(new Node(15));
        assertFalse(tree.isOrdered());  // Manual override of tree ordering.
    }
}
