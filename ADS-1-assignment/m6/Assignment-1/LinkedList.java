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