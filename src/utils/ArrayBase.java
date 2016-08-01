package utils;

/**
 * @param <T>
 */
public class ArrayBase<T> {
    public int size = 0;
    public T[] array;

    /**
     * Constructor
     */
    ArrayBase() {
        this.newArray();
    }

    /**
     * Enlarges array
     */
    protected void enlarge() {
        T[] old = this.array;

        this.newArray(this.array.length + 10);

        for (int i = 0; i <= old.length; i++) {
            this.array[i] = old[i];
        }
    }

    /**
     * returns true if empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * returns true if full
     *
     * @return boolean
     */
    public boolean isFull() {
        return this.size == this.array.length;
    }

    /**
     * returns size
     *
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * creates a new array of size 10
     */
    protected void newArray() {
        this.newArray(10);
    }

    /**
     * creates a new array of a certain size
     *
     * @param new_size int
     */
    protected void newArray( int new_size) {
        this.array = (T[]) new Object[new_size];
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String val = "ArrayBase{" +
                "array={";

        for (int i = 0; i < this.size(); i++) {
            val += this.array[i];
            if (i != this.size() - 1) val += " ";
        }

        val += "}, size=" + size + "}";

        return val;
    }
}
