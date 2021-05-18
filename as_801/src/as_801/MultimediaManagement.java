package as_801;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultimediaManagement {
	public static List<Multimedia> listOfMultimedia = new ArrayList<Multimedia>();

	public MultimediaManagement(List<Multimedia> listOfMultimedia) {
		super();
		MultimediaManagement.listOfMultimedia = listOfMultimedia;
	}

	public static void addMultiMedia(Multimedia multimedia) {
		listOfMultimedia.add(multimedia);
	}

	public static void displayMultiMedia() {
		for (Multimedia multimedia : listOfMultimedia) {
			System.out.println(multimedia);
		}
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String choose;

		do {
			System.out.println("------------------------------------ \n" + "1.add New Video \n" + "2.add New Song \n"
					+ "3.show All Mutimedia \n" + "4.Exit" + "-----------------------------------");
			System.out.print("Please choose: ");
			choose = scanner.nextLine();
			switch (choose) {
			case "1":
				addNewVideo();
				break;
			case "2":
				addNewSong();
				break;
			case "3":
				showAllMutimedia();
				break;
			case "4":
				System.exit(0);
				break;
			default:
				System.out.println("please choose 1 to 4");
				choose = "0";
				break;
			}

		} while (Integer.parseInt(choose) >= 1 && Integer.parseInt(choose) <= 6);
		;
	}

	private static void showAllMutimedia() {
		for (Multimedia multimedia : listOfMultimedia) {
			System.out.println(multimedia);
		}

	}

	private static void addNewSong() {
		Song song = new Song();

		song.createSong();

		MultimediaManagement.addMultiMedia(song);
		
		System.out.println("success");

	}

	private static void addNewVideo() {
		Video video = new Video();

		video.createVideo();

		MultimediaManagement.addMultiMedia(video);
		System.out.println("success");
	}
}
