package com.stu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stu.entity.Employee;
import com.stu.entity.Laterecord;
import com.stu.entity.Students;

import com.stu.util.DBHelper;

public class LaterecordDao {

	public int saveRecord(Laterecord laterecord){
		System.out.println(laterecord+"****");
	
		int row =0;
	try{
	 Connection conn = DBHelper.getConnection();
	 
	String sql = "insert into laterecord(student_no,student_name,building_no,dormitory_no,date) values(?,?,?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, laterecord.getStudent_no());
	ps.setString(2, laterecord.getStudent_name());
	ps.setString(3, laterecord.getBuilding_no());
	ps.setString(4, laterecord.getDormitory_no());
	ps.setString(5, laterecord.getDate());
	row = ps.executeUpdate();
	
				ps.close();
			}
	catch (Exception e) {
				e.printStackTrace();
			}
	
	return row;
	
			
		}
	
	
	

	public List<Laterecord> findLaterecord() {
		Connection conn = null;
		
		List<Laterecord> list = new ArrayList<Laterecord>();
		try {
			 conn = DBHelper.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "select student_no ,student_name,building_no,dormitory_no,date from laterecord";
				ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){

				Laterecord laterecord = new Laterecord();
				//student_no ,student_name,building_no,dormitory_no,date
				laterecord.setStudent_no(rs.getString("student_no"));
				laterecord.setStudent_name(rs.getString("student_name"));
				laterecord.setBuilding_no(rs.getString("building_no"));
				laterecord.setDormitory_no(rs.getString("dormitory_no"));
				laterecord.setDate(rs.getString("date"));
				list.add(laterecord);
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
	
	/*
	 * 	
	 */
		public List<Laterecord> queryByStuno(Laterecord laterecord) throws SQLException {
			//System.out.println("ѧ��+�������ڣ�"+students);
			Connection con = null;
			PreparedStatement pstmt = null;
				try {
					con = DBHelper.getConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String sql = "select student_no,student_name,building_no,dormitory_no,date from laterecord where student_no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, laterecord.getStudent_no());
				
				ResultSet rs = pstmt.executeQuery();
				List<Laterecord> list = new ArrayList<Laterecord>(); 
				while(rs.next()){
					// ʵ����Book���� id student_no,student_name,student_sex,department,grade,
					//professional,phonenumber,int_time,out_time,building_no,dormitory_no 
					
					Laterecord record=new Laterecord();

					// 2 ��name���Ը�ֵ
					record.setStudent_no(rs.getString("student_no"));
					// 3 ��sex���Ը�ֵ
					record.setStudent_name(rs.getString("student_name"));
					// 4 ��sex���Ը�ֵ
					record.setBuilding_no(rs.getString("building_no"));
				 	//5 ��age���Ը�ֵ
					record.setDormitory_no(rs.getString("dormitory_no"));
					record.setDate(rs.getString("date"));					

					// ��ͼ�������ӵ�������
					list.add(record);
			}
			
			return list;
		}


}
