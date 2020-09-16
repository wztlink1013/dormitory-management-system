package com.stu.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.entity.Employee;
import com.stu.entity.Role;
import com.stu.service.AdminService;
import com.stu.service.EmployeeService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	/**
	 * Constructor of the object.
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if("login".equals(action)){
			login(request,response);
		}else if("logout".equals(action)){
			logout(request,response);
		}
		
	
}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 try {
			    
				//Employee e = new Employee();
				//String employee_no = request.getParameter("employee_no");
				//String employee_ps = request.getParameter("employee_ps");
				//e.setEmployee_no(employee_no);
				//e.setEmployee_ps(employee_ps);
				Role r=new Role();
				String role = request.getParameter("role");
				String user = request.getParameter("user");
				
				String password = request.getParameter("password");
				
				r.setRole(role);
				r.setUser(user);
				r.setPassword(password);
				// 验证用户名和密码,true = 登陆成功
			   	
				
				try {
				if(r.getRole().equals("employee")){
					EmployeeService employeeservice=new EmployeeService();
					if (employeeservice.isLogin(r.getUser(), r.getPassword())) {// 成功的
						request.getSession().setAttribute("user",r.getUser() );
						request.getRequestDispatcher("employee.jsp").forward(request, response);
					    } 
					else {// 失败
						request.getRequestDispatcher("error.jsp").forward(request, response);
					        }
				       }
				else if(r.getRole().equals("admin")){
					    AdminService adminservice=new AdminService();
						if (adminservice.isLogin(r.getUser(), r.getPassword())) {// 成功的
							request.getSession().setAttribute("user",r.getUser() );
							request.getRequestDispatcher("admin.jsp").forward(request, response);
						    } 
						else {// 失败
							request.getRequestDispatcher("error.jsp").forward(request, response);
						        }
					}
				
					
				} catch (Exception e1) {

					e1.printStackTrace();
				}
		} 
				catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
