package model;

import java.io.Serializable;
import java.util.Objects;

import exceptions.YearPublicationException;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String author;
	private String description;
	private String yearPublication;
	private String isbn;
	private boolean isAvailable;
	
	public Book() {
		
	}

	public Book(Long id,String name, String author, String description, String yearPublication, String isbn ) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
		this.yearPublication = yearPublication;
		this.isbn = isbn;
		this.isAvailable= true;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYearPublication() {
		return yearPublication;
	}

	public void setYearPublication(String yearPublication) {
		if(yearPublication.length() == 4) {
			this.yearPublication = yearPublication;
			
		}else {
			throw new YearPublicationException("O ano passado precisa ter 4 caracteres.");
		}
	}

	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	
}
