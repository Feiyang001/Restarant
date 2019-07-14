package com.model;

import javax.swing.table.*;

import java.sql.*;
import java.util.*;

public class EmpModel2 extends AbstractTableModel {

	Vector<String> colums;
	Vector<Vector> rows;
	
	//提供员工号来删除员工的函数
	public boolean delEmpById(String empNo) {
		
		boolean b=true;
		
		String sql="delete from renshi where uId=?";
		String []paras= {empNo};
		SqlHelper2 sh=new SqlHelper2(); 
		try {
			sh.exeUpdata(sql, paras);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			sh.close();
		}
		return b;
	}
	
	//query方法写的要有通用性
	public void query(String sql,String paras[]) {
		colums=new Vector<String>();
		rows=new Vector<Vector>();
		SqlHelper2 sh=new SqlHelper2();
		ResultSet rs=sh.query(sql, paras);

		//把rs的结果放进去
		try {
			//从rs对象中可以得到一个ResultSetMetadata
			//rsm 可以得到结果有多少列，而且可以知道每列的名字
			ResultSetMetaData rsm=rs.getMetaData();
			for(int i=0;i<rsm.getColumnCount();i++) {
				this.colums.add(rsm.getColumnName(i+1));
			}
			
		while (rs.next()) {
			Vector<String> temp=new Vector<String>();
			for(int i=0;i<rsm.getColumnCount();i++) {
				temp.add(rs.getString(i+1));
			}
			rows.add(temp);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sh.close();
		}
	
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.colums.size();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return this.colums.get(arg0);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rows.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return (rows.get(arg0)).get(arg1);
	}

	

}