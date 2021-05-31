package dao;

import java.sql.SQLException;
import java.util.List;

import entities.NormalStudent;

public interface NormalStudentDAO {
	/**
	 * Execute a query to save all normal student to database.
	 * 
	 * @method saveNormalStudent
	 * 
	 * @param normalStudents
	 * 
	 * @throws SQLException
	 */
	boolean saveNormalStudent(List<NormalStudent> normalStudents) throws SQLException;
	
	
	List<NormalStudent> getAllNormalStudents() throws Exception;
}