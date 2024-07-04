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

import assessment_2329760.rolesTask.AdminTasks;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AdminCourses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTasks ad = new AdminTasks("Admin");
					ad.connectToDatabase();
					AdminCourses frame = new AdminCourses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void searchCourse(JTable tbl, String sText) {
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				 PreparedStatement st = conn.prepareStatement("SELECT * FROM coursestable WHERE courseName LIKE ?")) {
	            st.setString(1, "%" + sText + "%");
	            ResultSet resultSet = st.executeQuery();

	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel mdl = new DefaultTableModel();
	            mdl.addColumn("Course ID");
	            mdl.addColumn("Course Name");
	            mdl.addColumn("availability");
	            
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("courseId"));
	                row.add(resultSet.getString("courseName"));
	                row.add(resultSet.getString("availability"));
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
	public AdminCourses() {
		setTitle("Admin Dashboard-Courses");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 770);
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
		btnNewButton.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AdminHome home = new AdminHome();
				home.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(0, 206, 360, 107);
		panel_1.add(btnNewButton);
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/courses.png")));
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//courses
				
			}
		});
		btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnCourses.setBounds(0, 323, 360, 87);
		panel_1.add(btnCourses);
		
		JButton btnModules = new JButton("Modules");
		btnModules.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
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
		btnTeachers.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
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
		btnStudents.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
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
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 76));
		lblNewLabel_1.setBounds(10, 22, 330, 110);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(390, 10, 968, 711);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCoursesManagement = new JLabel("Courses Management Window");
		lblCoursesManagement.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/courses.png")));
		lblCoursesManagement.setBounds(216, 5, 526, 43);
		lblCoursesManagement.setForeground(SystemColor.textHighlight);
		lblCoursesManagement.setFont(new Font("Times New Roman", Font.BOLD, 36));
		panel.add(lblCoursesManagement);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/addIcon.png")));
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminTasks ad = new AdminTasks("Admin");
				ad.addCourse();
				ad.updateTableCourse(table);
				// adding new course
				
			}
		});
		btnAddNew.setForeground(SystemColor.text);
		btnAddNew.setBackground(SystemColor.activeCaptionText);
		btnAddNew.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnAddNew.setBounds(10, 564, 267, 118);
		panel.add(btnAddNew);
		
		JButton btnCourses_1_1 = new JButton("Edit Course");
		btnCourses_1_1.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/editIcon.png")));
		btnCourses_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Editing course
				AdminTasks ad = new AdminTasks("Admin");
				ad.editingCourse(table);
				ad.updateTableCourse(table);
				
			}
		});
		btnCourses_1_1.setForeground(SystemColor.text);
		btnCourses_1_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnCourses_1_1.setBackground(SystemColor.activeCaptionText);
		btnCourses_1_1.setBounds(360, 564, 267, 118);
		panel.add(btnCourses_1_1);
		
		JButton btnCourses_1_2 = new JButton("Delete Course");
		btnCourses_1_2.setIcon(new ImageIcon(AdminCourses.class.getResource("/assessment_2329760/pngImages/exitIcon.png")));
		btnCourses_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Deleting the course
				AdminTasks ad = new AdminTasks("Admin");
				ad.deleteCourse(table);
				ad.updateTableCourse(table);
				
			}
		});
		btnCourses_1_2.setForeground(SystemColor.text);
		btnCourses_1_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnCourses_1_2.setBackground(SystemColor.activeCaptionText);
		btnCourses_1_2.setBounds(680, 564, 267, 118);
		panel.add(btnCourses_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 58, 936, 404);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 10, 754, 59);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		panel_2.add(textField);
		textField.setColumns(10);
		
		
		table = new JTable();
		table.setBounds(10, 120, 894, 274);
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		AdminTasks.updateTableCourse(table);
		panel_2.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(914, 0, 22, 394);
		panel_2.add(scrollPane);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(10, 15, 130, 43);
		lblSearch.setForeground(SystemColor.textHighlight);
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 36));
		panel_2.add(lblSearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 87, 894, 36);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course ID");
		lblNewLabel.setBounds(71, 0, 98, 26);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(379, 0, 128, 26);
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(lblCourseName);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(721, 0, 113, 26);
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(lblAvailability);
		
		JLabel lblCurrentCourses = new JLabel("Courses Editor");
		lblCurrentCourses.setForeground(SystemColor.textHighlight);
		lblCurrentCourses.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblCurrentCourses.setBounds(369, 472, 258, 43);
		panel.add(lblCurrentCourses);
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	searchCourse(table, textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	searchCourse(table, textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text fields
            }
        });
		
		
		
	}
}
