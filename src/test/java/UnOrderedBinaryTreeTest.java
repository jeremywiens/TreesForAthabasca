/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
 */

import static org.junit.Assert.*;
import org.junit.Test;

/** Testing for question 1 */
public class UnOrderedBinaryTreeTest {
    @Test
    public void test(){
        // Basic tree functionality
        UnOrderedBinaryTree tree = new UnOrderedBinaryTree();

        tree.add(12);

        assertTrue(tree.isOrdered());

        tree.add(7);
        tree.add(12);
        assertFalse(tree.isOrdered()); //Can't be ordered because contains same node twice
    }

    @Test
    public void test1(){

        // Complex tree with nodes hardcoded for deterministic testing
        UnOrderedBinaryTree tree = new UnOrderedBinaryTree();
        Node node1 = tree.add(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 =  new Node(5);
        Node node6 =  new Node(6);
        Node node7 = new Node(7);
        Node node8 =  new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        tree.size = 10;

        node1.setParent(null);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setParent(node1);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setParent(node1);
        node3.setLeft(node9);
        node3.setRight(node4);
        node4.setParent(node3);
        node5.setParent(node2);
        node5.setLeft(node7);
        node5.setRight(node8);
        node6.setParent(node2);
        node7.setParent(node5);
        node8.setParent(node5);
        node9.setParent(node3);
        node9.setLeft(node10);
        node10.setParent(node9);

        tree.inOrderNumber();
        tree.preOrderNumber();
        tree.postOrderNumber();

        assertEquals(tree.preOrderNext(node1), node2);
        assertEquals(tree.preOrderNext(node3), node9);
        assertEquals(tree.preOrderNext(node8), node6);
        assertEquals(tree.preOrderNext(node7), node8);
        assertEquals(tree.preOrderNext(node9), node10);
        assertNull(tree.preOrderNext(node4));



        assertEquals(tree.postOrderNext(node7), node8);
        assertEquals(tree.postOrderNext(node2), node10);
        assertEquals(tree.postOrderNext(node10), node9);
        assertEquals(tree.postOrderNext(node8), node5);
        assertNull(tree.postOrderNext(node1));

        assertEquals(tree.inOrderNext(node3), node4);
        assertEquals(tree.inOrderNext(node2), node6);
        assertEquals(tree.inOrderNext(node7), node5);
        assertEquals(tree.inOrderNext(node10), node9);
        assertEquals(tree.inOrderNext(node6), node1);
        assertNull(tree.inOrderNext(node4));
    }
}
