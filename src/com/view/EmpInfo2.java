package com.view;
import com.model.*;
import java.sql.*;

import javax.swing.*;

import com.tools.Mytools;

import java.awt.*;
import java.awt.event.*;

public class EmpInfo2 extends JPanel implements ActionListener {
	
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_lab1,p3_lab;
	JTextField jtf;
	JButton p1_jb1,p4_jb2,p4_jb3,p4_jb4,p4_jb5;
	EmpModel2 em;
	JTable p2_jt;
	JScrollPane jsp;
	
	public EmpInfo2() {
		
		p1=new JPanel(new FlowLayout(FlowLayout.CENTER ));
		p1_lab1=new JLabel("请输入员工号或姓名");
		p1_lab1.setFont(Mytools.f2);
		jtf=new JTextField(20);
		jtf.setBorder(BorderFactory.createLoweredBevelBorder());
		p1_jb1=new JButton("查询");
		p1_jb1.addActionListener(this);
		p1_jb1.setFont(Mytools.f2);
		p1.add(p1_lab1);
		p1.add(jtf);
		p1.add(p1_jb1);
		
		p2=new JPanel(new BorderLayout());
		em=new EmpModel2();
		String paras[]= {"1"};
		em.query("select uId,Name,Sex,zhiwei from renshi where 1=?", paras);
		p2_jt=new JTable(em);
		jsp=new JScrollPane(p2_jt);
		p2.add(jsp);
		
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT ));
		p3_lab=new JLabel("     总记录");
		p3_lab.setFont(Mytools.f2);
		p3.add(p3_lab);
		
		p4=new JPanel(new FlowLayout(FlowLayout.RIGHT ));
		p4_jb2=new JButton("增加");
		p4_jb2.setFont(Mytools.f2);
		p4_jb3=new JButton("删除");
		
		p4_jb3.setFont(Mytools.f2);
		p4_jb4=new JButton("修改");
		p4_jb4.setFont(Mytools.f2);
		p4_jb5=new JButton("详细信息");
		p4_jb5.setFont(Mytools.f2);
		p4.add(p4_jb5);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
		
		p5=new JPanel(new BorderLayout());
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.add(p1, "North");
		this.add(p2, "Center");
		this.add(p5,"South");	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
