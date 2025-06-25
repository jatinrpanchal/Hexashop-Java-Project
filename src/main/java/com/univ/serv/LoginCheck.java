package com.univ.serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.univ.DAO.CustomerDAO;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String unm=request.getParameter("unm");
	    String pw=request.getParameter("pw");
	   CustomerDAO dao=new CustomerDAO();
	   List lst=dao.loginCheck(unm, pw);
	   if(lst==null || lst.isEmpty())
	   {
		response.sendRedirect("login.jsp");   
	   }else {
		HttpSession hs=request.getSession(true);
		hs.setAttribute("user", lst);
		response.sendRedirect("index.jsp");   
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
