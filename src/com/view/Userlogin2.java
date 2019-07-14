package com.view;
import  com.tools.*;
import com.model.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Userlogin2 extends JDialog implements ActionListener{
	Image p1_bg;
	JLabel lab1,lab2,lab3,lab4;
	JTextField jtf;
	JPasswordField jpw;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Userlogin2 u=new Userlogin2();
		
	}
	
	public  Userlogin2() {
		
		Container c=this.getContentPane();
		this.setLayout(null);

		lab2=new JLabel("�������û���");
		lab2.setBounds(60,190,150,30);
		lab2.setFont(Mytools.f1);
		c.add(lab2);

		lab3=new JLabel("������Ա���ţ�");
		lab3.setForeground(Color.red);
		lab3.setBounds(60,210,100,30);
		lab3.setFont(Mytools.f3);
		c.add(lab3);
		
		lab4=new JLabel("����������");
		lab4.setBounds(60,250,150,30);
		lab4.setFont(Mytools.f1);
		c.add(lab4);
		
		jtf=new JTextField(20);
		jtf.setBounds(160, 190,150,30);
		//����ͼ������
		jtf.setBorder(BorderFactory.createLoweredBevelBorder());
		c.add(jtf);
		
		jpw=new JPasswordField(20);
		jpw.setBounds(160,250,150,30);
		jpw.setBorder(BorderFactory.createLoweredBevelBorder());
		c.add(jpw);
		
		jb1=new JButton("��¼");
		jb1.setFont(Mytools.f1);
		jb1.addActionListener(this);
		jb1.setBounds(80,300,80,30);
		c.add(jb1);
		
		jb2=new JButton("�˳�"); 
		jb2.addActionListener(this);
		jb2.setBounds(200,300,80,30);
		jb2.setFont(Mytools.f1);
		c.add(jb2);

		BackImage bi=new BackImage();
		bi.setBounds(0,0,360,360);
		c.add(bi);		
		
		this.setUndecorated(true);//��ʹ�����¿�
		this.setSize(360, 360);
		this.setVisible(true);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-200, h/2-150);
	}
	

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1) {
			//ȡ��Ա���ź�����
			String u=this.jtf.getText().trim();
			String p=new String(this.jpw.getPassword());
			
			UserModel2 um=new UserModel2();
			String rs=um.checkUser(u, p);
			System.out.println("�û�  "+u+"  ����"+p+" ְλ "+rs);
				
				if(rs.equals("����")||rs.equals("����")||rs.equals("����Ա")) 
					{
						System.out.println("��������");
						new Windows2();
						this.dispose();
					}
			
		}else if(arg0.getSource()==jb2) {
			System.exit(0);
		}		
	}
	
	public class BackImage extends JPanel{
		Image im;
		
		public BackImage() {
			try {
				im=ImageIO.read(new File("image/userlogin.png"));
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		public void paintComponent(Graphics g){
			g.drawImage(im, 0, 0, 360, 360, this);
		}
	}

}
