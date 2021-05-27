package entities;

import common.Validator;
import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;

public abstract class Student {
	private String fullName;
	private String doB;
	private String sex;
	private String phoneNumber;
	private String universityName;
	private String gradeLevel;

	public Student() {
		super();
	}

	public Student(String fullName, String doB, String sex, String phoneNumber, String universityName,
			String gradeLevel) {
		super();
		this.fullName = fullName;
		this.doB = doB;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.universityName = universityName;
		this.gradeLevel = gradeLevel;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) throws InvalidFullNameException {
		if (Validator.isFullName(fullName)) {
			this.fullName = fullName;
		}else {
			throw new InvalidFullNameException("Full name has min 10 and max 50 character ");
		}
		
	}

	public String getDoB() {
		return doB;
	}

	public void setDoB(String doB) throws InvalidDOBException {
		
		if (Validator.isDOB(doB)) {
			this.doB = doB;
		}else {
			throw new InvalidDOBException("Day of birth has formart Number dd/MM/YYYY");
		}
		
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (Validator.isPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;			
		}else {
			throw new InvalidPhoneNumberException("Phone number must be start with 090, 098, 091, 031,035,038");
		}
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	
	public abstract String showMyInfor();

	@Override
	public String toString() {
		return "fullName=" + fullName + ", doB=" + doB + ", sex=" + sex + ", phoneNumber=" + phoneNumber
				+ ", universityName=" + universityName + ", gradeLevel=" + gradeLevel ;
	} 
	
	

}
