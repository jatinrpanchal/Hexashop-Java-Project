package com.univ.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.univ.DAO.CustomerDAO;
import com.univ.DTO.CustomerDTO;


@WebServlet("/CustomerReg")
public class CustomerReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CustomerDTO dto=new CustomerDTO();
	dto.setCname(request.getParameter("cname"));
	dto.setCadd(request.getParameter("cadd"));
	dto.setEmail(request.getParameter("email"));
	dto.setMob(Long.parseLong(request.getParameter("mob")));
	dto.setUnm(request.getParameter("unm"));
	dto.setPw(request.getParameter("pw"));
	
	CustomerDAO dao=new CustomerDAO();
	int x=dao.insert(dto);
	if(x==1)
	{
	 response.sendRedirect("login.jsp");	
	}else {
     response.sendRedirect("signup.jsp"); 	
	}
	
  }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
