package assessment_2329760.AdminDashBoard;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assessment_2329760.rolesTask.AdminTasks;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AdminTeachers extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTeachers frame = new AdminTeachers();
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
	public AdminTeachers() {
		setResizable(false);
		setTitle("Admin Dashboard-Teachers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1419, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setForeground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 10, 370, 711);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(AdminTeachers.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// home
				AdminHome home = new AdminHome();
				home.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(0, 206, 360, 107);
		panel_1.add(btnNewButton);
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.setIcon(new ImageIcon(AdminTeachers.class.getResource("/assessment_2329760/pngImages/courses.png")));
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//courses
				AdminCourses courses = new AdminCourses();
				courses.setVisible(true);
				setVisible(false);
				
			}
		});
		btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnCourses.setBounds(0, 323, 360, 87);
		panel_1.add(btnCourses);
		
		JButton btnModules = new JButton("Modules");
		btnModules.setIcon(new ImageIcon(AdminTeachers.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
		btnModules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// modules
				AdminModules modules = new AdminModules();
				modules.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnModules.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnModules.setBounds(0, 420, 360, 87);
		panel_1.add(btnModules);
		
		JButton btnTeachers = new JButton("Teachers");
		btnTeachers.setIcon(new ImageIcon(AdminTeachers.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// teachers
				
			}
		});
		btnTeachers.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnTeachers.setBounds(0, 517, 360, 87);
		panel_1.add(btnTeachers);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setIcon(new ImageIcon(AdminTeachers.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// students
				AdminStudents dbStudents= new AdminStudents();
				dbStudents.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnStudents.setBounds(0, 614, 360, 87);
		panel_1.add(btnStudents);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_4.setBounds(10, 10, 350, 156);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("ADMIN");
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 76));
		lblNewLabel_1_1.setBounds(10, 22, 330, 110);
		panel_4.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(396, 28, 999, 711);
		contentPane.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(22, 58, 967, 643);
		panel_2.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 29, 760, 155);
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		AdminTasks.updateTableTeacherEntry(table);
		panel_2_1.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(935, 10, 22, 394);
		panel_2_1.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 0, 760, 36);
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_2_1.add(panel_3);
		
		JLabel lblAvailability = new JLabel("Email");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability.setBounds(535, 0, 62, 26);
		panel_3.add(lblAvailability);
		
		JLabel lblModuleId = new JLabel("Name");
		lblModuleId.setForeground(Color.WHITE);
		lblModuleId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModuleId.setBounds(148, 0, 62, 26);
		panel_3.add(lblModuleId);
		
		JButton btnAddNew_1 = new JButton("Delete Entry");
		btnAddNew_1.setIcon(null);
		btnAddNew_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminTasks ad = new AdminTasks("Admin");
				ad.deleteEntryTeacher(table);
				ad.updateTableTeacherEntry(table);
				
			}
		});
		btnAddNew_1.setBounds(779, 140, 146, 64);
		btnAddNew_1.setForeground(SystemColor.text);
		btnAddNew_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1.setBackground(SystemColor.activeCaptionText);
		panel_2_1.add(btnAddNew_1);
		
		table_1 = new JTable();
		table_1.setBounds(10, 265, 760, 368);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		AdminTasks.updateTableTeachingTeachers(table_1);
		panel_2_1.add(table_1);
		
		JLabel lblModulesAssignedTeachers = new JLabel("Modules Assigned Teachers");
		lblModulesAssignedTeachers.setForeground(SystemColor.textHighlight);
		lblModulesAssignedTeachers.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblModulesAssignedTeachers.setBounds(10, 194, 427, 43);
		panel_2_1.add(lblModulesAssignedTeachers);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(438, 214, 487, 3);
		panel_2_1.add(panel);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setForeground(Color.WHITE);
		panel_3_1.setBackground(Color.BLACK);
		panel_3_1.setBounds(10, 234, 760, 36);
		panel_2_1.add(panel_3_1);
		
		JLabel lblCourseName_1 = new JLabel("Module Name");
		lblCourseName_1.setForeground(Color.WHITE);
		lblCourseName_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName_1.setBounds(419, 0, 142, 26);
		panel_3_1.add(lblCourseName_1);
		
		JLabel lblAvailability_1 = new JLabel("Name");
		lblAvailability_1.setForeground(Color.WHITE);
		lblAvailability_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability_1.setBounds(637, 0, 62, 26);
		panel_3_1.add(lblAvailability_1);
		
		JLabel lblModuleId_1 = new JLabel("Email");
		lblModuleId_1.setForeground(Color.WHITE);
		lblModuleId_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModuleId_1.setBounds(45, 0, 62, 26);
		panel_3_1.add(lblModuleId_1);
		
		JLabel lblModuleId_1_1 = new JLabel("Module ID");
		lblModuleId_1_1.setForeground(Color.WHITE);
		lblModuleId_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModuleId_1_1.setBounds(217, 0, 111, 26);
		panel_3_1.add(lblModuleId_1_1);
		
		JButton btnAddNew_1_1_1 = new JButton("Delete");
		btnAddNew_1_1_1.setIcon(new ImageIcon(AdminTeachers.class.getResource("/assessment_2329760/pngImages/exitIcon.png")));
		btnAddNew_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminTasks ad = new AdminTasks("Admin");
				ad.deleteTeacherAssigned(table_1);
				ad.updateTableTeachingTeachers(table_1);
			}
		});
		btnAddNew_1_1_1.setForeground(SystemColor.text);
		btnAddNew_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1_1.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1_1.setBounds(780, 413, 145, 64);
		panel_2_1.add(btnAddNew_1_1_1);
		
		JButton btnAddNew_1_2 = new JButton("Assign Module");
		btnAddNew_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminTasks ad= new AdminTasks("Admin");
				ad.confirmModuleAssign(table);
				ad.updateTableTeachingTeachers(table_1);
			}
		});
		btnAddNew_1_2.setForeground(SystemColor.text);
		btnAddNew_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_2.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_2.setBounds(779, 40, 146, 64);
		panel_2_1.add(btnAddNew_1_2);
		
		JLabel lblCurrentCourses = new JLabel("");
		lblCurrentCourses.setForeground(SystemColor.textHighlight);
		lblCurrentCourses.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblCurrentCourses.setBounds(369, 472, 240, 43);
		panel_2.add(lblCurrentCourses);
		
		JLabel lblTeachersManagementWindow = new JLabel("Teachers Management Window");
		lblTeachersManagementWindow.setIcon(new ImageIcon(AdminTeachers.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
		lblTeachersManagementWindow.setForeground(SystemColor.textHighlight);
		lblTeachersManagementWindow.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblTeachersManagementWindow.setBounds(236, 10, 515, 43);
		panel_2.add(lblTeachersManagementWindow);
	}
}
