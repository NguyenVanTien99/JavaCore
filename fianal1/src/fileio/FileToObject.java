package fileio;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import common.Validator;
import entities.Book;
import exception.invalidPDateException;
import exception.invalidPYearException;
import exception.invalidPublisherEception;


public class FileToObject {

	public static final String FILE_PATH_GOODSTUDENT = "./src/data/book.txt";
	public static final String FILE_PATH_NORMALSTUDENT = "./src/data/magazine.txt";
	
//	public static void main(String args[]){  

//         
//}  

	public static List<Book> convertGoodStudentFromFile() {
		List<Book> books  = new ArrayList<>();
		List<String> listStringFromFile = null;

		Book book = null;

		try {
			listStringFromFile = FileUtils.readFromFile(FILE_PATH_GOODSTUDENT);
		} catch (IOException e) {
			System.out.println("Read file Found");
		}
		
		for (int i = 0; i < listStringFromFile.size(); i++) {
			

			String[] splitStrings = listStringFromFile.get(i).split(",");
			
			try {
				Validator.validatePYear(splitStrings[0]);
				Validator.validatePublisher(splitStrings[1]);
				Validator.validatePDate(splitStrings[2]);
				
				book = new Book(Integer.valueOf(splitStrings[0]), splitStrings[1], new SimpleDateFormat("dd/MM/yyyy").parse(splitStrings[2]),
						splitStrings[3], splitStrings[4], splitStrings[5]);
				
				
			} catch (invalidPYearException | invalidPublisherEception | invalidPDateException  e) {
				System.out.println("-line " + (i + 1) + " error: " + e.getMessage());
				
			} catch (Exception e) {
				System.out.println("Error file");
				continue;
			}
			
			books.add(book);

	}
//		for (Book bString : books) {
//			bString.display();
//		}
		return books;
		
		
	}		
	
	public static void main(String[] args) {
		convertGoodStudentFromFile();
	}

}
