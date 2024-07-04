package assessment_2329760.auth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assessment_2329760.databaseTables.AvailableCourses;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField name_text;
	private JTextField courseId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static boolean checkEmailValidity(String email) {
		String emailCheck = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(emailCheck);
	}
	private static boolean checkPwdValidity(String pswd) {
		String pswdCheck="^(?=.*[0-9])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$";
		return pswd.matches(pswdCheck);
	}
	
	public static boolean checkEmail(String email) {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM logins WHERE email=?"))
		{
			stmnt.setString(1, email);
			ResultSet resSet = stmnt.executeQuery();
			return resSet.next();
			
		    }
		catch(SQLException e) {
			e.printStackTrace();
			return false;
			}
	}
	
	public static boolean insertStudent(String name, String email, String password,String courseId ,String role) {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				PreparedStatement stmnt = conn.prepareStatement("INSERT INTO logins (name, email, password,studentCourseId ,role) VALUES (?,?,?,?,?)"))
		{
			stmnt.setString(1, name);
			stmnt.setString(2, email);
			stmnt.setString(3, password);
			stmnt.setString(4, courseId);
			stmnt.setString(5, role);
			stmnt.executeUpdate();
			return true;
			
		    }
		catch(SQLException e) {
			e.printStackTrace();
			return false;
			}
	}

	/**
	 * Create the frame.
	 */
	public Signup() {
		setTitle("Student Signup");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 446, 646);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Sign up");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(103, 10, 247, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(10, 165, 81, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password: (Eg: sfkj@34)");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(10, 317, 301, 31);
		panel.add(lblNewLabel_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtEmail.setToolTipText("");
		txtEmail.setBounds(10, 206, 426, 38);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('x');
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		passwordField.setBounds(10, 358, 426, 38);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_1_1.setBounds(10, 404, 301, 31);
		panel.add(lblNewLabel_1_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		passwordField_1.setEchoChar('x');
		passwordField_1.setBounds(10, 445, 426, 38);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Role:");
		lblNewLabel_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_2.setBounds(10, 276, 67, 31);
		panel.add(lblNewLabel_1_2);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Student", "Teacher"}));
		comboBox.setBounds(87, 269, 349, 38);
		panel.add(comboBox);
		
		JLabel name_label = new JLabel("Name:");
		name_label.setForeground(SystemColor.textHighlight);
		name_label.setFont(new Font("Times New Roman", Font.BOLD, 26));
		name_label.setBounds(10, 76, 81, 31);
		panel.add(name_label);
		
		name_text = new JTextField();
		name_text.setToolTipText("");
		name_text.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		name_text.setColumns(10);
		name_text.setBounds(10, 117, 426, 38);
		panel.add(name_text);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Course ID:");
		lblNewLabel_1_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_2_1.setBounds(169, 508, 126, 31);
		panel.add(lblNewLabel_1_2_1);
		
		courseId = new JTextField();
		courseId.setToolTipText("");
		courseId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		courseId.setColumns(10);
		courseId.setBounds(305, 506, 131, 38);
		panel.add(courseId);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("For Student*");
		lblNewLabel_1_2_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_2_1_1.setBounds(10, 508, 149, 31);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Click here for available Courses Course Id References");
		lblNewLabel_1_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Courses Table
				AvailableCourses courses = new AvailableCourses();
				courses.setVisible(true);
				
				
			}
		});
		lblNewLabel_1_2_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(10, 545, 340, 31);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = name_text.getText();
				String email = txtEmail.getText();
				String role = (String) comboBox.getSelectedItem();
				String pswd = new String(passwordField.getPassword());
				String confPswd = new String(passwordField_1.getPassword());
				String course = courseId.getText();
				
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(name_text, "Name field cannot be empty! ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if (!checkEmailValidity(email)) {
					JOptionPane.showMessageDialog(txtEmail, "Invalid email!\nEmail format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!checkPwdValidity(pswd)) {
					JOptionPane.showMessageDialog(passwordField, "Invalid Password Format!\nCorrect format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!(pswd.equals(confPswd))){
					JOptionPane.showMessageDialog(passwordField_1, "Wrong Password Re-entered!\nPlease confirm similar password.", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if(checkEmail(email)) {
					JOptionPane.showMessageDialog(txtEmail, "Email has been in use already. Re enter your email please. ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if(!(insertStudent(name, email,pswd,course ,role))){
					JOptionPane.showMessageDialog(passwordField, "Couldn't signup. Signup Failed!", "Signup Failed!", JOptionPane.WARNING_MESSAGE);
					return;
					
				}
				JOptionPane.showMessageDialog(passwordField, "Sign up Successful. You can now login, but your Dashboard gets Running only after Administrator approves your registration.", "Signup Successful!", JOptionPane.PLAIN_MESSAGE);

				
			}
		});
		
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(157, 586, 135, 50);
		panel.add(btnNewButton);
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Already Have account?");
		lblNewLabel_1_1_1_1.setBounds(95, 666, 278, 31);
		lblNewLabel_1_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(188, 707, 70, 31);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setForeground(SystemColor.activeCaption);
	}
}
/*
public void actionPerformed(ActionEvent e) {
	
	String email = txtEmail.getText();
	String role = (String) comboBox.getSelectedItem();
	String pswd = new String(passwordField.getPassword());
	String confPswd = new String(passwordField_1.getPassword());
	if (!checkEmailValidity(email)) {
		JOptionPane.showMessageDialog(txtEmail, "Invalid email!\nEmail format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
		return;
	}
	if (!checkPwdValidity(pswd)) {
		JOptionPane.showMessageDialog(passwordField, "Invalid Password Format!\nCorrect format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
		return;
	}
	if(!(pswd.equals(confPswd))){
		JOptionPane.showMessageDialog(passwordField_1, "Wrong Password Re-entered!\nPlease confirm similar password.", "Warning", JOptionPane.WARNING_MESSAGE);
		return;
	}

	if(checkEmail(email)) {
		JOptionPane.showMessageDialog(txtEmail, "Email has been in use already. Re enter your email please. ", "Warning", JOptionPane.WARNING_MESSAGE);
		return;
	}

	if(!(insertStudent(email,pswd,role))){
		JOptionPane.showMessageDialog(passwordField, "Couldn't signup. Signup Failed!", "Signup Failed!", JOptionPane.WARNING_MESSAGE);
		return;
		
	}
	JOptionPane.showMessageDialog(passwordField, "Sign up Successful. You can now login", "Signup Successful!", JOptionPane.PLAIN_MESSAGE);

	
}
*/

