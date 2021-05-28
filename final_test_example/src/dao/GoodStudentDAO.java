package dao;

import java.sql.SQLException;
import java.util.List;

import entities.GoodStudent;

public interface GoodStudentDAO {
	
	/**
	 * Execute a query to save all good student to database.
	 * 
	 * @method saveStudent
	 * 
	 * @param goodStudents
	 * 
	 * @throws SQLException
	 */
	Boolean saveStudent(List<GoodStudent> goodStudents) throws SQLException;

}
