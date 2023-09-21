package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.GestionVol;
import models.Client;

import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.StringBufferInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import models.Vol;
import java.awt.Color;

public class jframeRechercherVol {

	JFrame frameRechercherVol;
	JTextField ref;
	JLabel erreur;
	JTextField dat_vol;
	JTextField heur_arrivee ;
	JTextField heur_depart ;
	JTextField destination;
	JTextField prix;
	JTextField etat_vol;
	JLabel admin;
	JButton modif;
	JButton rechercher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeRechercherVol window = new jframeRechercherVol();
					window.frameRechercherVol.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframeRechercherVol() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRechercherVol = new JFrame();
		frameRechercherVol.setBounds(100, 100, 800, 400);
		frameRechercherVol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRechercherVol.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rerchercher un vol");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(302, 0, 181, 29);
		frameRechercherVol.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Référence :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(122, 74, 97, 14);
		frameRechercherVol.getContentPane().add(lblNewLabel_1);
		
		ref = new JTextField();
		ref.setForeground(Color.BLUE);
		ref.setBounds(280, 74, 86, 20);
		frameRechercherVol.getContentPane().add(ref);
		ref.setColumns(10);
		
		rechercher = new JButton("Rechercher");
		rechercher.setFont(new Font("Tahoma", Font.BOLD, 11));
		rechercher.setBackground(Color.BLUE);
		rechercher.setForeground(Color.WHITE);
		rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Vol> volList = new ArrayList<Vol>();
				GestionVol gsv =new GestionVol();
				try {
					volList = gsv.RechercherVol(ref.getText());
					 if (ref.getText().length()<= 0) {
						 erreur.setText("Entrer la référence");
							erreur.setForeground(Color.red);
					 }
					 else if(volList.size()==0) {
						 erreur.setText("Aucun vol pour cette référence");
							erreur.setForeground(Color.red);
					 }
					 else {
						 for (int i=0;i<=volList.size();i++) {
							 ref.setEnabled(false);
								dat_vol.setVisible(true);
								heur_arrivee.setVisible(true);
								heur_depart.setVisible(true);
								prix.setVisible(true);
								destination.setVisible(true);
								etat_vol.setVisible(true);
								rechercher.setEnabled(false);
								erreur.setText("");
								
							 System.out.println(volList.get(i));
							 dat_vol.setText(volList.get(i).getDate_Vol());
							 heur_depart.setText(volList.get(i).getHeure_Depart());
							 heur_arrivee.setText(volList.get(i).getHeure_Arrivee());
							 destination.setText(volList.get(i).getDestination());
							 etat_vol.setText(volList.get(i).getEtat_Vol());
							 prix.setText(Integer.toString(volList.get(i).getPrix()));
						 }
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		rechercher.setBounds(420, 73, 125, 23);
		frameRechercherVol.getContentPane().add(rechercher);
		
		JLabel lblNewLabel_2 = new JLabel("Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(89, 156, 54, 14);
		frameRechercherVol.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Heure départ :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(89, 214, 114, 14);
		frameRechercherVol.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Heure d'arrivée :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(89, 280, 131, 14);
		frameRechercherVol.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Destination :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(438, 156, 107, 14);
		frameRechercherVol.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Etat :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(438, 214, 46, 14);
		frameRechercherVol.getContentPane().add(lblNewLabel_6);
		
		etat_vol = new JTextField("");
		etat_vol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
				modif.setEnabled(true);
			}
		});
		etat_vol.setForeground(Color.BLUE);
		etat_vol.setFont(new Font("Tahoma", Font.ITALIC, 15));
		etat_vol.setBounds(583, 214, 114, 17);
		etat_vol.setVisible(false);
		frameRechercherVol.getContentPane().add(etat_vol);
		
