package as_501;

import java.util.Scanner;

public class CourseManagement {
	
	public static void find(String type, Course[] course) {
		for (int i = 0; i < course.length; i++) {
			if(course[i].getName().equals(type)) {
				System.out.println(course[i]);
			}else if (course[i].getCode().equals(type)) {
				System.out.println(course[i]);
			}else if (course[i].getStatus().equals(type)) {
				System.out.println(course[i]);
			}else if (course[i].getFlag().equals(type)) {
				System.out.println(course[i]);
			}
					
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Course[] course = new Course[2];

//		course[0] = new Course("FW001", "SQL", 4.0, "active", "optional");
//
//		course[1] = new Course("FW002", "Java", 4.0, "active", "optional");
//
//		course[2] = new Course("FW004", "Ruby", 3.0, "in-active", "mandatory");
//
//		course[3] = new Course("FW005", "C++", 2.0, "in-active", "mandatory");
//
//		course[4] = new Course("FW006", "Js", 4.0, "active", "N/A");
		
		for (int i = 0; i < course.length; i++) {
			System.out.println("1. Enter the employee " + (i + 1));
			course[i] = new Course();
			course[i].input();
		}
		
		System.out.println("2. Display all course");
		for (Course item : course) {
			System.out.println(item);
		}
		
		System.out.println("3. Find course by value (name,code,status,type)");
		String value = scanner.next();
		find(value, course);

		System.out.println("4. Display all course with flag is mandatory");
		
		find("mandatory", course);
	}
}
