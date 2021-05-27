package FileSample;

import java.io.File;
import java.io.IOException;

public class FileSample {
	
	public static void main(String[] args) {
		File file = new File("D:/date1.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
