import java.util.Scanner;
import java.util.ArrayList;
public class Solution {
	public static void main(String[] args) {
		// BinarySearchSymbolTable<String, Integer> bst =
		//           new BinarySearchSymbolTable<String, Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		scan.nextLine();
		// bst = new BinarySearchSymbolTable<String, Integer>(n);
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
	Sorting s = new Sorting();
	AddStocks(int n) {
		stack = new Stocks[n];
		size = 0;
	}
	public void addStock(Stocks s) {
		stack[size++] = s;
		// System.out.println(size);
	}
	public void sort(int n) {
		s.sort(stack,n);
		for(int i=size-5;i<size;i++) {
			System.out.println(stack[i].getName() +" "+ stack[i].getChange());
		}System.out.println();
			
			
		
	}
	class Sorting {
		public void sort(Stocks[] st,int n) {
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					System.out.println(st[i].getChange());
					if (less(st[i],st[j])) {
						swap(st[i], st[j]);
					}
				}
			}
		}
		public void swap(Stocks s1, Stocks s2) {
			Stocks temp = s1;
			s2 = s1;
			s1 = temp;
		}
		public boolean less(Stocks s1, Stocks s2) {
			// System.out.println(s1.getChange() + " " + s2.getChange());
			if (s1.getChange() < s2.getChange()) {
				return true;
			}
			if (s1.getChange() - s2.getChange() == 0) {
				if (s1.getName().compareTo(s2.getName()) > 0) {
					return true;
				}
			}
			return false;
		}

	}
}

class Stocks {
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
}
