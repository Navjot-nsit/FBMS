import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Add() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 29, 789, 386);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Teams", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblTeamid = new JLabel("Team_Id :");
		lblTeamid.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamid.setBounds(76, 39, 115, 37);
		panel.add(lblTeamid);
		
		JLabel lblTeamname = new JLabel("Team_Name :");
		lblTeamname.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamname.setBounds(76, 103, 115, 37);
		panel.add(lblTeamname);
		
		JLabel lblNewLabel = new JLabel("City :");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(76, 152, 86, 43);
		panel.add(lblNewLabel);
		
		JLabel lblOwner = new JLabel("Owner :");
		lblOwner.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblOwner.setBounds(76, 207, 69, 34);
		panel.add(lblOwner);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField.setBounds(283, 44, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_1.setBounds(283, 108, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_2.setBounds(283, 160, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_3.setBounds(283, 211, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into teams values(?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					pst.execute();
				
					pst.close();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					
					String query2 = "select * from teams ";
					PreparedStatement pst2 = conn.prepareStatement(query2);
				
					ResultSet rs1 = pst2.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
			
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}

			}
		});
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit.setBounds(545, 67, 130, 43);
		panel.add(btnSubmit);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(545, 161, 130, 43);
		panel.add(btnReturn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Players", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblTeam = new JLabel("Team :");
		lblTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeam.setBounds(77, 37, 61, 16);
		panel_1.add(lblTeam);
		
		JLabel lblKitNo = new JLabel("Kit No :");
		lblKitNo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblKitNo.setBounds(407, 37, 61, 16);
		panel_1.add(lblKitNo);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblName.setBounds(77, 92, 61, 16);
		panel_1.add(lblName);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPosition.setBounds(407, 92, 61, 16);
		panel_1.add(lblPosition);
		
		JLabel lblNationality = new JLabel("Nationality :");
		lblNationality.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNationality.setBounds(77, 150, 87, 16);
		panel_1.add(lblNationality);
		
		JLabel lblDob = new JLabel("DOB :");
		lblDob.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDob.setBounds(407, 150, 61, 16);
		panel_1.add(lblDob);
		
		JLabel lblTeamId = new JLabel("Team Id :");
		lblTeamId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamId.setBounds(77, 201, 67, 16);
		panel_1.add(lblTeamId);
		
		JLabel lblContractStartYear = new JLabel("Contract Start Year :");
		lblContractStartYear.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblContractStartYear.setBounds(394, 201, 155, 16);
		panel_1.add(lblContractStartYear);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_4.setBounds(191, 32, 130, 26);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_5.setBounds(561, 32, 130, 26);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_6.setBounds(191, 87, 130, 26);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_7.setBounds(561, 87, 130, 26);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_8.setBounds(191, 145, 130, 26);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_9.setBounds(561, 145, 130, 26);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_10.setBounds(191, 196, 130, 26);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_11.setBounds(561, 191, 130, 26);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into players values(?,?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField_4.getText());
					pst.setString(2,textField_5.getText());
					pst.setString(3,textField_6.getText());
					pst.setString(4,textField_7.getText());
					pst.setString(5,textField_8.getText());
					pst.setString(6,textField_9.getText());
					pst.setString(7,textField_10.getText());
					pst.setString(8,textField_11.getText());
					pst.execute();
				
					pst.close();
					
					String query2 = "select * from players ";
					PreparedStatement pst2 = conn.prepareStatement(query2);
				
					ResultSet rs1 = pst2.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					
			
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnSubmit_1.setBounds(135, 267, 137, 39);
		panel_1.add(btnSubmit_1);
		
		JButton btnReturn_1 = new JButton("Return");
		btnReturn_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
			}
		});
		btnReturn_1.setBounds(379, 267, 124, 39);
		panel_1.add(btnReturn_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Stadiums", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblStadiumId = new JLabel("Stadium Id : ");
		lblStadiumId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblStadiumId.setBounds(78, 54, 101, 16);
		panel_2.add(lblStadiumId);
		
		JLabel lblStadiumName = new JLabel("Stadium Name :");
		lblStadiumName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblStadiumName.setBounds(78, 113, 135, 16);
		panel_2.add(lblStadiumName);
		
		JLabel lblCapacity = new JLabel("Capacity :");
		lblCapacity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCapacity.setBounds(78, 173, 111, 16);
		panel_2.add(lblCapacity);
		
		JLabel lblTeamId_1 = new JLabel("Team Id :");
		lblTeamId_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamId_1.setBounds(78, 241, 101, 16);
		panel_2.add(lblTeamId_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_12.setBounds(292, 49, 130, 26);
		panel_2.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_13.setBounds(292, 108, 130, 26);
		panel_2.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_14.setBounds(292, 168, 130, 26);
		panel_2.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_15.setBounds(292, 236, 130, 26);
		panel_2.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into stadium values(?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField_12.getText());
					pst.setString(2,textField_13.getText());
					pst.setString(3,textField_14.getText());
					pst.setString(4,textField_15.getText());
					pst.execute();
				
					pst.close();
					
					String query2 = "select * from stadium ";
					PreparedStatement pst2 = conn.prepareStatement(query2);
				
					ResultSet rs1 = pst2.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					
			
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}

			}
		});
		btnNewButton.setBounds(549, 76, 130, 46);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(549, 173, 130, 46);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Coaches", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblCoachId = new JLabel("Coach Id :");
		lblCoachId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCoachId.setBounds(84, 41, 101, 16);
		panel_3.add(lblCoachId);
		
		JLabel lblCoachName = new JLabel("Coach Name :");
		lblCoachName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCoachName.setBounds(84, 100, 101, 16);
		panel_3.add(lblCoachName);
		
		JLabel lblNewLabel_1 = new JLabel("Nationality :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(84, 151, 90, 16);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblContractStartYear_1 = new JLabel("Contract Start Year :");
		lblContractStartYear_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblContractStartYear_1.setBounds(84, 206, 155, 16);
		panel_3.add(lblContractStartYear_1);
		
		JLabel lblTeamId_2 = new JLabel("Team Id :");
		lblTeamId_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamId_2.setBounds(84, 261, 84, 16);
		panel_3.add(lblTeamId_2);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_16.setBounds(289, 36, 130, 26);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_17.setBounds(289, 95, 130, 26);
		panel_3.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_18.setBounds(289, 146, 130, 26);
		panel_3.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_19.setBounds(289, 201, 130, 26);
		panel_3.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_20.setBounds(289, 256, 130, 26);
		panel_3.add(textField_20);
		textField_20.setColumns(10);
		
		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into coach values(?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField_16.getText());
					pst.setString(2,textField_17.getText());
					pst.setString(3,textField_18.getText());
					pst.setString(4,textField_19.getText());
					pst.setString(5,textField_20.getText());
					pst.execute();
				
					pst.close();
					
					String query2 = "select * from coach ";
					PreparedStatement pst2 = conn.prepareStatement(query2);
				
					ResultSet rs1 = pst2.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
					textField_16.setText("");
					textField_17.setText("");
					textField_18.setText("");
					textField_19.setText("");
					textField_20.setText("");
			
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnSubmit_2.setBounds(545, 76, 144, 55);
		panel_3.add(btnSubmit_2);
		
		JButton btnReturn_2 = new JButton("Return");
		btnReturn_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
			}
		});
		btnReturn_2.setBounds(545, 174, 144, 55);
		panel_3.add(btnReturn_2);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Matches", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblMatchId = new JLabel("Match Id :");
		lblMatchId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblMatchId.setBounds(52, 40, 85, 16);
		panel_4.add(lblMatchId);
		
		JLabel lblHomeTeam = new JLabel("Home Team :");
		lblHomeTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblHomeTeam.setBounds(364, 41, 97, 16);
		panel_4.add(lblHomeTeam);
		
		JLabel lblAwayTeam = new JLabel("Away Team :");
		lblAwayTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAwayTeam.setBounds(52, 93, 111, 16);
		panel_4.add(lblAwayTeam);
		
		JLabel lblNewLabel_2 = new JLabel("Score :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(364, 94, 61, 16);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblHtGoals = new JLabel("HT Goals :");
		lblHtGoals.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblHtGoals.setBounds(52, 148, 85, 16);
		panel_4.add(lblHtGoals);
		
		JLabel lblAtGoals = new JLabel("AT Goals :");
		lblAtGoals.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAtGoals.setBounds(364, 149, 79, 16);
		panel_4.add(lblAtGoals);
		
		JLabel lblResult = new JLabel("Result :");
		lblResult.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblResult.setBounds(52, 206, 61, 16);
		panel_4.add(lblResult);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDate.setBounds(364, 207, 61, 16);
		panel_4.add(lblDate);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_21.setBounds(175, 36, 130, 26);
		panel_4.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_22.setBounds(488, 36, 130, 26);
		panel_4.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_23.setBounds(175, 89, 130, 26);
		panel_4.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_24.setBounds(488, 89, 130, 26);
		panel_4.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_25.setBounds(175, 144, 130, 26);
		panel_4.add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_26.setBounds(488, 144, 130, 26);
		panel_4.add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_27.setBounds(175, 202, 130, 26);
		panel_4.add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_28.setBounds(488, 202, 130, 26);
		panel_4.add(textField_28);
		textField_28.setColumns(10);
		
		JButton btnSubmit_3 = new JButton("Submit");
		btnSubmit_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query1 = "insert into match_info values(?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query1);
					pst.setString(1,textField_21.getText());
					pst.setString(2,textField_25.getText());
					pst.setString(3,textField_26.getText());
					pst.setString(4,textField_24.getText());
					pst.setString(5,textField_27.getText());
					pst.setString(6,textField_28.getText());
					
					pst.execute();
					
					String query2 = "insert into plays values(?,?,?)";
					
					PreparedStatement pst2 = conn.prepareStatement(query2);
					
					pst2.setString(1,textField_21.getText());
					pst2.setString(2,textField_22.getText());
					pst2.setString(3,textField_23.getText());
					
					pst2.execute();
					
					String query3 = "select * from match_info natural join plays ";
					PreparedStatement pst3 = conn.prepareStatement(query3);
				
					ResultSet rs1 = pst3.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				
					
					textField_21.setText("");
					textField_22.setText("");
					textField_23.setText("");
					textField_24.setText("");
					textField_25.setText("");
					textField_26.setText("");
					textField_27.setText("");
					textField_28.setText("");
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnSubmit_3.setBounds(201, 266, 130, 42);
		panel_4.add(btnSubmit_3);
		
		JButton btnReturn_3 = new JButton("Return");
		btnReturn_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
			}
		});
		btnReturn_3.setBounds(364, 266, 130, 42);
		panel_4.add(btnReturn_3);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("League", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblSeason = new JLabel("Season :");
		lblSeason.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSeason.setBounds(50, 36, 61, 16);
		panel_5.add(lblSeason);
		
		JLabel lblPosition_1 = new JLabel("Position :");
		lblPosition_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPosition_1.setBounds(269, 36, 76, 16);
		panel_5.add(lblPosition_1);
		
		JLabel lblTeamId_3 = new JLabel("Team Id :");
		lblTeamId_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamId_3.setBounds(487, 36, 76, 16);
		panel_5.add(lblTeamId_3);
		
		JLabel lblMatchesPlayed = new JLabel("Plays :");
		lblMatchesPlayed.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblMatchesPlayed.setBounds(50, 104, 61, 16);
		panel_5.add(lblMatchesPlayed);
		
		textField_29 = new JTextField();
		textField_29.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_29.setBounds(115, 31, 130, 26);
		panel_5.add(textField_29);
		textField_29.setColumns(10);
		
		JLabel lblWins = new JLabel("Wins :");
		lblWins.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWins.setBounds(269, 104, 61, 16);
		panel_5.add(lblWins);
		
		JLabel lblDraws = new JLabel("Draws :");
		lblDraws.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDraws.setBounds(487, 104, 61, 16);
		panel_5.add(lblDraws);
		
		JLabel lblLoses = new JLabel("Loses :");
		lblLoses.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLoses.setBounds(50, 163, 61, 16);
		panel_5.add(lblLoses);
		
		JLabel lblGoalsFor = new JLabel("GF :");
		lblGoalsFor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblGoalsFor.setBounds(269, 163, 55, 16);
		panel_5.add(lblGoalsFor);
		
		JLabel lblGoalsAgainst = new JLabel("GA :");
		lblGoalsAgainst.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblGoalsAgainst.setBounds(487, 164, 37, 16);
		panel_5.add(lblGoalsAgainst);
		
		JLabel lblPoints = new JLabel("Points :");
		lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPoints.setBounds(50, 234, 61, 16);
		panel_5.add(lblPoints);
		
		JButton btnSubmit_4 = new JButton("Submit");
		btnSubmit_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into league values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField_29.getText());
					pst.setString(2,textField_30.getText());
					pst.setString(3,textField_31.getText());
					pst.setString(4,textField_32.getText());
					pst.setString(5,textField_33.getText());
					pst.setString(6,textField_34.getText());
					pst.setString(7,textField_35.getText());
					pst.setString(8,textField_36.getText());
					pst.setString(7,textField_37.getText());
					pst.setString(8,textField_38.getText());
					
					pst.execute();
				
					pst.close();
					
					String query2 = "select * from league ";
					PreparedStatement pst2 = conn.prepareStatement(query2);
				
					ResultSet rs1 = pst2.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
					textField_29.setText("");
					textField_30.setText("");
					textField_31.setText("");
					textField_32.setText("");
					textField_33.setText("");
					textField_34.setText("");
					textField_35.setText("");
					textField_36.setText("");
					textField_37.setText("");
					textField_38.setText("");
					
			
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
				
			}
		});
		btnSubmit_4.setBounds(342, 258, 138, 50);
		panel_5.add(btnSubmit_4);
		
		JButton btnReturn_4 = new JButton("Return");
		btnReturn_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
				
			}
		});
		btnReturn_4.setBounds(547, 258, 138, 50);
		panel_5.add(btnReturn_4);
		
		textField_30 = new JTextField();
		textField_30.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_30.setBounds(342, 31, 130, 26);
		panel_5.add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_31.setBounds(560, 31, 130, 26);
		panel_5.add(textField_31);
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_32.setBounds(115, 99, 130, 26);
		panel_5.add(textField_32);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_33.setBounds(345, 100, 130, 26);
		panel_5.add(textField_33);
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_34.setBounds(560, 94, 130, 26);
		panel_5.add(textField_34);
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_35.setBounds(115, 158, 130, 26);
		panel_5.add(textField_35);
		textField_35.setColumns(10);
		
		textField_36 = new JTextField();
		textField_36.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_36.setBounds(321, 159, 130, 26);
		panel_5.add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_37.setBounds(560, 159, 130, 26);
		panel_5.add(textField_37);
		textField_37.setColumns(10);
		
		textField_38 = new JTextField();
		textField_38.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_38.setBounds(128, 229, 130, 26);
		panel_5.add(textField_38);
		textField_38.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 442, 775, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
