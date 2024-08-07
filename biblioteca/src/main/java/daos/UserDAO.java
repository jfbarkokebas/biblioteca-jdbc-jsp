package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.User;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password, whatsapp, phone) "
        		+ "VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getWhatsapp());
            stmt.setString(5, user.getPhone());
            stmt.execute();
            connection.commit();

        }
    }

    public User getUser(Long id) throws SQLException {
    	
        String sql = "SELECT * FROM users WHERE id = ? ";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("whatsapp"),
                        rs.getString("phone")
                    );
                }
            }
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
    	
        List<User> users = new ArrayList<>();
        
        String sql = "SELECT * FROM users ORDER BY name ASC LIMIT 300";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        	
        	try(ResultSet rs = stmt.executeQuery()){
        		
        		 while (rs.next()) {
                     users.add(new User(
                         rs.getLong("id"),
                         rs.getString("name"),
                         rs.getString("email"),
                         rs.getString("password"),
                         rs.getString("whatsapp"),
                         rs.getString("phone")
                     ));
                 }
        	}
           
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, password = ?, whatsapp = ?, phone = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getWhatsapp());
            stmt.setString(5, user.getPhone());
            stmt.setLong(6, user.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(Long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}