package com.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.tools.ImagePanel;
import com.tools.Mytools;

public class Windows2 extends JFrame implements ActionListener,MouseListener{
	
	Image titleImage,jp5_timebg,jp1_bg;
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5,jmm6;
	ImageIcon jmm1_icon1,jmm1_icon2,jmm1_icon3,jmm1_icon4,jmm1_icon5,jmm1_icon6;
	
	//工具栏
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	JPanel jp1,jp2,jp3,jp4,jp5;
	
	JLabel jp5_timelab;
	javax.swing.Timer t;//这个类可以定时的触发Action事件，可以完成
	
	ImagePanel jp1_imagePanel;
	JLabel jp1_lab1,jp1_lab2,jp1_lab3,jp1_lab4,jp1_lab5,jp1_lab6,jp1_lab7,jp1_lab8;
	
	CardLayout cl;
	JLabel jp2_lab1,jp2_lab2;
	JLabel jp3_lab1,jp3_lab2,jp3_lab3,jp3_lab4,jp3_lab5,jp3_lab6,jp3_lab7,jp3_lab8,jp3_lab9;
	
	JSplitPane jsp;
	Cursor cs;
	public static void main(String[] args) {
		Windows2 w=new Windows2();
	}

	//初始化菜单栏
	public void initMenu() {
		jmm1_icon1=new ImageIcon("image/5.jpg");
		jmm1_icon2=new ImageIcon("image/6.png");
		jmm1_icon3=new ImageIcon("image/7.png");
		jmm1_icon4=new ImageIcon("image/4.png");
		jmm1_icon5=new ImageIcon("image/2.png");
		
		jm1=new JMenu("系统管理");
		jm1.setFont(Mytools.f1);
		
		jmm1=new JMenuItem("切换用户",jmm1_icon1);
		jmm1.setFont(Mytools.f2);
		jmm2=new JMenuItem("切换到收款界面",jmm1_icon2);
		jmm2.setFont(Mytools.f2);
		jmm3=new JMenuItem("登录管理",jmm1_icon3);
		jmm3.setFont(Mytools.f2);
		jmm4=new JMenuItem("万年历",jmm1_icon4);
		jmm4.setFont(Mytools.f2);
		jmm5=new JMenuItem("退出",jmm1_icon5);
		jmm5.addActionListener(this);
		jmm5.setFont(Mytools.f2);
		
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		
		jm2=new JMenu("人事管理");
		jm2.setFont(Mytools.f1);
		jm3=new JMenu("菜单服务");
		jm3.setFont(Mytools.f1);
		jm4=new JMenu("报表统计");
		jm4.setFont(Mytools.f1);
		jm5=new JMenu("成本及库房");
		jm5.setFont(Mytools.f1);
		jm6=new JMenu("帮助");
		jm6.setFont(Mytools.f1);
		
		jmb=new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		
		this.setJMenuBar(jmb);
	}
	
