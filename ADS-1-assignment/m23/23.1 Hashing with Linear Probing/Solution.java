import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinearProbingHash lph = new LinearProbingHash(n);
        LinearProbing lp = new LinearProbing();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            int index;
            //System.out.println(Arrays.toString(input));
            switch (input[0]) {
            case "put":
                index = lp.hashhCode(input[1], n);
                lph.put(new LinearProbing(input[1], Integer.parseInt(input[2])), index);
                break;
            case "get":
                System.out.println(lph.get(input[1]));
                break;
            case "delete":
                lph.delete(input[1]);
                break;
            case "display":
                System.out.println(lph.display());
                break;
            default:
                break;
            }
        }
    }
}
class LinearProbing {
    String key;
    int value;
    LinearProbing(String key1, int value1) {
        key = key1;
        value = value1;
    }
    LinearProbing() {

    }
    public String getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
    public int hashhCode(String key, int m) {
        final int eleven = 11;
        return (eleven * key.hashCode()) % m;
    }
}
class LinearProbingHash {
    LinearProbing[] lp;
    int n;
    LinearProbingHash(int n1) {
        lp = new LinearProbing[n];
        n = n1;
    }
    public void put(LinearProbing s, int index) {
        int i=0;
        if (lp[index].equals(null)) {
            lp[index] = s;
        } else {
            while (lp[i] != null) {
                i = index;
                i = i + 1;
            }
            lp[i] = s;
            if (i == n - 1) {
                i = 0;
            }
        }



    }
    public Integer get(String key) {
        for (int i = 0; i < n; i++) {
            if (lp[i].getKey().equals(key)) {
                return lp[i].getValue();
            }
        }
        return null;
    }
    public void delete(String key) {
        for (int i = 0; i < n; i++) {
            if (lp[i].getKey().equals(key)) {
                lp[i] = null;
            }
        }
    }
    public String display() {
        String str = "{";
        int i;
        for (i = 0; i < n - 1; i++) {
            if (lp[i] != null) {
                str += lp[i].getKey() + ":" + lp[i].getValue() + ", ";
            }
        }
        if (lp[i] != null) {
            str += lp[i].getKey() + ":" + lp[i].getValue();
        }
        str += "}";
        return str;
    }


}