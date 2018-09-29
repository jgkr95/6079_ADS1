class LinkedList {
	Node head;
	public  class Node {
		int data;
		Node next;
		Node(int data) {
			this.data=data;

		}
	}
	public  void insert(int data) {
		Node newnode = new Node(data);
		newnode.next=null;

		if(head==null) {
			head = newnode;
		} else {
			Node cur = head;
			while(cur.next!=null) {
				cur=cur.next;
			}
			cur.next=newnode;
		}
	}
	public void remove(int i) {
		Node cur = head;
		int count=1;
		while(cur.next.next!=null) {
			cur = cur.next;
		}
		cur.next = null;
	}
	public String toStri() {
			Node cur = head;
			int i=0;
			String content = "";
			while(cur.next!=null) {
				// System.out.print(cur.data);
				content+=cur.data;
				cur=cur.next;
			}
			content += cur.data;
			return content;
			// System.out.println(cur.data);
	}
}
class Stack {
	LinkedList list = new LinkedList();
	int[] number;
	int size;
	Stack(String number1) {
		number = new int[number1.length()];
		size = 0;
	}
	Stack(int len) {
		number = new int[len];
		size = 0;
	}
	public void push(int digit) {
		number[size++] = digit;
	}
	public int top() {
		return number[size-1];
	}
	public void pop() {
		size--;
	}
	public boolean isempty() {
		return size == 0;
	}

}