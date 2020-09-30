import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;

public class AddUser extends JFrame {

	private JPanel contentPane;
	MysqlConnect db=new MysqlConnect();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conn=null;
	private JTextField textField_3;
	public AddUser() {
		setTitle("Add User");
		conn=MysqlConnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("User name");
		name.setForeground(new Color(255, 255, 255));
		name.setBounds(252, 180, 207, 20);
		contentPane.add(name);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(252, 248, 207, 20);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Password");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setBounds(252, 316, 207, 20);
		contentPane.add(lblPhone);
		
		textField = new JTextField();
		textField.setBounds(252, 211, 229, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 279, 229, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(252, 347, 229, 26);
		contentPane.add(textField_2);
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(new Color(255, 255, 255));
		lblType.setBounds(252, 374, 207, 20);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "USER", "EDUCATION", "HEALTH", "ADMIN"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(252, 405, 229, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login adPanel = new Login();
				adPanel.setVisible(true);

			}
		});
		btnNewButton.setBounds(252, 451, 83, 29);
		contentPane.add(btnNewButton);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setForeground(new Color(0, 0, 128));
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try {
					String query="insert into user (name,email,password,user_type,citizen_nid) values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.setString(1,textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4,comboBox.getSelectedItem().toString());

					pst.setString(5, textField_3.getText());
					pst.executeUpdate();

					pst.close();
					JOptionPane.showMessageDialog(null, "Apply successfully");
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnApply.setBounds(366, 451, 115, 29);
		contentPane.add(btnApply);
		
		JLabel label = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/bdlogo.PNG")).getImage(); //code for login icon (line 1)
		label.setIcon(new ImageIcon(img2)); //code for login icon (line 2)
		
		label.setBounds(0, 0, 195, 185);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/1.PNG")).getImage(); //code for login icon (line 1)
		label_1.setIcon(new ImageIcon(img3)); //code for login icon (line 2)
		
		label_1.setBounds(237, 24, 415, 63);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(252, 153, 229, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNid = new JLabel("NID");
		lblNid.setForeground(Color.WHITE);
		lblNid.setBounds(252, 128, 46, 14);
		contentPane.add(lblNid);
	}
}
