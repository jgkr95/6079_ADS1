import java.util.Scanner;
class Deque<Item> {
    Node head;
    Node tail;
    int size;
    Deque() {

    }
    class Node {
        Node next;
        Item data;
        Node(Item dataa) {
            data = dataa;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void pushLeft(Item item) {
        Node newnode = new Node(item);
        newnode.next = head;
        head = newnode;
        size++;
        print();

    }
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
    public void popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
            head = head.next;
            size--;
            print();
        }
    }
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
class Solution {
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