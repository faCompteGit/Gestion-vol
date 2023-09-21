package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Reservation;
import models.Vol;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class jframeListReservation {

	JFrame frameListe;
	private JTable tablereservation;
	private JButton btnNewButton;
	JLabel admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeListReservation window = new jframeListReservation();
					window.frameListe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframeListReservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameListe = new JFrame();
		frameListe.setBounds(100, 100, 800, 500);
		frameListe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameListe.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 41, 500, 400);
		frameListe.getContentPane().add(scrollPane);
		
		tablereservation = new JTable();
		scrollPane.setViewportView(tablereservation);
		tablereservation.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num\u00E9ro r\u00E9servation", "Num\u00E9ro client", "Mode de paeiment", "R\u00E9f\u00E9rence vol", "Nombre billet"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablereservation.getColumnModel().getColumn(0).setPreferredWidth(108);
		tablereservation.getColumnModel().getColumn(1).setPreferredWidth(82);
		tablereservation.getColumnModel().getColumn(2).setPreferredWidth(102);
		tablereservation.getColumnModel().getColumn(3).setPreferredWidth(81);
		tablereservation.getColumnModel().getColumn(4).setPreferredWidth(79);
		
		JButton Afficher = new JButton("Afficher");
		Afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url="jdbc:mysql://localhost:3306/Aeroport";
				String user="root";
				String pass="";
			
					try(Connection con = DriverManager.getConnection(url,user,pass);
						Statement statement = con.createStatement();){
						ResultSet rs;
					
						String sql = "select distinct * from reservations ";
						 rs = statement.executeQuery(sql);
						 
						 //ResultSetMetaData rs2 = rs.getMetaData();
						
						 //int c = rs2.getColumnCount();
						// df.setColumnCount(c);
						 
						 
						    while (rs.next()) {
						    	//for(int i=0;i < c; i++) {
						    	
						    		String id= rs.getString("id");
						    		String clId = rs.getString("client_id");
						    		String md_paei = rs.getString("mode_paiement");
						    		String dt_reser = rs.getString("date_reservation");
						    		String nbr_bilt = rs.getString("nbr_billet");
						    		
						    		String tabdata[]= {id,clId,md_paei,dt_reser,nbr_bilt};
						    		 DefaultTableModel df = (DefaultTableModel) tablereservation.getModel();
						    	//}
						    	//Reservation res = new Reservation(rs.getString("client_id"), rs.getString("mode_paiement"),rs.getString("date_reservation"),rs.getString("nbr_billet"));
						    	
						    	df.addRow(tabdata);
						    }
					}catch (Exception e2) {
						// TODO: handle exception
					}
					
					     
					
				    
				}
			
		});
		Afficher.setBounds(10, 77, 89, 23);
		frameListe.getContentPane().add(Afficher);
		
		btnNewButton = new JButton("accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframemenu j = new jframemenu();
				j.framemenu.setVisible(true);
				j.nom_admin.setText(admin.getText());
				frameListe.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(0, 0, 89, 23);
		frameListe.getContentPane().add(btnNewButton);
		
		admin = new JLabel("");
		admin.setBounds(103, 5, 46, 14);
		admin.setVisible(false);
		frameListe.getContentPane().add(admin);
	}
}
