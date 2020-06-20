package br.com.jogo.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Criptografia {
	private static final String KEY = "Bar12345Bar12345";

	public static String criptografar(String valor) {
		byte[] encrypted = null;
		try {
			Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			encrypted = cipher.doFinal(valor.getBytes());
		} catch (Exception erro) {
			erro.printStackTrace();
		}
		return new String(encrypted);

	}

	public static String descriptografar(String valor) {
		String decrypted = null;
		try {
			Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			decrypted = new String(cipher.doFinal(valor.getBytes()));
		} catch (Exception erro) {
			erro.printStackTrace();
		}
		return decrypted;
	}
}