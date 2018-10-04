import java.util.Scanner;
class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch(tokens[0]) {
				case "insertAt":
				try {
								list.insertAt(Integer.parseInt(tokens[1]),tokens[2]);
								list.display();
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
								break;
							}
				case "reverse":
							try {
								list.reverse();

								// list.display();
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
					break;
				default : 
					break;

			}

		}
	}
}
class LinkedList<E>{

	Node head;
	Node tail;
	int size;
	
	class Node{
		E data;
		Node next;

		public Node(E dataa){
			this.data = dataa;
			this.next = null;
		}
	}

	public LinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void insertAt(int index, E data) throws Exception{

		if(index < 0 || index > size){
			throw new Exception("Can't insert at this position.");
		}

		head = insertAt(head, new Node(data), index, 0);
		size++;

	}

	private Node insertAt(Node curr, Node newNode, int index, int currIndex){
		if(curr == null){

			return newNode;
		}
		else if(currIndex == index){
			newNode.next = curr;
			return newNode;
		}

		curr.next = insertAt(curr.next, newNode, index, currIndex+1);
		return curr;

	}


	public void reverse() throws Exception {
		if(head == null){
			throw new Exception("No elements to reverse.");
		}
		reverse(head, null);
	}

	private Node reverse(Node curr, Node prev){



		if(curr.next == null){
			head = curr;
			head.next = prev;
			return null;
		}

		Node temp = curr.next;
		curr.next = prev;

		reverse(temp,curr);
		return head;
	}

	public void display(){
		Node curr = head;
		String result = "";
		while(curr!=null){
			if(curr.next == null){
				result += curr.data;
			}
			else{
				result += curr.data+", ";
			}
			curr = curr.next;
		}

		System.out.println(result);
	}
}
