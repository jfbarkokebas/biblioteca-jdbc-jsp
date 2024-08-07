package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Book;
import model.User;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (name, author, description, yearPublication, isbn) "
        		+ "VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getDescription());
            stmt.setString(4, book.getYearPublication());
            stmt.setString(5, book.getIsbn());
            stmt.execute();
            connection.commit();

        }
    }

    public User getBook(Long id) throws SQLException {
    	
        String sql = "SELECT * FROM books WHERE id = ? ";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("yearPublication"),
                        rs.getString("isbn")
                    );
                }
            }
        }
        return null;
    }

    public List<Book> getAllBooks() throws SQLException {
    	
        List<Book> books = new ArrayList<>();
        
        String sql = "SELECT * FROM books ORDER BY name ASC LIMIT 300";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        	
        	try(ResultSet rs = stmt.executeQuery()){
        		
        		 while (rs.next()) {
        			 books.add(new Book(
                         rs.getLong("id"),
                         rs.getString("name"),
                         rs.getString("author"),
                         rs.getString("description"),
                         rs.getString("yearPublication"),
                         rs.getString("isbn")
                     ));
                 }
        	}
           
        }
        return books;
    }

    public void updateBook(Book books) throws SQLException {
        String sql = "UPDATE books SET name = ?, author = ?, description = ?, yearPublication = ?, isbn = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, books.getName());
            stmt.setString(2, books.getAuthor());
            stmt.setString(3, books.getDescription());
            stmt.setString(4, books.getYearPublication());
            stmt.setString(5, books.getIsbn());
            stmt.setLong(6, books.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteBook(Long id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
