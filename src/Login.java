import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

public class Login extends JDialog {

	//static String passingNid=null;
	private final JPanel contentPanel = new JPanel();
   /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 CitizenAccount c=new CitizenAccount();
		
	Connection conn = null;
	private JTextField textField;
	private JPasswordField passwordField;
   /**
	 * Create the dialog.
	 */
	public Login() {
   	setTitle("Login");
		conn = MysqlConnect.connect();
		setBounds(100, 100, 643, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(175, 238, 238));
		contentPanel.setBackground(new Color(175, 238, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Email:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBounds(96, 278, 57, 42);
		contentPanel.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(175, 280, 270, 42);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(96, 347, 69, 29);
		contentPanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 345, 270, 37);
		contentPanel.add(passwordField);
		{
			JButton okButton = new JButton("LOG IN");
			okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			okButton.setBounds(175, 411, 86, 40);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
									
					try {
				        MysqlConnect db = new MysqlConnect();

						String email1 = textField.getText();
						String password1 = passwordField.getText();

						Statement st = db.getStatement();
						ResultSet rs = st.executeQuery(
								"select *from user where email='" + email1 + "' and password='" + password1 + "';");
						if (rs.next()) {
							String type = rs.getString("user_type");
							boolean active = rs.getString("active").toLowerCase().equals("active");
							if (active) {
								CustomSession ss = new CustomSession();
								
								ss.set("type", type);
								ss.set("email", rs.getString("email"));
								if (type.toUpperCase().equals("ADMIN")) {
									dispose();
									AdminPanel adPanel = new AdminPanel();
									adPanel.setVisible(true);
								} else if (type.toUpperCase().equals("USER")) {
									dispose();
									CitizenAccount adPanel = new CitizenAccount();
									adPanel.setVisible(true);
								} else if (type.toUpperCase().equals("EDUCATION")) {
									dispose();
									EducationPanel adPanel = new EducationPanel();
									adPanel.setVisible(true);
								} else if (type.toUpperCase().equals("HEALTH")) {
									dispose();
									HealthPanel adPanel = new HealthPanel();
									adPanel.setVisible(true);
								}
							} else {
								JOptionPane.showMessageDialog(null, "You Are Not Active User", "Message",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Email Or Password Not Match", "Message",
									JOptionPane.INFORMATION_MESSAGE);
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblLogo = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bdlogo.png")).getImage(); //code for login icon (line 1)
		lblLogo.setIcon(new ImageIcon(img1)); //code for login icon (line 2)
		
		lblLogo.setBounds(191, 0, 201, 174);
		contentPanel.add(lblLogo);
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddUser au=new AddUser();
				au.setVisible(true);
			
			}
		});
		btnApply.setBounds(317, 413, 89, 37);
		contentPanel.add(btnApply);
		
		JLabel lblSs = new JLabel("");
		lblSs.setForeground(new Color(175, 238, 238));
		lblSs.setBackground(new Color(175, 238, 238));
		Image img2 = new ImageIcon(this.getClass().getResource("/1.PNG")).getImage(); //code for login icon (line 1)
		lblSs.setIcon(new ImageIcon(img2)); //code for login icon (line 2)
		
		lblSs.setBounds(79, 185, 415, 66);
		contentPanel.add(lblSs);
		//JLabel lblLogo = new JLabel("");
		//Image img2 = new ImageIcon(this.getClass().getResource("/bdLogin.png")).getImage(); //code for login icon (line 1)
			}
}
