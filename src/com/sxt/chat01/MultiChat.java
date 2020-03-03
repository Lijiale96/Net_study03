package com.sxt.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ���������ң�������
 * Ŀ�꣺ʵ��һ���ͻ����������շ�������Ϣ
 * 
 */
public class MultiChat {
    public static void main(String[] args) throws IOException {
    	System.out.println("---Server----");
//    	* 1��ָ���˿�ʹ��ServerSocket����������
    	ServerSocket server = new ServerSocket(8888);
    	// * 2������ʽ�ȴ����� accept
    		Socket client = server.accept();
    		System.out.println("һ���ͻ��˽���������");
    		
    		DataInputStream dis = new DataInputStream(client.getInputStream());
    		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
    		
    		boolean isRunning = true;
    		while (isRunning) {
    	//3��������Ϣ
    		String msg = dis.readUTF();		
     //4��������Ϣ
    	
    		dos.writeUTF(msg);
    		//�ͷ���Դ
    		dos.flush();
    		}
    		 dos.close();
    		 dis.close();
    		 client.close();
	}
}
