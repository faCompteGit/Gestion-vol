package models;

import java.util.Scanner;

public class Reservation {
	private int nbr_billet;
	private int client_id;
	private String mode_paiement;
	private String date_Reservation;
	private String vol_ref;
	
	public Reservation( int nbr_billet, int client_id, String mode_paiement, String date_Reservation,String vol_ref) {
		super();
		this.nbr_billet = nbr_billet;
		this.client_id = client_id;
		this.mode_paiement = mode_paiement;
		this.date_Reservation = date_Reservation;
		this.vol_ref = vol_ref;
	}
	
	
	public int getNbr_billet() {
		return nbr_billet;
	}
	
	public void setNbr_billet(int nbr_billet) {
		this.nbr_billet = nbr_billet;
	}
	
	public int getClient_id() {
		return client_id;
	}
	
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	
	public String getMode_paiement() {
		return mode_paiement;
	}
	
	public void setMode_paiement(String mode_paiement) {
		this.mode_paiement = mode_paiement;
	}
	
	public String getDate_Reservation() {
		return date_Reservation;
	}
	
	public void setDate_Reservation(String date_Reservation) {
		this.date_Reservation = date_Reservation;
	}
	
	public String getVol_ref() {
		return vol_ref;
	}
	
	public void setVol_ref(String vol_ref) {
		this.vol_ref = vol_ref;
	}
	
	
	
	

}
