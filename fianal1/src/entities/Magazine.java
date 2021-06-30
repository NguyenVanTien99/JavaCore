package entities;

import java.util.Date;

public class Magazine extends Publication {
	
	
	private String author;
	private int volumn;
	private int edition;
	
	

	public Magazine() {
		super();
	}



//	public Magazine(int publicationYear, StringBuffer publisher, Date publicationDate, String author, int volumn,
//			int edition) {
//		super(publicationYear, publisher, publicationDate);
//		this.author = author;
//		this.volumn = volumn;
//		this.edition = edition;
//	}

	


	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getVolumn() {
		return volumn;
	}



	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}



	public int getEdition() {
		return edition;
	}



	public void setEdition(int edition) {
		this.edition = edition;
	}

	

	@Override
	public String toString() {
		return "Magazine [author=" + author + ", volumn=" + volumn + ", edition=" + edition + "]";
	}



	@Override
	void display() {
		System.out.println("publicationYear=" + this.getPublicationYear() + ", publisher=" + this.getPublisher()
				+ ", publicationDate=" + this.getPublicationDate() + "author=" + author + ", volumn=" + volumn + ", edition=" + edition);
		
	}

	

}
