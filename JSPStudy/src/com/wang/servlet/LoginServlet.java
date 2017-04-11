package com.wang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("uname");
		String password=request.getParameter("pwd");
		String forward=null;
		
		//System.out.println(name+" "+password);
		if(name.equals("wang") && password.equals("123"))
		{
			forward="/16/success.jsp";
			//response.sendRedirect(request.getContextPath()+"/16/success.jsp");
			RequestDispatcher rd=request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}else
		{
			forward="/16/error.jsp";
			//response.sendRedirect(request.getContextPath()+"/16/success.jsp");
			RequestDispatcher rd=request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
		
	}

}
