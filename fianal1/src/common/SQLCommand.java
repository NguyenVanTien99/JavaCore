package common;

public class SQLCommand {
	public static String BOOK_ADD = "INSERT INTO book VALUES (?) ";	
	public static String BOOK_GET_ALL = "SELECT * FROM book ";
	
	public static String NORMAL_STUDENT_ADD = "INSERT INTO NormalStudent VALUES (?,?,?,?,?,?,?,?) ";
	public static String NORMAL_STUDENT_GET_ALL = "SELECT * FROM NormalStudent ";
}
 