		JLabel lblNewLabel_7 = new JLabel("Prix :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(438, 280, 54, 14);
		frameRechercherVol.getContentPane().add(lblNewLabel_7);
		
		
		prix = new JTextField("");
		prix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
				modif.setEnabled(true);
			}
		});
		prix.setForeground(Color.BLUE);
		prix.setFont(new Font("Tahoma", Font.ITALIC, 15));
		prix.setBounds(572, 278, 125, 20);
		prix.setVisible(false);
		frameRechercherVol.getContentPane().add(prix);
		
		destination = new JTextField("");
		destination.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
				modif.setEnabled(true);
			}
		});
		destination.setForeground(Color.BLUE);
		destination.setFont(new Font("Tahoma", Font.ITALIC, 15));
		destination.setBounds(572, 154, 125, 20);
		destination.setVisible(false);
		frameRechercherVol.getContentPane().add(destination);
		
		heur_depart = new JTextField("");
		heur_depart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
				modif.setEnabled(true);
			}
		});
		heur_depart.setForeground(Color.BLUE);
		heur_depart.setFont(new Font("Tahoma", Font.ITALIC, 15));
		heur_depart.setBounds(221, 280, 112, 17);
		heur_depart.setVisible(false);
		frameRechercherVol.getContentPane().add(heur_depart);
		
		heur_arrivee = new JTextField("");
		heur_arrivee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
				modif.setEnabled(true);
			}
		});
		heur_arrivee.setForeground(Color.BLUE);
		heur_arrivee.setFont(new Font("Tahoma", Font.ITALIC, 15));
		heur_arrivee.setBounds(221, 214, 112, 17);
		heur_arrivee.setVisible(false);
		frameRechercherVol.getContentPane().add(heur_arrivee);
		
		dat_vol = new JTextField("");
		dat_vol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modif.setVisible(true);
				modif.setEnabled(true);
			}
		});
		dat_vol.setForeground(new Color(0, 0, 255));
		dat_vol.setFont(new Font("Tahoma", Font.ITALIC, 15));
		dat_vol.setBounds(153, 156, 97, 17);
		dat_vol.setVisible(false);
		frameRechercherVol.getContentPane().add(dat_vol);
		
		erreur = new JLabel("");
		erreur.setBounds(438, 320, 336, 14);
		frameRechercherVol.getContentPane().add(erreur);
		
		JButton btnNewButton = new JButton("Accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframemenu j = new jframemenu();
				j.framemenu.setVisible(true);
				j.nom_admin.setText(admin.getText());
				frameRechercherVol.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 0, 89, 23);
		frameRechercherVol.getContentPane().add(btnNewButton);
		
		admin = new JLabel("");
		admin.setBounds(97, 5, 46, 14);
		admin.setVisible(false);
		frameRechercherVol.getContentPane().add(admin);
		
		modif = new JButton("Modifier");
		modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionVol gsv = new GestionVol();
	
					
					if(ref.getText().length()<=0 || dat_vol.getText().length()<=0 || heur_depart.getText().length()<=0 || destination.getText().length()<=0 || etat_vol.getText().length()<=0 || prix.getText().length()<=0 ) {
						erreur.setText("Veuillez remplir tous les champs");
						 erreur.setForeground(Color.red);
					}
					if(gsv.isNumeric(prix.getText())==true) {
						
						if(ref.getText().length()>0 && dat_vol.getText().length()>0 && heur_depart.getText().length()>0 && heur_arrivee.getText().length()>0 && destination.getText().length()>0 && etat_vol.getText().length()>0 && prix.getText().length()>0 ) {
							Vol vol = new Vol(ref.getText().trim(),dat_vol.getText().trim(),heur_depart.getText().trim(),heur_arrivee.getText().trim(),destination.getText().trim(),etat_vol.getText().trim(),Integer.parseInt(prix.getText().trim()));
							try {
								gsv.ModifierVol(ref.getText(), vol);
								System.out.println(vol.getDate_Vol());
								erreur.setText("Vol modifier");
								erreur.setForeground(Color.green);
								modif.setEnabled(false);
								dat_vol.setVisible(false);
								dat_vol.setText("");
								heur_arrivee.setVisible(false);
								heur_arrivee.setText("");
								heur_depart.setVisible(false);
								heur_depart.setText("");
								prix.setVisible(false);
								prix.setText("");
								destination.setVisible(false);
								destination.setText("");
								etat_vol.setVisible(false);
								etat_vol.setText("");
								ref.setEnabled(true);
								ref.setText("");
								rechercher.setEnabled(true);
								
								modif.setVisible(false);
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
					}
					else {
						erreur.setText("le prix doit etre un entier");
						 erreur.setForeground(Color.red);
					}
				      
				    
				int pr =(Integer) Integer.parseInt(prix.getText().trim());
				
				//Boolean re = gsv.isNumeric(prix.getText());
				System.out.println(ref.getText().length());
				//System.out.println(re);
				
						
						
						
			}
				
		});
		modif.setBackground(Color.BLUE);
		modif.setForeground(Color.WHITE);
		modif.setFont(new Font("Tahoma", Font.BOLD, 11));
		modif.setBounds(588, 73, 89, 23);
		modif.setVisible(false);
		frameRechercherVol.getContentPane().add(modif);
	}
}
