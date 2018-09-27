import java.util.Scanner;
public final class Solution{
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int nooflines = scan.nextInt();
		for(int i=0;i<nooflines;i++) {
			
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
		braces = new char[200];
		size = 0; 
	}
	public String check() {
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)=='('||data.charAt(i)=='{'||data.charAt(i)=='{') {
				push(data.charAt(i));
			}if(size!=0) {
			if(data.charAt(i)==')') {
				if(braces[size-1]=='(') {
					pop(data.charAt(i));
				}
			}else if(data.charAt(i)=='}') {
				if(braces[size-1]=='{') {
					pop(data.charAt(i));
				}
			}else if(data.charAt(i)==']') {
				if(braces[size-1]=='[') {
					pop(data.charAt(i));
				}
			} else{
				return "NO++++";	
			}}
		}
		if(size==0) {
			return "YES";
		}
		return "NO";
	}
	public void push(char in) {
		braces[size++] = in;
	}
	public void pop(char in) {
		if(size!=0) {
			size--;
		}
		
	}

}