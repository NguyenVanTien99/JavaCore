package as_802.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Book extends Publication implements Comparable<Book> {

	private String isbn;
	private Set<String> author;
	private String publicationPlace;

	public Book() {
	}

	public Book(int publicationYear, String publisher, Date publicationDate, String isbn, Set<String> author,
			String publicationPlace) {
		super(publicationYear, publisher, publicationDate);
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
	}

	@Override
	public void display() {
		toString();
	}

	@Override
	public String toString() {
		return super.toString() + ", isbn=" + isbn + ", author=" + author + ", publicationPlace=" + publicationPlace;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(Set<String> author) {
		this.author = author;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

	@Override
	public int compareTo(Book o) {

		if (this.isbn.equals(o.getIsbn())) {
			return this.getPublicationDate().compareTo(o.getPublicationDate());
		}

		return this.isbn.compareTo(o.getIsbn());
	}

}
