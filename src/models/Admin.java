package models;

public class Admin {

	private String nom;
	private String pass;
	public Admin(String nom, String pass) {
		super();
		this.nom = nom;
		this.pass = pass;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
