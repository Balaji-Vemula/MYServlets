package com.balaji.useradmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class UserDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/useradmin";
    private String jdbcUsername="root";
    private String jdbcPassword="Balaji@123";
    private Connection jdbcConnection;
     
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException x) {
                throw new SQLException(x);
            }
            jdbcConnection = DriverManager.getConnection(
            		jdbcURL,jdbcUsername,jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO user (username,first_name,last_name,pn,email,gender,pwd) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getFirst_name());
        statement.setString(3, user.getLast_name());
        statement.setString(4, user.getPn());
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getGender());
        statement.setString(7, user.getPwd());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();
         
        String sql = "SELECT * FROM User";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String username=resultSet.getString("username");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String pn = resultSet.getString("pn");
            String email = resultSet.getString("email");
            String gender=resultSet.getString("gender");
			String pwd=resultSet.getString("pwd");
			User user = new User(id,username, first_name, last_name, pn, email, gender, pwd);
            listUser.add(user);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listUser;
    }
     
    public boolean deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM user where user_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET username=?,first_name = ?, last_name = ?, pn = ?, email = ?, gender=?, pwd=?";
        sql += " WHERE user_id = ?";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getFirst_name());
        statement.setString(3, user.getLast_name());
        statement.setString(4, user.getPn());
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getGender());
        statement.setString(7, user.getPwd());
        statement.setInt(8,user.getId());
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
     
    public User getUser(int id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_id = ?";
       
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String username=resultSet.getString("username");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String pn = resultSet.getString("pn");
            String email = resultSet.getString("email");
            String gender=resultSet.getString("gender");
			String pwd=resultSet.getString("pwd");
             
			user=new User(id, username, first_name, last_name, pn, email, gender, pwd);
        }
         
        resultSet.close();
        statement.close();
        disconnect();
        return user;
    }

	public boolean check(String uname, String pass) throws SQLException {
		String sql="Select * from user where username=? and pwd=?";
		connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1,uname);
		statement.setString(2,pass);
		ResultSet resultSet= statement.executeQuery();
		
		if(resultSet.next())
		{
			return true;
		}
		resultSet.close();
        statement.close();
        disconnect();
		return false;
	}
}