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

public class DegreePanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DegreePanel frame = new DegreePanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Connection conn=null;
     private JTextField textField;
     private JTextField textField_1;
     private JTextField textField_2;
     private JTextField textField_3;
     private JTextField textField_4;
     private JTextField textField_5;
	/**
	 * Create the frame.
	 */
	public DegreePanel() {
		setTitle("Degree Information");
		conn=MysqlConnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(146, 193, 272, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(46, 196, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 236, 272, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Registation No:");
		lblNewLabel_1.setBounds(46, 239, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 282, 272, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Department:");
		lblNewLabel_2.setBounds(46, 280, 90, 25);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 329, 272, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CGPA:");
		lblNewLabel_3.setBounds(46, 332, 78, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 370, 272, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Year:");
		lblNewLabel_4.setBounds(46, 373, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(146, 412, 272, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Institute:");
		lblNewLabel_5.setBounds(40, 415, 78, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Degree Type:");
		lblNewLabel_6.setBounds(40, 447, 95, 14);
		contentPane.add(lblNewLabel_6);
		
		JComboBox degreeCombo = new JComboBox();
		degreeCombo.setBounds(146, 443, 272, 22);
		contentPane.add(degreeCombo);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(248, 248, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into degree (citizen_nid,registation_no,department,cgpa,year,institute,degree_type) values(?,?,?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.setString(1,textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7,degreeCombo.getSelectedItem().toString());
				
					pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data is saved");
					pst.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnNewButton.setBounds(465, 216, 162, 23);
		contentPane.add(btnNewButton);
		
		degreeCombo.addItem("B.Sc");
		degreeCombo.addItem("MBA");
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBackground(new Color(248, 248, 255));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EducationPanel adPanel = new EducationPanel();
				adPanel.setVisible(true);
			}
		});
		btnLogOut.setBounds(465, 259, 162, 23);
		contentPane.add(btnLogOut);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bdlogo.PNG")).getImage(); //code for login icon (line 1)
		label.setIcon(new ImageIcon(img1)); //code for login icon (line 2)
		
		label.setBounds(0, 0, 198, 172);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/1.PNG")).getImage(); //code for login icon (line 1)
		label_1.setIcon(new ImageIcon(img2)); //code for login icon (line 2)
		
		label_1.setBounds(233, 21, 411, 66);
		contentPane.add(label_1);
		
		JLabel lblHealthIsWelth = new JLabel("DEGREE INFORMATION\r\n");
		lblHealthIsWelth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHealthIsWelth.setBounds(347, 98, 291, 36);
		contentPane.add(lblHealthIsWelth);
	}
}
