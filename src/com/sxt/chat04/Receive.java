package com.sxt.chat04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * ʹ�ö��̷߳�װ�����ն�
 * 1��������Ϣ
 * 2���ӿ���̨��ȡ��Ϣ
 * 3���ͷ���Դ
 * 4����дrun
 */
public class Receive implements Runnable {

	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	public Receive(Socket client) {
		this.client=client;
		this.isRunning =true;
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			System.out.println("=====2======");
		release();
		}
	}
	//������Ϣ
	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
		System.out.println("===4======");
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
