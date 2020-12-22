package com.dt95.demo01;


import java.sql.SQLException;
import java.util.Scanner;


import com.dt95.dao.BaseDao;


public class Demo02 extends BaseDao{
	private Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Demo02 demo2 = new Demo02();
		System.out.println("��������Ҫ���еĲ���:");
		System.out.println("1������\t2��ɾ����\t3���޸�");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch (i) {
		case 1:
			demo2.add();
			break;
		case 2:
			demo2.delete();
			break;
		case 3:
			demo2.update();
			break;


		default:
			System.out.println("�������󣡣���������");
			break;
		}
	}
	
	public int show(String sql,Object...args){
		int flag = 0;
		try {
			pst = getCon().prepareStatement(sql);
			for(int i = 0; i<args.length; i++){
				pst.setObject(i+1, args[i]);
			}
			flag = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con, pst, rs);
		}
		return flag;
	}
	public void add(){
		String sql = "insert into info values(?,?)";
		System.out.println("������Ҫ����ı��:");
		int id = sc.nextInt();
		System.out.println("������Ҫ���������:");
		String name = sc.next();
		show(sql, id,name);
	}
	public void delete(){
		String sql = "delete from info where id = ?";
		System.out.println("������Ҫɾ���ı��:");
		int id = sc.nextInt();
		show(sql, id);
	}
	public void update(){
		String sql = "update info set name=? where id = ?";
		System.out.println("������Ҫ�޸ĵı��:");
		int id = sc.nextInt();
		System.out.println("������Ҫ�޸ĵ�����:");
		String name = sc.next();
		show(sql, name,id);
	}
}
