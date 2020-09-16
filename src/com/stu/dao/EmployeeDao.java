package com.stu.dao;

import java.sql.Connection;
import java.sql.ResultSet;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


import com.stu.entity.Employee;

import com.stu.util.DBHelper;

public class EmployeeDao {

	public int saveEmployee(Employee employee){
		System.out.println(employee+"****");
	
		int row =0;
	try{

	 Connection conn = DBHelper.getConnection();
	// building_no  employee_no  employee_name  employee_ps 	 
	String sql = "insert into employee(building_no,employee_no,employee_name,employee_ps) values(?,?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, employee.getBuilding_no());
	ps.setString(2, employee.getEmployee_no());
	ps.setString(3, employee.getEmployee_name());
	ps.setString(4, employee.getEmployee_ps());
	row = ps.executeUpdate();
				ps.close();
			}
	catch (Exception e) {
				e.printStackTrace();
			}
	
	return row;	
		}	
	


	public List<Employee> findEmployee() {
		Connection conn = null;
		
		List<Employee> list = new ArrayList<Employee>();
		try {
			 conn = DBHelper.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "select building_no,employee_no,employee_name,employee_ps from employee";
				ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){

				Employee employee = new Employee();
				//building_no,employee_no,employee_name,employee_ps
				employee.setBuilding_no(rs.getString("building_no"));
				employee.setEmployee_no(rs.getString("employee_no"));
				employee.setEmployee_name(rs.getString("employee_name"));
				employee.setEmployee_ps(rs.getString("employee_ps"));
				list.add(employee);
			}
			rs.close();		
			stmt.close();	
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	public boolean isLogin(String employee_no, String employee_ps) throws Exception{
		boolean isT=false;
		Connection conn = DBHelper.getConnection();
		Statement stmt = conn.createStatement();// 3��Statement �ӿ���Ҫͨ��Connection �ӿڽ���ʵ��������
		//"select * from user where username = '" + username
		//+ "' and password = '" + password + "'"
	    ResultSet rs = stmt.executeQuery("select employee_no,employee_ps from employee where employee_no = '" + employee_no+ "' and employee_ps = '" + employee_ps + "'"); // ִ��SQL ��䣬��ѯ���ݿ�
		while (rs.next()) {
			isT = true;
	 	}
		rs.close();
		// 4���ر����ݿ�
		return isT;
	}
	
	
	public String findByEmployeeNo(String employee_no) throws SQLException {
		   Connection con=null;
		   ResultSet rs =null;
		   PreparedStatement pstmt =null;
		   try{
		    con=DBHelper.getConnection();;
			String sql = "SELECT * FROM  employee WHERE employee_no=?";
		    pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee_no);
			rs = pstmt.executeQuery();
			if(rs == null) {
				return null;
			}
			if(rs.next()) {
				Employee employee = new Employee();
				employee.setEmployee_no(rs.getString("employee_no"));
				employee.setEmployee_ps(rs.getString("employee_ps"));
			return employee_no;
			} else {
				return null;
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		} 
		}
	
	
	
	
	public List<Employee> queryByeID(Employee employee) throws SQLException {
		//System.out.println("ѧ��+�������ڣ�"+students);
		Connection con = null;
		PreparedStatement pstmt = null;
			try {
				con = DBHelper.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql = "select * from employee where employee_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getEmployee_no());
			
			ResultSet rs = pstmt.executeQuery();
			List<Employee> list = new ArrayList<Employee>(); 
			while(rs.next()){
				// ʵ����Book���� id student_no,student_name,student_sex,department,grade,
				Employee employee1 = new Employee();
				//building_no,employee_no,employee_name,employee_ps
				// ���������Ը�ֵ
				employee1.setBuilding_no(rs.getString("building_no"));
				employee1.setEmployee_no(rs.getString("employee_no"));
				employee1.setEmployee_name(rs.getString("employee_name"));
				employee1.setEmployee_ps(rs.getString("employee_ps"));
				// ������Ա������ӵ�������
				list.add(employee1);
			
		}
		
		return list;
	}

}
