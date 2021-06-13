// This code is of ServletContext and ServletConfig

package com.vemula;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		out.print("hi  ");
		
		ServletConfig cg=getServletConfig();
		String str=cg.getInitParameter("name");
		
		/*// for Servlet Context
		 * ServletContext ctx=getServletContext();
		 * String str=ctx.getInitParameter("phone");
		 */
		out.println(str);
	}

}
