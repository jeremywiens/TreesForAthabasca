/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
 */

import static org.junit.Assert.*;
import org.junit.Test;

/**Testing for question 4 */
public class HashTableTest {
    @Test
    public void test() {
        HashTable<Integer> table = new HashTable( 10);
        table.add(22);
        assertTrue( table.contains(22));
        table.add(9);
        table.add(43);
        table.add(32);
        table.add(65);
        table.add(54);
        table.add(59);

        //Test basic functionality of finding and adding
        assertTrue(table.contains(22));
        assertTrue(table.contains(43));
        assertTrue(table.contains(54));
        assertTrue(table.contains(59));
        assertFalse(table.contains(66));


        //Test that remove works
        assertEquals((Integer) 59, table.remove(59));
        //Element is actually removed
        assertFalse(table.contains(59));

        //Null return if element does not exist
        assertNull(table.remove(0));

        //Can add element where there once was one.
        assertTrue(table.add(0));
        assertFalse(table.add(0));
        assertTrue(table.contains(0));

        //After removing where element should be, can still find.
        table.add(2);
        table.remove(22);
       assertTrue(table.contains(2));

        //Cannot add element that exists in table
        assertFalse(table.add(2));

        //Remove 2
        assertEquals((Integer) 2, table.remove(2));

    }

    @Test
    public void test2() {

        Integer[] numArr = new Integer[]{1, 5, 21,
                26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146};

        HashTable<Integer> table = new HashTable(13);
        for(Integer i: numArr){
            table.add(i);
        }

        assertEquals("[111, 1, 39, 5, 14, 15, 16, 17, 18, 19, 20, 21, 26, 145, 146]", table.toString());
    }

    /** Illustrate example in question with constant hashing function of K mod 13 */
    @Test
    public void test3() {
        HashTable<Integer> table = new HashTable(13, false); //Do not resize table

        table.add(1);
        assertEquals("[1]", table.toString());
        table.add(5);
        assertEquals("[1, 5]", table.toString());
        table.add(21);
        assertEquals("[1, 5, 21]", table.toString());
        table.add(26);
        table.add(39);
        table.add(14);
        assertEquals("[26, 1, 39, 14, 5, 21]", table.toString());
        table.add(15);
        table.add(16);
        assertEquals("[26, 1, 39, 14, 15, 5, 16, 21]", table.toString());
        table.add(17);
        table.add(18);
        table.add(19);
        assertEquals("[26, 1, 39, 14, 15, 5, 16, 17, 21, 18, 19]", table.toString());
        table.add(20);
        table.add(111);
        assertEquals("[26, 1, 39, 14, 15, 5, 16, 17, 21, 18, 19, 20, 111]", table.toString());

        assertFalse(table.add(145));
        assertFalse(table.add(146));

        assertEquals("[26, 1, 39, 14, 15, 5, 16, 17, 21, 18, 19, 20, 111]", table.toString());
    }
}
