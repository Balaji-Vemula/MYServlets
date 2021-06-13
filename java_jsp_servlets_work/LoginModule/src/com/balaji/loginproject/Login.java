package com.balaji.loginproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginDao dao=new LoginDao();
		//if(uname.equals("Balaji")&& pass.equals("Vemula"))// for static checking username and password
		try {
			if(dao.check(uname, pass))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
