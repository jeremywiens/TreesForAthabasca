/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
  */

/**
 * Class to find prime numbers and to check that numbers are indeed prime
 */
public class PrimeChecker {

    /**
     * Create a prime checker
     */
    public PrimeChecker(){}

    /**
     * Algorithm found on https://en.wikipedia.org/wiki/AKS_primality_test
     *
     * @param x integer to check
     * @return whether or not the given integer is prime
     */
    public boolean isPrime(int x) {
        if(x < 2) return false;
        if(x < 4) return true;
        if(x % 2 == 0 || x % 3 == 0) return false;

        int i = 5;
        int j = 2;

        while(i * i <= x){
            if(x % i == 0) return false;
            i += j;
            j = 6 - j;
        }

        return true;
    }

    /**
     * @param x number to find prime number after
     * @return return the first prime number after x
     */
    public int findNextPrime(int x) {
        int temp = x;
        while(true){
            temp++;
            if(this.isPrime(temp)) return temp;
        }
    }
}
