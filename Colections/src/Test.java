import java.util.HashSet;

class Student {
	public Student(int r) {
		rollno = r;
	}
	
	int rollno;
	
	
}

public class Test {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student(4));
		
		Student student = new Student(6);
		
		students.add(new Student(6));
		
		System.out.println(students.contains(new Student(6)));
	}
}
