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
     * Pushes element to steque.
     *
     * @param      item  The item
     * Time complexity of this method is O(1)
     */
    public void push(final Item item) {
        Node newnode = new Node(item);
        newnode.next = head;
        head = newnode;
        size++;
        print();

    }
    /**
     * Pushes element to right.
     *
     * @param      item  The item of Item type
     * Time complexity of this method is O(N) because we have to move to
     *  last node using while loop and then insetion takes place.
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
     * Time complexity of this method is O(1)
     */
    public void pop() {
        if (size == 0) {
            System.out.println("Steque is empty.");
        } else {
            head = head.next;
            size--;
            print();
        }
    }
    /**
     * { Prints all the elements of Steque }.
     * Time complexity of this method is O(N) because we have print
     *  all elements present in linked list.
     */
    public void print() {
        Node cur = head;
        // String[] content = new String[size];
        int i = 0;
        if (size == 0) {
            System.out.println("Steque is empty.");
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
        int count = 0, i = 0;
        int n = sc.nextInt();
        sc.nextLine();
        Steque d = new Steque();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            if (data.equals("") || data.equals(null)) {
                d = new Steque();
                System.out.println();
                continue;

            } else {
                String[] str = data.split(" ");
                switch (str[0]) {
                case "push":
                    d.push(Integer.parseInt(str[1]));
                    break;
                case "enqueue":
                    d.enqueue(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    d.pop();
                    break;
                default:
                    break;
                }
            }
        }

    }
}
