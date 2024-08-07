package services;

import java.sql.SQLException;
import java.util.List;

import daos.BookDAO;
import model.Book;
import model.User;

public class BookService {

	BookDAO dao = new BookDAO();
	
	public  void addBook(Book book) {
		
		//APLICAR AS REGRAS DE NEGÓCIO
		
		if(book != null) {
			try {
				dao.addBook(book);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Optional<List<Book>> getAllBooks(){
		//APLICAR AS REGRAS DE NEGÓCIO
		try {
			
			return dao.getAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
}
