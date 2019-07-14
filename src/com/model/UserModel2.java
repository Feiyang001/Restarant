/**
 * �����û�������ģ�ͣ�������ɶ��û��ĸ��ֲ�����crud��
 * ������Ҫ�Ǳ�д��Ŀ��Ҫ��ҵ�����
 */

package com.model;
import com.view.*;
import com.tools.*;
import java.sql.*;
public class UserModel2 {

	/**
	 * 
	 * @param uid  Ա����
	 * @param p  ����
	 * @return �����û���ְλ�����û�У��ͷ��ؿ�
	 */
	public String checkUser(String uid,String p) {
		
		//ְλ
		String zhiwei=" ";
		SqlHelper2 sh=null;
		
		try {
			//��֯sql���Ͳ����б�
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
