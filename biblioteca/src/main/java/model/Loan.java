package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private User user;
	private Book book;
	private LocalDate loanDate;
	private LocalDate expirationDate;
	private int daysUntilExpiration = 8;
	
	public Loan() {
		setExpirationDate();
	}
	
	public Loan(User user, Book book, LocalDate loanDate) {
   		this.user = user;
		this.book = book;
		this.loanDate = loanDate;
		setExpirationDate();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate() {
		this.expirationDate = loanDate.plusDays(daysUntilExpiration); 
	}
	
}
