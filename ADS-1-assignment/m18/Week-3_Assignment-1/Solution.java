import java.util.Scanner;
import java.util.ArrayList;
public class Solution {
	public static void main(String[] args) {
		// BinarySearchSymbolTable<String, Integer> bst =
		//           new BinarySearchSymbolTable<String, Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		scan.nextLine();
		for (int i = 0; i < 6; i++) {
			AddStocks as = new AddStocks(n);
			for(int j=0;j<n;j++) {
			String[] tokens = scan.nextLine().split(",");
			as.addStock(new Stocks(tokens[0], Double.parseDouble(tokens[1])));
		}as.sort(n);
		}
		

	}
}
class AddStocks {
	Stocks[] stack;
	int size;
	MinPQ<Stocks> min;
	MaxPQ<Stocks> max;
	
	AddStocks(int n) {
		stack = new Stocks[n];
		size = 0;
		min = new MinPQ<Stocks>(n);
		max = new MaxPQ<Stocks>(n);
 	}
	public void addStock(Stocks s) {

		stack[size++] = s;
		min.insert(s);
		max.insert(s);
	}
	public void sort(int n) {
		Sorting s = new Sorting();
		s.sort(stack,n);

		for(int i=0;i<5;i++) {
			System.out.println(max.delMax());
		}System.out.println();
		for(int i=n-5;i<n;i++) {
			System.out.println(min.delMin());
		}System.out.println();
	}
}

class Stocks implements Comparable<Stocks>{
	String name;
	double change;
	Stocks(String name1, double change1) {
		name = name1;
		change = change1;
	}
	public double getChange() {
		return change;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name+" "+change;
	}
	public int compareTo(final Stocks that) {
		if(this.change>that.change) {
			return 1;
		} if(this.change<that.change) {
			return -1;
		}
		if(this.getName().compareTo(that.getName())>0) {
			return 1;
		}
		if(this.getName().compareTo(that.getName())<0) {
			return -1;
		}
		return 0;
	}
}
