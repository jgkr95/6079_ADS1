/**
 * class for LinkedList.
 */
class LinkedList {
	Node head;
	/**
	 * Class for node.
	 */
	public  class Node {
		int data;
		Node next;
		/**
		 * Constructs the object.
		 *
		 * @param      data  The data is of integer type
		 */
		Node(int data) {
			this.data=data;

		}
	}
	/**
	 * { Inserts the data into the linkedlist }.
	 *
	 * @param      data  The data is of integer type
	 */
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
	/**
	 * { remove the element from linked list }.
	 *
	 * @param      i     { index }
	 */
	public void remove(int i) {
		Node cur = head;
		int count=1;
		while(cur.next.next!=null) {
			cur = cur.next;
		}
		cur.next = null;
	}
	/**
	 * { Gives values of linkedlist }.
	 *
	 * @return     { string conetent }
	 */
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
/**
 * class Stack here.
 */
class Stack {
	LinkedList list = new LinkedList();
	int[] number;
	int size;
	/**
	 * Constructs the object.
	 *
	 * @param      number1  The number 1
	 */
	Stack(String number1) {
		number = new int[number1.length()];
		size = 0;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      len   The length
	 */
	Stack(int len) {
		number = new int[len+1];
		size = 0;
	}
	/**
	 * { Adds the element to the stack }.
	 *
	 * @param      digit  The digit
	 */
	public void push(int digit) {
		number[size++] = digit;
	}
	/**
	 * { gives the top element of the stack }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int top() {
		return number[size-1];
	}
	/**
	 * { deletes top element }.
	 */
	public void pop() {
		size--;
	}
	/**
	 * { To check whether stack is empty or not }.
	 *
	 * @return     { true or false }
	 */
	public boolean isempty() {
		return size == 0;
	}

}
