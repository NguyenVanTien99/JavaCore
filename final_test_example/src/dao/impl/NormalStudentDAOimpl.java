package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBUtils;
import common.SQLCommand;
import dao.NormalStudentDAO;
import entities.NormalStudent;
import fileio.FileToObject;

public class NormalStudentDAOimpl implements NormalStudentDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

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

	@Override
	public List<NormalStudent> getAllNormalStudents() throws Exception {

		List<NormalStudent> normalStudents = new ArrayList<NormalStudent>();

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.NORMAL_STUDENT_GET_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {

				NormalStudent normalStudent = new NormalStudent();
				
				normalStudent.setFullName(results.getString(1));
				normalStudent.setDoB(String.valueOf(results.getDate(2)));
				normalStudent.setSex(results.getString(3));
				normalStudent.setPhoneNumber(results.getString(4));
				normalStudent.setUniversityName(results.getString(5));
				normalStudent.setGradeLevel(results.getString(6));
				normalStudent.setEnglishScore(results.getDouble(7));
				normalStudent.setEntryTestScore(results.getDouble(8));

				normalStudents.add(normalStudent);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}
		return normalStudents;
	}

	public static void main(String[] args) {
		NormalStudentDAOimpl normalStudentDAOimpl = new NormalStudentDAOimpl();
//
//		try {
//
//			if (normalStudentDAOimpl.saveNormalStudent(FileToObject.convertNormalStudentFromFile())) {
//				System.out.println("success");
//			} else {
//				System.out.println("fail");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			
			System.out.println(normalStudentDAOimpl.getAllNormalStudents());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
