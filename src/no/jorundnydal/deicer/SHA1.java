package no.jorundnydal.deicer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
	
	private String hash;
	
	public String getHash() {
		return hash;
	}
	
	public SHA1(String key, String data) throws NoSuchAlgorithmException {
		hash = makeSHA1Hash(key, data);
	}
	
	private String makeSHA1Hash(String key, String data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.reset();
		byte[] buffer = key.getBytes();
		byte[] buffer2 = data.getBytes();
		md.update(buffer);
		md.update(buffer2);
		byte[] digest = md.digest();
		
		String hexStr = "";
		for (int i = 0; i < digest.length; i++) {
			hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
		}
		return hexStr;
	}
}
