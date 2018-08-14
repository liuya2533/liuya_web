package test1;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.awt.*;

public class Demo1 extends JPanel implements Runnable,MouseListener
{
	int boardRows= 18;
	int boardCols= 18;
	int boardSize= 20;
	int chess[][]=new int[19][19];
	//坐标
	int x,y;
	//最大时间（秒）
	int maxTime=0;
	//时间限制
	int blackTime=0;
	int whiteTime=0;
	String message="黑方先手";
	//双方剩余的时间
	
	String blackmessage="无限制";
	String whitemessage="无限制";
	boolean isblack=true;
	boolean canplay=true;
	//添加按钮
	JButton jb1,jb2,jb3;
	Thread t=new Thread(this);
	
	public Demo1()
	{
		t.start();
		t.suspend();
		jb1=new JButton("重新开始");
		jb2=new JButton("设置");
		jb3=new JButton("退出");
		
		//jb1.setBounds(400, 110, 70, 30);
		
		//this.add(jb1);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		//BufferedImage b1 =new BufferedImage(495,475,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2=(Graphics2D)g;
		
		//画背景
		System.out.println("1");
		g2.drawImage(new ImageIcon("image/bg.jpg").getImage(), 0, 0, 495, 475,null);
		Color c = g2.getColor();
		g2.setColor(Color.black);
		//画行
		for(int i=0;i<=boardRows;i++)
		{
			g2.drawLine(10,50+boardSize*i, 10+boardSize*boardRows, 50+boardSize*i);
		}
		//画列
		for(int i=0;i<=boardCols;i++)
		{
			g2.drawLine(10+boardSize*i, 50, 10+boardSize*i, 50+boardSize*boardCols);
		}
		//画三三
		g2.fillOval(67, 107, 6, 6);
		g2.fillOval(67, 347, 6,6);
		g2.fillOval(307,107,6,6);
		g2.fillOval(307,347,6,6);
		
		//画附点
		g2.fillOval(67, 227, 6, 6);
		g2.fillOval(307, 227, 6,6);
		g2.fillOval(187,107,6,6);
		g2.fillOval(187,347,6,6);
		//画天元
		g2.fillOval(187,227,6,6);
		Font f=new Font("黑体",Font.BOLD,24);
		g2.setFont(f);
		g2.setFont(new Font("黑体",Font.BOLD,15));
		g2.setColor(Color.BLACK);
		g2.drawString("游戏信息："+message,130,40);
		g2.setFont(new Font("宋体",Font.ITALIC,15));
		g2.drawString("黑方时间: "+blackmessage, 25,445);
		g2.drawString("白方时间: "+whitemessage,245,445);
		//画按钮
		g2.setColor(Color.BLUE);
		g2.drawRect(400, 80, 70, 30);
		g2.setFont(new Font("黑体",Font.BOLD,15));
		g2.drawString("重新开始", 405, 100);
		//设置按钮
		g2.draw3DRect(400, 130, 70, 30, true);
		g2.setFont(new Font("黑体",Font.BOLD,15));
		g2.drawString("设置游戏", 405, 150);
		//游戏说明
		g2.draw3DRect(400, 180, 70, 30, true);
		g2.setFont(new Font("黑体",Font.BOLD,15));
		g2.drawString("关于游戏", 405, 200);
		//画认输
		g2.draw3DRect(400, 280, 70, 30, true);
		g2.setFont(new Font("黑体",Font.BOLD,15));
		g2.drawString("认输", 415, 300);
		//画退出
		g2.draw3DRect(400,330, 70, 30, true);
		g2.setFont(new Font("黑体",Font.BOLD,15));
		g2.drawString("退出", 415, 350);
		
		for(int i=0;i<=boardRows;i++)
		{
			for(int j=0;j<=boardCols;j++)
			{
				//System.out.println(chess[i][j]);
				if(chess[i][j]==1)
				{
					int tempx=i*20-10;
					int tempy=j*20+30;
					//画黑棋
					g2.setColor(Color.black);
					g2.fillOval(tempx+12, tempy+13, 15, 15);
				}
				else if(chess[i][j]==2)
				{
					int tempx=i*20-10;
					int tempy=j*20+30;
					g2.setColor(Color.white);
					g2.fillOval(tempx+12, tempy+13, 15, 15);
				}
			}
		}
		g2.setColor(c);
		//g2.drawImage(new ImageIcon("image/bg.jpg").getImage(), 0, 0, 495, 475,null);
				
	}
	public boolean JudgeChess(int x,int y)
	{
		//横向判断
		int a,b;
		boolean flag=false;
		int count=1;
		a=1;
		
		while(chess[x][y]==chess[x-a][y]&& chess[x-a][y]!=0)
		{
			count++;
			a++;
			if(count==5)
			{
			flag=true;
			break;
			}
		}
		if(flag==false)
		{
			a=1;
			while(chess[x+a][y]==chess[x][y] && chess[x+a][y]!=0)
			{
				count++;
				a++;
				if(count==5)
				{
				flag=true;
				break;
				}
			}
		}
		//竖向判断
		if(flag==false)
		{
			a=1;
			count=1;
			while(chess[x][y]==chess[x][y-a] && chess[x][y-a]!=0)
			{
				count++;
				a++;
				if(count==5)
				{
				flag=true;
				break;
				}
			}
			if(flag==false)
			{
				a=1;
				while(chess[x][y]==chess[x][y+a] && chess[x][y+a]!=0)
				{
					count++;
					a++;
					if(count==5)
					{
					flag=true;
					break;
					}
				}
			}
		}
		//方向\
		if(flag==false)
		{
			//斜上\
			a=1;
			count=1;
			while(chess[x][y]==chess[x-a][y-a]&&chess[x-a][y-a]!=0 && x-a>=0 && y-a>=0)
			{
				count++;
				a++;
				if(count==5)
				{
				flag=true;
				break;
				}
			}
			if(flag==false)
			{
				//斜下\
				a=1;
				while(chess[x][y]==chess[x+a][y+a]&&chess[x+a][y+a]!=0 && x+a<=boardSize*boardCols && y+a<=boardSize*boardCols)
				{
					count++;
					a++;
					if(count==5)
					{
					flag=true;
					break;
					}
				}
			}
		}
		//方向/
		if(flag==false)
		{
			//斜上/
			a=1;
			count=1;
			while(chess[x][y]==chess[x+a][y-a]&&chess[x+a][y-a]!=0 && x+a<=boardSize*boardCols && y-a>=0)
			{
				count++;
				a++;
				if(count==5)
				{
				flag=true;
				break;
				}
			}
			//斜下/
			if(flag==false)
			{
				a=1;
				while(chess[x][y]==chess[x-a][y+a]&&chess[x-a][y+a]!=0 && x-a>=0 && y+a<=boardSize*boardCols)
				{
					count++;
					a++;
					if(count==5)
					{
					flag=true;
					break;
					}
				}
			}
		}
		return flag;
	}
	public void run() {
		// TODO Auto-generated method stub
		if(maxTime>0)
		{
		while(true)
		{
			if(isblack)
			{
				blackTime--;
				if(blackTime==0)
				{
					JOptionPane.showMessageDialog(this, "黑方超时,游戏结束！");
				}
			}
			else
			{
				whiteTime--;
				if(whiteTime==0)
				{
					JOptionPane.showMessageDialog(this, "白方超时,游戏结束！");
				}
			}
			this.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		System.out.println("x:"+m.getX()+" "+"y:"+m.getY());
		this.x=m.getX();
		this.y=m.getY();
		if(10<=x && x<=(10+boardRows*boardSize) && y>=50 && y<=(50+boardCols*boardSize))
		{
			this.x=(x-10)/20;
			this.y=(y-50-20)/20;
			if(chess[x][y]==0)
			{
				
			if(isblack==true)
			{
				chess[x][y]=1;
				
				isblack=false;
				message="轮到白方";
			}
			//else if(isblack==false)
			else
			{
				chess[x][y]=2;
				isblack=true;
				message="轮到黑方";
			}
			}
			//System.out.println(chess[x][y]);
			if(JudgeChess(x,y)==true)
			{
				System.out.println(message);
				JOptionPane.showMessageDialog(this,"游戏结束"+(chess[x][y]==1?"黑方":"白方")+"获胜。");
			}
			this.repaint();
		}
		
		if(m.getX()>=400 && m.getX()<=470 && m.getY()>=80 && m.getY()<=110)
		{
			for(int i=0;i<19;i++)
			{
				for(int j=0;j<19;j++)
				{
					chess[i][j]=0;
				}
			}
			blackTime=maxTime;
			whiteTime=maxTime;
			if(maxTime>0)
			{
				blackmessage=maxTime/3600+":"+(maxTime/60-maxTime/3600*60+":"+(maxTime-maxTime/60*60));
				whitemessage=maxTime/3600+":"+(maxTime/60-maxTime/3600*60+":"+(maxTime-maxTime/60*60));
				t.resume();
			}
			else
			{
				blackmessage="无限制";
				whitemessage="无限制";
			}
			message="黑方先行";
			isblack=true;
			this.repaint();
		}
		if(m.getX()>=400 && m.getX()<=470 && m.getY()>=130 && m.getY()<=160)
		{
			String input=JOptionPane.showInputDialog("请输入游戏最大时间（单位分钟），如果输入0，表示没有时间限制");
			try
			{
				maxTime=Integer.parseInt(input)*60;
				if(maxTime<0)
				{
					JOptionPane.showMessageDialog(this,"不能输负数");
				}
				if(maxTime==0)
				{
					int result=JOptionPane.showConfirmDialog(this,"设置完成，是否开始新游戏？");
					if(result==0)
					{
						for(int i=0;i<19;i++)
						{
							for(int j=0;j<19;j++)
							{
								chess[i][j]=0;
							}
						}
						message="黑方先行";
						isblack=true;
						blackmessage="无限制";
						whitemessage="无限制";
						this.repaint();
					}
				}
				if(maxTime>0)
				{
					int result=JOptionPane.showConfirmDialog(this,"设置完成，是否开始新游戏？");
					if(result==0)
					{
						for(int i=0;i<19;i++)
						{
							for(int j=0;j<19;j++)
							{
								chess[i][j]=0;
							}
						}
						message="黑方先行";
						isblack=true;
						blackmessage=maxTime/3600+":"+(maxTime/60-maxTime/3600*60+":"+(maxTime-maxTime/60*60));
						whitemessage=maxTime/3600+":"+(maxTime/60-maxTime/3600*60+":"+(maxTime-maxTime/60*60));
						this.repaint();
				}
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "请正确输入信息");
		}
			
		}
		
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
	
}