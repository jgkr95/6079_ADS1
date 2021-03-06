import java.util.Scanner;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) {
        // BinarySearchSymbolTable<String, Integer> bst =
        //           new BinarySearchSymbolTable<String, Integer>();

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        AddStocks as = new AddStocks(n);
        Stocks stockdata;

        BinarySearchSymbolTable<String, Integer> maxST =
            new BinarySearchSymbolTable<String, Integer>();
        BinarySearchSymbolTable<String, Integer> minST =
            new BinarySearchSymbolTable<String, Integer>();

        
        for (int i = 0; i < 6; i++) {
            as = new AddStocks(n);
            MinPQ<Stocks> min = new MinPQ<Stocks>(n);
            MaxPQ<Stocks> max = new MaxPQ<Stocks>(n);
            for (int j = 0; j < n; j++) {
                String[] tokens = scan.nextLine().split(",");
                // as.addStock(new Stocks(tokens[0], Double.parseDouble(tokens[1])));
                stockdata = new Stocks(tokens[0], Double.parseDouble(tokens[1]));
                min.insert(stockdata);
                max.insert(stockdata);

            }
            // as.sort(n);
            for (int l = 0; l < 5; l++) {
                Stocks temp = max.delMax();
                System.out.println(temp);
                if (maxST.contains(temp.getName())) {
                    maxST.put(temp.getName(), maxST.get(temp.getName()) + 1);
                } else {
                    maxST.put(temp.getName(), 1);
                    // distinct++;
                }

            } System.out.println();
            for (int k = 0; k < 5; k++) {
                Stocks temp1 = min.delMin();
                System.out.println(temp1);
                if (minST.contains(temp1.getName())) {
                    minST.put(temp1.getName(), minST.get(temp1.getName()) + 1);
                } else {
                    minST.put(temp1.getName(), 1);
                    // distinct++;
                }
            } System.out.println();

        }
        int n1 = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            
            String[] tokens = scan.nextLine().split(",");
            // as = new AddStocks();
            switch (tokens[0]) {
            case "get" :
                // as.get(tokens[1], tokens[2]);
                if (tokens[1].equals("minST")) {
                    if(minST.get(tokens[2])==null) {
                        System.out.println(0);
                    }else {
                    System.out.println(minST.get(tokens[2]));
                }}
                if (tokens[1].equals("maxST")) {
                    if(maxST.get(tokens[2])==null) {
                        System.out.println(0);
                    }else {
                    System.out.println(maxST.get(tokens[2]));
                }
                }
                break;
            case "intersection":
                // as.intersection();
                ArrayList<String> minkeys = minST.keys();
                ArrayList<String> maxkeys = maxST.keys();
                for (String keysMin : minkeys) {
                    for (String keysMax : maxkeys) {
                        if (keysMin.equals(keysMax)) {
                            System.out.println(keysMin);
                        }
                    }
                }
                break;
            default:
                break;
            }
        }


    }
}

class AddStocks {
    Stocks[] stack;
    int size;
    MinPQ<Stocks> min;
    MaxPQ<Stocks> max;
    BinarySearchSymbolTable<String, Integer> maxST =
        new BinarySearchSymbolTable<String, Integer>();
    BinarySearchSymbolTable<String, Integer> minST =
        new BinarySearchSymbolTable<String, Integer>();


    AddStocks(int n) {
        stack = new Stocks[n];
        size = 0;
        min = new MinPQ<Stocks>(n);
        max = new MaxPQ<Stocks>(n);
    }
    AddStocks() {

    }
    public void addStock(Stocks s) {

        // stack[size++] = s;
        min.insert(s);
        max.insert(s);
    }
    public void sort(int n) {
        for (int i = 0; i < 5; i++) {
            Stocks temp = max.delMax();
            System.out.println(temp);
            if (maxST.contains(temp.getName())) {
                maxST.put(temp.getName(), maxST.get(temp.getName()) + 1);
            } else {
                maxST.put(temp.getName(), 1);
                // distinct++;
            }

        } System.out.println();
        for (int i = n - 5; i < n; i++) {
            Stocks temp1 = min.delMin();
            System.out.println(temp1);
            if (minST.contains(temp1.getName())) {
                minST.put(temp1.getName(), minST.get(temp1.getName()) + 1);
            } else {
                minST.put(temp1.getName(), 1);
                // distinct++;
            }
        } System.out.println();
    }
    public void get(String str, String name) {
        if (str.equals("minST")) {
            System.out.println(minST.get(name));
        }
        if (str.equals("maxST")) {
            System.out.println(maxST.get(name));
        }
    }
    public void intersection() {
        ArrayList<String> minkeys = minST.keys();
        ArrayList<String> maxkeys = maxST.keys();
        for (String keysMin : minkeys) {
            for (String keysMax : maxkeys) {
                if (keysMin.equals(keysMax)) {
                    System.out.println(keysMin);
                }
            }
        }
    }
}

class Stocks implements Comparable<Stocks> {
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
        return name + " " + change;
    }
    public int compareTo(final Stocks that) {
        if (this.change > that.change) {
            return 1;
        } if (this.change < that.change) {
            return -1;
        }
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        }
        if (this.getName().compareTo(that.getName()) < 0) {
            return -1;
        }
        return 0;
    }
}
