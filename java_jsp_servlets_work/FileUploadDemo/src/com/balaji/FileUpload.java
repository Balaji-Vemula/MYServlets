package com.balaji;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload1
 */
public class FileUpload extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> multi = null;
		multi = sf.parseRequest(request);
		
		for(FileItem item:multi)
		{
			try {
				item.write(new java.io.File("D:\\uploading_location\\sineeth\\"+item.getName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("error in sineeth2");
			}
		}
		PrintWriter out=response.getWriter();
		out.println("File uploaded successfully......!");
	}

}
