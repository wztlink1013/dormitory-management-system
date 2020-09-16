<%@ page  pageEncoding="utf-8"%>

<% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
		return;
	}
%>

<form action="AddEmpServlet" method="post" onsubmit="return check(this);">
		<table align="center" width="450" >
			<tr>
				<td align="center" colspan="2">
					<h2>添加层长</h2>
					
				</td>
			</tr>
			<tr>
				<td align="right">层长编号:</td>
				<td><input type="text" name="employee_no" /></td>
			</tr>
			<tr>
				<td align="right">层长姓名:</td>
				<td><input type="text" name="employee_name" /></td>
			</tr>

			<tr>
			<td align="right">宿舍楼号:</td>
			<td>
				<select name="building_no">
					<option value="1" selected="selected">1</option>
					<option value="2" selected="selected">2</option>
					<option value="3" selected="selected">3</option>
					<option value="4" selected="selected">4</option>
					<option value="5" selected="selected">5</option>
					<option value="6" selected="selected">6</option>
					<option value="7" selected="selected">7</option>
					<option value="8" selected="selected">8</option>
					<option value="9" selected="selected">9</option>
					<option value="10" selected="selected">10</option>
					<option value="11" selected="selected">11</option>
					
				</select>
			</td>
			<tr>
				<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
				<td><input type="text" name="employee_ps"  value="123456"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="添　加">
				</td>
			</tr>
		</table>
	</form>