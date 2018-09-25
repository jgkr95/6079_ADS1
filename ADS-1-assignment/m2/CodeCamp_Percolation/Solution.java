import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { Number of opened blocks in grid }.
     */
    private int opensites = 0;
    /**
     * { object of WeightedQuickUnionUF }.
     */
    private WeightedQuickUnionUF uf;
    /**
     * { grid 2d square array with given size }.
     */
    private boolean[][] grid;
    /**
     * { size of grid }.
     */
    private int size;
    /**
     * Constructs initiliases the object.
     *
     * @param      n     { size oof the grid }
     */
    Percolation(final int n) {
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        size = n;
    }
    /**
     * { opens the blocks and sends them for union operation }.
     *
     * @param      row   The row is of integer type
     * @param      col   The col is of integer type
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
     * Determines if open or not.
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
     * { returns the number of open blocks }.
     *
     * @return     { integer varibale of opensites }
     */
    public int numberOfOpenSites() {
        return opensites;
    }
    /**
     * { Determines whether the grid percolates or not }.
     *
     * @return     { true if percolates else false }
     */
    public boolean percolates() {
        return uf.connected(size * size, size * size + 1);
    }
}
/**
 * { Solution to read input }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { main method to handle input }.
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
