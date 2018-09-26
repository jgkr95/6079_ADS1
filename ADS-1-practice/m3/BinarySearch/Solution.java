import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeofarray = scan.nextInt();
        int key;
        int[] array = new int[sizeofarray];
        for (int i = 0; i < sizeofarray; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("Enter key to search : ");
        key = scan.nextInt();
        BinarySearch(key, array);
    }
    public static void BinarySearch(int key, int[] array) {
        Arrays.sort(array);
        int high = array.length - 1;
        int low = 0;
        int mid = 0;
        int index = -1;
        while (low <= high) {
            System.out.println("mid " + mid);
            mid = low + (high - low) / 2;
            if (array[mid] == key) {

                if (array[mid] == array[mid - 1]) {
                    index = mid;

                    System.out.println("Key found at index " + mid);
                    break;
                }
            }
            if (key < array[mid]) {
                high = mid - 1;
            }
            if (key > array[mid]) {
                low = mid + 1;
                mid = (high + low) / 2;
            }
        }
        if (index == -1) {
            System.out.println("Key not found in list");
        }

    }
}
