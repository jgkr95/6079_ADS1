import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { var_description }.
     */
    private int opensites = 0;
    /**
     * { var_description }.
     */
    private WeightedQuickUnionUF uf;
    /**
     * { var_description }.
     */
    private boolean[][] grid;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Percolation(final int n) {
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        size = n;
    }
    /**
     * { function_description }.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        // if (grid[row][col]) return;
        grid[row][col] = true;
        opensites++;
        if (col + 1 < size && isOpen(row, col + 1)) {
            uf.union(row * size + col, row * size + (col + 1));
        }
        if (row + 1 < size && isOpen(row + 1, col)) {
            uf.union(row * size + col, (row + 1) * size + col);

        }
        if (col - 1 >= 0 && isOpen(row, col - 1)) {
            uf.union(row * size + col, row * size + (col - 1));

        }
        if (row - 1 >= 0 && isOpen(row - 1, col)) {
            uf.union(row * size + col, (row - 1) * size + col);
        }
        if (row == 0) {
            uf.union(col, size * size);
        }
        if (row == size - 1) {
            uf.union(row * size + col, (size * size) + 1);
        }
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        return grid[row][col];

    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int numberOfOpenSites() {
        return opensites;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
        return uf.connected(size * size, size * size + 1);
    }
}
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Percolation p = new Percolation(scan.nextInt());
        while (scan.hasNext()) {
            p.open(scan.nextInt() - 1, scan.nextInt() - 1);
        }
        System.out.println(p.percolates());
    }
}
