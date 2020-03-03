package com.sxt.chat033;

import java.io.Closeable;
import java.io.IOException;

/*
 * 工具类
 * 
 */
public class UjsUtils {

/*
 * 释放资源
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
	
