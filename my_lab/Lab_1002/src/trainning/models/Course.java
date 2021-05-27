package trainning.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import trainning.utils.InvalidIdException;
import trainning.utils.Validator;


public class Course implements Statistical, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;

	private Set<Student> students;

	private Double credit;
	private int enrollment;

	public Course() {

	}

	public Course(String id, String title, Set<Student> students, Double credit, int enrollmant) {
		super();
		this.id = id;
		this.title = title;
		this.students = students;
		this.credit = credit;
		this.enrollment = enrollmant;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws InvalidIdException {
		if (Validator.isCourseId(id) && Validator.isExisted(id)) {
			this.id = id;
		} else {
			throw new InvalidIdException("Id is not valid");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollmant) {
		this.enrollment = enrollmant;
	}

	@Override
	public Map<String, Integer> getStatistic() {
		Map<String, Integer> stats = new HashMap<String, Integer>();
		stats.put("A", 0);
		stats.put("B", 0);
		stats.put("C", 0);
		stats.put("D", 0);

		for (Student student : students) {
			if (student.getGpa() >= 8.5) {
				stats.put("A", stats.get("A") + 1);
			} else if (student.getGpa() < 8.5 && student.getGpa() >= 7) {
				stats.put("B", stats.get("B") + 1);
			} else if (student.getGpa() < 7 && student.getGpa() >= 6) {
				stats.put("C", stats.get("C") + 1);
			} else {
				stats.put("D", stats.get("D") + 1);
			}
		}
		return stats;
	}

}
