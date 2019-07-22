import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
public class Modify extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify frame = new Modify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;

	/**
	 * Create the frame.
	 */
	public Modify() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome w = new Welcome();
				w.setVisible(true);
			}
		});
		btnSearch.setBounds(66, 215, 108, 64);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add w = new Add();
				w.setVisible(true);
				dispose();	
			}
		});
		btnAdd.setBounds(248, 215, 124, 64);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Del w = new Del();
				w.setVisible(true);
				dispose();
			}
		});
		btnDelete.setBounds(437, 214, 124, 65);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update w = new Update();
				w.setVisible(true);
				dispose();
			}
		});
		btnUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnUpdate.setBounds(647, 215, 124, 64);
		contentPane.add(btnUpdate);
		
		JLabel lblWelcomeAdministrator = new JLabel("Welcome Administrator");
		lblWelcomeAdministrator.setForeground(Color.RED);
		lblWelcomeAdministrator.setFont(new Font("PT Serif", Font.BOLD, 50));
		lblWelcomeAdministrator.setBounds(140, 51, 590, 77);
		contentPane.add(lblWelcomeAdministrator);
		
		
	
	}
}
