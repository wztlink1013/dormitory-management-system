<%@ page  pageEncoding="utf-8"%>
<% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
		return;
	}
%>
<form action="servlet/AddStuServlet" method="post" onsubmit="return check(this);">
		<table align="center" width="450" >
			<tr>
				<td align="center" colspan="2">
					<h2>添加学生</h2>
					
				</td>
			</tr>
			
			<tr>
				<td align="right">学&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
				<td><input type="text" name="student_no" /></td>
			</tr>
			<tr>
				<td align="right"> 姓&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
				<td><input type="text" name="student_name" /></td>
			</tr>
			<tr>
			<td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
			<td>
				<input type="radio" name="student_sex" value="男" checked="checked"/>男
				<input type="radio" name="student_sex" value="女"/>女
			</td>
		    </tr>
			
			<tr>
			<td align="right">院&nbsp;&nbsp;&nbsp;&nbsp;系:</td>
			<td>
				<select name="department">
					<option value="信息科学与工程学院" selected="selected">信息科学与工程学院</option>
					<option value="马克思主义学院" selected="selected">马克思主义学院</option>
					<option value="体育学院" selected="selected">体育学院</option>
					<option value="外国语学院" selected="selected">外国语学院</option>
					<option value="音乐学院" selected="selected">音乐学院</option>
					<option value="新闻与传媒学院" selected="selected">新闻与传媒学院</option>
					<option value="数学与统计学院" selected="selected">数学与统计学院</option>
					
				</select>
			</td>
			<tr>
			<td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;级:</td>
			<td>
				<select name="grade">
					<option value="2012" selected="selected">2016</option>
					<option value="2013" selected="selected">2017</option>
					<option value="2014" selected="selected">2018</option>
					<option value="2015" selected="selected">2019</option>
					
				</select>
			</td>
		    </tr>
			<tr>
				<td align="right">专&nbsp;&nbsp;&nbsp;&nbsp;业:</td>
				<td><input type="text" name="professional" /></td>
			</tr>
			<tr>
				<td align="right">电话号码:</td>
				<td><input type="text" name="phonenumber" /></td> 
			</tr>
			<tr>
				<td align="right">入住时间:</td>
				<td><input type="text" name="int_time" /></td>
			</tr>
			<tr>
				<td align="right">离开时间:</td>
				<td><input type="text" name="out_time" /></td>
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
				<td align="right">宿舍房号:</td>
				<td><input type="text" name="dormitory_no" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="添　加">
				</td>
			</tr>
		</table>
	</form>