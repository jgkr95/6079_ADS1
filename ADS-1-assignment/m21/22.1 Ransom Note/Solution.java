import java.util.Scanner;
/**
 * Class for separate chaining hash st.
 */
class SeparateChainingHashST {
    /**
     * Capacity of the symbol table.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs.
     */
    private int n;
    /**
     * hash table size.
     */
    private int m;
    /**
     * array of linked-list symbol tables.
     */
    private SequentialSearchST<String, Integer>[] st;
    /**
     * Initializes an empty symbol table.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      m1    The m 1
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<String, Integer>[]) new SequentialSearchST[m1];
        for (int i = 0; i < m1; i++) {
            st[i] = new SequentialSearchST<String, Integer>();
        }
    }
    /**
     * Function to generate hash value to given key.
     *
     * @param      key   The key
     *
     * @return     { Generated hash value }
     * Time complexity is O(1)
     */
    private int hash(final String key) {
        final int data = 0x7fffffff;
        return (key.hashCode() & data) % m;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * Complexity of the function is 1.
     *
     * @return the number of key-value pairs in this symbol table
     * Time complexity is O(1)
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     * Complexity is 1.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     * Time complexity is O(1)
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * Time complexity is O(1)
     */
    public boolean contains(final String key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * Time complexity is O(1)
     */
    public Integer get(final String key) {
        int i = hash(key);
        return st[i].get(key);
    }

    /**.
     * Inserts the specified key-value pair into
     * the symbol table,overwriting the old
     * value with the new value if the symbol
     * table already contains the specified key.
     * Deletes the specified key (and its
     * associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * Time complexity is O(1)
     */
    public void put(final String key, final Integer val) {
        if (val == null) {
            delete(key);
            return;
        }

        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }

    /**.
     * Removes the specified key and its
     * associated value from this symbol table
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * 
     */
    public void delete(final String key) {
        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * Checks the if the string can be formed from the
     * given words in the magazine.
     *
     * @param      st     { Hash table object }
     * @param      n      { Length of the string }
     * @param      notes  The notes
     *
     * @return     { Yes or No based on the strings. }
     * Time complexity is O(N)
     */
    public static String check(final SeparateChainingHashST st,
        final int n, final String[] notes) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer p = st.get(notes[i]);
            if (p == null || p == 0) {
                return "No";
            }
            st.put(notes[i], --p);
        }
        return "Yes";
    }

    /**
     * Main method to handle the input.
     *
     * @param      args  The arguments are of String array type.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SeparateChainingHashST st = new SeparateChainingHashST();
        String[] num = sc.nextLine().split(" ");
        int m = Integer.parseInt(num[0]);
        int n = Integer.parseInt(num[1]);
        while (sc.hasNextLine()) {
            String[] magazine = sc.nextLine().split(" ");
            st = new SeparateChainingHashST(magazine.length);
            for (int i = 0; i < m; i++) {
                if (st.contains(magazine[i])) {
                    int val = st.get(magazine[i]);
                    st.put(magazine[i], ++val);
                } else {
                    st.put(magazine[i], 1);
                }
            }
            String[] str = sc.nextLine().split(" ");
            System.out.println(check(st, n, str));
        }
    }
}
