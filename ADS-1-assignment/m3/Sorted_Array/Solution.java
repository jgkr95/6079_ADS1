import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeoffirstarray = scan.nextInt();
        int sizeofsecondarray = scan.nextInt();
        int[] firstarray = new int[sizeoffirstarray];
        int[] secondarray =  new int[sizeofsecondarray];
        scan.nextLine();
        String data1 = scan.nextLine();
        String data2 = scan.nextLine();
        String[] array1 = data1.split(",");
        String[] array2 = data2.split(",");
        for(int i=0;i<array1.length;i++) {
            firstarray[i] = Integer.parseInt(array1[i].trim());
        }
        for(int i=0;i<array2.length;i++) {
            secondarray[i] = Integer.parseInt(array1[i].trim());
        }
        sort(firstarray,secondarray);
    }
    public static void sort(int[] array1, int[] array2) {
        int m=0,n=0;
        int[] finalarray = new int[array2.length+array1.length];
        for(int i=0;i<array2.length+array1.length;i++) {
            if(array1[m]<=array2[n]) {
                finalarray[i] = array1[m];
                m = m+1;
            }
            else if(array1[m]>array2[n]) {
                finalarray[i] = array2[n];
                n = n+1;
            }
        }
        System.out.println(Arrays.toString(finalarray).replace(" ","").replace("[","").replace("]",""));
    }
}