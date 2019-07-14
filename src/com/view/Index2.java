package com.view;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;

public class Index2 extends JWindow implements Runnable{
	paint  p;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index2 i=new Index2();
		Thread t=new Thread(i);
		t.start();
	}
	public Index2() {
		
		p=new paint();
		this.add(p);
		
		this.setSize(400, 250);
		this.setVisible(true);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-200, h/2-150);
		
		
	}
	//闪屏类
	class paint extends JPanel implements Runnable
	{
	 
	    Thread t;
	    int x = 10;
	    int i = 0, j = 40, u = 10;
	    String gg[] = { "系", "统", "正", "在", "加", "载", "请", "稍", "候" };
	    int k = 0, tt = 0;
	    String shi[] = { "勒", "布", "朗", "詹", "姆", "斯", "哼", "哼", "哈", "哈", "下", "美", "味", "招", "八", "方", "贵", "客", "结", "四",
	            "海", "良", "朋", "|", "1", "2", "3","4","5","6" };
	    Font f = new Font("隶书", Font.PLAIN, 18);
	    
	    boolean ifok = true;
	    int width = 180;
	    int height = 0;
	    int dian = 0;
	 
	    paint()
	    {
	        t = new Thread(this);
	        t.start();
	    }
	 
	    public void run()
	    {
	        while (true)
	        {
	 
	            if (x <= 380)        repaint();
	 
	            try {
	                Thread.sleep(70);
	                i++;
	                j = j - 6;
	                u = u + 10;
	 
	                if (tt == 3)    width = width - 20;
	 
	                if (i == 4)
	                {
	 
	                    tt++;
	                    if (ifok && x > 120 + k * 20)    k++;
	                    if (k >= gg.length - 1)        ifok = false;
	                    x = x + 10;
	                    i = 0;
	                    j = 40;
	                    u = 10;
	                    dian++;
	                    if (dian > 3)    dian = 0;
	                }
	 
	            } catch (InterruptedException e)
	 
	            {
	                System.out.println("线程中断");
	            }
	        }
	    }
	 
	    public void paintComponent(Graphics g)
	    {
	        Image image;
	        image=Toolkit.getDefaultToolkit().getImage("image/bj.JPG");
	        g.drawImage(image, 0, 0, this.getWidth(), 200,this);
	 
	        int r=(int)(Math.random()*255);
	        int b=(int)(Math.random()*255);
	        int y=(int)(Math.random()*255);
	 
	        g.setColor(new Color(250,250,250));
	        g.fillRect(x, 210, 390-x, 30);
	        g.setColor(new Color(250,250,250));
	        if(i>1) g.fillRect(x,225-(j+20)/2,10,j+20);
	        if(j>25) g.setColor(new Color(r,b,y));
	        else g.setColor(new Color(123,194,252));
	        g.fillRect(x, 235-j/2,10, j);
	        g.setColor(new Color(123,194,252));
	        g.drawRect(10, 222, 380, 42);
	 
	        if(x<120)
	        {
	            for(int l=0;l<gg.length;l++)
	            {
	                g.setColor(new Color(0,0,0));
	                g.drawString(gg[l],120+l*20,242);
	            }
	 
	            for(int l=0;l<dian;l++)
	            {
	                g.setColor(new Color(0,0,0));
	                g.drawString("*",300+l*10,247);
	            }
	            g.drawString("*",300+10*dian, 247);
	            }
	            else
	            {
	                g.setColor(new Color(23,23,230));
	                g.drawString(gg[k],120+k*20,242);
	                
	                for(int l=k+1;l<gg.length;l++)
	                {
	                    g.setColor(new Color(0,0,0));
	                    g.drawString(gg[l],120+l*20,242);
	                }
	                if(x>300+dian*10) g.setColor(new Color(23,23,230));
	                for(int l=0;l<dian;l++)
	                {
	                    g.drawString("*",300+l*10,247);
	                }
	                g.drawString("*",300+10*dian,247);
	                }
	 
	                //------------逐字写诗
	                if(tt<3)
	                {
	                    for(int rr=0;rr<=tt;rr++)
	                    {
	                        g.setColor(new Color(r,b,y));
	                        g.drawString(shi[rr],180,60+rr*20);
	                    }
	                    g.drawString(shi[tt], 180, 60+tt*20);
	                }
	 
	                if(tt>=3&&tt<7)
	                {
	                    g.setColor(new Color(230,0,0));
	                    for(int rr=0;rr<3;rr++) g.drawString(shi[rr],180,60+rr*20);
	                    g.setColor(new Color(r,b,y));
	                    if(tt<8) for(int rr=3;rr<=tt;rr++) g.drawString(shi[rr],150,rr*20-20);
	                    if(tt>=7){ for(int rr=3;rr<8;rr++) g.drawString(shi[rr],150,rr*20-20);}
	                }
	 
	                if(tt>=7&&tt<13)
	                {
	                    g.setColor(new Color(230,0,0));
	                    for(int rr=0;rr<3;rr++) g.drawString(shi[rr],180,60+rr*20);
	                    for(int rr=3;rr<=7;rr++) g.drawString(shi[rr],150,rr*20-20);
	                    g.setColor(new Color(r,b,y));
	                    if(tt<13) for(int rr=8;rr<=tt;rr++) g.drawString(shi[rr],120, rr*20-120);
	                    if(tt>=13) {for(int rr=8;rr<13;rr++) g.drawString(shi[rr],120, rr*20-120);}
	                }
	 
	                if(tt>=13&&tt<18)
	                {
	                    g.setColor(new Color(230,0,0));
	                    for(int rr=0;rr<3;rr++) g.drawString(shi[rr],180,60+rr*20);
	                    for(int rr=3;rr<=7;rr++) g.drawString(shi[rr],150,rr*20-20);
	                    for(int rr=8;rr<13;rr++) g.drawString(shi[rr],120,rr*20-120);
	                    g.setColor(new Color(r,b,y));
	                    if(tt<18) for(int rr=13;rr<=tt;rr++) g.drawString(shi[rr],90, rr*20-220);
	                    if(tt>=18) {for(int rr=13;rr<18;rr++) g.drawString(shi[rr],90, rr*20-220);}
	                }
	 
	                if(tt>=18&&tt<23)
	                {
	                    g.setColor(new Color(230,0,0));
	                    for(int rr=0;rr<3;rr++) g.drawString(shi[rr],180,60+rr*20);
	                    for(int rr=3;rr<=7;rr++) g.drawString(shi[rr],150,rr*20-20);
	                    for(int rr=8;rr<13;rr++) g.drawString(shi[rr],120,rr*20-120);
	                    for(int rr=13;rr<18;rr++) g.drawString(shi[rr],90,rr*20-220);
	                    g.setColor(new Color(r,b,y));
	                    if(tt<23) for(int rr=18;rr<=tt;rr++) g.drawString(shi[rr],60, rr*20-320);
	                    if(tt>=23) {for(int rr=18;rr<23;rr++) g.drawString(shi[rr],60, rr*20-320);}
	                }
	 
	                if(tt>=23&&tt<30)
	                {
	                    g.setColor(new Color(230,0,0));
	                    for(int rr=0;rr<3;rr++) g.drawString(shi[rr],180,60+rr*20);
	                    for(int rr=3;rr<=7;rr++) g.drawString(shi[rr],150,rr*20-20);
	                    for(int rr=8;rr<13;rr++) g.drawString(shi[rr],120,rr*20-120);
	                    for(int rr=13;rr<18;rr++) g.drawString(shi[rr],90,rr*20-220);
	                    for(int rr=18;rr<23;rr++) g.drawString(shi[rr],60,rr*20-320);
	                    g.setColor(new Color(r,b,y));
	                    if(tt<30) for(int rr=23;rr<=tt;rr++) g.drawString(shi[rr],30, rr*20-400);
	                    if(tt>=30) {tt=0;for(int rr=23;rr<30;rr++) g.drawString(shi[rr],30, rr*20-400);}
	                }
	 
	                if(tt>=30)
	                {
	                    g.setColor(new Color(230,0,0));
	                    for(int rr=0;rr<3;rr++) g.drawString(shi[rr],180,60+rr*20);
	                    for(int rr=3;rr<=7;rr++) g.drawString(shi[rr],150,rr*20-20);
	                    for(int rr=8;rr<13;rr++) g.drawString(shi[rr],120,rr*20-120);
	                    for(int rr=13;rr<18;rr++) g.drawString(shi[rr],90,rr*20-220);
	                    for(int rr=18;rr<23;rr++) g.drawString(shi[rr],60,rr*20-320);
	                    for(int rr=23;rr<30;rr++) g.drawString(shi[rr],30,rr*20-400);
	                }
	        }
	}
	 
	@Override
	public void run() {
		while(true) {
			//等待闪屏效果结束后再跳转到登录界面
			
			try {
				Thread.sleep(30*500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("闪屏结束");
			 Userlogin2 us=new Userlogin2();
			 this.dispose();//
			 break;//退出线程
		}
		
	}

}
