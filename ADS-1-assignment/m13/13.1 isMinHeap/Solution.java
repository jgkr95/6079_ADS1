import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Comparable[] heap;
		Comparable[] heapNull = {null};
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		int n = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < n; i++) {
			String[] tokens = scan.nextLine().split(",");
			heap = new Comparable[tokens.length+1];
			for(int j = 0;j<tokens.length;j++) {
				heap[j+1]=tokens[j];
			}
			Minheap m = new Minheap(heap);
			System.out.println(m.check());

		}

	}
}
class Minheap {
	int size;
	Comparable[] heapArray;
	Minheap(Comparable[] arr) {
		heapArray = arr;
		size = arr.length;
	}
	public boolean check() {
		return isMinHeap(1);
	}
	private boolean isMinHeap(int k) {
		if (k > size) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left  <= size && greater(k,left))  return false;
		if (right <= size && greater(k,right)) return false;
		return isMinHeap(left) && isMinHeap(right);
	}
	private boolean greater(int i, int j) {
		return heapArray[i].compareTo(heapArray[j]) > 0;
	}
}