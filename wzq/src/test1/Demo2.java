package test1;

import javax.swing.JFrame;

public class Demo2 extends JFrame{

	/**
	 * @param args
	 */
	Demo1 de=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo2 de2=new Demo2();
	}
	public Demo2()
	{
		this.setTitle("Îå×ÓÆå");
		this.setSize(510,510);
		de=new Demo1();
		this.add(de);
		this.addMouseListener(de);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
