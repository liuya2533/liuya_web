package com.utils;

import java.util.Scanner;

public class ConsoleUtil {

	public static int getOption(int low,int high){
		while(true){
			Scanner scan=new Scanner(System.in);
			System.out.println("��ѡ��");
			try{
				int num=scan.nextInt();
				if(num<low || num> high){
					System.out.println("��ֵ�Ƿ�������ѡ��");
				}else{
					return num;
				}
			}catch(Exception e){
				
			}
		}
	}
	public static String getString(){
		while(true){
			Scanner scan=new Scanner(System.in);
			//System.out.println("��ѡ��");
			String str=scan.nextLine();
			if(str !=null && str.trim()!=""){
				return str;
			}else{
				System.out.println("����");
			}
		}
	}
	public static String getEmail(){
		while(true){
			Scanner scan=new Scanner(System.in);
			String email=scan.nextLine();
			/*
			 * ������@
			 * �����ж��@�͡�
			 * @������.ǰ��
			 * @���ܿ�ͷ�������ܽ�β
			 */
			if(email.indexOf("@") ==-1|| email.indexOf(".")==-1){
				System.out.println("�����б�����@��.");
			}else if(email.indexOf("@") != email.lastIndexOf("@") || email.indexOf(".")!=
					email.lastIndexOf(".")){
				System.out.println("�����в����ж��@��.");
			}else if(email.startsWith("@")  || email.endsWith(".")){
				System.out.println("�����в���@��ͷ��.��β");
			}else{
				return email;
			}
		}
	}
	
}
