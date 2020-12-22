package com.dt95.demo01;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;//通道
		PreparedStatement pst=null;//预编译
		ResultSet rs=null;//马车
		try {
			String sql="SELECT id,NAME FROM info WHERE id=?";
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
			pst=con.prepareStatement(sql);
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入查询号码:");
			int sno=sc.nextInt();
			pst.setInt(1, sno);
			rs=pst.executeQuery();
			String id="";
			String name="";
			while(rs.next()){
				id=rs.getString("id");
				name=rs.getString("name");
			}
			System.out.println("读取mysql数据表");
			System.out.println(id+"\t"+name+"\t");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}
}
