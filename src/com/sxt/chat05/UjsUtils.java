package com.sxt.chat05;

import java.io.Closeable;
import java.io.IOException;

/*
 * ������
 * 
 */
public class UjsUtils {

/*
 * �ͷ���Դ
 * 
 */
	
	public static void close(Closeable...targets) {
		for (Closeable target : targets) {
			try {
				if (null!=target) {
					target.close();
//					try {
//						
//	        			if (null==dos) {
//	        				dos.close();
//						}
//					} catch (IOException e) {
//					
//						e.printStackTrace();
//					} 
//	        		try {
//	        			if (null==dis) {
//	        				dis.close();
//						}
//						
//					} catch (IOException e) {
//					
//						e.printStackTrace();
//					}
//	        		
//	         		 try {
//	         			if (null==client) {
//	         				client.close();
//						}
//					} catch (IOException e) {
//						
//						e.printStackTrace();
//					}
//	          		
//				}
			}
				}catch(Exception e) {
				//UjsUtils.close(dis,dos,client);
			}
		}
	}
}
	
