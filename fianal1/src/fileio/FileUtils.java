package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {	
	
	public static void writeInFile(String pathFile, String line, boolean over) throws Exception {
		BufferedWriter bufferedWriter = null;		
		try {
			FileWriter fileWriter = new FileWriter(pathFile, over);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(line);
			bufferedWriter.newLine();	
		} catch (Exception e) {
			throw new Exception();
		}finally {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	}

	public static List<String> readFromFile(String pathFile) throws IOException {
		BufferedReader bufferedReader = null;
		
		List<String> listLine = new ArrayList<>();
		
		try {
			FileReader fileReader = new FileReader(pathFile);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				listLine.add(line);
			}
		} catch (IOException e) {
			throw new IOException();
		}finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return listLine;
	}

	public static void deleteContentFromFile(String pathFile) throws IOException {
		FileOutputStream writer = new FileOutputStream(pathFile);
		writer.write(("").getBytes());
		writer.close();
	}
}
