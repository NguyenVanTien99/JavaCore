package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class main {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;

	public static void main(String[] args) throws SQLException {

//		String sDate = "31/12/1998";
//		Date date = null;
//		try {
//			date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Order order = new Order();

		
		
		  String str="2015/03/31"; 
		  
		  Date date=Date.valueOf(str);

		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection.prepareStatement("INSERT INTO dates VALUES ?");
		preparedStatement.setDate(1, date);
		
		preparedStatement.execute();

	}

}
