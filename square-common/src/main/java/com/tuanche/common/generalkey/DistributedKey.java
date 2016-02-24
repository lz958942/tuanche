package com.tuanche.common.generalkey;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DistributedKey  implements Serializable {
	
	private static final long serialVersionUID = -7702062003187076760L;

	private static ConcurrentMap<String,String> map = new ConcurrentHashMap<String, String>() ;
	
	private static Random rand = new Random();
	
	private static Object obj = new Object();
	
	private static long timeGen() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 
	 * 生成八位随机数
	 * @return
	 */
	private static int getRandomNum(){
		return  rand.nextInt(89999999)+10000000;
	}
	
	
	/**
	 * 
	 * 获取本机IP
	 * @return
	 */
	private static  String getIp(){
		if(map.get("IP") == null){
			synchronized (obj) {
				try {
					InetAddress addr = InetAddress.getLocalHost();
					String localip=addr.getHostAddress();
					localip = localip.replaceAll("\\.","");
					map.put("IP", localip);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return map.get("IP");
	}
	
	
	/**
	 * 手机号+ip地址+时间生成主键
	 * @param phone
	 * @return
	 */
	public static String makePhoneKey(String phone) {
		String data = phone+ timeGen() / 60 / 1000;
		return data;
	}
	
	/**
	 * 手机号+时间生成主键
	 * @param phone
	 * @return
	 */
	public static String makeIPPhoneKey(String phone) {
		String data =   getIp() + phone + timeGen() / 60 / 1000;
		return data;
	}
	
	
	
	/**
	 * 8位随机数+时间生成主键
	 * @param phone
	 * @return
	 */
	public static String makeRandomKey() {
		String data = "" + getRandomNum()+ timeGen();
		return data;
	}
	
	
	/**
	 * ip地址+8位随机数+时间生成主键
	 * @param phone
	 * @return
	 */
	public static String makeRandomIPKey() {
		String data =   getIp() + getRandomNum() + timeGen();
		return data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistributedKey distributedKey = new DistributedKey();
		System.out.println(distributedKey.makeIPPhoneKey("13211112222"));
		System.out.println(distributedKey.makePhoneKey("13211112222"));
		System.out.println(distributedKey.makeRandomIPKey());
		System.out.println(distributedKey.makeRandomKey());
	}
	
}
