package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import common.DBUtils;
import common.SQLCommand;
import dao.NormalStudentDAO;
import entities.NormalStudent;
import fileio.FileToObject;

public class NormalStudentDAOimpl implements NormalStudentDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	@Override
	public boolean saveNormalStudent(List<NormalStudent> normalStudents) throws SQLException {
		int results[] = null;
		
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.NORMAL_STUDENT_ADD);
			connection.setAutoCommit(false);

			for (NormalStudent normalStudent : normalStudents) {
				preparedStatement.setString(1, normalStudent.getFullName());
				preparedStatement.setString(2, normalStudent.getDoB());
				preparedStatement.setString(3, normalStudent.getSex());
				preparedStatement.setString(4, normalStudent.getPhoneNumber());
				preparedStatement.setString(5, normalStudent.getUniversityName());
				preparedStatement.setString(6, normalStudent.getGradeLevel());
				preparedStatement.setDouble(7, normalStudent.getEnglishScore());
				preparedStatement.setDouble(8, normalStudent.getEntryTestScore());

				preparedStatement.addBatch();

			}
			results = preparedStatement.executeBatch();
			connection.commit();

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		if (results.length > 0) {
			return true;
		}

		return false;
		
	}
	
	public static void main(String[] args) {
		NormalStudentDAOimpl normalStudentDAOimpl = new NormalStudentDAOimpl();
		
		
		try {
			
			if (normalStudentDAOimpl.saveNormalStudent(FileToObject.convertNormalStudentFromFile())) {
				System.out.println("success");
			}else {
				System.out.println("fail");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
