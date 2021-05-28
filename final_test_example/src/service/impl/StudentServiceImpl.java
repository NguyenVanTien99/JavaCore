package service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

		do {
			System.out.println("Enter the number student company need: ");
			numberStudentString = scanner.nextInt();

			if (numberStudentString >= 10 && numberStudentString <= 15) {
				System.out.println("Employee");
				break;
			}

			continue;
		} while (true);

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
		
		Collections.sort(normalStudents, new Comparator<NormalStudent>() {
			
//			public class BirthDateComparator implements Comparator<Person> {
//			    public int compare(Person p, Person q) {
//			        if (p.getBirthDate().before(q.getBirthDate()) {
//			            return -1;
//			        } else if (p.getBirthDate().after(q.getBirthDate()) {
//			            return 1;
//			        } else {
//			            return 0;
//			        }        
//			    }
//			}

			@Override
			public int compare(NormalStudent o1, NormalStudent o2) {
				
				if (o1.getEnglishScore() ==  o2.getEnglishScore()) {
					return o2.getFullName().compareTo(o1.getFullName());
				}
				
//				if (o1.getEnglishScore() ==  o2.getEnglishScore()) {
//					return o2.getDoB().compareTo(o1.getDoB());
//				}
				
				if (o1.getEntryTestScore() == o2.getEntryTestScore()) {
					return Double.valueOf(o2.getEnglishScore()).compareTo(Double.valueOf(o1.getEnglishScore()));
				}
				

				return Double.valueOf(o2.getEntryTestScore()).compareTo(Double.valueOf(o1.getEntryTestScore()));
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
