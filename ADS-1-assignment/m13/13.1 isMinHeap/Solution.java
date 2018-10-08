import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**.
     * { Main method to handle input }
     *
     * @param      args  The arguments are of String array type
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        int n = scan.nextInt();
        scan.nextLine();
        switch (type) {
        case "String" :
            for (int i = 0; i < n; i++) {
                String[] tokens = scan.nextLine().split(",");
                if (tokens.length == 1 && tokens[0].equals("")) {
                    System.out.println("false");
                     continue;
                    }
                String[] strHeap = new String[tokens.length + 1];
                strHeap[0] = null;
                for (int j = 0; j < tokens.length; j++) {
                    strHeap[j + 1] = tokens[j];
                }
                MinHeap m = new MinHeap();
                m.isMinHeap(strHeap);
            }
            break;
        case "Integer":
            for (int i = 0; i < n; i++) {
                String[] tokens = scan.nextLine().split(",");
                if (tokens.length == 1 && tokens[0].equals("")) {
                    System.out.println("false");
                     continue;
                    }
                Integer[] intHeap = new Integer[tokens.length + 1];
                for (int j = 0; j < tokens.length; j++) {
                    intHeap[j + 1] = Integer.parseInt(tokens[j]);
                }
                MinHeap m = new MinHeap();
                m.isMinHeap(intHeap);
            }
            break;
        case "Double":
            for (int i = 0; i < n; i++) {
                String[] tokens = scan.nextLine().split(",");
                if (tokens.length == 1 && tokens[0].equals("")) {System.out.println("false"); continue;}
                Double[] doubleHeap = new Double[tokens.length + 1];
                for (int j = 0; j < tokens.length; j++) {
                    doubleHeap[j + 1] = Double.parseDouble(tokens[j]);
                }
                MinHeap m = new MinHeap();
                m.isMinHeap(doubleHeap);
            }
            break;
        case "Float" :
            for (int i = 0; i < n; i++) {
                String[] tokens = scan.nextLine().split(",");
                if (tokens.length == 1 && tokens[0].equals("")) {System.out.println("false"); continue;}
                Float[] heap = new Float[tokens.length + 1];
                for (int j = 0; j < tokens.length; j++) {
                    heap[j + 1] = Float.parseFloat(tokens[j]);
                }
                MinHeap m = new MinHeap();
                m.isMinHeap(heap);
            } break;
        }
    }
}
/**
 * Class for minimum heap.
 *
 * @param      <E>   { Generic type }
 */
class MinHeap<E extends Comparable<E>> {
    /**
     * Constructs the object.
     */
    MinHeap() {
    }
    /**
     * Determines if minimum heap.
     *
     * @param      array  The array is input
     * THe time complexity of this method is O(N)
     * Because it checks entire array to check
     */
    public void isMinHeap(final E[] array) {
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
