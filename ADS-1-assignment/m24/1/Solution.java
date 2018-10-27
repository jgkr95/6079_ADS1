import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		AddStudent as = new AddStudent(size);
		for (int i = 0; i < size; i++) {
			String[] tokens = scan.nextLine().split(",");
			as.add(new Student(Integer.parseInt((tokens[0]))
				, tokens[1], Double.parseDouble(tokens[2])));
		}
		int queries = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < queries; i++) {
			String[] tokens = scan.nextLine().split(" ");
			Student sObj = as.get(Integer.parseInt(tokens[1]));
			boolean flag = as.contains(Integer.parseInt(tokens[1]));
			switch (tokens[2]) {
			case "1":
				if (flag) {
					System.out.println(sObj.getName());
				} else {
					System.out.println("Student doesn't exists...");
				}
				break;
			case "2":
				if (flag) {
					System.out.println(sObj.getTotal());
				} else {
					System.out.println("Student doesn't exists...");
				}
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
class Student {
	/**
	 * { var_description }
	 */
	int rollNumber;
	/**
	 * { var_description }
	 */
	String name;
	/**
	 * { var_description }
	 */
	double totalMarks;
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
	Student(final int rollNumber1, final String name1, final double totalMarks1) {
		rollNumber = rollNumber1;
		name = name1;
		totalMarks = totalMarks1;
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
/**
 * Class for add student.
 */
class AddStudent {
	/**
	 * { var_description }.
	 */
	Student[] sInfo;
	/**
	 * { var_description }.
	 */
	int size;
	/**
	 * Constructs the object.
	 *
	 * @param      size1  The size 1
	 */
	AddStudent(final int size1) {
		sInfo = new Student[size1];
	}
	/**
	 * { function_description }.
	 *
	 * @param      s     { parameter_description }
	 */
	public void add(final Student s) {
		sInfo[size++] = s;
	}
	/**
	 * { function_description }.
	 *
	 * @param      rollNumber  The roll number
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Student get(final int rollNumber) {
		Student s = new Student();
		for (int i = 0; i < size; i++) {
			if (sInfo[i].getRollNumber() == rollNumber) {
				if (s == null) {
					s = sInfo[i];
				} else if (sInfo[i].getTotal() > s.getTotal()) {
					s = sInfo[i];
				}
			}
		}
		return s;
	}
	/**
	 * { function_description }.
	 *
	 * @param      roll  The roll
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean contains(final int roll) {
		for (int i = 0; i < size; i++) {
			if (sInfo[i].getRollNumber() == roll) {
				return true;
			}
		}
		return false;
	}
}
