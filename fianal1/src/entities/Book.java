package entities;

import java.util.Date;


public class Book extends Publication {
	private String isbn;
	private String author;
	private String publicationPlace;

	public Book() {
	}

	public Book(String isbn, String author, String publicationPlace) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
	}

	public Book(int publicationYear, String publisher, Date publicationDate, String isbn, String author,
			String publicationPlace) {
		super(publicationYear, publisher, publicationDate);
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", publicationPlace=" + publicationPlace + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public void display() {
		System.out.println("publicationYear=" + this.getPublicationYear() + ", publisher=" + this.getPublisher()
				+ ", publicationDate=" + this.getPublicationDate() + "isbn=" + isbn + ", author=" + author
				+ ", publicationPlace=" + publicationPlace);
	}

}
