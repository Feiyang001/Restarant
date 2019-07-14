/*
 * 这是一个可以动态加载一个图片做背景的jpanel
 */

package com.tools;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;

public class ImagePanel extends JPanel {
   
	Image im;

	 public ImagePanel(Image im){
		 this.im=im;
		 int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		 int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		 this.setSize(w,h);
	 }
	 public void paintComponent(Graphics g) {
		 //每次都清屏
		 super.paintComponents(g);
		 g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
		 
	 }
}
