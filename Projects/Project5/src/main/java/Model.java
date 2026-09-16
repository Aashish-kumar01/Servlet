import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
	private String name;
	private String email;
	private String upassword;
	private String ucity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	
	public int register() {
		Connection connect = null;
		PreparedStatement pstmt= null;
		int row=0;
		try {
			connect = jdbcutil.getDBConnection();
			String sql = "INSERT INTO personalInfo (uname,email,upassword,ucity) VALUES(?,?,?,?)";
			pstmt = connect.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setString(3, upassword);
			pstmt.setString(4, ucity);
			
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				jdbcutil.closeResource(connect, pstmt);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
}
