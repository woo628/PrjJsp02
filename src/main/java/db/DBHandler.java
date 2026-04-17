package db;
import java.sql.*;

public class DBHandler {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuid = "sky";
	private String dbpwd = "1234";
	
	// 회원목록
	public void listUser() throws ClassNotFoundException, SQLException {
		Class.forName(driver);	
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		
		String sql = "select * from TUSER order by id";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		String fmt = "%s %s %s";
		while (rs.next()) {
			String userid = rs.getString("id");
			String username = rs.getString("name");
			String email = rs.getString("email");
			String msg = String.format(fmt,userid,username,email);
			System.out.println(msg);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
	}
	
	
	
	
	// 회원추가
	public int addUser(String userid, String username, String email) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,dbuid,dbpwd);
		
		String sql = "insert into TUSER values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,userid);
		pstmt.setString(2,username);
		pstmt.setString(3,email);
		
		int aftcnt = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return aftcnt;
	}
	
	// 회원수정
	public int fixUser(String userid, String username, String email) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		
		String sql = "update TUSER set name=?, email=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setString(2,email);
		pstmt.setString(3,userid);
		
		int upcnt = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return upcnt;
	}
}
