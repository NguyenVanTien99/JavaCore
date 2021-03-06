package as_501;

import java.util.Scanner;

public class Course {
	private String code;
	private String name;
	private double duration;
	private String status;
	private String flag;

	public Course() {

	}

	public Course(String code, String name, double duration, String status, String flag) {
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.status = status;
		this.flag = flag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {

		return "Course [code=" + code + ", name=" + name + ", duration=" + duration + ", status=" + status + ", flag="
				+ flag + "]";

	}

	public void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean check;

		do {
			check = false;
			System.out.print("Enter code: ");

			try {
				code = scanner.nextLine();
				Validator.validateCode(code);
			} catch (GeneralException e) {
				System.out.println(e.getMessage());
				check = true;
			}
		} while (check);
		
		System.out.print("Enter name: ");
		name = scanner.nextLine();
		
		do {
			check = false;
			System.out.print("Enter duration: ");
			
			try {
				duration = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("value is number");
				check = true;
			}						
		} while (check);
		
		
		
		do {
			check = false;
			System.out.print("Enter status: ");

			try {
				status = scanner.nextLine();
				Validator.validateStatus(status);
			} catch (GeneralException e) {
				System.out.println(e.getMessage());
				check = true;
			}
		} while (check);
		
		do {
			check = false;
			System.out.print("Enter flag: ");

			try {
				flag = scanner.nextLine();
				Validator.validateFlag(flag);
			} catch (GeneralException e) {
				System.out.println(e.getMessage());
				check = true;
			}
		} while (check);

	}

}
