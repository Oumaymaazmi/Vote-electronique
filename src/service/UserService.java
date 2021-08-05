package service;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.jws.soap.SOAPBinding.Use;

import bean.User;

public class UserService {
	private User user;

	public UserService(User user) {
		this.user = user;
	}

	public byte[] signature(String msg, PublicKey publecKeyServer) {

		try {
			byte[] messageBytes = msg.getBytes();
			// the digest method to generate a hash:
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] messageHash = md.digest(messageBytes);
			// Encrypting the Generated Hash
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.PRIVATE_KEY, user.getClePrivate());
			byte[] digitalSignature1 = cipher.doFinal(messageHash);
			// cript for the public key to the server
			Cipher cipher2 = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publecKeyServer);
			byte[] digitalSignature = cipher.doFinal(digitalSignature1);

			return digitalSignature1;
		} catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return null;

	}
	public void decripto(byte[] signature) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		//we create a Cipher instance
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.PUBLIC_KEY, user.getClePublic());
		byte[] decryptedMessageHash = cipher.doFinal(signature);
		//generate a new message hash from the received message:
		
		System.out.println(decryptedMessageHash.toString());
		
	}

}
