package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBConnection;

public class UsersDAO {
	public static String LoadUser(String userName, String userPass) throws SQLException, ClassNotFoundException {
		try {
			String str = "select * from users";
			ResultSet rs = DBConnection.ExecuteQueryResultSet(str);
			
			while(rs.next()) {
				if(userName.equals(rs.getString("userName")) && userPass.equals(rs.getString("userPass"))) {
					return rs.getString("Quyen");
				}
			}
		}catch(SQLException se) {
			return "";
		}
		return "";
	}
	
}
