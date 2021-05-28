package entities;

public class NormalStudent extends Student {

	private double englishScore;
	private double entryTestScore;

	public NormalStudent() {
		super();
	}

	public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String universityName,
			String gradeLevel, double englishScore, double entryTestScore) {
		super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}
	

	@Override
	public String toString() {
		return "NomalStudent [englishScore=" + englishScore + ", entryTestScore=" + entryTestScore + "]";
	}

	@Override
	public String showMyInfor() {
		return super.toString() + ", englishScore = " + englishScore + ", entryTestScore = " + entryTestScore ;
	}

	public double getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(double englishScore) {
		this.englishScore = englishScore;
	}

	public double getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(double entryTestScore) {
		this.entryTestScore = entryTestScore;
	}
	
	

}
