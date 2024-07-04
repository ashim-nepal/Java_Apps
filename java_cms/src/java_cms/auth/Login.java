package assessment_2329760.auth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import assessment_2329760.StudentDashboard.StudentHome;
import assessment_2329760.TeacherDashboard.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtEmail;
	private JPasswordField passwordField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	public static boolean checkLogin(String email, String password, String role) {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM logins WHERE email=? AND password=? AND role=?"))
		{
			stmnt.setString(1, email);
			stmnt.setString(2, password);
			stmnt.setString(3, role);
			ResultSet resSet = stmnt.executeQuery();
			return resSet.next();
			
		    }
		catch(SQLException e) {
			e.printStackTrace();
			return false;
			}
	}
	
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("University Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(242, 10, 1, 1);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Student Sign up");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds(103, 10, 247, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setBounds(10, 122, 81, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password: (Eg: sfkj@34)");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(10, 208, 301, 31);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField.setColumns(10);
		textField.setBounds(10, 160, 426, 38);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		passwordField.setEchoChar('x');
		passwordField.setBounds(10, 249, 426, 38);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_1_1.setBounds(10, 303, 301, 31);
		panel.add(lblNewLabel_1_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		passwordField_1.setEchoChar('x');
		passwordField_1.setBounds(10, 344, 426, 38);
		panel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(154, 415, 135, 50);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 446, 453);
		panel_1.setLayout(null);
		contentPane.add(panel_1);
		
		JLabel lblUniversityLogin = new JLabel("University Login");
		lblUniversityLogin.setForeground(SystemColor.textHighlight);
		lblUniversityLogin.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblUniversityLogin.setBounds(94, 10, 258, 50);
		panel_1.add(lblUniversityLogin);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_2.setBounds(10, 122, 81, 31);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel password = new JLabel("Password:");
		password.setForeground(SystemColor.textHighlight);
		password.setFont(new Font("Times New Roman", Font.BOLD, 26));
		password.setBounds(10, 208, 301, 31);
		panel_1.add(password);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 160, 426, 38);
		panel_1.add(txtEmail);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		passwordField_2.setEchoChar('x');
		passwordField_2.setBounds(10, 249, 426, 38);
		panel_1.add(passwordField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Role:");
		lblNewLabel_1_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_1_1_1.setBounds(10, 313, 66, 31);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 26));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Student", "Teacher"}));
		comboBox.setBounds(102, 309, 334, 38);
		panel_1.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String pswd = new String(passwordField_2.getPassword());     
				String role = (String) comboBox.getSelectedItem();
				if (!checkEmailValidity(email)) {
					JOptionPane.showMessageDialog(txtEmail, "Invalid email!\nEmail format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!checkPwdValidity(pswd)) {
					JOptionPane.showMessageDialog(passwordField_2, "Invalid Password Format!\nCorrect format is: ", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(!(checkLogin(email,pswd,role))) {
					JOptionPane.showMessageDialog(passwordField_2, "Couldn't login! Please check your credentials and loin again.", "Login Failed", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(role == "Student") {
					StudentHome stD = new StudentHome(email);
					stD.setVisible(true);
					setVisible(false);
				}
				else if(role == "Teacher") {
					TeacherHome t = new TeacherHome(email);
					t.setVisible(true);
					setVisible(false);
				}
				
				
			}
		});
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnLogin.setBackground(SystemColor.activeCaption);
		btnLogin.setBounds(156, 380, 135, 50);
		panel_1.add(btnLogin);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Create New Account!");
		lblNewLabel_1_1_1_1_1.setBounds(118, 484, 241, 31);
		lblNewLabel_1_1_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Signup");
		lblNewLabel_2.setBounds(187, 525, 84, 31);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup signup = new Signup();
				signup.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("A");
		lblNewLabel_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin adLogin = new AdminLogin();
				adLogin.setVisible(true);
				setVisible(false);
				
				
			}
		});
		lblNewLabel_1_1_1_1_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_1_1_1_1_1.setBounds(431, 547, 25, 31);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
	}

}
