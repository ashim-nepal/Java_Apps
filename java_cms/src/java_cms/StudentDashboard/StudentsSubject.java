package assessment_2329760.StudentDashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assessment_2329760.rolesTask.StudentsTasks;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class StudentsSubject extends JFrame {
	static String studEmail;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsSubject frame = new StudentsSubject(studEmail);
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
	public StudentsSubject(String email) {
		String level = StudentsTasks.getCurrentLvl(email);
		String name = StudentsTasks.getEmailsName(email);
		
		setTitle("Student Dashboard-Teachers");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1488, 787);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(SystemColor.inactiveCaption);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 10, 370, 730);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(StudentsSubject.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Home
				StudentHome stDB = new StudentHome(email);
				stDB.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(0, 357, 360, 167);
		panel_1.add(btnNewButton);
		
		JButton btnStudents = new JButton("My Subjects");
		btnStudents.setIcon(new ImageIcon(StudentsSubject.class.getResource("/assessment_2329760/pngImages/subjectsIcon.png")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Teachers
			}
		});
		btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnStudents.setBounds(0, 553, 360, 167);
		panel_1.add(btnStudents);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(SystemColor.inactiveCaption);
		panel_3_1_1.setBounds(10, 10, 350, 323);
		panel_1.add(panel_3_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("STUDENT");
		lblNewLabel_1_1_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 62));
		lblNewLabel_1_1_1_1.setBounds(10, 22, 330, 110);
		panel_3_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel(email);
		lblNewLabel_1_1_1_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblNewLabel_1_1_1_1_1.setBounds(10, 142, 330, 80);
		panel_3_1_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel(name);
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 232, 330, 80);
		panel_3_1_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(388, 10, 1086, 740);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblModules = new JLabel("Current Modules");
		lblModules.setIcon(new ImageIcon(StudentsSubject.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
		lblModules.setBounds(10, 10, 319, 43);
		lblModules.setForeground(SystemColor.textHighlight);
		lblModules.setFont(new Font("Times New Roman", Font.BOLD, 36));
		panel.add(lblModules);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 106, 1066, 217);
		// update table Modules
		StudentsTasks.updateTableCurrentModules(table, email, level);
		panel.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 73, 1066, 36);
		panel.add(panel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Module ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(97, 0, 113, 26);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblCourseName = new JLabel("Module Name");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(422, 0, 141, 26);
		panel_3.add(lblCourseName);
		
		JLabel lblAvailability = new JLabel("Marks Obtained");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability.setBounds(754, 0, 158, 26);
		panel_3.add(lblAvailability);
		
		JLabel lblOptionalModulesforYear = new JLabel("Optional Modules(for Year 3)");
		lblOptionalModulesforYear.setForeground(SystemColor.textHighlight);
		lblOptionalModulesforYear.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblOptionalModulesforYear.setBounds(10, 342, 463, 43);
		panel.add(lblOptionalModulesforYear);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setForeground(Color.WHITE);
		panel_3_1.setBackground(Color.BLACK);
		panel_3_1.setBounds(10, 437, 883, 36);
		panel.add(panel_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Module ID");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(87, 0, 119, 26);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		JLabel lblCourseName_1 = new JLabel("Course ID");
		lblCourseName_1.setForeground(Color.WHITE);
		lblCourseName_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName_1.setBounds(388, 0, 128, 26);
		panel_3_1.add(lblCourseName_1);
		
		JLabel lblCourseName_1_1 = new JLabel("Course Name");
		lblCourseName_1_1.setForeground(Color.WHITE);
		lblCourseName_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName_1_1.setBounds(677, 0, 128, 26);
		panel_3_1.add(lblCourseName_1_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table_1.setBounds(10, 471, 883, 259);
		// Add optional in sem 1
		StudentsTasks.updateTableModulesOptional(table_1,level);
		
		
		panel.add(table_1);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table_2.setBounds(10, 605, 883, 125);
		
		JButton btnAddNew = new JButton("Add");
		btnAddNew.setIcon(new ImageIcon(StudentsSubject.class.getResource("/assessment_2329760/pngImages/addIcon.png")));
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsTasks st = new StudentsTasks("Stud");
				st.enrollOptionalModule(table_1, email, name);
				st.updateTableCurrentModules(table, email, level);
				st.updateTableModulesOptional(table_1,level);
				
			}
		});
		btnAddNew.setForeground(SystemColor.text);
		btnAddNew.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnAddNew.setBackground(SystemColor.activeCaptionText);
		btnAddNew.setBounds(915, 552, 143, 81);
		panel.add(btnAddNew);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.light"));
		panel_2.setBounds(327, 12, 238, 51);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(10, 0, 96, 43);
		panel_2.add(lblLevel);
		lblLevel.setForeground(SystemColor.textHighlight);
		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		
		JLabel lblL = new JLabel(level);
		lblL.setForeground(SystemColor.textHighlight);
		lblL.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblL.setBounds(106, 0, 96, 43);
		panel_2.add(lblL);
	}
}