	//初始化工具栏
	public void initToolbar() {
		jtb=new JToolBar();
		jtb.setFloatable(false);//不可以浮动
		jb1=new JButton(new ImageIcon("image/1.png"));
		jb2=new JButton(new ImageIcon("image/2.png"));
		jb3=new JButton(new ImageIcon("image/3.png"));
		jb4=new JButton(new ImageIcon("image/4.png"));
		jb5=new JButton(new ImageIcon("image/5.png"));
		jb6=new JButton(new ImageIcon("image/6.png"));
		jb7=new JButton(new ImageIcon("image/7.png"));
		jb8=new JButton(new ImageIcon("image/8.png"));
		jb9=new JButton(new ImageIcon("image/9.png"));
		jb10=new JButton(new ImageIcon("image/10.png"));
		
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
		
	}
	//初始化中间的panel
	public void initallPanel() {
		//处理jp1
		jp1=new JPanel(new BorderLayout());		
		try {
			jp1_bg=ImageIO.read(new File("image/12.jpg"));
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		jp1_imagePanel=new ImagePanel(jp1_bg);
		jp1_imagePanel.setLayout(new GridLayout(8, 1));
		
	    cs=new Cursor(Cursor.HAND_CURSOR);
	    
		jp1_lab8=new JLabel(new ImageIcon("image/11.png"));
		jp1_imagePanel.add(jp1_lab8);
		jp1_lab1=new JLabel("人事管理",new ImageIcon("image/1.png"),0);
		jp1_lab1.setFont(Mytools.f3);
		jp1_lab1.setEnabled(false);
		jp1_lab1.setCursor(cs);
		jp1_lab1.addMouseListener(this);
		jp1_imagePanel.add(jp1_lab1);
		jp1_lab2=new JLabel("登录管理",new ImageIcon("image/2.png"),0);
		jp1_lab2.setFont(Mytools.f3);
		jp1_lab2.setEnabled(false);
		jp1_lab2.setCursor(cs);
		jp1_lab2.addMouseListener(this);
		jp1_imagePanel.add(jp1_lab2);
		jp1_lab3=new JLabel("菜谱价格",new ImageIcon("image/3.png"),0);
		jp1_lab3.setFont(Mytools.f3);
		jp1_lab3.setEnabled(false);
		jp1_lab3.setCursor(cs);
		jp1_lab3.addMouseListener(this);
		jp1_imagePanel.add(jp1_lab3);
		jp1_lab4=new JLabel("报表统计",new ImageIcon("image/4.png"),0);
		jp1_lab4.setFont(Mytools.f3);
		jp1_lab4.setEnabled(false);
		jp1_lab4.setCursor(cs);
		jp1_lab4.addMouseListener(this);
		jp1_imagePanel.add(jp1_lab4);
		jp1_lab5=new JLabel("成本库房",new ImageIcon("image/5.png"),0);
		jp1_lab5.setFont(Mytools.f3);
		jp1_lab5.setEnabled(false);
		jp1_lab5.setCursor(cs);
		jp1_lab5.addMouseListener(this);
		jp1_imagePanel.add(jp1_lab5);
		jp1_lab6=new JLabel("系统设置",new ImageIcon("image/6.png"),0);
		jp1_lab6.setFont(Mytools.f3);
		jp1_lab6.setEnabled(false);
		jp1_lab6.setCursor(cs);
		jp1_lab6.addMouseListener(this);
		jp1_imagePanel.add(jp1_lab6);
		jp1_lab7=new JLabel("动画设置",new ImageIcon("image/7.png"),0);
		jp1_lab7.setFont(Mytools.f3);
		jp1_lab7.setEnabled(false);
		jp1_lab7.setCursor(cs);
		jp1_lab7.addMouseListener(this);
		jp1_imagePanel.add(jp1_lab7);
		
		jp1.add(jp1_imagePanel);
		
		//处理jp2,jp3,jp4
		jp4=new JPanel(new BorderLayout());
		cl=new CardLayout();
		jp2=new JPanel(cl);
		jp2_lab1=new JLabel(new ImageIcon("image/001.png"));
		jp2_lab2=new JLabel(new ImageIcon("image/002.png"));
		jp2.add(jp2_lab1,"0");
		jp2.add(jp2_lab2,"1");
		
		jp3=new JPanel(cl);
		EmpInfo2 em=new EmpInfo2();
		//jp3_lab1=new JLabel(new ImageIcon("image/j1.jpg"));
		jp3.add(em,"0");
		jp3_lab2=new JLabel(new ImageIcon("image/j2.jpg"));
		jp3.add(jp3_lab2,"1");
		jp3_lab3=new JLabel(new ImageIcon("image/j3.jpg"));
		jp3.add(jp3_lab3,"2");
		jp3_lab4=new JLabel(new ImageIcon("image/j4.jpg"));
		jp3.add(jp3_lab4,"3");
		jp3_lab5=new JLabel(new ImageIcon("image/j5.jpg"));
		jp3.add(jp3_lab5,"4");
		jp3_lab6=new JLabel(new ImageIcon("image/j6.jpg"));
		jp3.add(jp3_lab6,"5");
		jp3_lab7=new JLabel(new ImageIcon("image/j8.jpg"));
		jp3.add(jp3_lab7,"6");
		
		
		
		
		
		jp4.add(jp2,"West");
		jp4.add(jp3,"Center");
		
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp4);
		jsp.setDividerLocation(120);
		jsp.setDividerSize(0);
	}
	//初始化状态栏
	public void initPanel5() {
		jp5=new JPanel(new BorderLayout());
		t=new Timer(1000, this);
		t.start();
	    jp5_timelab=new JLabel(Calendar.getInstance().getTime().toString()+"    ");
	    try {
			jp5_timebg=ImageIO.read(new File("image/time.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    ImagePanel imt=new ImagePanel(jp5_timebg);
	    imt.setLayout(new BorderLayout());
	    imt.add(jp5_timelab,"East");
	    
	    jp5.add(imt);
	        
	}
	
	public Windows2() {
		
		try {
			System.out.println("ok2");
			titleImage=ImageIO.read(new File("image/bh.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//调用初始化函数 
		this.initMenu();
		this.initToolbar();
		this.initallPanel();
		this.initPanel5();
		
		Container  ct=this.getContentPane();
		ct.add(jtb,"North");
		ct.add(jsp,"Center");
		ct.add(jp5,"South");
		
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(titleImage);
		this.setSize(w,h-40);
		this.setVisible(true);
		this.setTitle("餐饮系统");
	}

	public void actionPerformed(ActionEvent arg0) {
		
		this.jp5_timelab.setText("当前时间："+Calendar.getInstance().getTime().toString()+"   ");
		
		if(arg0.getSource()==jmm5) {
		    System.exit(0);
		}
	
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
			if(arg0.getSource()==jp1_lab1) {
				cl.show(jp3, "0");
			}else if(arg0.getSource()==jp1_lab2) {
				cl.show(jp3, "1");
			}else if(arg0.getSource()==jp1_lab3) {
				cl.show(jp3, "2");
			}else if(arg0.getSource()==jp1_lab4) {
				cl.show(jp3, "3");
			}else if(arg0.getSource()==jp1_lab5) {
				cl.show(jp3, "4");
			}else if(arg0.getSource()==jp1_lab6) {
				cl.show(jp3, "5");
			}else if(arg0.getSource()==jp1_lab7) {
				cl.show(jp3, "6");
			}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource()==jp1_lab1) {
			jp1_lab1.setEnabled(true);
		}else if(arg0.getSource()==jp1_lab2) {
			jp1_lab2.setEnabled(true);
		}else if(arg0.getSource()==jp1_lab3) {
			jp1_lab3.setEnabled(true);
		}else if(arg0.getSource()==jp1_lab4) {
			jp1_lab4.setEnabled(true);
		}else if(arg0.getSource()==jp1_lab5) {
			jp1_lab5.setEnabled(true);
		}else if(arg0.getSource()==jp1_lab6) {
			jp1_lab6.setEnabled(true);
		}else if(arg0.getSource()==jp1_lab7) {
			jp1_lab7.setEnabled(true);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource()==jp1_lab1) {
			jp1_lab1.setEnabled(false);
		}else if(arg0.getSource()==jp1_lab2) {
			jp1_lab2.setEnabled(false);
		}else if(arg0.getSource()==jp1_lab3) {
			jp1_lab3.setEnabled(false);
		}else if(arg0.getSource()==jp1_lab4) {
			jp1_lab4.setEnabled(false);
		}else if(arg0.getSource()==jp1_lab5) {
			jp1_lab5.setEnabled(false);
		}else if(arg0.getSource()==jp1_lab6) {
			jp1_lab6.setEnabled(false);
		}else if(arg0.getSource()==jp1_lab7) {
			jp1_lab7.setEnabled(false);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
