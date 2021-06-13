package com.balaji.useradmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    public void init() {
 
        userDAO = new UserDAO("jdbc:mysql://localhost:3306/useradmin", "root", "Balaji@123");

    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String action = request.getServletPath();
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertUser(request, response);
                break;
            case "/deleteconfirm":
                deleteUserConfirm(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateUser(request, response);
                break;
            case "/list":
            	listUser(request, response);
                break;
            case "/loginpage":
            	showLoginPage(request, response);
                break;
            case "/login":
            	loginPage(request, response);
                break;
            case "/Logout":
            	logout(request, response);
                break;
            default:
                ShowAdminPage(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	
    	HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
		
		response.setHeader("pragma", "no-cache");// Http version 1.0
		
		response.setHeader("Expires", "0");// for proxies

		if(session.getAttribute("uname")==null)
		{
			response.sendRedirect("Admin.jsp");
		}
		else {
			session.setAttribute("flag", "ds");
	        int id = Integer.parseInt(request.getParameter("id"));
	        User user = new User(id);
	        userDAO.deleteUser(user);
	        response.sendRedirect("list");
		}
    }
    
    private void deleteUserConfirm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		// TODO Auto-generated method stub
    	HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
		
		response.setHeader("pragma", "no-cache");// Http version 1.0
		
		response.setHeader("Expires", "0");// for proxies

		if(session.getAttribute("uname")==null)
		{
			response.sendRedirect("Admin.jsp");
		}
		else {
    	
			int id = Integer.parseInt(request.getParameter("id"));
	        User existingUser = userDAO.getUser(id);
	        request.setAttribute("user", existingUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteConfirm.jsp");
	        dispatcher.forward(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession();
		session.removeAttribute("uname");
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}

	private void loginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		try {
			if(userDAO.check(uname, pass))
			{
				HttpSession session=request.getSession();
				session.setAttribute("uname", uname);
				session.setAttribute("flag","ls");
				response.sendRedirect("list");
			}
			else
			{
				response.sendRedirect("Login.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void showLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
		
	}

	private void ShowAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.jsp");
        dispatcher.forward(request, response);
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
			List<User> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
	        dispatcher.forward(request, response);
		
    }
   
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
		
		response.setHeader("pragma", "no-cache");// Http version 1.0
		
		response.setHeader("Expires", "0");// for proxies

		if(session.getAttribute("uname")==null)
		{
			response.sendRedirect("Admin.jsp");
		}
		else {
	    	int id = Integer.parseInt(request.getParameter("id"));
	        User existingUser = userDAO.getUser(id);
	        request.setAttribute("user", existingUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
	        dispatcher.forward(request, response);
		}
 
    }
 
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	HttpSession session=request.getSession();
    	session.setAttribute("flag", "rs");
    	String username = request.getParameter("username");
    	String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String pn = request.getParameter("pn");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String pwd = request.getParameter("pwd");
 
        User newUser = new User(username, first_name, last_name, pn, email, gender, pwd);
        userDAO.insertUser(newUser);
        response.sendRedirect("Login.jsp");
    }
 
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
		
		response.setHeader("pragma", "no-cache");// Http version 1.0
		
		response.setHeader("Expires", "0");// for proxies

		if(session.getAttribute("uname")==null)
		{
			response.sendRedirect("Admin.jsp");
		}
		else {
			session.setAttribute("flag", "us");
	        int id = Integer.parseInt(request.getParameter("id"));
	        String username = request.getParameter("username");
	    	String first_name = request.getParameter("first_name");
	        String last_name = request.getParameter("last_name");
	        String pn = request.getParameter("pn");
	        String email = request.getParameter("email");
	        String gender = request.getParameter("gender");
	        String pwd = request.getParameter("pwd");
	 
	        User user = new User(id, username, first_name, last_name, pn, email, gender, pwd);
	        userDAO.updateUser(user);
	        response.sendRedirect("list");
        }
    }
 
    
}