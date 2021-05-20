package as_902.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public static void writeInFile(String pathFile, String line, boolean over) throws Exception {

		try {
			FileWriter fileWriter = new FileWriter(pathFile, over);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (Exception e) {
			throw new Exception();
		}
	}

	public static List<String> readFromFile(String pathFile) throws IOException {
		
		 List<String> listLine = new ArrayList<>();
	        try {
	            FileReader fileReader = new FileReader(pathFile);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String line = null;
	            while ((line = bufferedReader.readLine()) != null){
	                listLine.add(line);
	            }
	            bufferedReader.close();
	        }catch(IOException e){
	            throw new IOException();
	        }
	        return listLine;
	        
	}
	
	
	public static void deleteContentFromFile(String pathFile) throws IOException  {
		FileOutputStream writer = new FileOutputStream(pathFile);
		writer.write(("").getBytes());
		writer.close();
	}
		
}
