import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * sum.
     */
    private long sum;
    /**
     * integer firstNumber.
     */
    private int firstNumber;
    /**
     * integer secondnumber.
     */
    private int secondNumber;
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    long getSum() {
        return sum;
    }
    /**
     * gets firstnumber.
     *
     * @return  integer
     */
    int geti() {
        return firstNumber;
    }
    /**
     * gets secondnumber.
     *
     * @return  integer
     */
    int getj() {
        return secondNumber;
    }
    /**
     * Constructs the object.
     *
     * @param      a     integer firstnumber
     * @param      b     integer secondnumber
     * Time complexity of this method is O(1).
     */
    CubeSum(final int a, final int b) {
        this.sum = a * a * a + b * b * b;
        this.firstNumber = a;
        this.secondNumber = b;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return     integer -1,0,1
     * Time complexity of this method is O(1).
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.getSum()) {
            return -1;
        }
        if (this.sum > that.getSum()) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + "";
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function to handle the input and process it.
     *
     * @param      args  The arguments are of String array type.
     */
     public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int ways = sc.nextInt();
        final int sixHundred = 600;
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= sixHundred; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int pair = 1;
        int count = 0;
        CubeSum previous = new CubeSum(0, 0);
        while (!pq.isEmpty()) {
            CubeSum current = pq.delMin();
            if (current.getSum() == previous.getSum()) {
                pair++;
                if (pair == ways) {
                    count++;
                }
                if (number == count) {
                    System.out.println(current);
                    break;
                }
            } else {
                pair = 1;
            }
            previous = current;
            if (current.getj() < sixHundred) {
                pq.insert(new CubeSum(current.geti(), current.getj() + 1));
            }
        }
    }
}
