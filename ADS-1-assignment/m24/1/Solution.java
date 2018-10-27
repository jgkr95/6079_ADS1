import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		AddStudent as = new AddStudent(size);
		for (int i = 0; i < size; i++) {
			String[] tokens = scan.nextLine().split(",");
			as.add(new Student(Integer.parseInt((tokens[0])), tokens[1], Double.parseDouble(tokens[2])));
		}
		int queries = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < queries; i++) {
			String[] tokens = scan.nextLine().split(" ");
			Student sObj = as.get(Integer.parseInt(tokens[1]));
			if (sObj == null) {
				System.out.println("Student doesn't exists...");
			}
			switch (tokens[2]) {
			case "1":
				System.out.println(sObj.getName());
				break;
			case "2":
				if (sObj.getTotal() < 1) {
					System.out.println("Student doesn't exists...");
				} else {
					System.out.println(sObj.getTotal());
				}
				break;
			default:
				break;
			}
		}
	}
}
class Student {
	int rollNumber;
	String name;
	double totalMarks;
	Student() {

	}
	Student(int rollNumber1, String name1, double totalMarks1) {
		rollNumber = rollNumber1;
		name = name1;
		totalMarks = totalMarks1;
	}
	public String getName() {
		return name;
	}
	public double getTotal() {
		return totalMarks;
	}
	public int getRollNumber() {
		return rollNumber;
	}
}
class AddStudent {
	Student[] sInfo;
	int size;
	AddStudent(int size1) {
		sInfo = new Student[size1];
	}
	public void add(Student s) {
		sInfo[size++] = s;
	}
	public Student get(int rollNumber) {
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

}