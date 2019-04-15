/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)

 Answer for question 4, linear probing can be used with a hashing function of
 K mod 13 if table is constructed with HashTable(13, false)
 */

/**
 * A hash table of type T, uses linear probing to handle conflicts.
 *
 * @param <T> element type of hashTable
 */
public class HashTable<T> {

    // All elements in the table
    private Option<T>[] table;
    // The number of elements in the table, not likely equal to table.length
    private int size = 0;
    // The exponent related to the size of the table
    private int lengthExp;
    // The number of defined elements in the table
    private int nonNull = 0;
    // Helper to find prime numbers for sizing the table
    private PrimeChecker prime = new PrimeChecker();
    // Boolean only to be turned off is user would not like dynamic resizing of table
    private boolean resize = true;
    // The minimum size of the table in order to be resized
    private final int MIN_SIZE = 30;

    /**
     * Create an empty hash table with a user defined table size
     *
     * @param size the initial size of the table
     */
    public HashTable(int size){
        newTable(size);
    }

    /**
     * Create an empty hash table with a user defined table size, and specify if the table
     * should not be resized
     *
     * @param size   The intitial size of the table
     * @param resize if false, the table will not be resized
     */
    public HashTable(int size, boolean resize){
        this.resize = resize;
        newTable(size);
    }

    /**
     * Creates an empty hash table
     */
    public HashTable(){
        lengthExp = 3;
        int len = prime.findNextPrime(1 << lengthExp);
        newTable(len);
    }
    /**
     * The actual creation of the table, Options used to keep track of deleted elements
     * @param size size of the table
     */
    private void newTable(int size){
        @SuppressWarnings("unchecked")
        Option<T> obj[] = new Option[size];
        table = obj;
    }

    /**
     * @param val the element to check
     * @return whether or not the element val exists in the hash table
     */
    public boolean contains(T val) {return find(val) != null;}

    /**
     * Add an element to the hash table in amortized constant time
     *
     * @param val the element to be added
     * @return true if the element was added, false if it was not added (already exists or table is too full).
     */
    public boolean add(T val){
        if(find(val) != null) return false;

        if(2*(nonNull + 1) > table.length) resize();

        int idx = hash(val) % table.length;

        while(table[idx] != null && table[idx].isDefined()){
            idx = (idx == table.length - 1) ? 0: idx + 1;
        }
        if(table[idx] == null) nonNull++;
        size++;

        table[idx] = new Option(val);

        return true;
    }

    /**
     * Remove the given element from the table, if it exists, and in amortized constant time
     *
     * @param val the element to remove
     * @return the element removed, or null if no such element exists.
     */
    public T remove(T val){

        int idx = hash(val) % table.length;
        while(table[idx] != null){
            Option<T> cVal = table[idx];
            if(cVal.isDefined() && cVal.get().equals(val)){
                table[idx] = new Option();
                size--;
                if(8*size < table.length && table.length > MIN_SIZE) resize(); // Only decrease size of table if relatively large
                return cVal.get();
            }
            idx = (idx == table.length - 1) ? 0: idx + 1;
        }
        return null;
    }

    /** Resize the table to the next biggest or smallest prime number */
    private void resize() {
        if(resize) {
            lengthExp = 1;
            while ((1 << lengthExp) < 3 * size) lengthExp++;
            Option<T>[] oldTable = table;
            newTable(prime.findNextPrime(1 << lengthExp));
            nonNull = size;

            for (Option<T> i : oldTable) {
                if (i != null && i.isDefined()) {
                    int idx = hash(i.get()) % table.length;
                    while (table[idx] != null) {
                        idx = (idx == table.length - 1) ? 0 : idx + 1;
                    }
                    table[idx] = i;
                }
            }
        }
    }

    /**
     * Find the index for the given given element in the table
     *
     * @param value the value to find in the table
     * @return the index it exits in the table, or null if it does not exist
     */
    private Integer find(T value){

        int tempVal = hash(value) % table.length;
        int count = table.length;

        while(table[tempVal] != null){
            if(table[tempVal].isDefined() && value.equals(table[tempVal].get())) return tempVal;
            tempVal = (tempVal == table.length -1) ? 0 : tempVal + 1;
            if(count-- < 0) return -1;
        }
        return null;
    }

    @Override
    public String toString(){
        String table = "[";

        for(Option<T> i:this.table){
            if(i!= null && i.isDefined()) table += i.get().toString() + ", ";
        }
        return table.substring(0, table.length()-2) + "]";
    }

    /**
     * @param v find the hash of this value
     * @return the integer hashCode of v
     */
    private int hash(T v){
        return v.hashCode();
    }
}
