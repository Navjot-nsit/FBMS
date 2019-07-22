import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JComboBox comboBox,comboBox_1,comboBox_2,comboBox_3;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
			comboBox.addItem("none");
			comboBox.addItem("City");
			comboBox.addItem("Owner");
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
			
		}
		
	}
	public void fillComboBox1() {
		try {
			
			comboBox_1.removeAllItems();
			comboBox_1.addItem("none");
			comboBox_1.addItem("City");
			comboBox_1.addItem("Owner");
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
			
		}
		
	}
	
	public void fillComboBox2() {
		try {
			
			comboBox_2.removeAllItems();
			comboBox_2.addItem("none");
			comboBox_2.addItem("Coach Name");
			comboBox_2.addItem("Nationality");
			comboBox_2.addItem("Contract Start Year");
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
			
		}
		
	}
	
	public void fillComboBox3() {
		try {
			
			comboBox_3.removeAllItems();
			comboBox_3.addItem("none");
			comboBox_3.addItem("Position");
			comboBox_3.addItem("Contract Start Year");
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
			
		}
		
	}
	
	Connection conn = null;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the frame.
	 */
	public Update() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 53, 818, 304);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Teams", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField.setBounds(178, 67, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTeamId = new JLabel("Enter Team Id :");
		lblEnterTeamId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterTeamId.setBounds(52, 72, 114, 16);
		panel.add(lblEnterTeamId);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox.setBounds(556, 68, 148, 27);
		panel.add(comboBox);
		
		JLabel lblSelectAnAttribute = new JLabel("Select an attribute :");
		lblSelectAnAttribute.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSelectAnAttribute.setBounds(385, 72, 143, 16);
		panel.add(lblSelectAnAttribute);
		
		JLabel lblEnterUpdatedData = new JLabel("Enter Updated Data :");
		lblEnterUpdatedData.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterUpdatedData.setBounds(52, 149, 169, 16);
		panel.add(lblEnterUpdatedData);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_1.setBounds(230, 144, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String col = comboBox.getSelectedItem().toString();
				String data = textField_1.getText();
				
				try {
					String query ="";
					if(col=="City") {
					    query = "UPDATE teams SET City = ? WHERE Team_id = ?";
					}else if(col=="Owner") {
						query = "UPDATE teams SET Owner = ? WHERE Team_id = ?";
					}
					PreparedStatement pst = conn.prepareStatement(query);
	
					pst.setString(1, data);
					pst.setString(2, id);
				    pst.execute();
				    
				    JOptionPane.showMessageDialog(null,"Data Updated Successfully ");
				 
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit.setBounds(465, 144, 117, 29);
		panel.add(btnSubmit);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Stadiums", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblEnterStadiumId = new JLabel("Enter Stadium Id :");
		lblEnterStadiumId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterStadiumId.setBounds(69, 46, 144, 16);
		panel_1.add(lblEnterStadiumId);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_2.setBounds(225, 42, 130, 26);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSelectAnAtrribute = new JLabel("Select an atrribute :");
		lblSelectAnAtrribute.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSelectAnAtrribute.setBounds(394, 46, 156, 16);
		panel_1.add(lblSelectAnAtrribute);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox_1.setBounds(562, 43, 164, 27);
		panel_1.add(comboBox_1);
		
		JLabel lblEnterUpdatedData_1 = new JLabel("Enter Updated Data :");
		lblEnterUpdatedData_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterUpdatedData_1.setBounds(69, 130, 165, 16);
		panel_1.add(lblEnterUpdatedData_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_3.setBounds(246, 126, 130, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_2.getText();
				String col = comboBox_1.getSelectedItem().toString();
				String data = textField_3.getText();
				
				try {
					String query ="";
					if(col=="Stadium Name") {
					    query = "UPDATE stadium SET Stadium_Name = ? WHERE Stadium_id = ?";
					}else if(col=="Capacity") {
						query = "UPDATE stadium SET Capacity = ? WHERE Stadium_id = ?";
					}
					PreparedStatement pst = conn.prepareStatement(query);
	
					pst.setString(1, data);
					pst.setString(2, id);
				    pst.execute();
				    
				    JOptionPane.showMessageDialog(null,"Data Updated Successfully ");
				 
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnSubmit_1.setBounds(439, 125, 117, 29);
		panel_1.add(btnSubmit_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Coaches", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblEnterCoachId = new JLabel("Enter Coach Id :");
		lblEnterCoachId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterCoachId.setBounds(49, 54, 126, 16);
		panel_2.add(lblEnterCoachId);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_4.setBounds(184, 50, 130, 26);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblSelectAnAttribute_1 = new JLabel("Select an attribute :");
		lblSelectAnAttribute_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSelectAnAttribute_1.setBounds(397, 55, 148, 16);
		panel_2.add(lblSelectAnAttribute_1);
		
	    comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox_2.setBounds(563, 51, 138, 27);
		panel_2.add(comboBox_2);
		
		JLabel lblEnterUpdatedData_2 = new JLabel("Enter Updated Data :");
		lblEnterUpdatedData_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterUpdatedData_2.setBounds(49, 135, 164, 16);
		panel_2.add(lblEnterUpdatedData_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_5.setBounds(225, 131, 130, 26);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField_4.getText();
				String col = comboBox_2.getSelectedItem().toString();
				String data = textField_5.getText();
				
				try {
					String query ="";
					if(col=="Coach Name") {
					    query = "UPDATE coach SET Coach_Name = ? WHERE Coach_id = ?";
					}else if(col=="Nationality") {
						query = "UPDATE coach SET Nationality = ? WHERE Coach_id = ?";
					}else if(col=="Contract Start Year") {
						query = "UPDATE coach SET contract_start = ? WHERE Coach_id = ?";
					}
					PreparedStatement pst = conn.prepareStatement(query);
	
					pst.setString(1, data);
					pst.setString(2, id);
				    pst.execute();
				    
				    JOptionPane.showMessageDialog(null,"Data Updated Successfully ");
				 
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnSubmit_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit_2.setBounds(465, 131, 117, 29);
		panel_2.add(btnSubmit_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Players", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblEnterPl = new JLabel("Enter Player Name :");
		lblEnterPl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterPl.setBounds(50, 53, 140, 16);
		panel_3.add(lblEnterPl);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_6.setBounds(202, 49, 130, 26);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblSelectAnAttribute_2 = new JLabel("Select an attribute :");
		lblSelectAnAttribute_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSelectAnAttribute_2.setBounds(388, 54, 154, 16);
		panel_3.add(lblSelectAnAttribute_2);
		
	    comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox_3.setBounds(569, 50, 145, 27);
		panel_3.add(comboBox_3);
		
		JLabel lblEnterUpdatedData_3 = new JLabel("Enter Updated Data :");
		lblEnterUpdatedData_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterUpdatedData_3.setBounds(50, 135, 154, 16);
		panel_3.add(lblEnterUpdatedData_3);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_7.setBounds(228, 131, 130, 26);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = textField_6.getText();
				String col = comboBox_3.getSelectedItem().toString();
				String data = textField_7.getText();
				
				try {
					String query ="";
					if(col=="Position") {
					    query = "UPDATE players SET Position = ? WHERE Player_name = ?";
					}else if(col=="Contract Start Year") {
						query = "UPDATE players SET year_start = ? WHERE Player_name = ?";
					}
					PreparedStatement pst = conn.prepareStatement(query);
	
					pst.setString(1, data);
					pst.setString(2, id);
				    pst.execute();
				    
				    JOptionPane.showMessageDialog(null,"Data Updated Successfully ");
				 
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(468, 131, 117, 29);
		panel_3.add(btnNewButton);
		
		
		fillComboBox();
		fillComboBox1();
		fillComboBox2();
		fillComboBox3();
	}
}
