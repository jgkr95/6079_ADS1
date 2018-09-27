import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int nooflines = scan.nextInt();
		for (int i = 0; i < nooflines; i++) {

			String line = scan.next();
			stack paren = new stack(line);
			System.out.println(paren.check());
		}
	}

}
class stack {
	private String data;
	char[] braces;
	int size;

	public stack(final String input) {
		data =  input;
		braces = new char[data.length()];
		size = 0;
	}
	public String check() {
		// System.out.println(data+"--"+data.length());
		for(int i=0;i<data.length();i++) {
			// System.out.println(data.charAt(i));
		}
		for (int i = 0; i < data.length(); i++) {
			char compare = data.charAt(i);
			// System.out.println(compare);
			if (compare == '(' || compare == '{' || compare == '[') {
				// System.out.println(i+"-----");
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
				} else {
					// break;
				}
			}
		}
		System.out.println(size+" size");
		if (size == 0) {
			return "YES";
		}
		return "NO";
	}
	public void push(char in) {
		braces[size++] = in;
		// System.out.println(size+":::::::");
	}
	public void pop(char in) {
		if (size != 0) {
			size--;
		}

	}

}