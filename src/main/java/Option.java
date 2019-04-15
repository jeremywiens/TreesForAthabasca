/*
 Author: Jeremy Wiens
 Date: April. 1, 2019
 Assignment #2 (Comp 272 - Athabasca University)
 */

/**
 * This idea is borrowed from the Scala programming language. Used to differentiate deleted values, and empty
 * values in the Hash Table
 *
 * @param <T> the type of data stored in this option
 */
public class Option<T> {
    // Immutable data
    private T data;

    /**
     * Create a "None" (used as the deleted value)
     */
    public Option(){}

    /**
     * Create a defined option with the given data below. (Some(data))
     *
     * @param data the data stored in this option
     */
    public Option(T data){this.data = data;}

    /**
     * @return get the data from this option, of null if it is a None value
     */
    public T get(){return data;}

    /**
     * Check whether or not the data in the option is defined
     * @return true is the data is not null
     */
    public boolean isDefined(){ return data != null;}

    /**
     * Check whether or not the data in the option is defined
     * @return true is the data is null
     */
    public boolean isEmpty(){return data == null;}
}
