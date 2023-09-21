package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import controllers.GestionVol;
import models.Admin;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class jframeconnexion {

	JFrame frameConnexion;
	private JTextField username;
	private JPasswordField pass;
	JLabel erreur;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeconnexion window = new jframeconnexion();
					window.frameConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframeconnexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameConnexion = new JFrame();
		frameConnexion.setBounds(100, 100, 450, 300);
		frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameConnexion.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setBounds(180, 11, 100, 14);
		frameConnexion.getContentPane().add(lblNewLabel);
		
		JLabel lblusername = new JLabel("Nom d'utilisateur");
		lblusername.setBounds(69, 51, 100, 14);
		frameConnexion.getContentPane().add(lblusername);
		
		JLabel lblpass = new JLabel("Mot de passe");
		lblpass.setBounds(69, 103, 100, 14);
		frameConnexion.getContentPane().add(lblpass);
		
		JButton connexion = new JButton("Se connecter");
		connexion.setFont(new Font("Tahoma", Font.BOLD, 11));
		connexion.setBackground(Color.BLUE);
		connexion.setForeground(Color.WHITE);
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Admin adm =new Admin(username.getText(),pass.getText());
				 ArrayList<Admin> admli = new ArrayList<Admin>();
				 GestionVol gsv =new GestionVol();
				 
				 if(username.getText().length()<=0 || pass.getText().length()<=0) {
					 erreur.setText("Veuillez remplir tous les champs");
					 erreur.setForeground(Color.red);
				 }
				 else {
					 admli = gsv.seConnecter(adm);
					 if(admli == null) {
						 //System.out.println("Aucun compte");
						 erreur.setText("Nom d'utilisateur incorrecte");
						 erreur.setForeground(Color.red);
					 }
					 else {
				 
				 
					 for (int i=0;i<=admli.size();i++) {
						 if(admli.get(i).getNom().equals(adm.getNom()) && admli.get(i).getPass().equals(adm.getPass())) {
							 jframemenu j = new jframemenu();
							 j.framemenu.setVisible(true);
							 j.nom_admin.setText(admli.get(i).getNom());
							 frameConnexion.dispose(); 
						 }
						 else if(!admli.get(i).getPass().equals(adm.getPass())) {
							 erreur.setText("Mot de passe incorrect");
							 erreur.setForeground(Color.red);
						 }
				 
					 }}}}});
		
		
		connexion.setBounds(169, 150, 116, 23);
		frameConnexion.getContentPane().add(connexion);
		
		username = new JTextField();
		username.setForeground(Color.BLUE);
		username.setBounds(180, 48, 100, 20);
		frameConnexion.getContentPane().add(username);
		username.setColumns(10);
		
		pass = new JPasswordField();
		pass.setForeground(Color.BLUE);
		pass.setBounds(180, 100, 100, 20);
		frameConnexion.getContentPane().add(pass);
		
		erreur = new JLabel("");
		erreur.setForeground(Color.RED);
		erreur.setBounds(121, 194, 201, 14);
		frameConnexion.getContentPane().add(erreur);
	}
	
		
	
}
