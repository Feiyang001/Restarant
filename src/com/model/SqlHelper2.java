package com.model;
import com.tools.*;
import java.sql.*;
import java.util.*;

public class SqlHelper2 {
	
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	
	//String driverName = "com.mysql.jdbc.Driver";
	//String url = "jdbc:mysql://localhost:3306/test";
	
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName=aaa";
	String user="sa";
	String passwd="123456";
	
	public SqlHelper2() {
		try {
			Class.forName(driverName);
			ct=DriverManager.getConnection(url, user,passwd);
			
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	//对数据库的操作写一个函数
	public boolean exeUpdata(String sql,String []paras) {
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}
			ps.executeQuery();
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}
	//写一个返回ResultSet的函数
	public ResultSet query(String sql,String paras[]) {
		
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return rs;
	}
	//关闭流的函数
	public void close() {
		try {
			//if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e2) {
			e2.printStackTrace();
			// TODO: handle exception
		}		
	}
}

