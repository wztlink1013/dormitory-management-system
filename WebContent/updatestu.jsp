
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="com.stu.entity.Students"%>
<%@page import="com.stu.dao.StudentsDAO"%>

<% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
		return;
	}
%>
<form action="UpdateStuServlet" method="post" onsubmit="return check(this);">
		   <table align="center" width="450" >
		
			<tr>
				<td align="center" colspan="2">
					<h2>修改学生信息</h2>
					
				</td>
			</tr>
<%
		
		String id =request.getParameter("id");
		String student_no =request.getParameter("student_no");
		String student_name =request.getParameter("student_name");
		String student_sex =request.getParameter("student_sex");
		String department =request.getParameter("department");
		String grade =request.getParameter("grade");
		String professional =request.getParameter("professional");
		String phonenumber =request.getParameter("phonenumber");
		String int_time =request.getParameter("int_time");
		String out_time =request.getParameter("out_time");
		String building_no =request.getParameter("building_no");
		String dormitory_no =request.getParameter("dormitory_no");
		
		//student_no,student_name,student_sex,department,grade,
	    //professional,phonenumber,int_time,out_time,building_no,dormitory_no
		  
 %>			
			<tr>
				<td align="right">学&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
				
				<td><input type="text" name="student_no" value="<%=student_no%>"/></td>
			</tr>
			<tr>
				<td align="right"> 姓&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
				<td><input type="text" name="student_name" value="<%=student_name%>"/></td>
			</tr>
			
			<tr>
				<td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
				<td><input type="text" name="student_sex" value="<%=student_sex%>"/></td>
			</tr>
			<tr>
				<td align="right">院&nbsp;&nbsp;&nbsp;&nbsp;系:</td>
				<td><input type="text" name="department" value="<%=department%>"/></td>
			</tr>
			
		    <tr>
				<td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;级:</td>
				<td><input type="text" name="grade" value="<%=grade%>"/></td>
			</tr>
		    <tr>
				<td align="right">专&nbsp;&nbsp;&nbsp;&nbsp;业:</td>
				<td><input type="text" name="professional" value="<%=professional%>"/></td>
			</tr>
			
			<tr>
				<td align="right">电话号码:</td>
				<td><input type="text" name="phonenumber" value="<%=phonenumber%>"/></td> 
			</tr>
			<tr>
				<td align="right">入住时间:</td>
				<td><input type="text" name="int_time" value="<%=int_time%>"/></td>
			</tr>
			<tr>
				<td align="right">离开时间:</td>
				<td><input type="text" name="out_time" value="<%=out_time%>"/></td>
			</tr>
			<tr>
				<td align="right">宿舍楼号:</td>
				<td><input type="text" name="building_no" value="<%=building_no%>"/></td>
			</tr>
			
			
			<tr>
				<td align="right">宿舍房号:</td>
				<td><input type="text" name="dormitory_no" value="<%=dormitory_no%>"/></td>
			</tr>
			<tr>
			
			    <td><input type="hidden" name="id" value="<%=id%>"/></td>
		    </tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="确定">
				</td>
			</tr>
			
		</table>
	</form>