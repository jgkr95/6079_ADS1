import java.util.Scanner;
/**
 * Class for book.
 */
class Book {
    /**
     * name of the book.
     */
    private String name;
    /**
     * name of the author.
     */
    private String author;
    /**
     * price of the book.
     */
    private float price;
    /**
     * constructor for intialising the variables.
     *
     * @param      name1     { name is string type}
     * @param      author1     { authoris string type }
     * @param      price1     { price is float type}
     */
    Book(final String name1, final String author1, final float price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name in String.
     */
    public String getName() {
        return this.name;
    }
}
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * Constructs the object.
     */
    BinarySearchTree() {

    }
    /**
     * root node.
     */
    private Node root;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * key of book type.
         */
        private Book key;
        /**
         * value of integer type.
         */
        private int value;
        /**
         * left and right nodes.
         */
        private Node left, right;
        /**
         * Constructs the object.
         *
         * @param      k     { book }
         * @param      v     { value }
         */
        Node(final Book k, final int v) {
            this.key = k;
            this.value = v;
        }
    }
    /**
     * put method.
     *
     * @param      key    The key
     * @param      value  The value
     * Time comlexity of this method is O(1)
     */
    public void put(final Book key, final int value) {
         root = put(root, key, value);
    }
    /**
     * put overloaded method.
     *
     * @param      x      { Node }
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { returns the node }
     * Time complexity of this method is O(N)
     * In worst case it has to put all in down by down
     */
    private Node put(final Node x,
     final Book key, final int value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.getName().compareTo(x.key.getName());
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        }
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        if (cmp == 0) {
            x.value = value;
        }
        return x;
    }
    /**
     * gets the value of the given key.
     *
     * @param      key   The key is Book object
     *
     * @return     { returns integer value }
     * Time complexity of thisk method is O(N) in worst case
     */
    public Integer get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.key.getName());
                if (cmp < 0) {
                    x = x.left;
                }
                if (cmp > 0) {
                    x = x.right;
                }
                if (cmp == 0) {
                    return x.value;
                }
            }
            return null;
        }
    }
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * Main method is to handle the input.
     *
     * @param      args  The arguments are of String array type
     */
    public static void main(final String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        final int three = 3, four = 4;
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                    Book key = new Book(
                    tokens[1], tokens[2],
                    Float.parseFloat(tokens[three]));
                    int value =
                     Integer.parseInt(tokens[four]);
                    bst.put(key, value);
                    break;
                case "get":
                    key = new Book(tokens[1], tokens[2],
                     Float.parseFloat(tokens[three]));
                    System.out.println(bst.get(key));
                    break;
                default:
            }
        }
    }
}
