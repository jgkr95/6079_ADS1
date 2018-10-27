import java.util.Scanner;
import java.util.ArrayList;
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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        // AddStudent as = new AddStudent(size);
        LinearProbingHashST<String, String> lpht
            = new LinearProbingHashST<String, String>();
        for (int i = 0; i < size; i++) {
            String[] tokens = scan.nextLine().split(",");
            // as.add(new Student(Integer.parseInt((tokens[0])),
            //                 tokens[1], Double.parseDouble(tokens[2])));
            String str = tokens[1] + "," + tokens[2];
            lpht.put(tokens[0], str);
        }
        int queries = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < queries; i++) {
            try {
                String[] tokens = scan.nextLine().split(" ");
                String info = lpht.get(tokens[1]);

                String[] sObj = info.split(",");
                boolean flag = lpht.contains(tokens[1]);
                switch (tokens[2]) {
                case "1":
                    System.out.println(sObj[0]);

                    break;
                case "2":
                    System.out.println(sObj[1]);

                    break;
                default:
                    break;
                }
            } catch (Exception e) {
                System.out.println("Student doesn't exists...");
            }
        }
    }
}
/**
 * Class for student.
 */
class Student {
    /**
     * { var_description }.
     */
    private int rollNumber;
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private double totalMarks;
    /**
     * Constructs the object.
     */
    Student() {

    }
    /**
     * Constructs the object.
     *
     * @param      rollNumber1  The roll number 1
     * @param      name1        The name 1
     * @param      totalMarks1  The total marks 1
     */
    Student(final int rollNumber1, final String name1,
            final double totalMarks1) {
        rollNumber = rollNumber1;
        name = name1;
        totalMarks = totalMarks1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public double getTotal() {
        return totalMarks;
    }
    /**
     * Gets the roll number.
     *
     * @return     The roll number.
     */
    public int getRollNumber() {
        return rollNumber;
    }
}
// /**
//  * Class for add student.
//  */
// class AddStudent {
//     /**
//      * { var_description }.
//      */
//     private Student[] sInfo;
//     /**
//      * { var_description }.
//      */
//     private int size;
//     /**
//      * Constructs the object.
//      *
//      * @param      size1  The size 1
//      */
//     AddStudent(final int size1) {
//         sInfo = new Student[size1];
//     }
//     /**
//      * { function_description }.
//      *
//      * @param      s     { parameter_description }
//      */
//     public void add(final Student s) {
//         sInfo[size++] = s;
//     }
//     /**
//      * { function_description }.
//      *
//      * @param      rollNumber  The roll number
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Student get(final int rollNumber) {
//         Student s = new Student();
//         for (int i = 0; i < size; i++) {
//             if (sInfo[i].getRollNumber() == rollNumber) {
//                 if (s == null) {
//                     s = sInfo[i];
//                 } else if (sInfo[i].getTotal() > s.getTotal()) {
//                     s = sInfo[i];
//                 }
//             }
//         }
//         return s;
//     }
//     /**
//      * { function_description }.
//      *
//      * @param      roll  The roll
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public boolean contains(final int roll) {
//         for (int i = 0; i < size; i++) {
//             if (sInfo[i].getRollNumber() == roll) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
// import java.util.Scanner;
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

        // if (val == null) {
        //     delete(key);
        //     return;
        // }

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
