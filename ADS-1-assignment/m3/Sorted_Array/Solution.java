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
        String[] data1 = scan.nextLine().split(",");
        String[] data2 = scan.nextLine().split(",");
        for(int i=0;i<data1.length;i++) {
            System.out.println(data1[i]);
            firstarray[i] = Integer.parseInt(data1[i].trim());
        }

        for(int i=0;i<data2.length;i++) {
            System.out.println(data2[i]);
            secondarray[i] = Integer.parseInt(data2[i].trim());
        } 
        sort(firstarray,secondarray);
    }
    public static void sort(int[] arr1, int[] arr2) {
       int m=0,n=0;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int size =  arr1.length + arr2.length;
        int[] finalarray = new int[size];
        for(int i=0;i<size;i++) {
            System.out.println(arr1[m]);
            if(arr1[m]<arr2[n]&&m<arr1.length) {
                finalarray[i] = arr1[m];
                m = m+1;
            }
            else if(arr1[m]>arr2[n]&&n<arr2.length) {
                finalarray[i] = arr2[n];
                n = n+1;
            }
        }
        System.out.println(Arrays.toString(finalarray).replace(", ","").replace("[","").replace("]",""));
   }
}
