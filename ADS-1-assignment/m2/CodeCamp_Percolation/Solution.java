// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }
import java.util.Scanner;
class Percolation {
    int opensites = 0;
    WeightedQuickUnionUF uf;
    boolean[][] grid;
    int size;
    public Percolation(int n) {
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        size = n;
    }
    public void open(int row, int col) {
        if (grid[row][col]) return;
        grid[row][col] = true;
        opensites++;
        if (col-1 < size && isOpen(row, col + 1)) {
            uf.union(row * size + col, row * size + (col + 1));
        }
        if (row-1 < size&& isOpen(row + 1, col)) {
            uf.union(row * size + col, row + 1 * size + col);

        }
        if (col > 0 && isOpen(row, col - 1)) {
            uf.union(row * size + col, row * size + (col - 1));

        }
        if (row > 0 && isOpen(row - 1, col)) {
            uf.union(row * size + col, (row - 1) * size + col);
        }
        if (row == 0) {
            uf.union(col, size * size);
        }
        if (row == size - 1) {
            uf.union(col, (size * size) + 1);
        }
    }
    public boolean isOpen(int row, int col) {
        return grid[row][col];

    }
    // public boolean isFull(int row, int col) {
    //  return (opensites == row - 1 * col - 1);
    // }
    public int numberOfOpenSites() {
        return opensites;
    }
    public boolean percolates() {
        return uf.connected(size, size + 1);
    }
}

public final class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Percolation p = new Percolation(scan.nextInt());
        while (scan.hasNext()) {
            p.open(scan.nextInt() - 1, scan.nextInt() - 1);
        }
        System.out.println(p.percolates());
    }
}

