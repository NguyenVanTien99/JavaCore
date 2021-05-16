package as_702.model;

public class Student extends Person {
	
	private String studentID;
	private Double theory;
	private Double practice;
	
	public Student(String name, String gender, String phoneNumber, String email, String studentID, Double theory,
			Double practice) {
		super(name, gender, phoneNumber, email);
		this.studentID = studentID;
		this.theory = theory;
		this.practice = practice;
	}
	
	public double calculateFinalMark() {
		return (theory + practice)/2;
	}

	@Override
	void purchaseParkingPass() {
		// TODO Auto-generated method stub
		
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public Double getTheory() {
		return theory;
	}

	public void setTheory(Double theory) {
		this.theory = theory;
	}

	public Double getPractice() {
		return practice;
	}

	public void setPractice(Double practice) {
		this.practice = practice;
	}

	@Override
	public String toString() {
		return "Student: " + super.toString() + ", studentID=" + studentID + ", theory=" + theory + ", practice=" + practice ;
	}
	
	
	
	
	
	
	
}
