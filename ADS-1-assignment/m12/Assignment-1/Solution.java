import java.util.Scanner;
class Solution {
    Solution() { }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // Reserve res = new Reserve(n);
        Reserve res;
        Student[] merit;
        Student[] reserved;
        int[] reserve = new int[6];
        for (int i = 0; i < 5; i++) {
            reserve[i] = scan.nextInt();
        } reserve[reserve.length - 1] = n;
        scan.nextLine();
        res = new Reserve(reserve);
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(",");
            res.addStudent(new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]));

        }
        merit = res.sort();
        res.print(merit);
        System.out.println();
        reserved = res.reservationCreteria();
        res.print(reserved);
        System.out.println();
    }

}
class Reserve {
    private int vacancies;
    private int open;
    private int bc;
    private int sc;
    private int st;
    private Student[] students;
    private int size;
    private int studentcount;
    Reserve(int[] info) {
        // private final int index = 0;
        vacancies = info[0];
        open = info[1];
        bc = info[2];
        sc = info[3];
        st = info[4];
        studentcount = info[5];
        students = new Student[studentcount];
        size = 0;
    }
    public void addStudent(Student s) {
        students[size++] = s;
    }
    public Student[] sort() {
        Insertionsort insertion = new Insertionsort();
        students = insertion.sort(students, size);
        return students;
    }
    public void print(Student[] stud) {
        String str = "";
        try {
            for (int i = 0; i < stud.length; i++) {
                str = stud[i].getName() + "," + stud[i].getTotal() + "," + stud[i].getCategory();
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.print("");
        }
    }
    public Student[] reservationCreteria() {
        int count = 0;
        Student[] rescre = new Student[vacancies];
        for (int i = 0; i < open; i++) {
            // System.out.println(i);
            rescre[i] = students[i];
        }
        for (int i = open  ; i < open + bc; i++) {

            for (int j = i; j < size; j++) {
                if (students[j].getCategory().equals("BC")) {
                    // System.out.println(i);
                    rescre[i] = students[j];
                }
            }
        }
        for (int i = open + bc ; i < open + bc + sc; i++) {
            count = 0;
            for (int j = i; j < size; j++) {
                if (students[j].getCategory().equals("ST")) {
                    // System.out.println(i + "st");
                    count++;
                    rescre[i] = students[j];
                    if (count == st) {
                        break;
                    }
                }
            }
        }
        for ( int i = open + bc + st ; i < vacancies; i++) {
            // System.out.println("i loop");
            count = 0;
            for (int j = i; j < size; j++)  {
                // System.out.println(" j loop");
                if (students[j].getCategory().equals("SC")) {
                    // System.out.println("st loop");
                    // System.out.println(i + "sc");
                    count++;
                    // System.out.println(students[j].getName());
                    rescre[i] = students[j];
                    // System.out.println(rescre[i].getName());
                    if (count == sc) {
                        break;
                    }

                }
            }
        }
        for(int i=open+sc+bc+st;i<vacancies;i++) {
            for(int j=0;j<size;j++) {
                rescre[i]=students[j];
                // if(i+1==vacancies) {
                //     break;
                // }
            }
        }

        return rescre;
    }

}
class Student {
    private String name;
    private String dob;
    private int m1;
    private int m2;
    private int m3;
    // private int m4;
    private String category;
    private int total;
    Student(String name1, String date1, int ms1, int ms2, int ms3, int ms4, String category1) {
        name = name1;
        dob = date1;
        m1 = ms1;
        m2 = ms2;
        m3 = ms3;
        total = ms4;
        category = category1;
    }
    public int getTotal() {
        return total;
    }
    public int getM1() {
        return m1;
    }
    public int getM2() {
        return m2;
    }
    public int getM3() {
        return m3;
    }
    public String getDob() {
        return dob;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
}
class Insertionsort {
    /**
     * Constructs the object.
     */
    Insertionsort() {

    }
    /**
     * To perform selection sort.
     *
     * @param      team  The teams
     * @param      size   The size
     *
     * @return     sorted array of team objects
     * Time complexity of This method is O(N^2)
     *  because we are using nested for loops
     *   in worst case it may go up to O(N^2)
     */
    public Student[] sort(final Student[] stud, final int size) {
        Student[] stu = stud;
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (compare(stu[j - 1].getTotal(), stud[j].getTotal()) > 0) {
                    swap(j - 1, j, stu);
                } else if (compare(stu[j - 1].getTotal(), stud[j].getTotal()) == 0) {
                    if (compare(stu[j - 1].getM3(), stud[j].getM3()) > 0) {
                        swap(j - 1, j, stu);
                    } else if (compare(stu[j - 1].getM3(), stud[j].getM3()) == 0) {
                        if (compare(stu[j - 1].getM2(), stud[j].getM2()) > 0) {
                            swap(j - 1, j, stu);
                        } else if (compare(stu[j - 1].getM2(), stud[j].getM2()) == 0) {
                            if (stu[j - 1].getDob().compareTo(stu[j].getDob()) < 0) {
                                swap(j - 1, j, stu);
                            }
                        }
                    }
                }
            }
        }
        return stu;
    }
    /**
     * swapping the team objects.
     *
     * @param      index1  The index 1
     * @param      index2  The index 2
     * @param      teams   The teams
     */
    public void swap(final int index1, final int index2, final Student[] stud) {
        Student temp;
        temp = stud[index1];
        stud[index1] = stud[index2];
        stud[index2] = temp;
    }
    /**
     * compares two values.
     *
     * @param      a     { index position }
     * @param      b     { index position }
     *
     * @return     -1 if first element is less, 1 if greater and 0 if equal
     *
     */
    public int compare(final int a, final int b) {
        if (a < b) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}