import java.util.Scanner;
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            list.insert(Integer.parseInt(String.valueOf(digit)));
        }
        return list;
    }

    public static String digitsToNumber(LinkedList list) {
        String number = list.toStri();
        return number;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        String number1 = list1.toStri();
        String number2 = list2.toStri();
        int maxlength = 0;
        LinkedList resultadded = new LinkedList();
        Stack stack1 = new Stack(list1.toStri());
        Stack stack2 = new Stack(list2.toStri());
        if (list1.toStri().length() > list2.toStri().length()) {
            maxlength = list1.toStri().length();
        } else {
            maxlength = list2.toStri().length();
        }
        Stack result = new Stack(maxlength);
        for (int i = 0; i < number1.length(); i++) {
            char digit = number1.charAt(i);
            stack1.push(Integer.parseInt(String.valueOf(digit)));
        }
        for (int i = 0; i < number2.length(); i++) {
            char digit1 = number2.charAt(i);
            stack2.push(Integer.parseInt(String.valueOf(digit1)));
        }
        int carry = 0, op1 = 0, op2 = 0;
        while (true) {
            op1 = 0;
            op2 = 0;
            if (stack1.isempty() && stack2.isempty()) break;
            if (!stack1.isempty()) { op1 = stack1.top();  stack1.pop(); }
            if (!stack2.isempty()) { op2 = stack2.top();  stack2.pop(); }
            int opTotal = 0;
            opTotal = op1 + op2 + carry;
            // System.out.println(opTotal%10);
            result.push(opTotal % 10);
            if (opTotal >= 10) carry = 1; else carry = 0;
        }if (list1.toStri().length() == list2.toStri().length()) result.push(carry);
        while (!result.isempty()) {
            int top = result.top();
            // System.out.println(top);
            result.pop();
            resultadded.insert(top);
        }
        return resultadded;

    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
