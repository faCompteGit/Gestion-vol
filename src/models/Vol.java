package models;

public class Vol {
	private String ref;
	private String date_Vol;
	private String heure_Depart;
	private String heure_Arrivee;
	private String destination;
	private String etat_Vol;
	private int prix;
	
	
	public Vol(String ref, String date_Vol, String heure_Depart, String heure_Arrivee, String destination,
			String etat_Vol, int prix) {
		super();
		this.ref = ref;
		this.date_Vol = date_Vol;
		this.heure_Depart = heure_Depart;
		this.heure_Arrivee = heure_Arrivee;
		this.destination = destination;
		this.etat_Vol = etat_Vol;
		this.prix = prix;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getDate_Vol() {
		return date_Vol;
	}


	public void setDate_Vol(String date_Vol) {
		this.date_Vol = date_Vol;
	}


	public String getHeure_Depart() {
		return heure_Depart;
	}


	public void setHeure_Depart(String heure_Depart) {
		this.heure_Depart = heure_Depart;
	}


	public String getHeure_Arrivee() {
		return heure_Arrivee;
	}


	public void setHeure_Arrivee(String heure_Arrivee) {
		this.heure_Arrivee = heure_Arrivee;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getEtat_Vol() {
		return etat_Vol;
	}


	public void setEtat_Vol(String etat_Vol) {
		this.etat_Vol = etat_Vol;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	
	
	

}
