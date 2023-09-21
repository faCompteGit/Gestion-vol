package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.GestionVol;
import models.Admin;
import models.Reservation;
import models.Vol;
import models.Client;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class jframeResevation {

	JFrame frameReservation;
	JTextField id_client;
	JTextField ref;
	private JTextField date_reserv;
	private JTextField nbr_billet;
	JLabel erreur;
	JLabel admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeResevation window = new jframeResevation();
					window.frameReservation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframeResevation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameReservation = new JFrame();
		frameReservation.setBounds(100, 100, 800, 400);
		frameReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameReservation.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une réservation :");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(315, 11, 224, 22);
		frameReservation.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro client :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(83, 104, 118, 14);
		frameReservation.getContentPane().add(lblNewLabel_1);
		
		id_client = new JTextField();
		id_client.setForeground(Color.BLUE);
		id_client.setBounds(237, 98, 89, 20);
		frameReservation.getContentPane().add(id_client);
		id_client.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mode de paiement :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(83, 174, 156, 14);
		frameReservation.getContentPane().add(lblNewLabel_2);
		
		JComboBox mode_paiement = new JComboBox();
		mode_paiement.setForeground(Color.BLUE);
		mode_paiement.setModel(new DefaultComboBoxModel(new String[] {"espèce", "carte", "chèque"}));
		mode_paiement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mode_paiement.setBounds(237, 166, 89, 22);
		frameReservation.getContentPane().add(mode_paiement);
		
		JLabel lblNewLabel_3 = new JLabel("Référence vol :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(83, 252, 141, 14);
		frameReservation.getContentPane().add(lblNewLabel_3);
		
		ref = new JTextField();
		ref.setForeground(Color.BLUE);
		ref.setBounds(237, 246, 100, 20);
		frameReservation.getContentPane().add(ref);
		ref.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date réservation :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(428, 104, 141, 14);
		frameReservation.getContentPane().add(lblNewLabel_4);
		
		date_reserv = new JTextField();
		date_reserv.setForeground(Color.BLUE);
		date_reserv.setBounds(602, 104, 127, 20);
		frameReservation.getContentPane().add(date_reserv);
		date_reserv.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre de billet :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(453, 174, 141, 14);
		frameReservation.getContentPane().add(lblNewLabel_5);
		
		nbr_billet = new JTextField();
		nbr_billet.setForeground(Color.BLUE);
		nbr_billet.setBounds(602, 168, 73, 20);
		frameReservation.getContentPane().add(nbr_billet);
		nbr_billet.setColumns(10);
		
		JButton Ajouter = new JButton("ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionVol gsv =new GestionVol();
				Boolean nbrBillet =  gsv.isNumeric(nbr_billet.getText());
				Boolean num =  gsv.isNumeric(id_client.getText());
				
				if(nbr_billet.getText().length()<=0 || 	id_client.getText().length()<=0 || date_reserv.getText().length()<=0 || ref.getText().length()<=0	) {
					erreur.setText("Veuillez remplir tous les champs");
					erreur.setForeground(Color.red);
					
				}
				else if( nbrBillet != true) {
					erreur.setText("le nombre de billet doit etre un entier ");
					 erreur.setForeground(Color.red);
				}
				else if( num != true) {
					erreur.setText("le numéro du client doit etre un entier ");
					 erreur.setForeground(Color.red);
				}
				else {
					String paie = (String) mode_paiement.getSelectedItem();
					int i =Integer.parseInt(nbr_billet.getText());
					System.out.println(i);
					Reservation reser=new Reservation(i,Integer.parseInt(id_client.getText()),paie.toString(),date_reserv.getText(),ref.getText());
					 //GestionVol gsv =new GestionVol();
					 try {
						 ArrayList<Vol> li =new ArrayList<Vol>();
						 ArrayList<Client> cli =new ArrayList<Client>();
						 cli =gsv.RechercherClient(Integer.parseInt(id_client.getText()));
						 li = gsv.RechercherVol(ref.getText());
						 if(li.size()==0) {
							 erreur.setText("Pas de vol pour cette reférence");
								erreur.setForeground(Color.red);
						 }
						 else if(cli.size()==0) {
							 erreur.setText("Pas de client pour ce numéro");
								erreur.setForeground(Color.red);
						 }
						 else {
						 gsv.AjouterReservation(reser);
						 erreur.setText("Réservation ajoutée");
						 erreur.setForeground(Color.green);
						 ref.setText("");
						 id_client.setText("");
						 date_reserv.setText("");
						 nbr_billet.setText("");						 }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
				}
			}
		});
		Ajouter.setForeground(Color.WHITE);
		Ajouter.setBackground(Color.BLUE);
		Ajouter.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ajouter.setBounds(623, 270, 106, 23);
		frameReservation.getContentPane().add(Ajouter);
		
		erreur = new JLabel("");
		erreur.setBounds(293, 315, 491, 14);
		frameReservation.getContentPane().add(erreur);
		
		JButton btnNewButton = new JButton("Accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframemenu j = new jframemenu();
				j.framemenu.setVisible(true);
				j.nom_admin.setText(admin.getText());
				frameReservation.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 0, 89, 23);
		frameReservation.getContentPane().add(btnNewButton);
		
		admin = new JLabel("");
		admin.setBounds(97, 5, 46, 14);
		admin.setVisible(false);
		frameReservation.getContentPane().add(admin);
	}
}
