package com.eboji.agent.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtil {
	private static final Random RANDOM = new Random();		// 用于GUID生成
	private static final Random RANDOMSEC = new Random();	// 用于GUID生成
	
	protected static synchronized long getGUID() {
		StringBuffer buf = new StringBuffer();
		
		long mills = System.currentTimeMillis() % 100000000000l;
		long seed = Math.abs(RANDOM.nextInt()) % 10000;
		long seed2 = Math.abs(RANDOMSEC.nextInt()) % 10000;
		while (seed2 == seed) {
			seed2 = Math.abs(RANDOMSEC.nextInt()) % 10000;
		}

		seed = seed > 9 ? seed > 99 ? (seed > 999 ? seed : seed * 10)
				: seed * 100 : seed > 0 ? seed * 10 : 9999;
		seed2 = seed2 % 100;
		seed2 = seed2 > 9 ? seed2 : seed2 > 0 ? seed2 * 10 : 99;

		buf.append(mills).append(seed).append(seed2);
		return Long.valueOf(buf.toString());
	}
	
	/**
	 * 
	 * @param length 表示生成字符串的长度
	 * @return
	 */
	public static String getRandomChars(int length) {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 			// 生成字符串从此序列中取
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 	// 生成字符串从此序列中取
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		int number = random.nextInt(base.length());
		sb.append(base.charAt(number));
		for (int i = 0; i < length - 1; i++) {
			int num = random.nextInt(str.length());
			sb.append(str.charAt(num));
		}
		return sb.toString();
	}
	
	public static String getRandomGUID() {
		return getRandomChars(4) + getGUID();
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String str = getRandomChars(4) + getGUID();
		System.out.println("产生" + str + "耗时:" + (System.currentTimeMillis() - start) + "ms");
		
		Set<String> sets = new HashSet<String>();
		int size = 10000000;
		for(int i = 0; i < size; i++) {
			sets.add(getRandomChars(4) + getGUID());
		}
		
		System.out.println("重复的串个数为:" + (size - sets.size()));
	}
}
