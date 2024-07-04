package assessment_2329760.AdminDashBoard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assessment_2329760.auth.Login;
import assessment_2329760.rolesTask.AdminTasks;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AdminHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		int courseCount = AdminTasks.getCourseCount();
		int modulesCount = AdminTasks.getModulesCount();
		int teacherCount = AdminTasks.getTeacherCount();
		int studentCount = AdminTasks.getStudentCount();
		
		
		
		setTitle("Admin DashBoard-Home");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1363, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setForeground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 10, 370, 721);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// home
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(0, 216, 360, 107);
		panel_1.add(btnNewButton);
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/courses.png")));
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminCourses courses = new AdminCourses();
				courses.setVisible(true);
				setVisible(false);
				
			}
		});
		btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnCourses.setBounds(0, 333, 360, 87);
		panel_1.add(btnCourses);
		
		JButton btnModules = new JButton("Modules");
		btnModules.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
		btnModules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// modules
				AdminModules modules = new AdminModules();
				modules.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnModules.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnModules.setBounds(0, 430, 360, 87);
		panel_1.add(btnModules);
		
		JButton btnTeachers = new JButton("Teachers");
		btnTeachers.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// teachers
				AdminTeachers adTeachers = new AdminTeachers();
				adTeachers.setVisible(true);
				setVisible(false);
				
			}
		});
		btnTeachers.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnTeachers.setBounds(0, 527, 360, 87);
		panel_1.add(btnTeachers);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// students
				AdminStudents dbStudents= new AdminStudents();
				dbStudents.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnStudents.setBounds(0, 624, 360, 87);
		panel_1.add(btnStudents);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(10, 10, 350, 156);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 76));
		lblNewLabel_1.setBounds(10, 22, 330, 110);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(385, 112, 954, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdministratorTasks = new JLabel("Administrators Tasks");
		lblAdministratorTasks.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/Admin Dashboard.png")));
		lblAdministratorTasks.setBounds(10, 10, 427, 49);
		lblAdministratorTasks.setForeground(SystemColor.windowText);
		lblAdministratorTasks.setFont(new Font("Times New Roman", Font.BOLD, 42));
		panel.add(lblAdministratorTasks);
		
		JLabel lblmanageCourses = new JLabel("- Manage Courses");
		lblmanageCourses.setForeground(SystemColor.windowText);
		lblmanageCourses.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblmanageCourses.setBounds(10, 60, 375, 49);
		panel.add(lblmanageCourses);
		
		JLabel lblManageModules = new JLabel("- Manage Modules");
		lblManageModules.setForeground(SystemColor.windowText);
		lblManageModules.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblManageModules.setBounds(10, 96, 375, 49);
		panel.add(lblManageModules);
		
		JLabel lblManageTeachers = new JLabel("- Manage Teachers");
		lblManageTeachers.setForeground(SystemColor.windowText);
		lblManageTeachers.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblManageTeachers.setBounds(10, 135, 375, 49);
		panel.add(lblManageTeachers);
		
		JLabel lblManageStudents = new JLabel("- Manage Students");
		lblManageStudents.setForeground(SystemColor.windowText);
		lblManageStudents.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblManageStudents.setBounds(10, 174, 375, 49);
		panel.add(lblManageStudents);
		
		JLabel lblUniversityAdministrator = new JLabel("University Administrator");
		lblUniversityAdministrator.setIcon(null);
		lblUniversityAdministrator.setForeground(SystemColor.textHighlight);
		lblUniversityAdministrator.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblUniversityAdministrator.setBounds(390, 37, 487, 43);
		contentPane.add(lblUniversityAdministrator);
		
		JButton btnLogOut_1 = new JButton("Log Out");
		btnLogOut_1.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/LogoutIcon.png")));
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
		btnLogOut_1.setForeground(SystemColor.text);
		btnLogOut_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnLogOut_1.setBackground(new Color(100, 149, 237));
		btnLogOut_1.setBounds(1065, 10, 274, 92);
		contentPane.add(btnLogOut_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(395, 345, 464, 188);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/courses.png")));
		lblCourses.setBounds(112, 10, 202, 49);
		lblCourses.setForeground(SystemColor.windowText);
		lblCourses.setFont(new Font("Times New Roman", Font.BOLD, 42));
		panel_2.add(lblCourses);
		
		JLabel lblAdministratorTasks_1_1 = new JLabel(Integer.toString(courseCount));
		lblAdministratorTasks_1_1.setForeground(SystemColor.windowText);
		lblAdministratorTasks_1_1.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblAdministratorTasks_1_1.setBounds(176, 84, 67, 49);
		panel_2.add(lblAdministratorTasks_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 250, 240));
		panel_2_1.setBounds(875, 345, 464, 188);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblModules = new JLabel("Modules");
		lblModules.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
		lblModules.setForeground(SystemColor.windowText);
		lblModules.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblModules.setBounds(164, 10, 216, 49);
		panel_2_1.add(lblModules);
		
		JLabel lblAdministratorTasks_1_1_1 = new JLabel(Integer.toString(modulesCount));
		lblAdministratorTasks_1_1_1.setForeground(SystemColor.windowText);
		lblAdministratorTasks_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblAdministratorTasks_1_1_1.setBounds(213, 69, 80, 49);
		panel_2_1.add(lblAdministratorTasks_1_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(255, 250, 240));
		panel_2_2.setBounds(875, 543, 464, 188);
		contentPane.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		lblStudents.setForeground(SystemColor.windowText);
		lblStudents.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblStudents.setBounds(147, 10, 201, 49);
		panel_2_2.add(lblStudents);
		
		JLabel lblAdministratorTasks_1_1_1_1 = new JLabel(Integer.toString(studentCount));
		lblAdministratorTasks_1_1_1_1.setForeground(SystemColor.windowText);
		lblAdministratorTasks_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblAdministratorTasks_1_1_1_1.setBounds(214, 84, 103, 49);
		panel_2_2.add(lblAdministratorTasks_1_1_1_1);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(new Color(255, 250, 240));
		panel_2_3.setBounds(390, 543, 464, 188);
		contentPane.add(panel_2_3);
		panel_2_3.setLayout(null);
		
		JLabel lblTeachers = new JLabel("Teachers");
		lblTeachers.setIcon(new ImageIcon(AdminHome.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
		lblTeachers.setForeground(SystemColor.windowText);
		lblTeachers.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblTeachers.setBounds(111, 10, 194, 49);
		panel_2_3.add(lblTeachers);
		
		JLabel lblAdministratorTasks_1_1_1_1_1 = new JLabel(Integer.toString(teacherCount));
		lblAdministratorTasks_1_1_1_1_1.setForeground(SystemColor.windowText);
		lblAdministratorTasks_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblAdministratorTasks_1_1_1_1_1.setBounds(175, 82, 108, 49);
		panel_2_3.add(lblAdministratorTasks_1_1_1_1_1);
	}
}
