import java.util.Scanner;
/**
 * Class for merge.
 */
class Merge {
    /**
     * { cutoff for insertion sorting }.
     */
    private static final int CUTOFF = 7;
    /**
     * { This method copies two arrays elements
     *  in to auxilary array by sorting }.
     *
     * @param      array     The array is of Comparable array type
     * @param      newarray  The newarray is of Comparable array type
     * @param      lo        The lower is array starting index
     * @param      mid       The middle is middle index
     * @param      hi        The higher is last index
     */
    private static void merge(final Comparable[] array,
    final Comparable[] newarray, final int lo, final int mid, final int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                newarray[k] = array[j++];
            } else if (j > hi) {
                newarray[k] = array[i++];
            } else if (less(array[j], array[i])) {
                newarray[k] = array[j++];
            } else {
                newarray[k] = array[i++];
            }
        }
        assert isSorted(newarray, lo, hi);
    }
    /**
     * { This method copies two arrays elements
     * in to auxilary array by sorting }.
     *
     * @param      array     The array is of Comparable array type
     * @param      newarray  The newarray is of Comparable array type
     * @param      lo        The lower is array starting index
     * @param      hi        The higher is last index
     */
    private static void sort(final Comparable[] array,
     final Comparable[] newarray, final int lo, final int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(newarray, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(newarray, array, lo, mid);
        sort(newarray, array, mid + 1, hi);

        if (!less(array[mid + 1], array[mid])) {
            for (int i = lo; i <= hi; i++) {
                newarray[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, newarray, lo, mid, hi);
    }
    /**
     * { calls the above private sort method }.
     *
     * @param      a     is of comparable type
     */
    public static void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * { Insertion sort takes place here }.
     *
     * @param      a     auxilary array
     * @param      lo    The lower Starting index to sort
     * @param      hi    The higher last index to sort
     */
    public static void insertionSort(final Comparable[] a,
                                 final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }
    /**
     * { swaps the positions of the given index positions }.
     *
     * @param      aux     { Auxilaaary array }
     * @param      i     { index position }
     * @param      j     { indexposition }
     */
    public static void swap(final Comparable[] aux, final int i, final int j) {
        Comparable temp = aux[i];
        aux[i] = aux[j];
        aux[j] = temp;
    }
    /**
     * { Gives the comparison  of the given elements }.
     *
     * @param      a     { comparable elment }
     * @param      b     { comparable element }
     *
     * @return     { true if a is less than b, else false }
     */
    public static boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Determines if sorted.
     *
     * @param      aux     { Comparable array }
     *
     * @return     True if sorted, False otherwise.
     */
    public static boolean isSorted(final Comparable[] aux) {
        return isSorted(aux, 0, aux.length - 1);
    }
    /**
     * Determines if sorted.
     *
     * @param      aux   The auxiliary
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public static boolean isSorted(final Comparable[] aux,
                                 final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(aux[i], aux[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * { gives the given array elements in String }.
     *
     * @param      aux   The auxiliary array
     *
     * @return     { String with all auxilary elements }
     */
    public static Object show(final Object[] aux) {
        String s = "[";
        int i;
        for (i = 0; i < aux.length - 1; i++) {
            s += aux[i] + ", ";
        }
        s = s + aux[aux.length - 1] + "]";
        return s;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { main method to handle the input }.
     *
     * @param      args  The arguments of string array type
     */
    public static void main(final String[] args) {
        Merge m = new Merge();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String tokens = s.nextLine();
            String[] lines = tokens.split(",");
            m.sort(lines);
            System.out.println(m.show(lines));
            System.out.println();

        }
    }
}
