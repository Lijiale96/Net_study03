package com.sxt.chat03;

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
			}
				}catch(Exception e) {
			
			}
		}
	}
}
	
