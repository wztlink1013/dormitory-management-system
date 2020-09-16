package com.stu.servlet;

import com.stu.entity.Students;
import com.stu.dao.StudentsDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	/**
	 * Constructor of the object.
	 */
	public AddStuServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		       // ����response�ı���
				//response.setCharacterEncoding("utf-8");
				// ��ȡPrintWriter
				PrintWriter out = response.getWriter();
				// ����request�ı���
				//request.setCharacterEncoding("utf-8");
				// ��ȡ����
				
				//��ҳ�� ��ȡ�Ա�
				String student_no = request.getParameter("student_no");
				// ��ȡ����
				String student_name = request.getParameter("student_name");
				// ��ȡ�༶
				String student_sex = request.getParameter("student_sex");
				// ��ȡ����
				String department = request.getParameter("department");
				// ��ȡ�Ա�
				String grade = request.getParameter("grade");
				// ��ȡ����
				String professional = request.getParameter("professional");
				// ��ȡ�༶
				String phonenumber = request.getParameter("phonenumber");
				// ��ȡ����
				String int_time = request.getParameter("int_time");
				// ��ȡ�Ա�
				String out_time = request.getParameter("out_time");
				// ��ȡ����
				String building_no = request.getParameter("building_no");
				// ��ȡ�༶
				String dormitory_no = request.getParameter("dormitory_no");
				// ʵ����student
				Students students = new Students(student_no,student_name,student_sex,department,grade,professional,phonenumber,int_time,out_time,building_no,dormitory_no);	
				// ʵ����StudentDao
				StudentsDAO dao = new StudentsDAO();
				// ���ѧ����Ϣ
				int row = dao.saveStudent(students);
				if(row > 0){
					// ���³������Ϣ
					out.print("Successfully added" + row + "data");
					
				}else{
					out.print("Add data failure");
				}
				out.flush();
				out.close();
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
