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
	int opensites,rowcount,bottomrowcount;
	boolean[][] grid;
	public Percolation(int n) {
		grid = new boolean[n][n];
	}
	public void open(int row, int col) {
		grid[row - 1][col - 1] = true;
		if(row-1==0) rowcount++;
		if(row-1==grid.length-1) bottomrowcount++;
		opensites++;
	}
	public boolean isOpen(int row, int col) {
		return grid[row - 1][col - 1];
	}
	public boolean isFull(int row, int col) {
		return (opensites == row - 1 * col - 1);
	}
	public int numberOfOpenSites() {
		return opensites;
	}
	public boolean percolates() {
		int i = 0, j = 0;
		if(rowcount==0||bottomrowcount==0) return false;
		while (i < grid.length) {
			while (j < grid.length) {
				if (grid[i][j]) {
					if (j != grid.length - 1 && grid[i][j + 1]) {

					}
					if (i != grid.length - 1 && grid[i + 1][j]) {

					}
					if (j != 0 && grid[i][j - 1]) {

					}
					if (i != 0 && grid[i - 1][j]) {

					}
				}
			}
		}
		return true;
	}
}
public final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Percolation p = new Percolation(scan.nextInt());
		while (scan.hasNext()) {
			p.open(scan.nextInt(), scan.nextInt());
		}
		System.out.println(p.percolates());
	}
}

