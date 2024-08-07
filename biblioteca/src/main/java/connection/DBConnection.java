package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static String url = "jdbc:postgresql://localhost:5432/biblioteca?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "postgres";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	
	public DBConnection() {
		conectar();
	}
	
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver"); 
				connection = DriverManager.getConnection(url, user, senha);
				connection.setAutoCommit(false); 
				System.out.println("Conexão ok");
			}
			
		}catch (Exception e) {
			System.out.println("sem conexão");
			e.printStackTrace();
		}
	}

}

