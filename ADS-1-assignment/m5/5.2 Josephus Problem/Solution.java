import java.util.Scanner;
class Josephus {
	Node head;
	int size;
	class Node {
		Node next;
		int data;
		Node(int dataa) {
			data = dataa;
		}
	}

	public void insert(int data) {
		Node newnode = new Node(data);
		size++;
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
	public void circlepos() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
	}
	public void sword(int total, int killposition) {
		Node temp = head;
        int counter = 1;
        int i = 0;
        while (temp.next != null) {
            while (counter != killposition) {
                insert(temp.data);
                temp = temp.next;
                // popAtHead();
                head = head.next;
                counter++;
            }
        System.out.print(temp.data);
        temp = temp.next;
        counter = 1;
        // popAtHead();
        head = head.next;
        }
        System.out.println(temp.data);
		
	}
}
public final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Josephus jobj = new Josephus();
		int limit = scan.nextInt();
		while (limit >= 0) {
			int total = scan.nextInt();
			int kill = scan.nextInt();
			for (int i = 0; i < total; i++) {
				jobj.insert(i);
			}
			jobj.circlepos();
			jobj.sword(total, kill);
		}

	}
}
