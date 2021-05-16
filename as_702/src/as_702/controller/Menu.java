package as_702.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import as_702.exceptions.GeneralException;
import as_702.model.Person;
import as_702.model.Student;
import as_702.model.Teacher;
import as_702.validator.validator;

public class Menu {
	
	static Scanner scanner = new Scanner(System.in);
	static List<Person> personList = new ArrayList<>(); 
	
	static String name;
	static String gender;
	static String phoneNumber;
	static String email;
	
	public static void displayMainMenu() {
		String choose;
		
		do {
			System.out.println(
					 "------------------------------------ \n"
	                            + "1.Add new person \n"
	                            + "2.Show all person \n"
	                            + "3.Update student \n"
	                            + "4.Display teacher has salary higher than 1000$ \n"
	                            + "5.Display student to pass the course \n"
	                            + "6.Exit"
	                            + "-----------------------------------"
			);
			System.out.println("Please");
			choose = scanner.nextLine();
			
			switch (choose) {
			case "1":
				addNewPerson();
				break;
			case "2":
				showAllPerson();
				break;
			case "3":
				updateStudent();
				break;
			case "4":
				showTeacherHasSalaryhigherthan1000();				
				break;
			case "5":
				showStudentPassThisCourse();
				break;
			case "6":
				System.exit(0);
				break;

			default:
				System.out.println("please choose 1 to 6");
				displayMainMenu();
				break;
			}
			
		} while (Integer.parseInt(choose) >=1 && Integer.parseInt(choose) <=6 );;
	}
	
	
	
	
	private static void showStudentPassThisCourse() {
		
		if(personList.size() == 0) {
			System.out.println("List is empty");
		}else {
			for (Person person : personList) {
				if(person instanceof Student) {
					if(((Student) person).calculateFinalMark() > 6) {
						System.out.println(person);
					}
				}
			}			
		}
		
		displayMainMenu();
		
	}




	private static void showTeacherHasSalaryhigherthan1000() {
		
		if(personList.size() == 0) {
			System.out.println("List is empty");
		}else {
			for (Person person : personList) {
				if(person instanceof Teacher) {
					if(((Teacher) person).calculateSalary() > 1000) {
						System.out.println(person);
					}
				}
			}		
		}
		
		displayMainMenu();
		
	}




	private static void updateStudent() {
		for (Person person : personList) {
			if(person instanceof Student) {
				System.out.println(person);
			}
		}
		
		boolean check;
		
		String theory;
		String practice;
		
		System.out.println("Enter the ID of Student");
		String chooseID = scanner.nextLine();
		
		boolean checkExist = false;
		
		for (Person person : personList) {
			if(person instanceof Student) {
				if(((Student) person).getStudentID().equals(chooseID)) {
					
					checkExist = true;
					
					addGeneralInfo();		
					
					
					do {
						check = false;
						System.out.println("Enter theory");
						theory = scanner.nextLine();
						try {
							validator.validateTheoryOrPractice(theory);
						} catch (GeneralException e) {
							System.out.println(e.getMessage());
							check = true;
						}
						
					} while (check);
					
					
					do {
						check = false;
						System.out.println("Enter practice");
						practice = scanner.nextLine();
						try {
							validator.validateTheoryOrPractice(practice);
						} catch (GeneralException e) {
							System.out.println(e.getMessage());
							check = true;
						}
						
					} while (check);
					
					person.setName(name);
					person.setGender(gender);
					person.setPhoneNumber(chooseID);
					person.setEmail(email);
					((Student) person).setTheory(Double.parseDouble(theory));
					((Student) person).setPractice(Double.parseDouble(practice));
					System.out.println("update suceess");
					break;
					
				}
			}
		}
		
		if(!checkExist) {
			System.out.println("Id not valid");
		}
		
		displayMainMenu();
		
	}




	private static void showAllPerson() {
		for (Person person : personList) {
			System.out.println(person);
		}		
	}




	private static void addNewPerson() {
	String choose;
			
			do {
				System.out.println(
						 "------------------------------------ \n"
		                            + "1.Add student \n"
		                            + "2.add teacher \n"
		                            + "3.back to menu \n"
		                            + "-----------------------------------"
				);
				System.out.println("Please");
				choose = scanner.nextLine();
				
				switch (choose) {
				case "1":
					addNewStudent();
					break;
				case "2":
					addNewTeacher();
					break;
				case "3":
					displayMainMenu();
					break;
				default:
					System.out.println("please choose 1 to 3");
					displayMainMenu();
					break;
				}
				
			} while (Integer.parseInt(choose) >=1 && Integer.parseInt(choose) <=3 );;
			
	}
	
	
	private static void addGeneralInfo() {
		boolean check;
		

		
		System.out.println("Enter name");
		name = scanner.nextLine();
		
		System.out.println("Enter gender");
		gender = scanner.nextLine();
		
		System.out.println("Enter phone number");
		phoneNumber = scanner.nextLine();

		do {
			check = false;
			System.out.println("Enter email");
			email = scanner.nextLine();
			try {
				validator.validatEmail(email);
			} catch (GeneralException e) {
				System.out.println(e.getMessage());
				check = true;
			}
			
		} while (check);
		
	}



	private static void addNewStudent() {
		boolean check;
		addGeneralInfo();
		String studentID;
		String theory;
		String practice;
		 
			System.out.println("Enter student ID");
			studentID = scanner.nextLine();
			
			do {
				check = false;
				System.out.println("Enter theory");
				theory = scanner.nextLine();
				try {
					validator.validateTheoryOrPractice(theory);
				} catch (GeneralException e) {
					System.out.println(e.getMessage());
					check = true;
				}
				
			} while (check);
			
			
			do {
				check = false;
				System.out.println("Enter practice");
				practice = scanner.nextLine();
				try {
					validator.validateTheoryOrPractice(practice);
				} catch (GeneralException e) {
					System.out.println(e.getMessage());
					check = true;
				}
				
			} while (check);
			
			
			
			
		
		Student student = new Student(name, gender, phoneNumber, email, studentID, Double.parseDouble(theory),Double.parseDouble(practice));	
		personList.add(student);
		System.out.println("success");
	}




	private static void addNewTeacher() {
		addGeneralInfo();
		Double basicSalary = null;
		Double subsidy = null;
		
		boolean check;
		
		do {
			check = false;
			System.out.println("Enter the basic salary");
			
			try {
				basicSalary = Double.parseDouble(scanner.nextLine()); 
			} catch (Exception e) {
				System.out.println("value is number");
				check = true;
			}
			
		} while (check);
		
		do {
			check = false;
			System.out.println("Enter the subsidy");
			
			try {
				subsidy = Double.parseDouble(scanner.nextLine()); 
			} catch (Exception e) {
				System.out.println("value is number");
				check = true;
			}
			
		} while (check);
			
		Teacher teacher = new Teacher(name, gender, phoneNumber, email, basicSalary, subsidy);	
		personList.add(teacher);
		System.out.println("success");
	}




	public static void main(String[] args) {
		displayMainMenu();
	}

}