// New


/*

public void actionPerformed(ActionEvent e) {
				String name = name_text.getText();
				String email = txtEmail.getText();
				String role = (String) comboBox.getSelectedItem();
				String pswd = new String(passwordField.getPassword());
				String confPswd = new String(passwordField_1.getPassword());
				
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(name_text, "Name field cannot be empty! ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if (!checkEmailValidity(email)) {
					JOptionPane.showMessageDialog(txtEmail, "Invalid email!\nEmail format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!checkPwdValidity(pswd)) {
					JOptionPane.showMessageDialog(passwordField, "Invalid Password Format!\nCorrect format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!(pswd.equals(confPswd))){
					JOptionPane.showMessageDialog(passwordField_1, "Wrong Password Re-entered!\nPlease confirm similar password.", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if(checkEmail(email)) {
					JOptionPane.showMessageDialog(txtEmail, "Email has been in use already. Re enter your email please. ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if(!(insertStudent(name, email,pswd,role))){
					JOptionPane.showMessageDialog(passwordField, "Couldn't signup. Signup Failed!", "Signup Failed!", JOptionPane.WARNING_MESSAGE);
					return;
					
				}
				JOptionPane.showMessageDialog(passwordField, "Sign up Successful. You can now login", "Signup Successful!", JOptionPane.PLAIN_MESSAGE);

				
			}


*/