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

public class HSCPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HSCPanel frame = new HSCPanel();
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
    private JTextField textField_6;
    private JButton btnNewButton_1;
    
	/**
	 * Create the frame.
	 */
	public HSCPanel() {
		setTitle("HSC Information\r\n");
	    conn=MysqlConnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setForeground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(146, 204, 205, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblid = new JLabel("NID:");
		lblid.setBounds(26, 207, 46, 14);
		contentPane.add(lblid);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 255, 205, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblregistationno = new JLabel("Registation no:");
		lblregistationno.setBounds(26, 258, 110, 14);
		contentPane.add(lblregistationno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 314, 205, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lbldepartment = new JLabel("Department");
		lbldepartment.setBounds(26, 317, 101, 14);
		contentPane.add(lbldepartment);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 365, 205, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblgpa = new JLabel("GPA");
		lblgpa.setBounds(26, 368, 46, 14);
		contentPane.add(lblgpa);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 414, 205, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblboard = new JLabel("BOARD");
		lblboard.setBounds(26, 417, 83, 14);
		contentPane.add(lblboard);
		
		textField_5 = new JTextField();
		textField_5.setBounds(146, 460, 205, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblyear = new JLabel("YEAR");
		lblyear.setBounds(26, 463, 46, 14);
		contentPane.add(lblyear);
		
		textField_6 = new JTextField();
		textField_6.setBounds(146, 507, 205, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblinstitute = new JLabel("Institute");
		lblinstitute.setBounds(26, 510, 83, 14);
		contentPane.add(lblinstitute);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into hsc (citizen_nid,registation_no,department,gpa,board,year,institute) values(?,?,?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.setString(1,textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7,textField_6.getText());
					
					
					
					pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data is saved");
					pst.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}

			}
		});
		btnNewButton.setBounds(450, 313, 241, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EducationPanel adPanel = new EducationPanel();
				adPanel.setVisible(true);
			
			}
		});
		btnNewButton_1.setBounds(450, 384, 241, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bdlogo.png")).getImage(); //code for login icon (line 1)
		label.setIcon(new ImageIcon(img1)); //code for login icon (line 2)
		
		label.setBounds(0, 0, 195, 179);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/1.PNG")).getImage(); //code for login icon (line 1)
		label_1.setIcon(new ImageIcon(img2)); //code for login icon (line 2)
		
		label_1.setBounds(205, 32, 415, 69);
		contentPane.add(label_1);
		
		JLabel lblSscPanel = new JLabel("HIGHER  SECONDARY  SCHOOL  CERTIFICATE (HSC)");
		lblSscPanel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSscPanel.setBounds(205, 112, 357, 51);
		
		contentPane.add(lblSscPanel);
		
	}
}
