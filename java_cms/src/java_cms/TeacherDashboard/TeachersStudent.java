package assessment_2329760.TeacherDashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

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
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class TeachersStudent extends JFrame {
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
					TeachersStudent frame = new TeachersStudent(teacherEmail);
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
	public TeachersStudent(String email) {
		String name = TeachersTasks.getEmailsName(email);
		setTitle("Teacher Dashboard-Students");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1438, 782);
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
		btnNewButton.setIcon(new ImageIcon(TeachersStudent.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Home
				TeacherHome tDB = new TeacherHome(email);
				tDB.setVisible(true);
				setVisible(false);
			}
				
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(0, 357, 360, 167);
		panel_1.add(btnNewButton);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setIcon(new ImageIcon(TeachersStudent.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Students
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
		panel.setBounds(390, 10, 1034, 735);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setIcon(new ImageIcon(TeachersStudent.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		lblStudents.setForeground(SystemColor.textHighlight);
		lblStudents.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblStudents.setBounds(10, 10, 180, 43);
		panel.add(lblStudents);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 50, 1014, 36);
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(41, 0, 62, 26);
		panel_3.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Module Id");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(354, 0, 128, 26);
		panel_3.add(lblCourseName);
		
		JLabel lblAvailability = new JLabel("Marks");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability.setBounds(888, 0, 68, 26);
		panel_3.add(lblAvailability);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblName.setBounds(191, 0, 62, 26);
		panel_3.add(lblName);
		
		JLabel lblModuleName = new JLabel("Module Name");
		lblModuleName.setForeground(Color.WHITE);
		lblModuleName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModuleName.setBounds(528, 0, 134, 26);
		panel_3.add(lblModuleName);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblLevel.setBounds(738, 0, 62, 26);
		panel_3.add(lblLevel);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 83, 1014, 566);
		
		// table Update
		TeachersTasks.updateTableTutStudents(table, email);
		
		panel.add(table);
		
		JButton btnMarkGrade = new JButton("Mark Grade");
		btnMarkGrade.setIcon(new ImageIcon(TeachersStudent.class.getResource("/assessment_2329760/pngImages/gradeIcon.png")));
		btnMarkGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersTasks tut = new TeachersTasks("Tutor");
				tut.gradeMarks(table);
				tut.updateTableTutStudents(table, email);
			}
		});
		btnMarkGrade.setForeground(SystemColor.text);
		btnMarkGrade.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnMarkGrade.setBackground(SystemColor.activeCaptionText);
		btnMarkGrade.setBounds(303, 659, 462, 65);
		panel.add(btnMarkGrade);
		
		}
}
