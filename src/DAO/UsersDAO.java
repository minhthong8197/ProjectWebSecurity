package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBConnection;

public class UsersDAO {
	public static int LoadUser(String userName, String userPass) throws SQLException, ClassNotFoundException {
		try {
			String str = "select * from users";
			ResultSet rs = DBConnection.ExecuteQueryResultSet(str);
			System.out.println("helloooooooooooo");
			while (rs.next()) {
				if (userName.equals(rs.getString("userName")) && userPass.equals(rs.getString("userPass"))) {
					return rs.getInt("UserID");
				}
			}
		} catch (SQLException se) {
			return -1;
		}
		return -1;
	}

}
