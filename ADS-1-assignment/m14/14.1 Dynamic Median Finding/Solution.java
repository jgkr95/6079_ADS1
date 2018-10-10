import java.util.Scanner;
/**
 * Class for dynamic median.
 */
class DynamicMedian {
    /**
     * Object for MinPQ.
     */
    private MinPQ<Double> minObj;
    /**
     * Object for MaxPQ.
     */
    private MaxPQ<Double> maxObj;
    /**
     * Constructs the object.
     */
    DynamicMedian() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    /**
     * Inserrts element to Minheap.
     * @param      item  The item is of double type
     */
    public void insertAtMin(final double item) {
        minObj.insert(item);
    }
    /**
     * Inserts element to MaxpQ.
     *
     * @param      item  The item is of double type
     */
    public void insertAtMax(final double item) {
        maxObj.insert(item);
    }
    /**
     * Gets the minimum element from Minheap.
     *
     * @return     The minimum of Minheap.
     */
    public double getMin() {
        return minObj.min();
    }
    /**
     * Gets the maximum element from Maxheap.
     *
     * @return     The maximum of Maxheap.
     */
    public double getMax() {
        return maxObj.max();
    }
    /**
     * Deletes the maximum element form maxheap.
     *
     * @return     { root node of the Maxheap }
     */
    public double delMax() {
        return maxObj.delMax();
    }
    /**
     * Deletes the MInimum element from the minHeap
     *
     * @return     { Root node of the MinHeap }
     */
    public double delMin() {
        return minObj.delMin();
    }
    /**
     * Gets the minHeap size.
     *
     * @return     The minimum size.
     */public int getMinSize() {
        return minObj.size();
    }
    /**
     * Gets the maxHeap size.
     *
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return maxObj.size();
    }
}
/**
 * Calss Solution starts here.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Main method handle the input and to get dynamic median.
     *
     * @param      args  The arguments are of String array type
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DynamicMedian dm = new DynamicMedian();
        long inputs = scan.nextLong();
        double element = scan.nextDouble();
        dm.insertAtMin(element);
        double median = element;
        System.out.println(median);
        for (long i = 1; i < 10; i++) {
            double input = scan.nextDouble();
            if (input > median) {
                dm.insertAtMin(input);
            } else if (input < median) {
                dm.insertAtMax(input);
            } else {
                dm.insertAtMin(input);
            }
            if (dm.getMinSize() - dm.getMaxSize() > 1) {
                dm.insertAtMax(dm.delMin());
            }
            if (dm.getMaxSize() - dm.getMinSize()  > 1) {
                dm.insertAtMin(dm.delMax());
            }
            if (Math.abs(
                    dm.getMinSize() - dm.getMaxSize()) == 1) {
                if (dm.getMinSize() > dm.getMaxSize()) {
                    median = dm.getMin();
                    System.out.println(median);
                } else {
                    median = dm.getMax();
                    System.out.println(median);
                }
            }
            if (dm.getMinSize()  == dm.getMaxSize()) {
                double min = dm.getMin();
                double max = dm.getMax();
                median = (min + max) / 2.0;
                System.out.println(median);
            }
        }
    }
}
