package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import common.DBUtils;
import common.SQLCommand;
import entities.Book;
import fileio.FileToObject;


public class BookDAO {


	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	public Boolean saveBook(List<Book> books) throws SQLException  {
		int results[] = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_ADD);
			connection.setAutoCommit(false);

			for (Book goodStudent : books) {
				preparedStatement.setDate(1, new java.sql.Date(goodStudent.getPublicationDate().getTime()));

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
	
	public List<Book> getAllBooks() throws Exception {

		List<Book> normalStudents = new ArrayList<Book>();

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_GET_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {

				Book normalStudent = new Book();
				
				normalStudent.setPublicationDate(new Date((results.getDate(1).getTime())));
				
				normalStudents.add(normalStudent);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}
		return normalStudents;
	}
	
	public static void main(String[] args) {
		 
		
		
		try {
			List<Book> books = new BookDAO().getAllBooks();
			
			for (Book book : books) {
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String format = formatter.format(book.getPublicationDate());
				System.out.println(format);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
