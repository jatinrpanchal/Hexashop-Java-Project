package com.univ.serv;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.univ.DAO.CustomerDAO;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
@MultipartConfig(maxFileSize = 16177215)
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     // Getting the parametes from web page
 String price= request.getParameter("imgprice");
 String type= request.getParameter("imgtype");
		  
		        // Input stream of the upload file
		   InputStream in= null;
		   String message = null;
		  
		        // Obtains the upload file
		        // part in this multipart request
		  Part filePart=request.getPart("photo");
		  String fnm="";
		  
		        if (filePart != null) {
		  
		            // Prints out some information
		            // for debugging
		        fnm=filePart.getSubmittedFileName();
		 System.out.println(fnm);
		 
		 System.out.println(filePart.getSize());
		 System.out.println(filePart.getContentType());
		 // Obtains input stream of the upload file
		 in= filePart.getInputStream();
		        }
		  
		        // Sends the statement to the
		        // database server
		  CustomerDAO dao=new CustomerDAO();  
		  
		int row= dao.uploadFile(fnm,price,type,in);
		        if (row > 0) {
		response.sendRedirect("file.jsp");
		        }else {
		 response.sendRedirect("login.jsp");  	
		        }
		        
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
