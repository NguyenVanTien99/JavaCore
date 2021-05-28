package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.GoodStudentDAO;
import dao.NormalStudentDAO;
import dao.impl.GoodStudentDAOimpl;
import dao.impl.NormalStudentDAOimpl;
import entities.GoodStudent;
import entities.NormalStudent;
import fileio.FileToObject;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class StudentManagement {
	public static void main(String[] args) {
		String choice = "";
		Scanner scanner = new Scanner(System.in);
		List<GoodStudent> goodStudents;
		List<NormalStudent> normalStudents;

		StudentService studentService = new StudentServiceImpl();

		NormalStudentDAO normalStudentDAO = new NormalStudentDAOimpl();

		GoodStudentDAO goodStudentDAO = new GoodStudentDAOimpl();

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

			case "3":

				try {
					if (goodStudentDAO.saveStudent(FileToObject.convertGoodStudentFromFile())) {
						System.out.println("success");
					} else {
						System.out.println("fail");
					}

				} catch (SQLException e) {
					System.out.println("Input file have unknow errors");
				}

				break;

			case "4":

				try {

					if (normalStudentDAO.saveNormalStudent(FileToObject.convertNormalStudentFromFile())) {
						System.out.println("success");
					} else {
						System.out.println("fail");
					}

				} catch (SQLException e) {
					System.out.println("Input file have unknow errors");
				}

				break;

			case "5":

				studentService.chooseStudent(new Scanner(System.in));

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
		System.out.println("3.Save all good student");
		System.out.println("4.Save all Normal student");
		System.out.println("5.filter student for company");

	}
}
