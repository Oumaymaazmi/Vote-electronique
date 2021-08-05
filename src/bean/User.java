package bean;

import java.security.PrivateKey;
import java.security.PublicKey;

public class User {
	private PrivateKey clePrivate;
	private PublicKey clePublic;
	private String nom;
	private int nbrVote;
	
	public User(PrivateKey pv , PublicKey pu) {
		this.clePrivate=pv;
		this.clePublic= pu;
		// TODO Auto-generated constructor stub
	}
	
	
	public int getNbrVote() {
		return nbrVote;
	}
	public void setNbrVote(int nbrVote) {
		this.nbrVote = nbrVote;
	}
	public PrivateKey getClePrivate() {
		return clePrivate;
	}
	public void setClePrivate(PrivateKey clePrivate) {
		this.clePrivate = clePrivate;
	}
	public PublicKey getClePublic() {
		return clePublic;
	}
	public void setClePublic(PublicKey clePublic) {
		this.clePublic = clePublic;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	} 
	
	
}
