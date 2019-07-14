/**
 * 这是用户表数据模型，用它完成对用户的各种操作（crud）
 * 这里主要是编写项目需要的业务操作
 */

package com.model;
import com.view.*;
import com.tools.*;
import java.sql.*;
public class UserModel2 {

	/**
	 * 
	 * @param uid  员工号
	 * @param p  密码
	 * @return 返回用户的职位，如果没有，就返回空
	 */
	public String checkUser(String uid,String p) {
		
		//职位
		String zhiwei=" ";
		SqlHelper2 sh=null;
		
		try {
			//组织sql语句和参数列表
			String sql="select renshi.zhiwei from renshi,denglu where denglu.uId=renshi.uId and denglu.uId=? and denglu.passWd=?";
			String []paras= {uid,p};
			
			sh=new SqlHelper2();
			ResultSet rs=sh.query(sql, paras);
			if(rs.next()) {
				zhiwei=rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return zhiwei;
	}

}
