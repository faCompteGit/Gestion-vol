package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import controllers.GestionVol;
import models.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class jframeAjoutClient {

	JFrame addClient;
	private JTextField nom;
	private JTextField prenom;
	JLabel erreur;
	private JButton btnNewButton;
	JLabel admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeAjoutClient window = new jframeAjoutClient();
					window.addClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframeAjoutClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addClient = new JFrame();
		addClient.setBounds(100, 100, 800, 400);
		addClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addClient.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un client");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 23));
		lblNewLabel.setBounds(295, 11, 212, 38);
		addClient.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(155, 108, 116, 38);
		addClient.getContentPane().add(lblNewLabel_1);
		
		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nom.setForeground(Color.BLUE);
		nom.setBounds(281, 108, 242, 27);
		addClient.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(156, 197, 142, 38);
		addClient.getContentPane().add(lblNewLabel_2);
		
		prenom= new JTextField();
		prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prenom.setForeground(Color.BLUE);
		prenom.setBounds(281, 206, 225, 26);
		addClient.getContentPane().add(prenom);
		prenom.setColumns(10);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBackground(Color.BLUE);
		ajouter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ajouter.setForeground(Color.WHITE);
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionVol gsv =new GestionVol();
				Boolean name =  gsv.isAlphaNumeric(nom.getText());
				Boolean pren =  gsv.isAlphaNumeric(prenom.getText());

				String a ="a";
				if(nom.getText().length() <= 0 || prenom.getText().length() <= 0) {
					erreur.setText("veuillez remplir tous les champs");
					erreur.setForeground(Color.red);
					
				}
				else if(name != true || pren != true) {
					 erreur.setText("Retirez les mauvais caractères! ");
					 erreur.setForeground(Color.red);
				 }
				else {
					Client cl = new Client(nom.getText(), prenom.getText());
					
					try {
						gsv.AjouterClient(cl);
						erreur.setText("client ajouter");
						nom.setText("");
						prenom.setText("");
						erreur.setForeground(Color.green);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						erreur.setText("Erreur d'ajout");
						e1.printStackTrace();
					}
				}
			}
			
		});
		ajouter.setBounds(358, 290, 102, 23);
		addClient.getContentPane().add(ajouter);
		
		erreur = new JLabel("");
		erreur.setForeground(Color.RED);
		erreur.setBounds(331, 324, 443, 14);
		addClient.getContentPane().add(erreur);
		
		btnNewButton = new JButton("Accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframemenu j = new jframemenu();
				j.framemenu.setVisible(true);
				j.nom_admin.setText(admin.getText());
				 addClient.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 0, 89, 23);
		addClient.getContentPane().add(btnNewButton);
		
		admin = new JLabel("New label");
		admin.setBounds(99, 5, 46, 14);
		admin.setVisible(false);
		addClient.getContentPane().add(admin);
		
	}
}
