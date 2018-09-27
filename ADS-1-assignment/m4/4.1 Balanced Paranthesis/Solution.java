import java.util.Scanner;
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

        int nooflines = scan.nextInt();
        for (int i = 0; i < nooflines; i++) {

            String line = scan.next();
            Stack paren = new Stack(line);
            System.out.println(paren.check());
        }
    }

}
/**
 * List of .
 */
class Stack {
    /**
     * { var_description }.
     */
    private String data;
    /**
     * { var_description }.
     */
    private char[] braces;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    Stack(final String input) {
        data =  input;
        braces = new char[data.length()];
        size = 0;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String check() {
        for (int i = 0; i < data.length(); i++) {
            char compare = data.charAt(i);
            if (compare == '(' || compare == '{' || compare == '[') {
                push(compare);

            } if (size != 0) {
                if (compare == ')') {
                    if (braces[size - 1] == '(') {
                        pop(compare);
                    }
                } else if (compare == '}') {
                    if (braces[size - 1] == '{') {
                        pop(compare);
                    }
                } else if (compare == ']') {
                    if (braces[size - 1] == '[') {
                        pop(compare);
                    }
                }
            }
        }
        if (size == 0) {
            return "YES";
        }
        return "NO";
    }
    /**
     * { function_description }.
     *
     * @param      in    { parameter_description }
     */
    public void push(final char in) {
        braces[size++] = in;
    }
    /**
     * { function_description }.
     *
     * @param      in    { parameter_description }
     */
    public void pop(final char in) {
        if (size != 0) {
            size--;
        }

    }

}
