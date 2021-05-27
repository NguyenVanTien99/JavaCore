package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.GoodStudent;
import entities.NormalStudent;
import fileio.FileToObject;

public class StudentManagement {
	public static void main(String[] args) {
		String choice = "";
		Scanner scanner = new Scanner(System.in);
		List<GoodStudent> goodStudents;
		List<NormalStudent> normalStudents ;

		do {
			getmenu();

			System.out.println("Enter the choice: ");
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				
				try {
					goodStudents = FileToObject.convertGoodStudentFromFile();
					for (GoodStudent goodStudent : goodStudents) {
						System.out.println(goodStudent.showMyInfor());
					}
				} catch (Exception e) {
					System.out.println("input file have unknow errors");
				}
				

				
				
				break;
				
			case "2":
				
				try {
					normalStudents = FileToObject.convertNormalStudentFromFile();
					for (NormalStudent normalStudent : normalStudents) {
						System.out.println(normalStudent.showMyInfor());
					}
				} catch (Exception e) {
					System.out.println("input file have unknow errors");
				}
				

				
				
				break;
				
			default:
				choice = "N";
			}
		} while (choice != "N");
	}

	public static void getmenu() {
		System.out.println("--------------Menu----------------");
		System.out.println("1.Display all good student");
		System.out.println("2.Display all Normal student");

	}
}
