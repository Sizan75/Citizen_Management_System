import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class EducationPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EducationPanel frame = new EducationPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	

	/**
	 * Create the frame.
	 */
	public EducationPanel() {
		setTitle("Education Information\r\n");
        conn=MysqlConnect.connect();	

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 321, 782, 78);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(496, 173, 177, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("      NID");
		lblNewLabel.setBounds(400, 177, 55, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setForeground(new Color(25, 25, 112));
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String nid=textField.getText();
				String ssc=comboBox.getSelectedItem().toString();
			    if(ssc=="SSC" ) {
			    	dispose();
					SscPanel adPanel = new SscPanel();
					adPanel.setVisible(true);
			    }else if (ssc=="HSC") {
						dispose();
						HSCPanel adPanel = new HSCPanel();
						adPanel.setVisible(true);
					
					}
			    else if(ssc=="DEGREE") {
					dispose();
					DegreePanel adPanel = new DegreePanel();
					adPanel.setVisible(true);
			    	
			    }
			    }
			
		});
		btnInsert.setBounds(496, 253, 177, 23);
		contentPane.add(btnInsert);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setForeground(new Color(25, 25, 112));
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{   
					String type=comboBox.getSelectedItem().toString();
					if(type=="SSC") {
					String query = "select * from ssc where citizen_nid=?";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, textField.getText());
					
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					rs.close();
				    pst.close();
				}
					else if(type=="HSC") {
						String query = "select * from hsc where citizen_nid=?";
						PreparedStatement pst = conn.prepareStatement(query);
						
						pst.setString(1, textField.getText());
						
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						rs.close();
					    pst.close();
						
					}
					else if(type=="DEGREE") {
						String query = "select * from degree where citizen_nid=?";
						PreparedStatement pst = conn.prepareStatement(query);
						
						pst.setString(1, textField.getText());
						
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						rs.close();
					    pst.close();
					
					}
			    }
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnShow.setBounds(495, 287, 178, 23);
		contentPane.add(btnShow);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "SSC", "HSC", "DEGREE"}));
		comboBox.setBounds(496, 215, 102, 22);
		contentPane.add(comboBox);
		
		label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bdlogo.png")).getImage(); //code for login icon (line 1)
		label.setIcon(new ImageIcon(img1)); //code for login icon (line 2)
		
		label.setBounds(0, 0, 193, 169);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/1.png")).getImage(); //code for login icon (line 1)
		label_1.setIcon(new ImageIcon(img2)); //code for login icon (line 2)
		
		label_1.setBounds(264, 11, 422, 72);
		contentPane.add(label_1);
		
		lblEducationInformation = new JLabel("EDUCATION INFORMATION");
		lblEducationInformation.setForeground(new Color(25, 25, 112));
		lblEducationInformation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEducationInformation.setBounds(310, 105, 307, 23);
		contentPane.add(lblEducationInformation);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login adPanel = new Login();
				adPanel.setVisible(true);
			
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(700, 254, 127, 23);
		contentPane.add(btnNewButton);
	}
	
	JComboBox comboBox = new JComboBox();
	private JLabel label;
	private JLabel label_1;
	private JLabel lblEducationInformation;
	private JScrollPane scrollPane;
}
