package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.GestionVol;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import models.Client;
import models.Vol;

public class jframeAjoutVol {

	JFrame frameAjouterVol;
	private JTextField ref;
	private JTextField date;
	private JTextField heure_depart;
	private JTextField heure_arrivee;
	private JTextField destination;
	private JTextField prix;
	JLabel admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeAjoutVol window = new jframeAjoutVol();
					window.frameAjouterVol.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframeAjoutVol() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAjouterVol = new JFrame();
		frameAjouterVol.setBounds(100, 100, 800, 400);
		frameAjouterVol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAjouterVol.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un vol");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(321, 11, 129, 22);
		frameAjouterVol.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reférence :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(105, 66, 92, 14);
		frameAjouterVol.getContentPane().add(lblNewLabel_1);
		
		ref = new JTextField();
		ref.setForeground(Color.BLUE);
		ref.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ref.setBounds(207, 66, 86, 20);
		frameAjouterVol.getContentPane().add(ref);
		ref.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(105, 125, 64, 14);
		frameAjouterVol.getContentPane().add(lblNewLabel_2);
		
		date = new JTextField();
		date.setForeground(Color.BLUE);
		date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		date.setBounds(207, 119, 129, 20);
		frameAjouterVol.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Heure départ :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(105, 183, 108, 14);
		frameAjouterVol.getContentPane().add(lblNewLabel_3);
		
		heure_depart = new JTextField();
		heure_depart.setFont(new Font("Tahoma", Font.PLAIN, 17));
		heure_depart.setForeground(Color.BLUE);
		heure_depart.setBounds(223, 177, 129, 20);
		frameAjouterVol.getContentPane().add(heure_depart);
		heure_depart.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Heure arrivée :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(105, 239, 118, 14);
		frameAjouterVol.getContentPane().add(lblNewLabel_4);
		
		heure_arrivee = new JTextField();
		heure_arrivee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		heure_arrivee.setForeground(Color.BLUE);
		heure_arrivee.setBounds(223, 233, 129, 20);
		frameAjouterVol.getContentPane().add(heure_arrivee);
		heure_arrivee.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Destination :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(429, 66, 96, 14);
		frameAjouterVol.getContentPane().add(lblNewLabel_5);
		
		destination = new JTextField();
		destination.setForeground(Color.BLUE);
		destination.setFont(new Font("Tahoma", Font.PLAIN, 15));
		destination.setBounds(557, 66, 129, 20);
		frameAjouterVol.getContentPane().add(destination);
		destination.setColumns(10);
		
		JComboBox etat_vol = new JComboBox();
		etat_vol.setForeground(Color.BLUE);
		etat_vol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etat_vol.setModel(new DefaultComboBoxModel(new String[] {"Confirmer", "Annuler"}));
		etat_vol.setBounds(586, 113, 100, 22);
		frameAjouterVol.getContentPane().add(etat_vol);
		
		JLabel lblNewLabel_6 = new JLabel("Etat du vol :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(429, 121, 108, 14);
		frameAjouterVol.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Prix :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(429, 180, 46, 14);
		frameAjouterVol.getContentPane().add(lblNewLabel_7);
		
		prix = new JTextField();
		prix.setForeground(Color.BLUE);
		prix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prix.setBounds(557, 177, 129, 20);
		frameAjouterVol.getContentPane().add(prix);
		prix.setColumns(10);
		
		JLabel erreur = new JLabel("");
		erreur.setForeground(Color.RED);
		erreur.setBounds(338, 338, 217, 14);
		frameAjouterVol.getContentPane().add(erreur);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBackground(Color.BLUE);
		ajouter.setForeground(Color.WHITE);
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 17));
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionVol gsv =new GestionVol();
				Boolean re =  gsv.isAlphaNumeric(ref.getText());
				Boolean dat =  gsv.isAlphaNumeric(date.getText());
				Boolean heuA =  gsv.isAlphaNumeric(heure_arrivee.getText());
				Boolean heuD =  gsv.isAlphaNumeric(heure_depart.getText());
				Boolean des =  gsv.isAlphaNumeric(destination.getText());
				Boolean pr =  gsv.isNumeric(prix.getText());
				
				if(ref.getText().length()<= 0 || date.getText().length()<= 0 || heure_depart.getText().length()<= 0 || heure_arrivee.getText().length()<= 0 || destination.getText().length()<= 0 || etat_vol.getSelectedItem().equals(0) || prix.getText().length()<= 0) {
					erreur.setText("veuillez remplir tout les champs");
					erreur.setForeground(Color.red);
				}
				else if(re != true || heuA != true || heuD != true || des != true) {
					 erreur.setText("Retirez les mauvais caractères! ");
					 erreur.setForeground(Color.red);
				 }
				else if( pr != true) {
					erreur.setText("le prix doit etre un entier ");
					 erreur.setForeground(Color.red);
				}
				else {
					String etVil = (String) etat_vol.getSelectedItem();
					int pri = Integer.parseInt(prix.getText());
					Vol vol = new Vol(ref.getText(),date.getText(),heure_depart.getText(),heure_arrivee.getText(),destination.getText(),etVil,pri );
					
					try {
						 ArrayList<Vol> li =new ArrayList<Vol>();
						 li =gsv.RechercherVol(ref.getText());
						 if(li.size()!=0) {
							 erreur.setText("Cette référence existe");
								erreur.setForeground(Color.red);
						 }
						 else {
						gsv.AjouterVol(vol);
						erreur.setText("Vol ajouté");
						erreur.setForeground(Color.green);
						ref.setText("");
						date.setText("");
						heure_arrivee.setText("");
						heure_depart.setText("");
						destination.setText("");
						prix.setText("");
						 }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		ajouter.setBounds(586, 268, 100, 23);
		frameAjouterVol.getContentPane().add(ajouter);
		
		JButton btnNewButton = new JButton("Accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframemenu j = new jframemenu();
				j.framemenu.setVisible(true);
				j.nom_admin.setText(admin.getText());
				frameAjouterVol.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 0, 89, 23);
		frameAjouterVol.getContentPane().add(btnNewButton);
		
		admin = new JLabel("");
		admin.setBounds(102, 5, 46, 14);
		admin.setVisible(false);
		frameAjouterVol.getContentPane().add(admin);
	}
}
