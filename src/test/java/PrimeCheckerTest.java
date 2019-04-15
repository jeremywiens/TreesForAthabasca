/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class PrimeCheckerTest {
    @Test
    public void test() {

        PrimeChecker checker = new PrimeChecker();

        assertTrue(checker.isPrime(2));
        assertTrue(checker.isPrime(3));
        assertTrue(checker.isPrime(5));
        assertTrue(checker.isPrime(7));
        assertTrue(checker.isPrime(11));
        assertTrue(checker.isPrime(79));
        assertTrue(checker.isPrime(97));
        assertTrue(checker.isPrime(9931));

        assertFalse(checker.isPrime(0));
        assertFalse(checker.isPrime(1));
        assertFalse(checker.isPrime(4));
        assertFalse(checker.isPrime(12));
        assertFalse(checker.isPrime(333));
        assertFalse(checker.isPrime(4617));
    }

    @Test
    public void test1(){

        PrimeChecker checker = new PrimeChecker();

        assertEquals(2, checker.findNextPrime(-5));
        assertEquals(5, checker.findNextPrime(3));
        assertEquals(11, checker.findNextPrime(7));
        assertEquals(11, checker.findNextPrime(10));
        assertEquals(179, checker.findNextPrime(173));
        assertEquals(977, checker.findNextPrime(975));
    }
}