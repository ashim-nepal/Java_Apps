package assessment_2329760.StudentDashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assessment_2329760.auth.Login;
import assessment_2329760.rolesTask.StudentsTasks;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StudentHome extends JFrame {
	static String studEmail;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					StudentsTasks.connectToDatabase();
					StudentHome frame = new StudentHome(studEmail);
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
	public StudentHome(String email) {
		String level = StudentsTasks.getCurrentLvl(email);
		String name = StudentsTasks.getEmailsName(email) ;
		
		setTitle("Student Dashboard-Home");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1490, 792);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(SystemColor.inactiveCaption);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 10, 370, 711);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(StudentHome.class.getResource("/assessment_2329760/pngImages/courses.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Home
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(0, 357, 360, 167);
		panel_1.add(btnNewButton);
		
		JButton btnStudents = new JButton("My Subjects");
		btnStudents.setIcon(new ImageIcon(StudentHome.class.getResource("/assessment_2329760/pngImages/subjectsIcon.png")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentsSubject stSubs = new StudentsSubject(email);
				stSubs.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnStudents.setBounds(0, 534, 360, 167);
		panel_1.add(btnStudents);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(SystemColor.inactiveCaption);
		panel_3_1.setBounds(10, 10, 350, 323);
		panel_1.add(panel_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("STUDENT");
		lblNewLabel_1_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 62));
		lblNewLabel_1_1_1.setBounds(10, 22, 330, 110);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(email);
		lblNewLabel_1_1_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblNewLabel_1_1_1_1.setBounds(10, 142, 330, 80);
		panel_3_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel(name);
		lblNewLabel_1_1_1_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblNewLabel_1_1_1_1_1.setBounds(10, 232, 330, 80);
		panel_3_1.add(lblNewLabel_1_1_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(385, 10, 1091, 745);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(545, 5, 1, 1);
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.info);
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("email");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 10, 664, 79);
		panel_2.add(lblNewLabel);
		
		JLabel lblMeroNaam = new JLabel((String) null);
		lblMeroNaam.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblMeroNaam.setBounds(10, 91, 664, 79);
		panel_2.add(lblMeroNaam);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(SystemColor.text);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnLogOut.setBackground(new Color(100, 149, 237));
		btnLogOut.setBounds(728, 3, 274, 167);
		panel_2.add(btnLogOut);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(SystemColor.info);
		panel_2_1.setBounds(10, 5, 1071, 180);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(email);
		lblNewLabel_1.setIcon(new ImageIcon(StudentHome.class.getResource("/assessment_2329760/pngImages/mailIcon.png")));
		lblNewLabel_1.setBounds(10, 10, 767, 79);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel_2_1.add(lblNewLabel_1);
		
		JButton btnLogOut_1 = new JButton("Log Out");
		btnLogOut_1.setIcon(new ImageIcon(StudentHome.class.getResource("/assessment_2329760/pngImages/LogoutIcon.png")));
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
				
			}
		});
		btnLogOut_1.setBounds(787, 10, 274, 167);
		btnLogOut_1.setForeground(SystemColor.text);
		btnLogOut_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnLogOut_1.setBackground(new Color(100, 149, 237));
		panel_2_1.add(btnLogOut_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(StudentsTasks.getEmailsName(email));
		lblNewLabel_1_2.setIcon(new ImageIcon(StudentHome.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel_1_2.setBounds(10, 99, 767, 79);
		panel_2_1.add(lblNewLabel_1_2);
		
		JLabel lblMyTeachers = new JLabel("Tutors / Teachers");
		lblMyTeachers.setIcon(new ImageIcon(StudentHome.class.getResource("/assessment_2329760/pngImages/teacherIcon.png")));
		lblMyTeachers.setForeground(SystemColor.textHighlight);
		lblMyTeachers.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblMyTeachers.setBounds(10, 215, 380, 50);
		panel.add(lblMyTeachers);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 323, 1071, 412);
		// table Update
		StudentsTasks.updateTableMyTutorss(table, email, level);
		
		panel.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 288, 1071, 36);
		panel.add(panel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(10, 0, 54, 26);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblCourseName = new JLabel("Module Name");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(594, 0, 134, 26);
		panel_3.add(lblCourseName);
		
		JLabel lblAvailability = new JLabel("Module ID");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability.setBounds(878, 0, 113, 26);
		panel_3.add(lblAvailability);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1_2.setBounds(350, 0, 64, 26);
		panel_3.add(lblNewLabel_1_1_2);
	}
}
