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
        System.out.println(threesum(array));
    }
    public static int threesum(int[] array) {
        int count = 0;
        int k=0,j=0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            j = i + 1;
            k = array.length - 1;
            while (j < k) {
                if(array[i]+array[j]+array[k] == 0) {
                    count++;
                    j++;
                    k--;
                }
                else if(array[i]+array[j]+array[k]>0) {
                    k--;
                } else if(array[i]+array[j]+array[k]<0) {
                    j++;
                }
            }
        }
        return count;
    }
}
