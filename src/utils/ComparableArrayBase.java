package utils;

/**
 * @param <T>
 */
public class ComparableArrayBase<T extends Comparable<T>> extends ArrayBase<T> {
    /**
     * creates a new array of a certain size
     *
     * @param new_size int
     */
    public void newArray(int new_size) {
        this.array =  (T[]) new Comparable[new_size];
    }
}
