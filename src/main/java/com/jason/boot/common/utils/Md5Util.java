package com.jason.boot.common.utils;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;
/**
 * MD5加密并Base64编码.
 * 使用加盐MD5，减少被穷举法破密的风险，使用固定的盐值，这样盐值不用存库
 * @author jason
 *
 */
public class Md5Util {
    //盐值
    private static final String SALT = "0f6543a5518e4170bd7bc66209b3a9f3";
    public static String encode(String s) {
	try {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] bytes = md.digest((s+SALT).getBytes("utf-8"));
	    String hexString = toHex(bytes);
	    return Base64.encodeBase64String(hexString.getBytes("UTF-8"));
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
    /**
     * 将字节数组转为16进制字符串
     * @param bytes
     * @return
     */
    private static String toHex(byte[] bytes) {
	final char[] hexDigits = "0123456789ABCDEF".toCharArray();
	StringBuilder ret = new StringBuilder(bytes.length * 2);
	for (int i = 0; i < bytes.length; i++) {
	    ret.append(hexDigits[(bytes[i] >> 4) & 0x0f]);
	    ret.append(hexDigits[bytes[i] & 0x0f]);
	}
	return ret.toString();
    }
}
