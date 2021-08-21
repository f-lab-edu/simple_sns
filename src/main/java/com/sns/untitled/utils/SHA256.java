package com.sns.untitled.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

	public String encrypt(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(md.digest());
		}catch (NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}

	public String bytesToHex(byte[] bytes){
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes){
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}
