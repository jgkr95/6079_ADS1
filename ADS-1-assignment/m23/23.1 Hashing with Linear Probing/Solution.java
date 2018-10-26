import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**
     * Capacity value.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs in the symbol table.
     */
    private int n;
    /**
     * size of linear probing table.
     */
    private int m;
    /**
     * the keys.
     */
    private Key[] keys;
    /**
     * the values.
     */
    private Value[] vals;
    /**
     * Initializes an empty symbol table.
     */
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the size of keys
     * Time complexity is O(1)
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     * Time complexity is O(1)
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table.
     * contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol
     * table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * Time complexity is O(N)
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * hash function for keys that returns value between 0 and M-1.
     *
     * @param      key   The key
     *
     * @return     { hash value }
     * Time complexity is O(1)
     */
    private int hash(final Key key) {
        final int eleven = 11;
        return (eleven * key.hashCode()) % m;
    }


    /**
     * resizes the hash table to the given.
     * capacity by re-hashing all of the keys.     *
     *
     * @param      capacity  The capacity
     * Time complexity is O(N)
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp
        = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * Inserts the specified key-value pair into
     * the symbol table, overwriting the old
     * value with the new value if the symbol
     * table already contains the specified key.
     * Deletes the specified key (and its
     * associated value) from this symbol table
     * if the specified value is {@code null}
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * Time complexity is O(N) because of resize method
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        if (n >= m / 2) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null;
            i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * Time complexity is O(N)
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null;
            i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /**
     * Removes the specified key and its associated
     * value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * Time complexity is O(N)
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
        final int eight = 8;
        if (n > 0 && n <= m / eight) {
            resize(m / 2);
        }
    }

    /**
     * Returns all keys in this symbol
     * table as an {@code Iterable}.
     * To iterate over all of the keys
     * in the symbol table named {@code st},
     * use the foreach notation: {@code for
     * (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     * Time complexity is O(N)
     */
    public ArrayList<Key> keys() {
        ArrayList<Key> keyslist = new ArrayList<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                keyslist.add(keys[i]);
            }
        }
        return keyslist;
    }
    /**
     * Checks if the given element is present or not.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity is O(N)
     */
    public boolean check(final Key key) {
        if (key == null) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                if (key.equals(keys[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Display the values in a String.
     *
     * @return     { String of all values.}
     * Time complexity is O(N)
     */
    public String display() {
        if (size() == 0) {
            return "{}";
        }
        String str = "{";
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                str = str + keys[i] + ":"
                + get(keys[i]) + ", ";
            }
        }
        return str.substring(0, str.length() - 2) + "}";
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
    /**
     * Main function to handle the input.
     *
     * @param      args  The arguments are of String type
     * Time complexity of O(N)
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearProbingHashST<String, Integer> lpht
            = new LinearProbingHashST<String, Integer>();
        int n = Integer.parseInt(sc.nextLine());
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "put":
                lpht.put(input[1], Integer.parseInt(input[2]));
                break;
                case "get":
                System.out.println(lpht.get(input[1]));
                break;
                case "delete":
                lpht.delete(input[1]);
                break;
                case "display":
                System.out.println(lpht.display());
                break;
                default:
                break;
            }
        }
    }
}
