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
			System.out.print(killed.data+" ");
			temp2.next=temp1.next;
			temp1 = temp2.next;
			counter = 1;
		}
		System.out.println(temp1.data);

	}
}
public final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int limit = scan.nextInt();
		System.out.println(limit);
		int count = 0;
		while (count++ < limit) {
			Josephus jobj = new Josephus();
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
