package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import bean.User;
import service.UserService;

public class ApplicationClient {
	public static void main(String[] args)
			throws NotBoundException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, CertificateException, IOException, KeyStoreException, UnrecoverableEntryException {
		// ServiceVote stub= (ServiceVote) Naming.lookup("rmi://localhost:1011/SI");
		
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		keyStore.load(null);
		Certificate certificate = keyStore.getCertificate("receiverKeyPair");
		PublicKey publicKey1 = certificate.getPublicKey();
		PrivateKey privateKey = 
				  (PrivateKey) keyStore.getEntry(null, null);

		User user = new User(privateKey, publicKey1);
		UserService userService = new UserService(user);
		byte[] sug = userService.signature("oumayma", publicKey1);
		userService.decripto(sug);
	}

}
