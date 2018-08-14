package test1;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import sun.java2d.pipe.DrawImage;

import java.net.URL;
public class test extends JFrame{

	/**
	 * @param args
	 */
	Image img;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new test().setVisible(true);
	}

	public test()
	{
		//URL imgUrl=DrawImage.class.getResource("bg.jpg");
		//img=Toolkit.getDefaultToolkit().getImage(imgUrl);
		this.setSize(497,495);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new Mypanel());
	}
	class Mypanel extends JPanel implements MouseListener,KeyListener,Runnable
	{
		int boardRows= 18;
		int boardCols= 18;
		int boardSize= 20;
		//this.addMouseMotionLister(this);
		public void paint(Graphics g)
		{
			super.paint(g);
			Graphics2D g2=(Graphics2D)g;
			g2.drawImage(new ImageIcon("image/bg.jpg").getImage(), 0, 0, this);
			g2.setColor(Color.black);
			for(int i=0;i<=18;i++)
			{
				g2.drawLine(10,50+boardSize*i, 10+boardSize*boardRows, 50+boardSize*i);
			}
			for(int i=0;i<=boardSize;i++)
			{
				g2.drawLine(10+boardSize*i, 50, 10+boardSize*i, 50+boardSize*boardCols);
			}
		}
		//this.addMouseListener(new MouseListener() {
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("x:"+arg0.getX()+" "+"y:"+arg0.getY());
			
		}
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		//}
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getKeyCode()==KeyEvent.VK_W)
			{
				System.out.println("w");
			}
			
		}
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				this.repaint();
		}
	}
	}
}
