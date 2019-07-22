import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;

public class Del extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox;
	String a = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Del frame = new Del();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillComboBox() {
		try {
			comboBox.removeAllItems();
			
			comboBox.addItem("Teams");
			comboBox.addItem("Players");
			comboBox.addItem("Stadiums");
			comboBox.addItem("Coaches");
			comboBox.addItem("Matches");
			comboBox.addItem("League");
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
			
		}
		
	}

	/**
	 * Create the frame.
	 */
	Connection conn = null;
	private JTable table;
	
	public Del() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    comboBox = new JComboBox();
	    comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	    comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    		a=(String)comboBox.getSelectedItem();
	    		String query = "";
	    		if(a == "Teams") {
					query = "select * from teams";
				}else if(a=="Players") {
					query = "select * from players";
				}else if(a=="Stadiums") {
					query = "select * from stadium";
				}else if(a=="Coaches") {
					query = "select * from coach";
				}else if(a=="Matches") {
					query = "select * from match_info natural join plays";
				}else if(a=="League") {
					query = "select * from league";
				}
				
				PreparedStatement pst = conn.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
		
	    		}
	    		catch(Exception e1) {
	    			JOptionPane.showMessageDialog(null,e1);
	    		}
	    	}
	    });
		comboBox.setBounds(474, 33, 191, 27);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 86, 813, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					
					String query = "";
					
					if(a == "Teams") {
						
						String c =  (table.getModel().getValueAt(row, 1).toString());
						query = "delete from teams where Team_Name = ?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, c);
						pst.execute();
						
					}else if(a=="Players") {
						
						query = "delete from players where Player_name = ?";
						String c =  (table.getModel().getValueAt(row, 2).toString());
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, c);
						pst.execute();
						
					}else if(a=="Stadiums") {
						
						query = "delete from stadium where Stadium_Name = ?";
						String c =  (table.getModel().getValueAt(row, 1).toString());
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, c);
						pst.execute();
						
					}else if(a=="Coaches") {
						
						query = "delete from coach where Coach_Name = ?";
						String c =  (table.getModel().getValueAt(row, 1).toString());
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, c);
						pst.execute();
						
					}else if(a=="Matches") {
						
						query = "delete from match_info where match_id = ?";
						String c =  (table.getModel().getValueAt(row, 0).toString());
				
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, c);
						pst.execute();
						
						String query1 = "delete from plays where match_id = ?";
						PreparedStatement pst1 = conn.prepareStatement(query1);
						pst1.setString(1, c);
						pst1.execute();
						
					}else if(a=="League") {
						
						query = "delete from league where season = ?";
						String c =  (table.getModel().getValueAt(row, 0).toString());
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, c);
						pst.execute();
					}
					
					JOptionPane.showMessageDialog(null,"Successfully Deleted");
			
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}

			}
		});
		btnDelete.setBounds(355, 403, 150, 54);
		contentPane.add(btnDelete);
		
		JLabel lblSelectARelation = new JLabel("Select a relation :");
		lblSelectARelation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSelectARelation.setBounds(305, 37, 132, 16);
		contentPane.add(lblSelectARelation);
		
		fillComboBox();
	}
}
