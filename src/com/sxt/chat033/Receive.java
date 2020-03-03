package com.sxt.chat033;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import com.sxt.chat03.UjsUtils;

/*
 * ʹ�ö��̷߳�װ�����ն�
 * 1��������Ϣ
 * 2���ͷ���Դ
 * 3����дrun
 */
public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	public Receive(Socket client) {
		this.client=client;
		this.isRunning =true;
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			System.out.println("===2===");
		release();
		}
	}
	//������Ϣ
	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
		System.out.println("===4===");
			release();
		}
		return msg;
	}
	@Override
	public void run() {
		while (isRunning) {
		String msg =receive();
			if(!msg.equals("")) {
			System.out.println(msg);
			}
		}
	}
	
	//�ͷ���Դ
	private void release() {
		this.isRunning=false;
	UjsUtils.close(dis,client);
  }
}
