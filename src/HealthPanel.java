import java.awt.BorderLayout;
import java.util.Properties;
import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class HealthPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthPanel frame = new HealthPanel();
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
  private JButton btnLogOut;
  private JLabel label;
  private JLabel label_1;
  private JLabel lblHealthInformation;
	/**
	 * Create the frame.
	 */
	public HealthPanel() {
		setTitle("Health Information");
		conn=MysqlConnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setForeground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(122, 199, 188, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNid = new JLabel("NID: ");
		lblNid.setBounds(23, 202, 46, 14);
		contentPane.add(lblNid);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 245, 188, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProblem = new JLabel("Problem:");
		lblProblem.setBounds(23, 248, 59, 14);
		contentPane.add(lblProblem);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 298, 188, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHospitalName = new JLabel("Hospital Name:");
		lblHospitalName.setBounds(10, 301, 91, 14);
		contentPane.add(lblHospitalName);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 354, 188, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDa = new JLabel("Date:");
		lblDa.setBounds(10, 357, 46, 14);
		contentPane.add(lblDa);
		
		textField_4 = new JTextField();
		textField_4.setBounds(122, 395, 188, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDoctorName = new JLabel("Doctor Name:");
		lblDoctorName.setBounds(10, 398, 91, 14);
		contentPane.add(lblDoctorName);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(248, 248, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into health_table (problem,hospital_name,date,doctor_name,citizen_nid) values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					
					
					pst.setString(1, textField_1.getText());
					pst.setString(2,textField_2.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4,textField_4.getText());
					pst.setString(5,textField.getText());
					
					pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data is saved");
					pst.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnNewButton.setBounds(384, 243, 188, 23);
		contentPane.add(btnNewButton);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBackground(new Color(248, 248, 255));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogOut.setForeground(new Color(0, 0, 128));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login adPanel = new Login();
				adPanel.setVisible(true);
			
			}
		});
		btnLogOut.setBounds(384, 296, 188, 23);
		contentPane.add(btnLogOut);
		
		label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bdlogo.png")).getImage(); //code for login icon (line 1)
		label.setIcon(new ImageIcon(img1)); //code for login icon (line 2)
		label.setBounds(0, 0, 188, 170);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/1.png")).getImage(); //code for login icon (line 1)
		label_1.setIcon(new ImageIcon(img2)); //code for login icon (line 2)
		
		label_1.setBounds(206, 21, 419, 73);
		contentPane.add(label_1);
		
		lblHealthInformation = new JLabel("HEALTH  INFORMATION");
		lblHealthInformation.setForeground(new Color(25, 25, 112));
		lblHealthInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHealthInformation.setBounds(232, 120, 192, 30);
		contentPane.add(lblHealthInformation);
	}
}
