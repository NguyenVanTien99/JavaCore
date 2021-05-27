package service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.GoodStudent;
import entities.NormalStudent;
import fileio.FileToObject;
import service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public void chooseStudent(Scanner scanner) {
		List<GoodStudent> goodStudents = new ArrayList<>();
		List<NormalStudent> normalStudents = new ArrayList<>();

		goodStudents = FileToObject.convertGoodStudentFromFile();

		normalStudents = FileToObject.convertNormalStudentFromFile();

		int numberStudentString;

		System.out.println("Enter the number student company need: ");
		numberStudentString = scanner.nextInt();

		Collections.sort(goodStudents, new Comparator<GoodStudent>() {

			@Override
			public int compare(GoodStudent o1, GoodStudent o2) {
				if (o1.getGpa() == o2.getGpa()) {
					return o2.getFullName().compareTo(o1.getFullName());
				}
				return Double.valueOf(o2.getGpa()).compareTo(Double.valueOf(o1.getGpa()));

				// return o2.getFullName().compareTo(o1.getFullName());

			}
		});

		if (numberStudentString < goodStudents.size()) {
			for (int i = 0; i < numberStudentString; i++) {
				System.out.println(goodStudents.get(i).showMyInfor());
			}
		}

		if (numberStudentString > goodStudents.size()) {
			for (int i = 0; i < goodStudents.size(); i++) {
				System.out.println(goodStudents.get(i).showMyInfor());
			}

			for (int i = 0; i < (numberStudentString - goodStudents.size()); i++) {
				System.out.println(normalStudents.get(i).showMyInfor());
			}
		}

	}

	public static void main(String[] args) {
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

		studentServiceImpl.chooseStudent(new Scanner(System.in));

	}

}
