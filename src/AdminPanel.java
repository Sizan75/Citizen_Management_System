import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javafx.scene.control.TableColumn;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
public class AdminPanel extends JFrame {

	private JPanel contentPane;
	MysqlConnect db = new MysqlConnect();

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField nidField;
	private JTextField fnField;
	private JTextField lnField;
	private JTextField fnidField;
	private JTextField mnidField;
	private JTextField religionField;
	private JTextField textField_6;
	private JTextField searchField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private JTextField addressField;
	private JComboBox bgCombo;
	private final JRadioButton gender = new JRadioButton("Male");
	
	private String genderText = "", marriedText = "";
	private JTable table;
	private String selectedData = null;
	private JTextField textField;

	Connection conn=null;
	public AdminPanel() {
		conn=MysqlConnect.connect();
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Admin Panel");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 623);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bdlogo.png")).getImage(); //code for login icon (line 1)
		label.setIcon(new ImageIcon(img1)); //code for login icon (line 2)
		
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 187, 174);
		contentPane.add(label);

		JLabel lblPeoplesRepublicOf = new JLabel("       GOVERNMENT OF THE PEOPLE\u2019S REPUBLIC OF");
		lblPeoplesRepublicOf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeoplesRepublicOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeoplesRepublicOf.setBounds(201, 0, 422, 57);
		contentPane.add(lblPeoplesRepublicOf);

		JLabel lblNid = new JLabel("NID:");
		lblNid.setBounds(13, 185, 46, 14);
		contentPane.add(lblNid);

		nidField = new JTextField();
		nidField.setBounds(128, 182, 97, 20);
		contentPane.add(nidField);
		nidField.setColumns(10);

		JLabel lblName = new JLabel("first name:");
		lblName.setBounds(13, 216, 71, 14);
		contentPane.add(lblName);

		fnField = new JTextField();
		fnField.setBounds(128, 213, 97, 20);
		contentPane.add(fnField);
		fnField.setColumns(10);

		JLabel lblDateOfBirth = new JLabel("last name:");
		lblDateOfBirth.setBounds(13, 247, 71, 14);
		contentPane.add(lblDateOfBirth);

		lnField = new JTextField();
		lnField.setBounds(128, 244, 97, 20);
		contentPane.add(lnField);
		lnField.setColumns(10);

		JLabel lblDateOfBirth_1 = new JLabel("Date of Birth:");
		lblDateOfBirth_1.setBounds(13, 272, 80, 14);
		contentPane.add(lblDateOfBirth_1);

		JComboBox yearCombo = new JComboBox();
		yearCombo.setModel(new DefaultComboBoxModel(new String[] {"", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"}));
		yearCombo.setBounds(128, 293, 74, 22);
		contentPane.add(yearCombo);

		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(38, 297, 46, 14);
		contentPane.add(lblYear);

		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(38, 330, 46, 14);
		contentPane.add(lblMonth);

		JComboBox monthCombo = new JComboBox();
		monthCombo.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		monthCombo.setBounds(128, 326, 74, 22);
		contentPane.add(monthCombo);

		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(38, 363, 46, 14);
		contentPane.add(lblDay);

		JComboBox dayCombo = new JComboBox();
		dayCombo.setBounds(128, 359, 74, 22);
		contentPane.add(dayCombo);

		JLabel lblFathersNid = new JLabel("Father's NID:");
		lblFathersNid.setBounds(550, 395, 100, 14);
		contentPane.add(lblFathersNid);

		fnidField = new JTextField();
		fnidField.setBounds(660, 392, 142, 20);
		contentPane.add(fnidField);
		fnidField.setColumns(10);

		JLabel lblMothersNid = new JLabel("Mother's NID:");
		lblMothersNid.setBounds(550, 426, 100, 14);
		contentPane.add(lblMothersNid);

		mnidField = new JTextField();
		mnidField.setBounds(660, 423, 142, 20);
		contentPane.add(mnidField);
		mnidField.setColumns(10);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(13, 395, 91, 14);
		contentPane.add(lblAddress);

		JLabel lblDivision = new JLabel("Division:");
		lblDivision.setBounds(13, 427, 71, 14);
		contentPane.add(lblDivision);

		JComboBox divisionCombo = new JComboBox();
		divisionCombo.setModel(new DefaultComboBoxModel(new String[] {"", "Dhaka", "Khulna", "Rangpur", "Barishal", "Chittagong", "Sylhet", "Rajshahi"}));
		divisionCombo.setBounds(128, 423, 97, 22);
		contentPane.add(divisionCombo);

		JLabel lblDistrict = new JLabel("District:");
		lblDistrict.setBounds(13, 460, 91, 14);
		contentPane.add(lblDistrict);

		JComboBox districtCombo = new JComboBox();
		districtCombo.setBounds(128, 456, 97, 22);
		contentPane.add(districtCombo);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(13, 485, 71, 14);
		contentPane.add(lblGender);

		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		lblMaritalStatus.setBounds(13, 510, 100, 14);
		contentPane.add(lblMaritalStatus);

		JLabel lblBloodGroup = new JLabel("Blood Group:");
		lblBloodGroup.setBounds(13, 536, 71, 20);
		contentPane.add(lblBloodGroup);

		JLabel lblReligion = new JLabel("Religion:");
		lblReligion.setBounds(552, 363, 71, 14);
		contentPane.add(lblReligion);

		religionField = new JTextField();
		religionField.setBounds(660, 360, 142, 20);
		contentPane.add(religionField);
		religionField.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone: ");
		lblPhoneNumber.setBounds(550, 451, 91, 14);
		contentPane.add(lblPhoneNumber);

		textField_6 = new JTextField();
		textField_6.setBounds(660, 454, 142, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(660, 482, 142, 20);
		contentPane.add(textField);
		textField.setColumns(10);


		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(230, 230, 250));
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String dob = dayCombo.getSelectedItem().toString() + " " + monthCombo.getSelectedItem().toString()
							+ " " + yearCombo.getSelectedItem().toString();
					try {
						SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMM yyyy");
						java.util.Date date = formatter1.parse(dob);
						String reportDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
						dob = reportDate;
					} catch (Exception ex) {
						dob = "0000-00-00";
					}

					String bg = bgCombo.getSelectedItem().toString();
					

					String query="insert into citizen (NID, first_name, last_name, dob, FATHER_NID, MOTHER_NID, GENDER, MARITAL_STATUS, BLOOD_GROUP, RELIGION, PHONE, address, district, division,email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                  
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, nidField.getText());
					pst.setString(2, fnField.getText());
					pst.setString(3, lnField.getText());
					pst.setString(4, dob);
					pst.setString(5,fnidField.getText());
					pst.setString(6,mnidField.getText());
					pst.setString(7,genderText);
					pst.setString(8,marriedText);
					pst.setString(9,bg);
					pst.setString(10,religionField.getText());
					pst.setString(11,textField_6.getText());
					pst.setString(12,addressField.getText());
					pst.setString(13,divisionCombo.getSelectedItem().toString());
					pst.setString(14,districtCombo.getSelectedItem().toString());
					pst.setString(15,textField.getText());
					
					
					
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Data has been saved" );
					
					
			
				    pst.close();
					
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSave.setBounds(514, 534, 89, 23);
		contentPane.add(btnSave);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query = "update citizen set  first_name=?, last_name=?, FATHER_NID=? , MOTHER_NID=?, address=?, RELIGION=?,PHONE=?,email=?,GENDER=?, where NID=? ";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, fnField.getText());
					pst.setString(2, lnField.getText());
					pst.setString(3, fnidField.getText());
					pst.setString(4, mnidField.getText());
					pst.setString(5, addressField.getText());
					pst.setString(6, religionField.getText());
					pst.setString(7, textField_6.getText());
					pst.setString(8, textField.getText());
					pst.setString(9, gender.getText());
					//pst.setString(10, rdbtnMarried.getText());
					pst.setString(10, nidField.getText());
					
					
					
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
		btnUpdate.setBounds(637, 534, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "delete  from citizen where nid=? ";
					
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, nidField.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Data has been deleted");
		            pst.close();		
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnDelete.setBounds(751, 534, 89, 23);
		contentPane.add(btnDelete);

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(396, 142, 59, 14);
		contentPane.add(lblSearch);

		searchField = new JTextField();
				searchField.setBounds(479, 139, 240, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "select * from citizen where nid=?";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, searchField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					
					
					while(rs.next())
					{
						nidField.setText(rs.getString("nid"));
						fnField.setText(rs.getString("first_name"));
						lnField.setText(rs.getString("last_name"));
						fnidField.setText(rs.getString("FATHER_NID"));
						mnidField.setText(rs.getString("MOTHER_NID"));
						addressField.setText(rs.getString("address"));
						religionField.setText(rs.getString("RELIGION"));
						textField_6.setText(rs.getString("PHONE"));
						textField.setText(rs.getString("email"));
					   // gender.setText(rs.getString("GENDER"));
					  String mm=rs.getString("Gender");
						if(mm.equals("male")) {
							gender.setSelected(true);
							rdbtnFemale.setSelected(false);
							rdbtnOthers.setSelected(false);
						}else if(mm.equals("female")) {
							gender.setSelected(false);
							rdbtnFemale.setSelected(true);
							rdbtnOthers.setSelected(false);
						}else if(mm.equals("other")) {
							gender.setSelected(false);
							rdbtnFemale.setSelected(false);
							rdbtnOthers.setSelected(true);
						}
						
						String[] dobData=rs.getString("dob").split("-");
						if(dobData.length==3) {
							yearCombo.setSelectedItem(dobData[0]);
							monthCombo.setSelectedItem(getMonth(dobData[1]));
							dayCombo.setSelectedItem(dobData[2]);
						}
						
						String mmm=rs.getString("MARITAL_STATUS");
						
						if(mmm.toLowerCase().equals("unmarried")) {
							rdbtnUnmarried.setSelected(true);
							rdbtnMarried.setSelected(false);
						}else {
							rdbtnUnmarried.setSelected(false);
							rdbtnMarried.setSelected(true);
						}
						
						if(rs.getString("district")!=null) {
							try {
							districtCombo.setSelectedItem(rs.getString("district"));
							}catch(Exception ex) {}
						}
						if(rs.getString("division")!=null) {
							try {
								divisionCombo.setSelectedItem(rs.getString("division"));
							}catch(Exception ex) {}
						}
					}
					String query1 = "select NID,first_name,phone,email from citizen where nid=?";
					PreparedStatement pst1 = conn.prepareStatement(query1);
					pst1.setString(1, searchField.getText());
					
					ResultSet rs1 = pst1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
					
					
					rs.close();
				    pst.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			
			}});
		btnGo.setBounds(744, 137, 58, 23);
		contentPane.add(btnGo);
		for (int x = 1900; x <= 2018; x++) {
			yearCombo.addItem(x);
		}
		for (int x = 1; x <= 31; x++) {
			dayCombo.addItem(x);
		}

		// month
		monthCombo.addItem("January");
		monthCombo.addItem("February");
		monthCombo.addItem("March");
		monthCombo.addItem("April");
		monthCombo.addItem("May");
		monthCombo.addItem("June");
		monthCombo.addItem("July");
		monthCombo.addItem("August");
		monthCombo.addItem("September");
		monthCombo.addItem("October");
		monthCombo.addItem("November");
		monthCombo.addItem("December");

		// division
		divisionCombo.addItem("Dhaka");
		divisionCombo.addItem("Khulna");
		divisionCombo.addItem("Rangpur");
		divisionCombo.addItem("Barishal");
		divisionCombo.addItem("Chittagong");
		divisionCombo.addItem("Sylhet");
		divisionCombo.addItem("Rajshahi");

		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(128, 392, 97, 20);
		contentPane.add(addressField);
		gender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				genderText = "Male";
			}
		});
		gender.setBounds(128, 485, 59, 20);
		contentPane.add(gender);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(201, 485, 71, 20);
		contentPane.add(rdbtnFemale);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				genderText = "Female";
			}
		});

		JRadioButton rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setBackground(new Color(240, 240, 240));
		rdbtnOthers.setBounds(287, 485, 59, 20);
		contentPane.add(rdbtnOthers);
		rdbtnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				genderText = "Other";
			}
		});

		buttonGroup_1.add(gender);
		buttonGroup_1.add(rdbtnFemale);
		buttonGroup_1.add(rdbtnOthers);

		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marriedText = "Married";
			}
		});
		rdbtnMarried.setBounds(128, 510, 80, 20);
		contentPane.add(rdbtnMarried);

		JRadioButton rdbtnUnmarried = new JRadioButton("Unmarried");
		rdbtnUnmarried.setBounds(222, 510, 98, 20);
		contentPane.add(rdbtnUnmarried);
		rdbtnUnmarried.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marriedText = "Unmarried";
			}
		});

		buttonGroup_2.add(rdbtnMarried);
		buttonGroup_2.add(rdbtnUnmarried);

		 
		bgCombo = new JComboBox();
		bgCombo.setModel(new DefaultComboBoxModel(new String[] {"", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bgCombo.setBounds(128, 537, 142, 20);
		contentPane.add(bgCombo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(447, 185, 515, 116);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomSession cs=new CustomSession();
				cs.clear();
				System.out.println("d");
				dispose();
				Login adPanel = new Login();
				adPanel.setVisible(true);
			}
		});
		btnLogOut.setBounds(831, 135, 115, 29);
		contentPane.add(btnLogOut);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(552, 485, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("BANGLADESH\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(365, 55, 105, 29);
		contentPane.add(lblNewLabel);
		

		divisionCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = divisionCombo.getSelectedIndex();
				districtCombo.removeAllItems();

				if (index == 1) {
					for (String dis : Data.dhakaDivision) {
						districtCombo.addItem(dis);
					}
				} else if (index == 2) {
					for (String dis : Data.khulnaDivision) {
						districtCombo.addItem(dis);
					}
				} else if (index == 3) {
					for (String dis : Data.rangpurDivision) {
						districtCombo.addItem(dis);
					}
				} else if (index == 4) {
					for (String dis : Data.barishalDivision) {
						districtCombo.addItem(dis);
					}
				} else if (index == 5) {
					for (String dis : Data.chittagongDivision) {
						districtCombo.addItem(dis);
					}
				} else if (index == 6) {
					for (String dis : Data.sylhetDivision) {
						districtCombo.addItem(dis);
					}
				} else if (index == 7) {
					for (String dis : Data.rajshahiDivision) {
						districtCombo.addItem(dis);
					}
				}

			}
		});	
	}
	JRadioButton rdbtnFemale = new JRadioButton("Female");
	JRadioButton rdbtnOthers = new JRadioButton("Others");
	JRadioButton rdbtnMarried = new JRadioButton("Married");
	JRadioButton rdbtnUnmarried = new JRadioButton("Unmarried");
	
	private String getMonth(String mm) {
		if(mm.equals("01") | mm.equals("1")) {
			return "January";
		}
		if(mm.equals("02") | mm.equals("2")) {
			return "February";
		}
		if(mm.equals("03") | mm.equals("3")) {
			return "March";
		}
		if(mm.equals("04") | mm.equals("4")) {
			return "April";
		}
		if(mm.equals("05") | mm.equals("5")) {
			return "May";
		}
		if(mm.equals("06") | mm.equals("6")) {
			return "June";
		}
		if(mm.equals("07") | mm.equals("7")) {
			return "July";
		}
		if(mm.equals("08") | mm.equals("8")) {
			return "August";
		}
		if(mm.equals("09") | mm.equals("9")) {
			return "September";
		}
		if(mm.equals("10")) {
			return "October";
		}
		if(mm.equals("11")) {
			return "November";
		}
		if(mm.equals("12")) {
			return "December";
		}
		return "December";
	}
}