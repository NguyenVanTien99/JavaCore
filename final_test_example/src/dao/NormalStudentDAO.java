package dao;

import java.sql.SQLException;
import java.util.List;

import entities.NormalStudent;

public interface NormalStudentDAO {
	boolean saveNormalStudent(List<NormalStudent> normalStudents) throws SQLException;
}
