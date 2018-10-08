import java.util.Scanner;
import java.util.Arrays;
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
			System.out.println(tokens.length);
			if(tokens.length==1&&tokens[0].equals("")) {System.out.println("false"); continue;}
			heap = new Comparable[tokens.length+1];
			heap[0] = null;
			for(int j = 0;j<tokens.length;j++) {
				heap[j+1]=tokens[j];
			}
			MinHeap m = new MinHeap();
			m.isMinHeap(heap);
			// System.out.println(Arrays.toString(heap));
			// System.out.println(m.check());

		}

	}
}
class MinHeap {
    /**
     * an empty constructor.
     */
    MinHeap() {
    }
    /**
     * checks whether it is min heap or not.
     *the time complexiety is N.
     *N is the size of the array.
     * @param  array  which is given as input.
     */
    public void isMinHeap(final Comparable[] array) {
        int last = array.length - 1;
        while (last > 1) {
            if (array[last].compareTo(array[last / 2]) >= 0) {
                last--;
            } else {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
// class Minheap {
// 	int size;
// 	Comparable[] heapArray;
// 	Minheap(Comparable[] arr) {
// 		heapArray = arr;
// 		size = arr.length;
// 	}
// 	public boolean check() {
// 		if(heapArray.length==2) {
// 			return true;
// 		}
// 		return isMinHeap(1);
// 	}
// 	private boolean isMinHeap(int k) {
// 		if (k > size) return true;
// 		int left = 2 * k;
// 		int right = 2 * k + 1;
// 		if (left  <= size && greater(k,left))  return false;
// 		if (right <= size && greater(k,right)) return false;
// 		return isMinHeap(left) && isMinHeap(right);
// 	}
// 	private boolean greater(int i, int j) {
// 		return heapArray[i].compareTo(heapArray[j]) < 0;
// 	}
// }