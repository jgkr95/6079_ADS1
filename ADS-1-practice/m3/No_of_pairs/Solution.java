import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeofarray = scan.nextInt();
        int[] pairarray = new int[sizeofarray];
        for (int i = 0; i < sizeofarray; i++) {
            pairarray[i] = scan.nextInt();
        }

        Arrays.sort(pairarray);
        pairsaftersorting(pairarray);
    }
    public static void pairsaftersorting(int[] array) {
        int count = 0, sum = 0;
        int[] pair = new int[array.length / 2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            }
            if (array[i] != array[i + 1] || i == array.length - 2) {
                sum += ((count + 1) * count) / 2;
            }

        }
        System.out.println(sum);
    }
}
