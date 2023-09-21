package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.GestionVol;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import models.Client;
import models.Vol;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class jrameRechercheClient {

	 JFrame frameRechClient;
	private JTextField numClient;
	JTextField nom;
	JTextField prenom;
	JLabel erreur ;
	private JButton btnNewButton;
	JLabel admin;
	JButton modif;
	JButton btnRechercher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jrameRechercheClient window = new jrameRechercheClient();
					window.frameRechClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jrameRechercheClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRechClient = new JFrame();
		frameRechClient.setBounds(100, 100, 800, 400);
		frameRechClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRechClient.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rechercher un  client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(267, 11, 203, 14);
		frameRechClient.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro du client");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(141, 78, 131, 14);
		frameRechClient.getContentPane().add(lblNewLabel_1);
		
		numClient = new JTextField();
		numClient.setForeground(Color.BLUE);
		numClient.setBounds(312, 78, 110, 20);
		frameRechClient.getContentPane().add(numClient);
		numClient.setColumns(10);
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setBackground(Color.BLUE);
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Client> clList = new ArrayList<Client>();
				GestionVol gsv =new GestionVol();
				System.out.println(numClient.getText().length());
				Boolean b = gsv.isNumeric(numClient.getText()); 
				 if (numClient.getText().length()<=0) {
					 erreur.setText("Entrer le néro du client");
						erreur.setForeground(Color.red);
				 }
				 else if(b==false) {
					 erreur.setText("le numéro doit etre un entier");
						erreur.setForeground(Color.red);
				 }
				 
				try {
					int a = Integer.parseInt(numClient.getText());
					clList = gsv.RechercherClient(a); if(b==true) {
						 if(clList.size()==0) {
							 //System.out.println(b);
							 erreur.setText("Aucun client pour ce numéro");
								erreur.setForeground(Color.orange);
						 }
						 else {
						 
						 for (int i=0;i<=clList.size();i++) {
							numClient.setEnabled(false);
							nom.setVisible(true);
							prenom.setVisible(true);
							btnRechercher.setEnabled(false);
							nom.setText(clList.get(i).getNom());
							prenom.setText(clList.get(i).getPrenom());
							erreur.setText("");
						
						 }
					 }}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRechercher.setBounds(492, 77, 131, 23);
		frameRechClient.getContentPane().add(btnRechercher);
		
		JLabel lblNewLabel_2 = new JLabel("Nom du client :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(162, 179, 124, 14);
		frameRechClient.getContentPane().add(lblNewLabel_2);
		
		nom = new JTextField();
		nom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
			}
		});
		nom.setForeground(Color.BLUE);
		nom.setFont(new Font("Tahoma", Font.ITALIC, 15));
		nom.setBounds(312, 179, 110, 17);
		nom.setVisible(false);
		frameRechClient.getContentPane().add(nom);
		
		JLabel lblNewLabel_3 = new JLabel("Prénom du client :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(162, 268, 144, 14);
		frameRechClient.getContentPane().add(lblNewLabel_3);
		
		prenom = new JTextField();
		prenom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
			}
		});
		prenom.setForeground(Color.BLUE);
		prenom.setFont(new Font("Tahoma", Font.ITALIC, 15));
		prenom.setBounds(316, 268, 110, 17);
		prenom.setVisible(false);
		frameRechClient.getContentPane().add(prenom);
		
		erreur = new JLabel("");
		erreur.setForeground(Color.RED);
		erreur.setBounds(415, 313, 244, 14);
		frameRechClient.getContentPane().add(erreur);
		
		btnNewButton = new JButton("Accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframemenu j = new jframemenu();
				j.framemenu.setVisible(true);
				j.nom_admin.setText(admin.getText());
				frameRechClient.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(0, 0, 89, 23);
		frameRechClient.getContentPane().add(btnNewButton);
		
		admin = new JLabel("");
		admin.setBounds(96, 5, 46, 14);
		admin.setVisible(false);
		frameRechClient.getContentPane().add(admin);
		
		modif = new JButton("modif");
		modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nom.getText().length()>0 && prenom.getText().length()>0) {
					
					System.out.println(nom.getText());
					System.out.println(prenom.getText());
					
					try {
						Client cl = new Client(nom.getText(),prenom.getText());
						GestionVol gsv = new GestionVol();
						int i =Integer.parseInt(numClient.getText());
						gsv.ModifierClient(i, cl);
						erreur.setText("client modifier");
						 erreur.setForeground(Color.green);
						 btnRechercher.setEnabled(true);
						 modif.setVisible(false);
						 nom.setText("");
						 nom.setVisible(false);
						 prenom.setText("");
						 prenom.setVisible(false);
						 numClient.setText("");
						 numClient.setEnabled(true);
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					erreur.setText("Veuillez remplir tous les champs");
					 erreur.setForeground(Color.red);
				}
				
				 
			}
		});
		modif.setBackground(Color.BLUE);
		modif.setFont(new Font("Tahoma", Font.BOLD, 11));
		modif.setForeground(Color.WHITE);
		modif.setBounds(645, 77, 89, 23);
		modif.setVisible(false);
		frameRechClient.getContentPane().add(modif);
	}
}
