/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/** Testing for question 5 */
public class OrderedTreeTest {
    @Test
    public void test(){
        OrderedBinaryTree tree = new OrderedBinaryTree();

        tree.postOrderNumber();
        tree.preOrderNumber();
        tree.inOrderNumber();

        Node n1 = tree.add(1);

        // Basic testing
        try{
            n1.getPostOrder();
        } catch(Exception e){
            assertEquals("java.lang.NullPointerException", e.toString());
        }

        assertEquals(0, n1.getInOrder());

        tree.postOrderNumber();
        tree.preOrderNumber();
        tree.inOrderNumber();

        assertEquals(0, n1.getPostOrder());
        assertEquals(0, n1.getInOrder());
        assertEquals(0, n1.getPreOrder());
    }

    @Test
    public void test1(){
        OrderedBinaryTree tree = new OrderedBinaryTree();
        Node n1 = tree.add(1);
        Node n2 = tree.add(2);
        Node n3 = tree.add(3);

        tree.preOrderNumber();
        tree.postOrderNumber();
        tree.inOrderNumber();

        // Simple tree testing of ordering
        assertEquals(0, n1.getInOrder());
        assertEquals(2, n1.getPostOrder());
        assertEquals(0, n1.getPreOrder());

        assertEquals(2, n3.getInOrder());
        assertEquals(0, n3.getPostOrder());
        assertEquals(2, n3.getPreOrder());
    }

    @Test
    public void test2() {
        OrderedBinaryTree tree = new OrderedBinaryTree();

        Node node1 = tree.add(12);
        tree.add(7);
        tree.add(20);
        tree.add(3);
        tree.add(9);
        Node node2 =  tree.add(18);
        tree.add(25);
        tree.add(26);
        tree.add(22);
        tree.add(10);
        tree.add(15);
        tree.add(8);

        tree.preOrderNumber();
        tree.postOrderNumber();
        tree.inOrderNumber();

        // Complex tree testing
        assertEquals(6, node2.getPostOrder());
        assertEquals(7, node2.getPreOrder());
        assertEquals(7, node2.getInOrder());

        assertEquals(11, node1.getPostOrder());
        assertEquals(0, node1.getPreOrder());
        assertEquals(5, node1.getInOrder());
    }

    @Test
    public void test3() {
        OrderedBinaryTree tree = new OrderedBinaryTree();
        Node n1 = tree.add(6);
        Node n2 = tree.add(4);
        Node n3 = tree.add(8);
        Node n4 = tree.add(3);
        Node n5 = tree.add(5);
        Node n6 = tree.add(7);
        Node n7 = tree.add(9);

        tree.preOrderNumber();
        tree.postOrderNumber();
        tree.inOrderNumber();

        // Complex tree testing
        List<Integer> listNode1 = List.of(n1.getInOrder(), n1.getPreOrder(), n1.getPostOrder());
        List<Integer> listAns1 = List.of(3, 0, 6);
        assertEquals(listAns1, listNode1);

        List<Integer> listNode2 = List.of(n2.getInOrder(), n2.getPreOrder(), n2.getPostOrder());
        List<Integer> listAns2 = List.of(1, 1, 2);
        assertEquals(listAns2, listNode2);

        List<Integer> listNode3 = List.of(n3.getInOrder(), n3.getPreOrder(), n3.getPostOrder());
        List<Integer> listAns3 = List.of(5, 4, 5);
        assertEquals(listAns3, listNode3);

        List<Integer> listNode4 = List.of(n4.getInOrder(), n4.getPreOrder(), n4.getPostOrder());
        List<Integer> listAns4 = List.of(0, 2, 0);
        assertEquals(listAns4, listNode4);

        List<Integer> listNode5 = List.of(n5.getInOrder(), n5.getPreOrder(), n5.getPostOrder());
        List<Integer> listAns5 = List.of(2, 3, 1);
        assertEquals(listAns5, listNode5);

        List<Integer> listNode6 = List.of(n6.getInOrder(), n6.getPreOrder(), n6.getPostOrder());
        List<Integer> listAns6 = List.of(4, 5, 3);
        assertEquals(listAns6, listNode6);

        List<Integer> listNode7 = List.of(n7.getInOrder(), n7.getPreOrder(), n7.getPostOrder());
        List<Integer> listAns7 = List.of(6, 6, 4);
        assertEquals(listAns7, listNode7);
    }
}