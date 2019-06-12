package com.fastone.test.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class AESUtil  {

	private static final String IV_STRING = "&jkUmaIhg@h!A!R4";
	private static final String ENCODING = "UTF-8";
	private static final String KEY = "c$DiZ8XU#o14KeA5tAM7CsRnr2JcW6Z9";
	public static AESUtil  me;

	private AESUtil() {
		//单例
	}

	//双重锁
	public static AESUtil getInstance() {
		if (me == null) {
			synchronized (AESUtil.class) {
				if (me == null) {
					me = new AESUtil();
				}
			}
		}
		return me;
	}

	/**
	 * 使用KeyGenerator双向加密，DES/AES，注意这里转化为字符串的时候是将2进制转为16进制格式的字符串，
	 * 不是直接转，因为会出错* @param res 加密的原文
	 *
	 * @param isEncode true表示加密； false表示解密
	 * @return
	 */
	public String keyGeneratorES(String content, boolean isEncode) {
		try {

			byte[] enCodeFormat = KEY.getBytes(ENCODING);
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			byte[] initParam = IV_STRING.getBytes(ENCODING);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
			// 指定加密的算法、工作模式和填充方式
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			if (isEncode) {
				byte[] byteContent = content.getBytes(ENCODING);
				cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
				byte[] encryptedBytes = cipher.doFinal(byteContent);
				// 同样对加密后数据进行 base64 编码
				String base64 = new Base64().encodeToString(encryptedBytes);
				//进行url编码 去掉= ? &
				return URLEncoder.encode(base64, ENCODING);
			} else {
				//URL解码
				content = URLDecoder.decode(content, ENCODING);
				// base64 解码
				byte[] encryptedBytes = Base64.decodeBase64(content);
				cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
				byte[] result = cipher.doFinal(encryptedBytes);
				return new String(result, ENCODING);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 使用AES加密算法经行加密（可逆）
	 *
	 * @param res 需要加密的明文信息
	 * @return 加密后的密文
	 */
	public String AESEncode(String res) {
		return keyGeneratorES(res, true);
	}

	/**
	 * 对使用AES加密算法的密文进行解密
	 *
	 * @param res 需要解密的密文
	 * @return 解密后的内容
	 */
	public String AESDecode(String res) {
		return keyGeneratorES(res, false);
	}

	public static void main(String[] args) {
		AESUtil instance = AESUtil.getInstance();
		System.out.println(instance.AESEncode("I am Jacky"));
	}

}
