package com.sxt.chat033;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sxt.chat03.UjsUtils;

/*
 * 在线聊天室：服务器
 * 目标：使用多线程实现多个客户可以正常收发多条消息
 * 问题：
1、代码不好维护
2、读写没有分开 必须先写后读
 * 
 */
public class TMultiChat {
    public static void main(String[] args) throws IOException {
    	System.out.println("---Server----");
//    	* 1、指定端口使用ServerSocket创建服务器
    	ServerSocket server = new ServerSocket(8888);
    	// * 2、阻塞式等待连接 accept	
    	while (true) {
    		Socket client = server.accept();
    		System.out.println("一个客户端建立了连接");
    		new Thread(new Channel(client)).start();
    	}
		}
    
    static class Channel implements Runnable{
    	private DataInputStream dis;
    	private DataOutputStream dos;
    	private Socket client;
    	private boolean isRunning;
    	public Channel(Socket client){
    		this.client=client;
    		try {
    			dis = new DataInputStream(client.getInputStream());
			    dos = new DataOutputStream(client.getOutputStream());
				isRunning = true;
    		}catch(IOException e){
    			System.out.println("---1---");
    			release();
    		}
    	}
    	//接收消息
    	private String receive() {
    		String msg = " ";
    		try {
				msg = dis.readUTF();
			}catch (IOException e) {
		      System.out.println("---2---");
			  release();
			}
    		return msg;
    	}
    	//发送消息
    	private void send(String msg) {
    		 try {
    				dos.writeUTF(msg);
    				dos.flush();
    			} catch (IOException e) {
    				System.out.println("---3---");
    				release();
    			}
    	}
    	//释放资源
    	private void release() {
    		this.isRunning=false;
    	UjsUtils.close(dis,dos,client);
    	}
		@Override
		public void run() {
			while (isRunning) {
				String msg = receive();
				if (!msg.equals(" ")) {
					send(msg);
				}
			}
		}
    }
}

