import java.util.Scanner;
/**
 * Class Solution starts here.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method to handle the input.
     *
     * @param      args  The arguments are of String array type
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                Book bookdata = new Book(tokens[1],
                                         tokens[2], Float.parseFloat(tokens[2 + 1]));
                bst.put(bookdata, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                bookdata = new Book(tokens[1], tokens[2],
                                    Float.parseFloat(tokens[2 + 1]));
                if (bst.get(bookdata) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(bookdata));
                }
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                bookdata = new Book(tokens[1],
                                    tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.floor(bookdata));
                break;
            case "ceiling":
                bookdata = new Book(tokens[1],
                                    tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.ceiling(bookdata));
                break;
            case "delete":
                bst.delete(new Book(
                    tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1])));
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "deleteMax":
                bst.deleteMax();
                break;            
            default:
                break;
            }
        }
    }
}
/**
 * Class for book.
 */
class Book implements Comparable {
    /**
     * variable declaration.
     */
    private String name;
    /**
     * variable declaration.
     */
    private String author;
    /**
     * variable declaration.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      name1    The name
     * @param      author1  The author
     * @param      price1   The price
     */
    Book(final String name1,
         final String author1, final float price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * compare to method that returns integer.
     *
     * @param      object  The object
     *
     * @return  integer.
     */
    public int compareTo(final Object object) {
        Book that = (Book) object;
        return this.name.compareTo(that.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * root node.
     */
    private Node root;
    /**
     * Class for node.
     */
    private final class Node {
        /**
         * object of Book.
         */
        private Book key;
        /**
         * value.
         */
        private int val;
        /**
         * Left child of node.
         */
        private Node left;
        /**
         * right child of node.
         */
        private Node right;
        /**
         * size of tree.
         */
        private int size;
        /**
         * Constructs the object and initialises the objects.
         *
         * @param      key1   The key 1
         * @param      val1   The value 1
         * @param      size1  The size 1
         */
        private Node(final Book key1, final int val1, final int size1) {
            key = key1;
            val = val1;
            size = size1;
        }
    }
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * size method.
     *
     * @return size.
     */
    public int size() {
        return size(root);
    }
    /**
     * size overloaded method.
     *
     * @param      x Node
     *
     * @return size.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * get method to get the value of the given key.
     * @param      key   The key is Book object.
     *
     * @return  integer.
     * Time complexity is O(N)
     * As N is the height of the tree in worst case.
     */
    public int get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return -1;
    }
    /**
     * put method to inserts the key and the value.
     *
     * @param      key   The key
     * @param      val   The value
     * Time complexity is O(N) as it is calling put method.
     */
    public void put(final Book key, final int val) {
        root = put(root, key, val);
    }
    /**
     * Put method inserts the key and the value.
     * @param      x   parent node.
     * @param      key   The key is Book object.
     * @param      val   The value is Book object.
     *
     * @return root
     * Time complexity is O(N) as it is the height of the tree.
     */
    private Node put(final Node x, final Book key, final int val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
        }
        return x;
    }
    /**
     * Gives the minimum element.
     * @return minimum element.
     * Time complexity is O(logN) as it is calling min method again.
     */
    public Book min() {
        return min(root).key;
    }
    /**
     * Gives the minimum element.
     * @param      x Node
     *
     * @return minimum.
     * Time complexity is O(N)
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * Gives the maximum element.
     * @return maximum element.
     * Time complexity is O(N)
     */
    public Book max() {
        return max(root).key;
    }
    /**
     * Gives the maximum element.
     * @param      x Node
     *
     * @return maximum.
     * Time complexity is O(N)
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * Gives floored value of the given key.
     * @param      key   The key
     *
     * @return  floored value of the given key
     * Time complexity is O(N)
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * Gives floored value of the given key.
     * @param      x Node
     * @param      key   The key
     *
     * @return floored value of the given key.
     * Time complexity is O(logN)
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * Gives the ceiled value of the given key.
     * @param      key   The key
     *
     * @return     { ceiled value of the given key }
     * Time complexity is O(logN)
     */
    public Book ceiling(final Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * Gives the ceiled value of the given key.
     * @param      x Node
     * @param      key   The key
     *
     * @return     { ceiled value of the given key }
     * Time complexity is O(logN)
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * selects the given key and gives the value.
     * @param      k     {Integer}
     *
     * @return     {Book Object}
     * Time complexity of this method is O(logN).
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * selects the given key and gives the value.
     * @param      x     {parent Node}
     * @param      k     {Integer type}
     *
     * @return     {selected node}
     * Time complexity of this method is O(log(N)).
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    /**
     * { Gives no of left children }.
     * @param      key   The key
     *
     * @return     {no of left children}
     * Time complexity is O(logN) as it is calling rank method agaim.
     */
    public int rank(final Book key) {
        return rank(key, root);
    }
    /**
     * { Method of rank gives no of left children }.
     * @param      key   The key
     * @param      x     Node object
     *
     * @return     {no of left children}
     * Time complexity of this method is O(log(N)).
     */
    private int rank(final Book key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
    /**
     * This method is to delete the minimum element.
     * Time complexity is O(N)
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * This method is to delete the minimum element.
     * @param x  The temporary root
     *
     * @return root of tree.
     * Time complexity is O(N)
     */
    private Node deleteMin(
        final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.right)
                 + size(x.left);
        return x;
    }
    /**
     * This method is to delete the maximum element.
     *
     *Time complexity is O(N)
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * The method is to delete the maximum element.
     * @param x  The temporary root
     *
     * @return root of tree.
     * Time complexity is O(N)
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.right)
                 + size(x.left);
        return x;
    }
    /**
     * This method is to delete the given key value.
     *
     * @param      key   The key to be deleted
     * Time complexity is O(N)
     */
    public void delete(final Book key) {
        root = delete(root, key);
    }
    /**
     * The method is to delete the given key.
     *
     * @param   t  The temporary root
     * @param   key  the key which is to be deleted
     *
     * @return root of the tree after deletetion.
     * Time complexity is O(N)
     */
    private Node delete(final Node t,
                        final Book key) {
        Node x = t;
        if (x == null) {
            return null;
        }
        int cmp = key.getName().compareTo(
                      x.key.getName());
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            } else if (x.left == null) {
                return x.right;
            }
            Node temp = x;
            x = min(x.right);
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        x.size = 1 + size(x.right)
                 + size(x.left);
        return x;
    }
}
