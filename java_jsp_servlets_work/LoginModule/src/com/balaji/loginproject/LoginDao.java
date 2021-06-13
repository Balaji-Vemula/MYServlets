package com.balaji.loginproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String sql="Select * from login where uname=? and pass=?";
	String url="jdbc:mysql://localhost:3306/balaji";
	String user="root";
	String password="Balaji@123";
	
	public boolean check(String uname,String pass) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,uname);
		st.setString(2,pass);
		ResultSet rs= st.executeQuery();
		
		if(rs.next())
		{
			return true;
		}
		return false;
	}

}
