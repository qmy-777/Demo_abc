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
		Connection con=null;//ͨ��
		PreparedStatement pst=null;//Ԥ����
		ResultSet rs=null;//��
		try {
			String sql="SELECT id,NAME FROM info WHERE id=?";
			Class.forName("com.mysql.jdbc.Driver");//��������
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
			pst=con.prepareStatement(sql);
			Scanner sc=new Scanner(System.in);
			System.out.println("�������ѯ����:");
			int sno=sc.nextInt();
			pst.setInt(1, sno);
			rs=pst.executeQuery();
			String id="";
			String name="";
			while(rs.next()){
				id=rs.getString("id");
				name=rs.getString("name");
			}
			System.out.println("��ȡmysql���ݱ�");
			System.out.println(id+"\t"+name+"\t");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}
}
