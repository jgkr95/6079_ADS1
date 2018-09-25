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
	int opensites = 0,rowcount = 0,bottomrowcount = 0;
	WeightedQuickUnionUF uf;
	boolean[][] grid;
	int size;
	public Percolation(int n) {
		grid = new boolean[n][n];
		uf = new WeightedQuickUnionUF(n*n+2);
		size = n*n;
	}
	public void open(int row, int col) {
		if(grid[row][col]) return;
		grid[row][col] = true;
		opensites++;
		if (col != grid.length - 1 && grid[row][col + 1]) {
			uf.union(row*grid.length+col, row*grid.length+(col+1));
		}
		if (row != grid.length - 1 && grid[row + 1][col]) {
			uf.union(row*grid.length+col, row+1*grid.length+col);

		}
		if (col != 0 && grid[row][col - 1]) {
			uf.union(row*grid.length+col, row*grid.length+(col-1));

		}
		if (row != 0 && grid[row - 1][col]) {
			uf.union((row-1)*grid.length+col, (row-1)*grid.length+col);
		}
	}
	public boolean isOpen(int row, int col) {
		return grid[row][col];
		
	}
	// public boolean isFull(int row, int col) {
	// 	return (opensites == row - 1 * col - 1);
	// }
	public int numberOfOpenSites() {
		return opensites;
	}
	public boolean percolates() {
		return uf.connected(size,size+1);
	}
}

public final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Percolation p = new Percolation(scan.nextInt());
		while (scan.hasNext()) {
			p.open(scan.nextInt()-1, scan.nextInt()-1);
		}
		System.out.println(p.percolates());
	}
}

