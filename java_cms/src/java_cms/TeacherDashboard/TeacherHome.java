package assessment_2329760.TeacherDashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import assessment_2329760.auth.Login;
import assessment_2329760.rolesTask.TeachersTasks;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class TeacherHome extends JFrame {
	static String teacherEmail;
	

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
					TeachersTasks tut = new TeachersTasks("teacher");
					tut.connectToDatabase();
					
					TeacherHome frame = new TeacherHome(teacherEmail);
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
	public TeacherHome(String email) {
		String name = TeachersTasks.getEmailsName(email);
		
		
		
		setResizable(false);
		setTitle("Teacher Dashboard-Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1446, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 370, 711);
		panel_1.setForeground(SystemColor.inactiveCaption);
		panel_1.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(TeacherHome.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Home
			}
		});
		btnNewButton.setBounds(0, 357, 360, 167);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel_1.add(btnNewButton);
		
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setIcon(new ImageIcon(TeacherHome.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Students
				TeachersStudent tstuds = new TeachersStudent(email);
				tstuds.setVisible(true);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("TEACHER");
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 62));
		lblNewLabel_1_1.setBounds(10, 22, 330, 110);
		panel_3_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(email);
		lblNewLabel_1_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblNewLabel_1_1_1.setBounds(10, 142, 330, 80);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(name);
		lblNewLabel_1_1_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblNewLabel_1_1_1_1.setBounds(10, 232, 330, 80);
		panel_3_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(390, 10, 1032, 718);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMyModules = new JLabel("My Modules");
		lblMyModules.setIcon(new ImageIcon(TeacherHome.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
		lblMyModules.setForeground(SystemColor.textHighlight);
		lblMyModules.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblMyModules.setBounds(10, 201, 247, 50);
		panel.add(lblMyModules);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.info);
		panel_2.setBounds(10, 10, 1012, 180);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(email);
		lblNewLabel.setIcon(new ImageIcon(TeacherHome.class.getResource("/assessment_2329760/pngImages/mailIcon.png")));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 10, 664, 79);
		panel_2.add(lblNewLabel);
		
		JLabel lblMeroNaam = new JLabel(name);
		lblMeroNaam.setIcon(new ImageIcon(TeacherHome.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
		lblMeroNaam.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblMeroNaam.setBounds(10, 91, 664, 79);
		panel_2.add(lblMeroNaam);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setIcon(new ImageIcon(TeacherHome.class.getResource("/assessment_2329760/pngImages/LogoutIcon.png")));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
		btnLogOut.setForeground(SystemColor.text);
		btnLogOut.setBackground(new Color(100, 149, 237));
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnLogOut.setBounds(728, 3, 274, 167);
		panel_2.add(btnLogOut);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 308, 1012, 400);
		// table update
		TeachersTasks.updateTableMyModules(table, email);
		panel.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 274, 1012, 36);
		panel.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Module ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(201, 0, 113, 26);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblCourseName = new JLabel("Module Name");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(654, 0, 134, 26);
		panel_3.add(lblCourseName);
	}
}
