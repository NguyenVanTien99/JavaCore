package as_802.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import as_802.entities.Book;
import as_802.entities.Magazine;
import as_802.entities.Publication;

public class BookService {

	public void addNewPublication(Publication publication, Scanner scanner) {

		System.out.println("Enter the publication Year");

		do {

			try {
				publication.setPublicationYear(Integer.parseInt(scanner.nextLine()));
			} catch (Exception e) {
				System.out.println("Value is number");
				continue;
			}

			break;
		} while (true);

		System.out.println("Enter the Pubisher");

		publication.setPublisher(scanner.nextLine());

		System.out.println("Enter the publication date");

		do {

			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
				publication.setPublicationDate(date);
			} catch (ParseException e) {
				System.out.println("Date format dd/MM/yyyy");
				continue;
			}

			break;
		} while (true);

	}

	public List<Book> addNewBook(Scanner scanner) {
		List<Book> books = new ArrayList<Book>();

		String loop;

		Book book;

		do {

			book = new Book();

			addNewPublication(book, scanner);

			System.out.println("Enter the isbn");

			book.setIsbn(scanner.nextLine());

			System.out.println("Enter the publication place");

			book.setPublicationPlace(scanner.nextLine());

			books.add(book);

			System.out.println("Do you want continue to input the Book (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

		return books;

	}

	public List<Magazine> addNewMagazine(Scanner scanner) {
		List<Magazine> magazines = new ArrayList<>();

		String loop;

		Magazine magazine;

		do {

			magazine = new Magazine();

			addNewPublication(magazine, scanner);

			System.out.println("Enter the author");

			magazine.setAuthor(scanner.nextLine());

			System.out.println("Enter the volumn");

			do {

				try {
					magazine.setVolumn(Integer.parseInt(scanner.nextLine()));
				} catch (Exception e) {
					System.out.println("Value is number");
					continue;
				}

				break;
			} while (true);

			System.out.println("Enter the edition");

			do {

				try {
					magazine.setEdition(Integer.parseInt(scanner.nextLine()));
				} catch (Exception e) {
					System.out.println("Value is number");
					continue;
				}

				break;
			} while (true);

			magazines.add(magazine);

			System.out.println("Do you want continue to input the Magazine (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

		return magazines;

	}

	public void addAuthorInBook(Scanner scanner, Book book) {
		Set<String> authorSet = new HashSet<String>();
		String loop;

		do {

			System.out.println("Enter the name author of book");

			if (authorSet.add(scanner.nextLine()) == false) {
				System.out.println("Author existed");
			} else {
				System.out.println("Add successfully");
			}

			System.out.println("Do you want continue to input the author (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

		book.setAuthor(authorSet);

	}

	public void displayTop10magazines(List<Magazine> magazines) {
		
		if (magazines.size() == 0) {
			System.out.println("No value");
		}

		Collections.sort(magazines, new Comparator<Magazine>() {

			@Override
			public int compare(Magazine o1, Magazine o2) {
				return Integer.valueOf(o2.getVolumn()).compareTo(Integer.valueOf(o1.getVolumn()));
			}
		});

		if (magazines.size() <= 10) {
			for (Magazine magazine : magazines) {
				System.out.println(magazine);
			}
		} else {
			for (int i = 0; i < 10; i++) {
				System.out.println(magazines.get(i));
			}
		}

	}

	public void searchBooksByValue(List<Book> books, String value) {
		
		if (books.size() == 0) {
			System.out.println("No value");
		}

		Boolean check = true;

		for (Book book : books) {
			if (book.getIsbn().equals(value)) {
				System.out.println(book);
				check = false;
			} else if (book.getAuthor() != null && book.getAuthor().contains(value)) {
				System.out.println(book);
				check = false;
			} else if (book.getPublisher().equals(value)) {
				System.out.println(book);
				check = false;
			}
		}

		if (check) {
			System.out.println("No found");
		}

	}

	public static void main(String[] args) {
		BookService bookService = new BookService();

		bookService.addNewMagazine(new Scanner(System.in));
	}

}
