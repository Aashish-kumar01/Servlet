import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class jdbcutil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Drive is registered");
	}
	public static void closeResource(Connection connect, PreparedStatement pstmt) throws SQLException {
		if(connect != null)
			connect.close();
		if(pstmt != null)
			pstmt.close();
	}

	public static Connection getDBConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/servlet";
		String userName = "root";
		String password = "admin";
		
		return DriverManager.getConnection(url,userName,password);
	}
}
