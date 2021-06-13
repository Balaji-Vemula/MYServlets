package com.balaji.useradmin;

public class User {

	protected int id;
	protected String username;
    protected String first_name;
    protected String last_name;
    protected String pn;
    protected String email;
    protected String gender;
    protected String pwd;
    
    
	public User() {
		
	}
	public User(int id) {
		this.id = id;
	}
	public User(int id, String username, String first_name, String last_name, String pn, String email, String gender,
			String pwd) {
		this(username,first_name,last_name,pn,email,gender,pwd);
		this.id = id;
		
	}
	public User(String username, String first_name, String last_name, String pn, String email, String gender,
			String pwd) {
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.pn = pn;
		this.email = email;
		this.gender = gender;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPn() {
		return pn;
	}
	public void setPn(String pn) {
		this.pn = pn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
