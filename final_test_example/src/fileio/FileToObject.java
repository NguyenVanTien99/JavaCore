package fileio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.GoodStudent;
import entities.NormalStudent;
import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;

public class FileToObject {

	public static final String FILE_PATH_GOODSTUDENT = "./src/data/goodStudent.csv";
	public static final String FILE_PATH_NORMALSTUDENT = "./src/data/normalStudent.csv";

	public static List<GoodStudent> convertGoodStudentFromFile() {
		List<GoodStudent> goodStudents = new ArrayList<>();
		List<String> listStringFromFile = null;

		GoodStudent goodStudent;

		try {
			listStringFromFile = FileUtils.readFromFile(FILE_PATH_GOODSTUDENT);
		} catch (IOException e) {
			System.out.println("Read file Found");
		}

		for (int i = 0; i < listStringFromFile.size(); i++) {
			boolean checkBlank = true;

			String[] splitStrings = listStringFromFile.get(i).split(",");

			goodStudent = new GoodStudent();

			for (int j = 0; j < splitStrings.length; j++) {
				if (splitStrings[j].equals("")) {
					System.out.println("-value is blank in cell " + (j + 1) + " row " + (i + 1));
					checkBlank = false;
				}
			}

			if (checkBlank == false) {
				continue;
			}

			try {
				goodStudent.setFullName(splitStrings[0]);
			} catch (InvalidFullNameException e) {
				System.out.println("-line " + (i + 1) + " error: " + e.getMessage());
				continue;
			}

			try {
				goodStudent.setDoB(splitStrings[1]);
			} catch (InvalidDOBException e) {
				System.out.println("-line " + (i + 1) + " error: " + e.getMessage());
				continue;
			}

			goodStudent.setSex(splitStrings[2]);
			try {
				goodStudent.setPhoneNumber(splitStrings[3]);
			} catch (InvalidPhoneNumberException e) {
				System.out.println("-line " + (i + 1) + " error: " + e.getMessage());
				continue;
			}
			
			goodStudent.setUniversityName(splitStrings[4]);
			goodStudent.setGradeLevel(splitStrings[5]);
			goodStudent.setGpa(Double.parseDouble(splitStrings[6]));
			goodStudent.setBestRewardName(splitStrings[7]);

			goodStudents.add(goodStudent);
		}

		return goodStudents;

	}

	public static List<NormalStudent> convertNormalStudentFromFile() {
		List<NormalStudent> nomalStudents = new ArrayList<>();
		List<String> listStringFromFile = null;

		NormalStudent nomalStudent;

		try {
			listStringFromFile = FileUtils.readFromFile(FILE_PATH_NORMALSTUDENT);
		} catch (IOException e) {
			System.out.println("Read file Found");
		}

		for (int i = 0; i < listStringFromFile.size(); i++) {
			boolean checkBlank = true;

			String[] splitStrings = listStringFromFile.get(i).split(",");

			nomalStudent = new NormalStudent();

			for (int j = 0; j < splitStrings.length; j++) {
				if (splitStrings[j].equals("")) {
					System.out.println("-value is blank in cell " + (j + 1) + " row " + (i + 1));
					checkBlank = false;
				}
			}

			if (checkBlank == false) {
				continue;
			}

			try {
				nomalStudent.setFullName(splitStrings[0]);
			} catch (InvalidFullNameException e) {
				System.out.println("-line " + (i + 1) + " error: " + e.getMessage());
				continue;
			}
			try {
				nomalStudent.setDoB(splitStrings[1]);
			} catch (InvalidDOBException e) {
				System.out.println("-line " + (i + 1) + " error: " + e.getMessage());
				continue;
			}
			nomalStudent.setSex(splitStrings[2]);
			try {
				nomalStudent.setPhoneNumber(splitStrings[3]);
			} catch (InvalidPhoneNumberException e) {
				System.out.println("-line " + (i + 1) + " error: " + e.getMessage());
				continue;
			}
			nomalStudent.setUniversityName(splitStrings[4]);
			nomalStudent.setGradeLevel(splitStrings[5]);
			nomalStudent.setEnglishScore(Double.parseDouble(splitStrings[6]));
			nomalStudent.setEntryTestScore(Double.parseDouble(splitStrings[7]));

			nomalStudents.add(nomalStudent);
		}

		return nomalStudents;

	}

}
