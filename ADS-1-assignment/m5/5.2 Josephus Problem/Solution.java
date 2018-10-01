import java.util.Scanner;
/**
 * Class for josephus.
 */
class Josephus {
    /**
     * { head is Node object that stores starting address of linked list }.
     */
    Node head;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { next is Node object stores next object address }.
         */
        Node next;
        /**
         * { element to be stored }.
         */
        int data;
        /**
         * Constructs the object and intialises the data.
         *
         * @param      dataa  The dataa
         */
        Node(final int dataa) {
            data = dataa;
        }
    }
    /**
     * { Inserts the given element in to the linked list }.
     *
     * @param      data  The data is of integer type
     */
    public void insert(final int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newnode;
        }
    }
    /**
     * { Connects the head to the last node }.
     */
    public void circlepos() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
    }
    /**
     * { finds the killing position and removes that element until only
     *  one element reamins in linked list }.
     *
     * @param      killposition  The killposition
     */
    public void sword(final int killposition) {
        Node temp1 = head, temp2 = head;
        int counter = 1;
        int i = 0;
        while (temp1.next != temp1) {
            while (counter != killposition) {
                temp2 = temp1;
                temp1 = temp1.next;

                counter++;
            }
            Node killed = temp2.next;
            System.out.print(killed.data + " ");
            temp2.next = temp1.next;
            temp1 = temp2.next;
            counter = 1;
        }
        System.out.println(temp1.data);

    }
}
/**
 * class Solution starts here.
 */
public final class Solution {
    private Solution() {

    }
    /**
     * { This is main mehtod to handle input }.
     *
     * @param      args  The arguments are of String array type
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int limit = scan.nextInt();
        int count = 0;
        while (count++ < limit) {
            Josephus jobj = new Josephus();
            int total = scan.nextInt();
            int kill = scan.nextInt();
            for (int i = 0; i < total; i++) {
                jobj.insert(i);
            }
            jobj.circlepos();
            jobj.sword(kill);

        }

    }
}
