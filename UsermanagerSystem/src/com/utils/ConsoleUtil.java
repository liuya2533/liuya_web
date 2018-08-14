package com.utils;

import java.util.Scanner;

public class ConsoleUtil {

	public static int getOption(int low,int high){
		while(true){
			Scanner scan=new Scanner(System.in);
			System.out.println("请选择");
			try{
				int num=scan.nextInt();
				if(num<low || num> high){
					System.out.println("数值非法，重新选择");
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
			//System.out.println("请选择");
			String str=scan.nextLine();
			if(str !=null && str.trim()!=""){
				return str;
			}else{
				System.out.println("错误");
			}
		}
	}
	public static String getEmail(){
		while(true){
			Scanner scan=new Scanner(System.in);
			String email=scan.nextLine();
			/*
			 * 必须有@
			 * 不能有多个@和。
			 * @不能在.前面
			 * @不能开头，。不能结尾
			 */
			if(email.indexOf("@") ==-1|| email.indexOf(".")==-1){
				System.out.println("邮箱中必须有@和.");
			}else if(email.indexOf("@") != email.lastIndexOf("@") || email.indexOf(".")!=
					email.lastIndexOf(".")){
				System.out.println("邮箱中不能有多个@和.");
			}else if(email.startsWith("@")  || email.endsWith(".")){
				System.out.println("邮箱中不能@开头和.结尾");
			}else{
				return email;
			}
		}
	}
	
}
