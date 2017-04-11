package com.wang.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wang.entity.User;
import com.wang.service.CheckUserService;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CheckUserService cus=new CheckUserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
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
		String forward="";
		RequestDispatcher rd=null;
		if(name==null || password==null)
		{
			request.setAttribute("msg", "用户名或密码为空，请重新输入");
			forward="/17/error.jsp";
			rd=request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}else{
			User user=new User();
			user.setName(name);
			user.setPassword(password);
			boolean bool=cus.check(user);
			if(bool){
				forward="/17/success.jsp";
			}else{
				forward="/17/error.jsp";
				request.setAttribute("msg", "用户名或密码错误，请重新输入");
			}
			rd=request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
		
	}

}
