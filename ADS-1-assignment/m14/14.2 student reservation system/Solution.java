import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * name of the student.
     */
    private String name;
    /**
     * date of birth.
     */
    private String dob;
    /**
     * subject1 marks.
     */
    private int s1;
    /**
     * subject2 marks.
     */
    private int s2;
    /**
     * subject3 marks.
     */
    private int s3;
    /**
     * total marks.
     */
    private int total;
    /**
     * category.
     */
    private String category;
    /**
     * Constructs the object.
     *
     * @param      name1      The name
     * @param      dob1       The dob
     * @param      sub1        The s 1
     * @param      sub2        The s 2
     * @param      sub3        The s 3
     * @param      total1     The total
     * @param      category1  The category
     */
    Student(final String name1, final String dob1, final String sub1,
            final String sub2, final String sub3, final String total1,
            final String category1) {
        name = name1;
        dob = dob1;
        s1 = Integer.parseInt(sub1);
        s2 = Integer.parseInt(sub2);
        s3 = Integer.parseInt(sub3);
        total = Integer.parseInt(total1);
        category = category1;
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
     * Gets the total marks.
     *
     * @return     The total.
     */
    public int getTotal() {
        return total;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return category;
    }
    /**
     * Gets the year.
     *
     * @return     The year.
     */
    public int getYear() {
        String[] date = dob.split("-");
        int year = Integer.parseInt(date[2]);
        return year;
    }
    /**
     * Gets the month.
     *
     * @return     The month.
     */
    public int getMonth() {
        String[] date = dob.split("-");
        int month = Integer.parseInt(date[1]);
        return month;
    }
    /**
     * Gets the day.
     *
     * @return     The day.
     */
    public int getDay() {
        String[] date = dob.split("-");
        int day = Integer.parseInt(date[0]);
        return day;
    }
    /**
     * Method to compare two objects.
     *
     * @param      s    student object
     *
     * @return     integer value
     * Time complexity is O(1).
     */
    public int compareTo(final Student s) {
        if (this.total > s.total) {
            return 1;
        }
        if (this.total < s.total) {
            return -1;
        }
        if (this.s3 > s.s3) {
            return 1;
        }
        if (this.s3 < s.s3) {
            return -1;
        }
        if (this.s2 > s.s2) {
            return 1;
        }
        if (this.s2 < s.s2) {
            return -1;
        }
        if (this.getYear() > s.getYear()) {
            return 1;
        }
        if (this.getYear() < s.getYear()) {
            return -1;
        }
        if (this.getMonth() > s.getMonth()) {
            return 1;
        }
        if (this.getMonth() < s.getMonth()) {
            return -1;
        }
        if (this.getDay() > s.getDay()) {
            return 1;
        }
        if (this.getDay() < s.getDay()) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name + "," + this.total + "," + this.category;
    }
}
/**
 * Merit class.
 */
class Merit {
    /**
     * students array.
     */
    private Student[] students;
    /**
     * reserved array.
     */
    private Student[] reserved;

    /**
     * Gives the resrved object of index.
     *
     * @param      index  The index
     *
     * @return     element from reserved
     */
    Student reserved(final int index) {
        return this.reserved[index];
    }

