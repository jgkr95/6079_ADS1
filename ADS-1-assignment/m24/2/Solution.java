import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
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
        int size = Integer.parseInt(scan.nextLine());
        Student[] stu=new Student[size];
        // AddStudent as = new AddStudent(size);
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        for (int i = 0; i < size; i++) {
            String[] tokens = scan.nextLine().split(",");
            stu[i]=new Student(Integer.parseInt((tokens[0])),
                            tokens[1], Double.parseDouble(tokens[2]));
            st.put(stu[i],i);
            // as.add(new Student(Integer.parseInt((tokens[0])),
            //                 tokens[1], Double.parseDouble(tokens[2])));
        }
        int queries = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < queries; i++) {
            String[] tokens = scan.nextLine().split(" ");

            
            switch (tokens[2]) {
            case "BE":
                /**.
                 *between method gives for first arguement the root node
                 * equavalent and its right side children names
                 * and for second arguement the root node equivalent and
                 * left side children names.
                 */
                st.between(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
                break;
            case "LE":
                /**
                 * less than method gives left side children names.
                 */
                st.lessThan(Double.parseDouble(tokens[1]));
                break;
            case "GE":
                /**
                 * greater than gives right side children names.
                 */
                st.greaterThan(Double.parseDouble(tokens[1]));
                break;
            default:
                break;
            }
        }
    }
}
/**
 * Class for student.
 */
class Student implements Comparable{
    /**
     * { student roll number }.
     */
    private int rollNumber;
    /**
     * { student name }.
     */
    private String name;
    /**
     * { total marks of the student }.
     */
    private double totalMarks;
    /**
     * Constructs the object.
     */
    Student() {

    }
    /**
     * Constructs the object.
     *
     * @param      rollNumber1  The roll number 1
     * @param      name1        The name 1
     * @param      totalMarks1  The total marks 1
     */
    Student(final int rollNumber1, final String name1,
        final double totalMarks1) {
        rollNumber = rollNumber1;
        name = name1;
        totalMarks = totalMarks1;
    }
    /**
     * compares the total marks.
     *
     * @param      that  The that
     *
     * @return     { 1 if this.totalmarks are greater else -1 }
     */
    public int compareTo(Student that) {
        if(this.getTotal()>that.getTotal()) {
            return 1;
        }
        if(this.getTotal()<that.getTotal()) {
            return -1;
        }
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public double getTotal() {
        return totalMarks;
    }
    /**
     * Gets the roll number.
     *
     * @return     The roll number.
     */
    public int getRollNumber() {
        return rollNumber;
    }
}
