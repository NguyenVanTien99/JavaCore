package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import common.DBUtils;
import common.SQLCommand;
import dao.GoodStudentDAO;
import entities.GoodStudent;
import fileio.FileToObject;

public class GoodStudentDAOimpl implements GoodStudentDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	// private ResultSet results = null;

	@Override
	public Boolean saveStudent(List<GoodStudent> goodStudents) throws SQLException {
		int results[] = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.GOOD_STUDENT_ADD);
			connection.setAutoCommit(false);

			for (GoodStudent goodStudent : goodStudents) {
				preparedStatement.setString(1, goodStudent.getFullName());
				preparedStatement.setString(2, goodStudent.getDoB());
				preparedStatement.setString(3, goodStudent.getSex());
				preparedStatement.setString(4, goodStudent.getPhoneNumber());
				preparedStatement.setString(5, goodStudent.getUniversityName());
				preparedStatement.setString(6, goodStudent.getGradeLevel());
				preparedStatement.setDouble(7, goodStudent.getGpa());
				preparedStatement.setString(8, goodStudent.getBestRewardName());

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

		GoodStudentDAOimpl goodStudentDAOimpl = new GoodStudentDAOimpl();

		try {
			if (goodStudentDAOimpl.saveStudent(FileToObject.convertGoodStudentFromFile())) {
				System.out.println("success");
			}else {
				System.out.println("fail");
			}
			
		} catch (SQLException e) {
			System.out.println("Input file have unknow errors");
		}

	}

}
