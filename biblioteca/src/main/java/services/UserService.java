package services;

import java.sql.SQLException;
import java.util.List;

import daos.UserDAO;
import model.User;

public class UserService {
	
	UserDAO dao = new UserDAO();
	
	public  void addUser(User user) {
		
		//APLICAR AS REGRAS DE NEGÓCIO
		
		if(user != null) {
			try {
				dao.addUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<User> getAllUsers(){
		//APLICAR AS REGRAS DE NEGÓCIO
		try {
			
			return dao.getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

}
