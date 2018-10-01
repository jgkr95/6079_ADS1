import java.util.Scanner;
/**
 * Class for Steque.
 *
 * @param      <Item>  The item is of Generic type
 */
class Steque<Item> {
    /**
     * { head is Node object }.
     */
    private Node head;
    /**
     * { size of Steque }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Steque() {
        size = 0;
        head = null;

    }
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { next is Node object }.
         */
        private Node next;
        /**
         * { data is Item type }.
         */
        private Item data;
        /**
         * Constructs the object.
         *
         * @param      dataa  The dataa is of Item type
         */
        Node(final Item dataa) {
            data = dataa;
        }
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * { Size of the Steque }.
     *
     * @return     { size of the Steque }
     */
    public int size() {
        return size;
    }
    /**
     * Pushes a left.
     *
     * @param      item  The item
     */
    public void push(final Item item) {
        Node newnode = new Node(item);
        newnode.next = head;
        head = newnode;
        size++;
        print();

    }
    /**
     * Pushes a right.
     *
     * @param      item  The item of Item type
     */
    public void enqueue(final Item item) {
        Node newnode = new Node(item);
        size++;
        newnode.next = null;

        if (head == null) {
            head = newnode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newnode;
        }
        print();
    }
    /**
     * { deletes element from left side }.
     */
    public void popLeft() {
        if (size == 0) {
            System.out.println("Steque is empty");
        } else {
            head = head.next;
            size--;
            print();
        }
    }
    /**
     * { Deletes a element from right side }.
     */
    public void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            size--;
            print();
        }
    }
    /**
     * { Prints all the elements of Steque }.
     */
    public void print() {
        Node cur = head;
        // String[] content = new String[size];
        int i = 0;
        if (size == 0) {
            System.out.println("[]");
        } else {
            // System.out.print("[");
            while (cur.next != null) {

                System.out.print(cur.data + ", ");
                cur = cur.next;
            }
            System.out.print(cur.data);
            System.out.println();
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { This is main method to handle input }.
     *
     * @param      args  The arguments are of String array type
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        while (count < n) {
            Steque d = new Steque();
            String[] str = sc.nextLine().split(" ");
            System.out.println(str[0]+" =======");
            if (str[0].equals(" ")) {
                count++;
                System.out.println("+++"+str[0]+"++++");

            } else {
                switch (str[0]) {
                case "push":
                    d.push(Integer.parseInt(str[1]));
                    break;
                case "enqueue":
                    d.enqueue(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    d.popLeft();
                    break;
                case "popRight":
                    d.popRight();
                    break;
                default:
                    break;
                }
                n--;
            }
        }

    }
}
