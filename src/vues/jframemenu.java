package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class jframemenu {

	JFrame framemenu;
	JLabel nom_admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframemenu window = new jframemenu();
					window.framemenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframemenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framemenu = new JFrame();
		framemenu.setBounds(100, 100, 800, 400);
		framemenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framemenu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Reservation de vol");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 23));
		lblNewLabel_1.setBounds(287, 11, 215, 38);
		framemenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(jframemenu.class.getResource("/vues/fond.png")));
		lblNewLabel.setBounds(40, 45, 690, 101);
		framemenu.getContentPane().add(lblNewLabel);
		
		JButton addClient = new JButton("Ajouter un client");
		addClient.setForeground(Color.WHITE);
		addClient.setBackground(Color.BLUE);
		addClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframeAjoutClient j = new jframeAjoutClient();
				j.addClient.setVisible(true); 
				j.admin.setText(nom_admin.getText());
				framemenu.dispose();
			}
		});
		addClient.setFont(new Font("Tahoma", Font.BOLD, 11));
		addClient.setBounds(89, 194, 130, 23);
		framemenu.getContentPane().add(addClient);
		
		JButton rechercherClient = new JButton("Rechercher un client");
		rechercherClient.setForeground(Color.WHITE);
		rechercherClient.setBackground(Color.BLUE);
		rechercherClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jrameRechercheClient j = new jrameRechercheClient();
				j.frameRechClient.setVisible(true);
				j.admin.setText(nom_admin.getText());
				framemenu.dispose();
				
			}
		});
		rechercherClient.setFont(new Font("Tahoma", Font.BOLD, 11));
		rechercherClient.setBounds(89, 266, 150, 23);
		framemenu.getContentPane().add(rechercherClient);
		
		JButton addVol = new JButton("Ajouter un vol");
		addVol.setBackground(Color.BLUE);
		addVol.setForeground(Color.WHITE);
		addVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframeAjoutVol j = new jframeAjoutVol();
				j.frameAjouterVol.setVisible(true);
				j.admin.setText(nom_admin.getText());
				framemenu.dispose();
			}
		});
		addVol.setFont(new Font("Tahoma", Font.BOLD, 11));
		addVol.setBounds(346, 194, 120, 23);
		framemenu.getContentPane().add(addVol);
		
		JButton rechercherVol = new JButton("Rechercher un vol");
		rechercherVol.setForeground(Color.WHITE);
		rechercherVol.setBackground(Color.BLUE);
		rechercherVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframeRechercherVol j = new jframeRechercherVol();
				j.frameRechercherVol.setVisible(true);
				j.admin.setText(nom_admin.getText());
				framemenu.dispose();
			}
		});
		rechercherVol.setFont(new Font("Tahoma", Font.BOLD, 11));
		rechercherVol.setBounds(327, 266, 160, 23);
		framemenu.getContentPane().add(rechercherVol);
		
		JButton reserver = new JButton("Creer une réservation");
		reserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframeResevation j = new jframeResevation();
				j.frameReservation.setVisible(true);
				j.admin.setText(nom_admin.getText());
				framemenu.dispose();
				
			}
		});
		reserver.setForeground(Color.WHITE);
		reserver.setBackground(Color.BLUE);
		reserver.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserver.setBounds(545, 194, 160, 23);
		framemenu.getContentPane().add(reserver);
		
		JButton Affiche_reser = new JButton("Afficher les Réservations");
		Affiche_reser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframeListReservation j = new jframeListReservation();
				j.admin.setText(nom_admin.getText());
				j.frameListe.setVisible(true);
			}
		});
		Affiche_reser.setBackground(Color.BLUE);
		Affiche_reser.setFont(new Font("Tahoma", Font.BOLD, 11));
		Affiche_reser.setForeground(Color.WHITE);
		Affiche_reser.setBounds(532, 266, 185, 23);
		framemenu.getContentPane().add(Affiche_reser);
		
		JLabel lblNewLabel_2 = new JLabel("admin :");
		lblNewLabel_2.setBounds(40, 11, 45, 14);
		framemenu.getContentPane().add(lblNewLabel_2);
		
		nom_admin = new JLabel("");
		nom_admin.setForeground(Color.BLUE);
		nom_admin.setBounds(95, 11, 65, 14);
		framemenu.getContentPane().add(nom_admin);
		
		JButton deconnexion = new JButton("Se déconnecter");
		deconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframeconnexion j = new jframeconnexion();
				j.frameConnexion.setVisible(true);
				framemenu.hide();
			}
		});
		deconnexion.setForeground(Color.BLUE);
		deconnexion.setBounds(641, 7, 133, 23);
		framemenu.getContentPane().add(deconnexion);
	}
}
