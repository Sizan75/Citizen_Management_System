import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import java.util.Properties;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class CitizenAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CitizenAccount frame = new CitizenAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	Connection conn = null;
	private JTextField textField;
	
	
	
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public CitizenAccount() {
		setTitle("Citizen Account");
		conn = MysqlConnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/1.PNG")).getImage(); //code for login icon (line 1)
		label_1.setIcon(new ImageIcon(img2)); //code for login icon (line 2)
		
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(236, 11, 430, 79);
		contentPane.add(label_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 191, 716, 22);
		contentPane.add(menuBar);
		
		JMenu mnBasic = new JMenu("Basic");
		mnBasic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		 		}
		});
		menuBar.add(mnBasic);
		
		JMenuItem mntmBasicInfo = new JMenuItem("Basic Info");
		mntmBasicInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					 String a=textField.getText();
					 
					 String query="select NID,first_name,PHONE,EMAIL from citizen where NID=?";
						PreparedStatement pst1 = conn.prepareStatement(query);
						pst1.setString(1, textField.getText());
						
						ResultSet rs1 = pst1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						
						
						
						rs1.close();
					    pst1.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
			
				}
		});
	
		
		mnBasic.add(mntmBasicInfo);
		
		JMenu mnEducation = new JMenu("Education");
		menuBar.add(mnEducation);
		
		JMenuItem mntmSsc = new JMenuItem("SSC");
		mntmSsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					
					 
					 String query="select registation_no,department,gpa,year,institute from ssc where citizen_nid=?";
						PreparedStatement pst1 = conn.prepareStatement(query);
						pst1.setString(1, textField.getText());
						
						ResultSet rs1 = pst1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						
						
						
						rs1.close();
					    pst1.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
			
			
			}
		});
		mnEducation.add(mntmSsc);
		
		JMenuItem mntmHsc = new JMenuItem("HSC");
		mntmHsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					 String a=textField.getText();
					 
					 String query="select registation_no,department,gpa,year,institute from hsc where citizen_nid=?";
						PreparedStatement pst1 = conn.prepareStatement(query);
						pst1.setString(1, textField.getText());
						
						ResultSet rs1 = pst1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						
						
						
						rs1.close();
					    pst1.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
			
			
			}
		});
		mnEducation.add(mntmHsc);
		
		JMenuItem mntmDegree = new JMenuItem("Degree");
		mntmDegree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					 String a=textField.getText();
					 
					 String query="select registation_no,department,cgpa,year,institute,degree_type from degree where citizen_nid=?";
						PreparedStatement pst1 = conn.prepareStatement(query);
						pst1.setString(1, textField.getText());
						
						ResultSet rs1 = pst1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						
						
						
						rs1.close();
					    pst1.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
			
			
			}
		});
		mnEducation.add(mntmDegree);
		
		JMenu mnHealth = new JMenu("Health");
		menuBar.add(mnHealth);
		
		JMenuItem mntmHealthReports = new JMenuItem("Health reports");
		mntmHealthReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					 String a=textField.getText();
					 
					 String query="select problem,hospital_name,date,doctor_name from health_table where citizen_nid=?";
						PreparedStatement pst1 = conn.prepareStatement(query);
						pst1.setString(1, textField.getText());
						
						ResultSet rs1 = pst1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						
						
						
						rs1.close();
					    pst1.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
			
			
			}
		});
		mnHealth.add(mntmHealthReports);
		
		JLabel lblNid = new JLabel("NID:");
		lblNid.setForeground(new Color(255, 255, 255));
		lblNid.setBounds(20, 290, 46, 14);
		contentPane.add(lblNid);
		
		textField = new JTextField();
		textField.setBounds(76, 287, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bdlogo.png")).getImage(); //code for login icon (line 1)
		label.setIcon(new ImageIcon(img1)); //code for login icon (line 2)
		
		label.setBounds(0, 0, 200, 180);
		contentPane.add(label);
		
		JLabel lblCitizenInformation = new JLabel("CITIZEN INFORMATION ");
		lblCitizenInformation.setForeground(new Color(255, 255, 255));
		lblCitizenInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCitizenInformation.setBounds(246, 101, 298, 33);
		contentPane.add(lblCitizenInformation);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 332, 171, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(20, 335, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(76, 363, 171, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(20, 366, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblMarri = new JLabel("Marital Status:");
		lblMarri.setForeground(new Color(255, 255, 255));
		lblMarri.setBounds(10, 426, 84, 14);
		contentPane.add(lblMarri);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setBounds(112, 422, 78, 23);
		contentPane.add(rdbtnMarried);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		rdbtnSingle.setBounds(211, 422, 62, 23);
		contentPane.add(rdbtnSingle);
		
		JButton btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query = "update citizen set   PHONE=?, email=?  where NID=? ";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, textField_2.getText());
					pst.setString(2, textField_3.getText());
					//pst.setString(3, Field.getText());
					pst.setString(3, textField.getText());
					
					
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Updated successfully");
			
				    pst.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
	
	
			}
		});
		btnUpdateProfile.setForeground(new Color(25, 25, 112));
		btnUpdateProfile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateProfile.setBounds(76, 451, 142, 23);
		contentPane.add(btnUpdateProfile);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 290, 509, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login adPanel = new Login();
				adPanel.setVisible(true);
			
			}
		});
		btnLogout.setForeground(new Color(0, 0, 128));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBounds(757, 22, 115, 33);
		contentPane.add(btnLogout);
		
	}
}


