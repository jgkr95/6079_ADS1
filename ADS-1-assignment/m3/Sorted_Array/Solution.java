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
        if(!data1.equals(null)) {
        for(int i=0;i<array1.length;i++) {
            System.out.println(array1[i]);
            firstarray[i] = Integer.parseInt(array1[i].trim());
        } }
        if(!data2.equals(null)) {
        for(int i=0;i<array2.length;i++) {
            System.out.println(array2[i]);
            secondarray[i] = Integer.parseInt(array2[i].trim());
        } }
        sort(firstarray,secondarray);
    }
    public static void sort(int[] arr1, int[] arr2) {
        int m=0,n=0;
        int[] finalarray = new int[arr2.length+arr1.length];
        for(int i=0;i<arr2.length+arr1.length;i++) {
            if(arr1[m]<=arr2[n]) {
                finalarray[i] = arr1[m];
                m = m+1;
            }
            else if(arr1[m]>arr2[n]) {
                finalarray[i] = arr2[n];
                n = n+1;
            }
        }
        System.out.println(Arrays.toString(finalarray).replace(", ","").replace("[","").replace("]",""));
    }
}