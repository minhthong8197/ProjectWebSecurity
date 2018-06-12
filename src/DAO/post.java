package DAO;


import java.sql.PreparedStatement;

import java.sql.SQLException;

import DB.DBConnection;

public class post {
	public static Integer add(String PostName, String PostContent) throws SQLException, ClassNotFoundException {
		try {
			String str= "insert into post(PostName,PostContent) values (?,?)";
			
			PreparedStatement pst = DBConnection.connect().prepareStatement(str);	
			pst.setString(1, PostName);
		     pst.setString(2, PostContent);  
		     int i= pst.executeUpdate();
		     return i;
		}catch(SQLException se) {
			return -1;
		}
		}
	
}
