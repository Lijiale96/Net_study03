package com.sxt.chat04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 在线聊天室：客户端
 * 目标：加入容器 实现群聊
 * 
 */

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---Client----");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String name = br.readLine();
		// 1、建立连接： 使用Socket创建客户端+服务器的地址和端口
		Socket client = new Socket("localhost",8888);
		//2、客户端发送消息	
		new Thread(new Send(client,br.readLine())).start();
		new Thread(new Receive(client)).start();
		
	}
}
