import java.util.Scanner;
/**
 * Class for deque.
 *
 * @param      <Item>  The item is of Generic type
 */
class Deque<Item> {
    Node head;
    int size;
    /**
     * Constructs the object.
     */
    Deque() {
        size = 0;
        head = null;

    }
    /**
     * Class for node.
     */
    class Node {
        Node next;
        Item data;
        /**
         * Constructs the object.
         *
         * @param      dataa  The dataa is of Item type
         */
        Node(Item dataa) {
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
     * { Size of the deque }.
     *
     * @return     { size of the deque }
     */
    public int size() {
        return size;
    }
    /**
     * Pushes a left.
     *
     * @param      item  The item
     */
    public void pushLeft(Item item) {
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
    public void pushRight(Item item) {
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
            System.out.println("Deck is empty");
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
     * { Prints all the elements of deque }.
     */
    public void print() {
        Node cur = head;
        // String[] content = new String[size];
        int i = 0;
        if (size == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            while (cur.next != null) {

                System.out.print(cur.data + ", ");
                cur = cur.next;
            }
            System.out.print(cur.data + "]");
            System.out.println();
        }
    }
}
/**
 * Class for solution.
 */
class Solution {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque d = new Deque();
        int n = sc.nextInt();
        while (n >= 0) {
            String[] str = sc.nextLine().split(" ");
            switch (str[0]) {
            case "isEmpty":
                System.out.println(d.isEmpty());
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "pushLeft":
                d.pushLeft(Integer.parseInt(str[1]));
                break;
            case "pushRight":
                d.pushRight(str[1]);
                break;
            case "popLeft":
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