    /**
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Merit() {
        final int fifty = 50;
        students = new Student[fifty];
        reserved = new Student[fifty];
        size = 0;
    }
    /**
     * Adds a student.
     *
     * @param      st    student object
     * Time complexity of this method is O(1)
     */
    public void addStudent(final Student st) {
        students[size++] = st;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].getName() + "," + students[i].getTotal()
                   + "," + students[i].getCategory() + "\n";
        }
        return str;
    }
    /**
     * Method to swap.
     *
     * @param      studentss  The students
     * @param      i         The index
     * @param      j         The index
     * Time complexity is O(1).
     */
    public void exch(final Student[] studentss, final int i, final int j) {
        Student stu = studentss[j];
        students[j] = studentss[i];
        students[i] = stu;
    }
    /**
     *Time complexity is O(1).
     * check if it is in the array.
     *
     * @param      obj   The object
     *
     * @return     true or false
     */
    public boolean contains(final Student obj) {
        for (Student stu : reserved) {
            try {
                if (stu.equals(obj)) {
                    return true;
                }
            } catch (Exception e) {

            }
        }
        return false;
    }
    /**
     * copy into array based on reservation and vacancies.
     *
     * @param      noOfvacancies  No ofvacancies
     * @param      noOfunres      No ofunres
     * @param      noOfBC         No of bc
     * @param      noOfSC         No of sc
     * @param      noOfST         No of st
     */
    public void sortReserve(final int noOfvacancies, final int noOfunres,
                     final int noOfBC, final int noOfSC, final int noOfST) {
        int z = 0;
        for (int i = 0; i < noOfunres; i++) {
            reserved[z++] = students[i];
        }
        int bc = 0;
        if (noOfBC != 0) {
            for (int i = noOfunres; i < students.length; i++) {
                try {
                    if (students[i].getCategory().equals("BC")) {
                        reserved[z++] = students[i];
                        bc++;
                        if (bc == noOfBC) {
                            break;
                        }
                    }
                } catch (Exception e) {

                }
            }
        }
        int sc = 0;
        if (noOfSC != 0) {
            for (int i = noOfunres; i < size; i++) {
                if (students[i].getCategory().equals("SC")) {
                    reserved[z++] = students[i];
                    sc++;
                    if (sc == noOfSC) {
                        break;
                    }
                }
            }
        }
        int st = 0;
        if (noOfST != 0) {
            for (int i = noOfunres; i < size; i++) {
                if (students[i].getCategory().equals("ST")) {
                    reserved[z++] = students[i];
                    st++;
                    if (st == noOfST) {
                        break;
                    }
                }
            }
        }
        if (bc != noOfBC) {
            for (int i = noOfunres; i < students.length; i++) {
                if (!contains(students[i])) {
                    reserved[z++] = students[i];
                    bc++;
                    if (bc == noOfBC) {
                        break;
                    }
                }
            }
        }
        if (sc != noOfSC) {
            for (int i = noOfunres; i < students.length; i++) {
                if (!contains(students[i])) {
                    reserved[z++] = students[i];
                    sc++;
                    if (sc == noOfSC) {
                        break;
                    }
                }
            }
        }
        if (st != noOfST) {
            for (int i = noOfunres; i < students.length; i++) {
                if (!contains(students[i])) {
                    reserved[z++] = students[i];
                    st++;
                    if (st == noOfST) {
                        break;
                    }
                }
            }
        }
        reserved = Arrays.copyOf(reserved, z);
        Arrays.sort(reserved, Collections.reverseOrder());
    }
    /**
     * Insertion sort takes place in this method.
     * Time complexity is O(N^2) because of nested loop.
     */
    public void insertionsort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (!less(students, j - 1, j)) {
                    break;
                } else {
                    exch(students, j - 1, j);
                }
            }
        }
    }
    /**
     * compare two objects.
     *
     * @param      arr   The arr
     * @param      i     The index
     * @param      j     The index
     *
     * @return     true or false
     * Time complexity is O(1).
     */
    public boolean less(final Student[] arr, final int i, final int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }
}
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
     * main function to handle to the input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Merit m = new Merit();
        final int zero = 0, one = 1, two = 2, three = 3, four = 4, five = 5,
                         six = 6;
        int noOfapplied = Integer.parseInt(sc.nextLine());
        int noOfvacancies = Integer.parseInt(sc.nextLine());
        int noOfOpen = Integer.parseInt(sc.nextLine());
        int noOfBC = Integer.parseInt(sc.nextLine());
        int noOfSC = Integer.parseInt(sc.nextLine());
        int noOfST = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < noOfapplied; i++) {
            String data = sc.nextLine();
            String[] tokens = data.split(",");
            m.addStudent(new Student(tokens[zero], tokens[one], tokens[two],
                    tokens[three], tokens[four], tokens[five], tokens[six]));
        }
        m.insertionsort();
        System.out.println(m);
        m.sortReserve(noOfvacancies, noOfOpen, noOfBC, noOfSC, noOfST);
        for (int i = 0; i < noOfvacancies; i++) {
            System.out.println(m.reserved(i));
        }
    }
}
