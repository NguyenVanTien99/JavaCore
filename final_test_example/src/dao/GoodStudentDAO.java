package dao;

import java.sql.SQLException;
import java.util.List;

import entities.GoodStudent;

public interface GoodStudentDAO {
	Boolean saveStudent(List<GoodStudent> goodStudents) throws SQLException;

}
