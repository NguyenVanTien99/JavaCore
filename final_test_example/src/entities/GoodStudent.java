package entities;

public class GoodStudent extends Student  {

	private double gpa;
	private String bestRewardName;

	public GoodStudent() {
		super();
	}

	public GoodStudent(String fullName, String doB, String sex, String phoneNumber, String universityName,
			String gradeLevel, double gpa, String bestRewardName) {
		super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
	}

	@Override
	public String toString() {
		return "GoodStudent [gpa=" + gpa + ", bestRewardName=" + bestRewardName + "]";
	}

	@Override
	public String showMyInfor() {
		return super.toString() + ", gpa=" + gpa + ", bestRewardName=" + bestRewardName;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}


}
