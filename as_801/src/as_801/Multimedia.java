package as_801;

import java.util.Scanner;

public abstract class Multimedia {
	private String name;
	private Double duration;
	public static Scanner scanner = new Scanner(System.in);
	
	public Multimedia() {
	}
	
	public Multimedia(String name, Double duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
	
	public void createMultimedia() {
		
		Boolean check;
		
		System.out.print("Enter the name: ");
		name = scanner.nextLine();
		
		
		
		do {
			check = false;
			System.out.print("Enter the duration: ");
			try {
				duration = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("value is number");
				check = true;
			}
			
		} while (check);
		
		

		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}
	
	
}
