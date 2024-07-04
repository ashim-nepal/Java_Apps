package assessment_2329760.AdminDashBoard;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import assessment_2329760.databaseTables.ReportSlip;
import assessment_2329760.rolesTask.AdminTasks;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AdminStudents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTasks ad = new AdminTasks("Admin");
					ad.connectToDatabase();
					AdminStudents frame = new AdminStudents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void searchEnrolledStudent(JTable tbl, String sText) {
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				 PreparedStatement st = conn.prepareStatement("SELECT * FROM learningstudents WHERE email LIKE ?")) {
	            st.setString(1, "%" + sText + "%");
	            ResultSet resultSet = st.executeQuery();

	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel mdl = new DefaultTableModel();
	            mdl.addColumn("Email");
	            mdl.addColumn("Name");
	            mdl.addColumn("Course ID");
	            mdl.addColumn("Semester");
	            mdl.addColumn("Level");
	            
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("email"));
	                row.add(resultSet.getString("name"));
	                row.add(resultSet.getString("CourseId"));
	                row.add(resultSet.getString("semester"));
	                row.add(resultSet.getString("level"));
	                mdl.addRow(row);
	            }

	            tbl.setModel(mdl);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	}
	

	/**
	 * Create the frame.
	 */
	public AdminStudents() {
		setTitle("Admin Dashboard-Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(669, 10, 10, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setForeground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 10, 370, 711);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(AdminStudents.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
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
		btnCourses.setIcon(new ImageIcon(AdminStudents.class.getResource("/assessment_2329760/pngImages/courses.png")));
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
		btnModules.setIcon(new ImageIcon(AdminStudents.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
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
		btnTeachers.setIcon(new ImageIcon(AdminStudents.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// teachers
				AdminTeachers adTeachers = new AdminTeachers();
				adTeachers.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnTeachers.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnTeachers.setBounds(0, 517, 360, 87);
		panel_1.add(btnTeachers);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setIcon(new ImageIcon(AdminStudents.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// students
				
			}
		});
		btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnStudents.setBounds(0, 614, 360, 87);
		panel_1.add(btnStudents);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(SystemColor.inactiveCaption);
		panel_5.setBounds(10, 10, 350, 156);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("ADMIN");
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 76));
		lblNewLabel_1_1.setBounds(10, 22, 330, 110);
		panel_5.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(387, 30, 968, 711);
		contentPane.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(22, 58, 936, 643);
		panel_2.add(panel_2_1);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 29, 760, 155);
		AdminTasks.updateTableStudentEntry(table);
		panel_2_1.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(914, 0, 22, 394);
		panel_2_1.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 0, 760, 36);
		panel_2_1.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(353, 0, 62, 26);
		panel_3.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Id");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(585, 0, 99, 26);
		panel_3.add(lblCourseName);
		
		JLabel lblModuleId = new JLabel("Name");
		lblModuleId.setForeground(Color.WHITE);
		lblModuleId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModuleId.setBounds(81, 0, 62, 26);
		panel_3.add(lblModuleId);
		
		JButton btnAddNew_1 = new JButton("Assign Lvl");
		btnAddNew_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminTasks ad = new AdminTasks("Admmin");
				ad.confirmEntryStudent(table);
				ad.updateTableStudentEntry(table);
				ad.updateTableEnrolledStudents(table_1);
				
				
			}
		});
		btnAddNew_1.setForeground(SystemColor.text);
		btnAddNew_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1.setBounds(779, 29, 125, 64);
		panel_2_1.add(btnAddNew_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table_1.setBounds(10, 333, 760, 300);
		AdminTasks.updateTableEnrolledStudents(table_1);
		panel_2_1.add(table_1);
		
		JLabel lblEnrolledStudents = new JLabel("Enrolled Students");
		lblEnrolledStudents.setForeground(SystemColor.textHighlight);
		lblEnrolledStudents.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblEnrolledStudents.setBounds(10, 194, 274, 43);
		panel_2_1.add(lblEnrolledStudents);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(295, 219, 609, 4);
		panel_2_1.add(panel_4);
		
		JButton btnAddNew_1_1 = new JButton("Report");
		btnAddNew_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				if (selectedRow != -1) {
					String email = (String) table_1.getValueAt(selectedRow, 0);
					String name = (String) table_1.getValueAt(selectedRow, 1);
					String level = (String) table_1.getValueAt(selectedRow, 4);
					ReportSlip.updateRemark();
					ReportSlip report = new ReportSlip(email, name, level);
					report.setVisible(true);
				}
				
			}
		});
		btnAddNew_1_1.setForeground(SystemColor.text);
		btnAddNew_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1.setBounds(779, 495, 125, 64);
		panel_2_1.add(btnAddNew_1_1);
		
		JButton btnAddNew_1_2 = new JButton("Delete");
		btnAddNew_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminTasks ad = new AdminTasks("Admin");
				ad.deleteEntryStudent(table);
				ad.updateTableStudentEntry(table);
			}
		});
		btnAddNew_1_2.setForeground(SystemColor.text);
		btnAddNew_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_2.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_2.setBounds(780, 120, 125, 64);
		panel_2_1.add(btnAddNew_1_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		textField.setColumns(10);
		textField.setBounds(131, 247, 773, 36);
		panel_2_1.add(textField);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setForeground(SystemColor.textHighlight);
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblSearch.setBounds(10, 240, 130, 43);
		panel_2_1.add(lblSearch);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(754, 333, 16, 300);
		panel_2_1.add(scrollPane_1);
		
		JButton btnAddNew_1_1_1 = new JButton("Delete");
		btnAddNew_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminTasks ad = new AdminTasks("Admin");
				ad.deleteEnrolledStudent(table_1);
				ad.updateTableEnrolledStudents(table_1);
			}
		});
		btnAddNew_1_1_1.setForeground(SystemColor.text);
		btnAddNew_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1_1.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1_1.setBounds(779, 569, 125, 64);
		panel_2_1.add(btnAddNew_1_1_1);
		
		JButton btnAddNew_1_1_2 = new JButton("Up Level 5");
		btnAddNew_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminTasks ad = new AdminTasks("Admin");
				ad.upgradeLvl5(table_1);
				ad.updateTableEnrolledStudents(table_1);
				// Up level 5
				
			}
		});
		btnAddNew_1_1_2.setForeground(SystemColor.text);
		btnAddNew_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1_2.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1_2.setBounds(779, 293, 125, 64);
		panel_2_1.add(btnAddNew_1_1_2);
		
		JButton btnAddNew_1_1_3 = new JButton("Up Level 6");
		btnAddNew_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Up level 6
				AdminTasks ad = new AdminTasks("Admin");
				ad.upgradeLvl6(table_1);
				ad.updateTableEnrolledStudents(table_1);
			}
		});
		btnAddNew_1_1_3.setForeground(SystemColor.text);
		btnAddNew_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1_3.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1_3.setBounds(779, 363, 125, 64);
		panel_2_1.add(btnAddNew_1_1_3);
		
		JButton btnAddNew_1_1_4 = new JButton("SEM UP");
		btnAddNew_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Change semester
				AdminTasks ad = new AdminTasks("Admin");
				ad.updateSem(table_1);
				ad.updateTableEnrolledStudents(table_1);
			}
		});
		btnAddNew_1_1_4.setForeground(SystemColor.text);
		btnAddNew_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1_4.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1_4.setBounds(779, 437, 125, 48);
		panel_2_1.add(btnAddNew_1_1_4);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setForeground(Color.WHITE);
		panel_3_1.setBackground(Color.BLACK);
		panel_3_1.setBounds(10, 302, 760, 36);
		panel_2_1.add(panel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(31, 0, 62, 26);
		panel_3_1.add(lblNewLabel_1);
		
		JLabel lblCourseName_1 = new JLabel("Course Id");
		lblCourseName_1.setForeground(Color.WHITE);
		lblCourseName_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName_1.setBounds(316, 0, 99, 26);
		panel_3_1.add(lblCourseName_1);
		
		JLabel lblModuleId_1 = new JLabel("Name");
		lblModuleId_1.setForeground(Color.WHITE);
		lblModuleId_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModuleId_1.setBounds(169, 0, 62, 26);
		panel_3_1.add(lblModuleId_1);
		
		JLabel lblCourseName_1_1 = new JLabel("Semester");
		lblCourseName_1_1.setForeground(Color.WHITE);
		lblCourseName_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName_1_1.setBounds(482, 0, 91, 26);
		panel_3_1.add(lblCourseName_1_1);
		
		JLabel lblCourseName_1_1_1 = new JLabel("Level");
		lblCourseName_1_1_1.setForeground(Color.WHITE);
		lblCourseName_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName_1_1_1.setBounds(660, 0, 62, 26);
		panel_3_1.add(lblCourseName_1_1_1);
		
		JLabel lblCurrentCourses = new JLabel("");
		lblCurrentCourses.setForeground(SystemColor.textHighlight);
		lblCurrentCourses.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblCurrentCourses.setBounds(369, 472, 240, 43);
		panel_2.add(lblCurrentCourses);
		
		JLabel lblStudentsManagementWindow = new JLabel("Students Management Window");
		lblStudentsManagementWindow.setIcon(new ImageIcon(AdminStudents.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
		lblStudentsManagementWindow.setForeground(SystemColor.textHighlight);
		lblStudentsManagementWindow.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblStudentsManagementWindow.setBounds(216, 10, 526, 43);
		panel_2.add(lblStudentsManagementWindow);
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	searchEnrolledStudent(table_1, textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	searchEnrolledStudent(table_1, textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text fields
            }
        });
	}
}
