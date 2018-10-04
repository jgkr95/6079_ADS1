import java.util.Scanner;
/**
 * class Solution starts here for input handling.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { This is main method to handle the input }.
     *
     * @param      args  The arguments are of string array type
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            try {
                switch (tokens[0]) {
                case "insertAt":
                    list.insertAt(Integer.parseInt(tokens[1]),
                                   tokens[2]);
                    list.display();
                    break;

                case "reverse":
                    list.reverse();
                    list.display();
                    break;

                default :
                    break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
/**
 * List of linkeds.
 *
 * @param      <E>   { generic type }
 */
class LinkedList<E> {
    /**
     * { head is Node object to store starting address }.
     */
    private Node head;
    /**
     * { Size of the linkedlist }.
     */
    private int size;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { data to store element }.
         */
        private E data;
        /**
         * { Stores the address of next element }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      dataa  The dataa is E generic type
         */
        Node(final E dataa) {
            this.data = dataa;
            this.next = null;
        }
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.head = null;
        this.size = 0;
    }
    /**
     * { Inserts the element at given index position }.
     *
     * @param      index      The index is inetger type
     * @param      data       The data
     *
     * @throws     Exception  { Throws exception if index is invalid }
     * Time complexity is O(N) because in worst case, it may have
     * to recurse entire linked list
     */
    public void insertAt(final int index, final E data) throws Exception {

        if (index < 0 || index > size) {
            throw new Exception("Can't insert at this position.");
        }

        head = insertAt(head, new Node(data), index, 0);
        size++;

    }
    /**
     * { Inserts at given position }.
     *
     * @param      curr       The curr is Node object
     * @param      newNode    The new node is Node object
     * @param      index      The index is integer type
     * @param      currIndex  The curr index is integer type
     * Time complexity is O(N) because in worst case, it may have
     * to recurse entire linked list
     * @return     { Returns the object of node }
     */
    private Node insertAt(final Node curr, final Node newNode,
                          final int index, final int currIndex) {
        if (curr == null) {
            return newNode;
        } else if (currIndex == index) {
            newNode.next = curr;
            return newNode;
        }

        curr.next = insertAt(curr.next, newNode, index, currIndex + 1);
        return curr;

    }
    /**
     * { Reverse public method to call reverse recursive method }.
     *
     * @throws     Exception  { throws exception if linked list if empty }
     * Time complexity of this method is O(1) because
     * it just calls the reverse recursive method
     */
    public void reverse() throws Exception {
        if (head == null) {
            throw new Exception("No elements to reverse.");
        }
        reverse(head, null);
    }
    /**
     * { Reverses the linked list }.
     *
     * @param      curr  The curr is node object
     * @param      prev  The previous is node object
     *
     * @return     { returns the null if next addess if empty, else head }
     * Time complexity of this method O(N) beacuse
     * it has to traverse entire linkedlist to reverse the elements.
     */
    private Node reverse(final Node curr, final Node prev) {
        if (curr.next == null) {
            head = curr;
            head.next = prev;
            return null;
        }

        Node temp = curr.next;
        curr.next = prev;

        reverse(temp, curr);
        return head;
    }
    /**
     * { Displays the elements of the Linkedlists }.
     */
    public void display() {
        Node curr = head;
        String result = "";
        while (curr != null) {
            if (curr.next == null) {
                result += curr.data;
            } else {
                result += curr.data + ", ";
            }
            curr = curr.next;
        }

        System.out.println(result);
    }
}
