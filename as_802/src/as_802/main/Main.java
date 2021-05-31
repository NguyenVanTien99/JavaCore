package as_802.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import as_802.entities.Book;
import as_802.entities.Magazine;
import as_802.services.BookService;

public class Main {

	public static void main(String[] args) {
		String choice = "";
		Scanner scanner = new Scanner(System.in);

		List<Book> books = new ArrayList<Book>();

		List<Magazine> magazines = new ArrayList<Magazine>();

		BookService bookService = new BookService();

		do {
			getmenu();

			System.out.println("Enter the choice: ");
			choice = scanner.nextLine();

			switch (choice) {
			case "1":

				books.addAll(bookService.addNewBook(scanner));

				break;

			case "2":

				magazines.addAll(bookService.addNewMagazine(scanner));

				break;

			case "3":

				for (Book book : books) {
					System.out.println(book);
				}

				for (Magazine magazine : magazines) {
					System.out.println(magazine);
				}

				break;

			case "4":

				int stt = 1;

				for (Book book : books) {
					System.out.println(stt + "-" + book);
					stt++;
				}

				System.out.println("choose the books ");

				try {
					bookService.addAuthorInBook(scanner, books.get(Integer.parseInt(scanner.nextLine()) - 1));

				} catch (Exception e) {
					System.out.println("found");
				}

				break;
				
			case "5":

				bookService.displayTop10magazines(magazines);

				break;
				
			case "6":

				System.out.println("Enter the value to search");
				
				bookService.searchBooksByValue(books,scanner.nextLine());

				break;

			default:
				choice = "N";
				break;
			}
		} while (choice != "N");
	}

	public static void getmenu() {
		System.out.println("--------------Menu----------------");
		System.out.println("1.Add a Book");
		System.out.println("2.Add a magazine");
		System.out.println("3.Display Book and Magazine");
		System.out.println("4.Add author in Book");
		System.out.println("5.Display top 10 magazine by value");
		System.out.println("6.Search Book by value (isbn, author, publisher)");
		System.out.println("Enter N to exit");

	}
}
