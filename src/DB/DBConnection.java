package DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import DB.DBConnection;

public class DBConnection {
	public static Connection connect() throws SQLException {

		String url = "jdbc:mysql://35.198.251.138:3306/";
		String dbName = "websitehoithao?useUnicode=true&characterEncoding=UTF-8";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "1234";
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			System.out.print("connected from DBConnection.java");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static ResultSet ExecuteQueryResultSet(String str) throws ClassNotFoundException, SQLException {

		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = connect();
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(str);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static int NewPost(String PostName, String PostContent, String Ptl, String Pdate) throws SQLException {

		String str = "insert into post1(PostName,PostContent,Ptl,Pdate,P,P1) values (?,?,?,?,'chua duyet',3)";

		PreparedStatement pst = DBConnection.connect().prepareStatement(str);
		pst.setString(1, PostName);
		pst.setString(2, PostContent);
		pst.setString(3, Ptl);
		pst.setString(4, Pdate);
		int i = pst.executeUpdate();
		return i;
	}

	public static int NewPostad(String PostName, String PostContent, String Ptl, String Pdate) throws SQLException {

		String str = "insert into post1(PostName,PostContent,Ptl,Pdate,P,P1) values (?,?,?,?,'chua duyet',1)";

		PreparedStatement pst = DBConnection.connect().prepareStatement(str);
		pst.setString(1, PostName);
		pst.setString(2, PostContent);
		pst.setString(3, Ptl);
		pst.setString(4, Pdate);
		int i = pst.executeUpdate();
		return i;
	}

	public static int Newacount(String UserName, String Userpass, String FullName, String Gender, String PhoneNumber,
			String Quyen, String date) throws SQLException {

		String str = "insert into users(UserName,Userpass,FullName,Gender,PhoneNumber,Quyen,date) values (?,?,?,?,?,?,?)";

		PreparedStatement pst = DBConnection.connect().prepareStatement(str);
		pst.setString(1, UserName);
		pst.setString(2, Userpass);
		pst.setString(3, FullName);
		pst.setString(4, Gender);
		pst.setString(5, PhoneNumber);
		pst.setString(6, Quyen);
		pst.setString(7, date);

		int i = pst.executeUpdate();
		return i;
	}

}