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

public class AdminModules extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTasks ad = new AdminTasks("Admin");
					ad.connectToDatabase();
					
					AdminModules frame = new AdminModules();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void searchModule(JTable tbl, String sText) {
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				 PreparedStatement st = conn.prepareStatement("SELECT * FROM modulestable WHERE moduleName LIKE ?")) {
	            st.setString(1, "%" + sText + "%");
	            ResultSet resultSet = st.executeQuery();

	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Module Id");
	            tableModel.addColumn("Course Id");
	            tableModel.addColumn("Module Name");
	            tableModel.addColumn("level");

	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("courseId"));
	                row.add(resultSet.getString("moduleName"));
	                row.add(resultSet.getString("level"));
	                tableModel.addRow(row);
	            }


	            tbl.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	

	/**
	 * Create the frame.
	 */
	public AdminModules() {
		setResizable(false);
		setTitle("Admin DashBoard-Modules");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 370, 711);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setForeground(SystemColor.inactiveCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/homeIcon.png")));
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
		btnCourses.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
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
		btnModules.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
		btnModules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// modules
				
			}
		});
		btnModules.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnModules.setBounds(0, 420, 360, 87);
		panel_1.add(btnModules);
		
		JButton btnTeachers = new JButton("Teachers");
		btnTeachers.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/instructorIcon.png")));
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
		btnStudents.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/studentIcon.png")));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 10, 350, 156);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 76));
		lblNewLabel_1.setBounds(10, 22, 330, 110);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(390, 10, 968, 711);
		contentPane.add(panel_2);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/addIcon.png")));
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add new module
				AdminTasks ad = new AdminTasks("Admin");
				ad.addModules();
				ad.updateTableModules(table);
				
			}
		});
		btnAddNew.setForeground(SystemColor.text);
		btnAddNew.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnAddNew.setBackground(SystemColor.activeCaptionText);
		btnAddNew.setBounds(10, 588, 267, 94);
		panel_2.add(btnAddNew);
		
		JButton btnCourses_1_1 = new JButton("Edit Module");
		btnCourses_1_1.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/editIcon.png")));
		btnCourses_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Edit the module
				AdminTasks ad = new AdminTasks("Admin");
				ad.editingModules(table);
				ad.updateTableModules(table);
				
				
			}
		});
		btnCourses_1_1.setForeground(SystemColor.text);
		btnCourses_1_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnCourses_1_1.setBackground(SystemColor.activeCaptionText);
		btnCourses_1_1.setBounds(360, 588, 267, 94);
		panel_2.add(btnCourses_1_1);
		
		JButton btnCourses_1_2 = new JButton("Delete Module");
		btnCourses_1_2.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/exitIcon.png")));
		btnCourses_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete the module
				AdminTasks ad = new AdminTasks("Admin");
				ad.deleteModule(table);
				ad.updateTableModules(table);
				
			}
		});
		btnCourses_1_2.setForeground(SystemColor.text);
		btnCourses_1_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnCourses_1_2.setBackground(SystemColor.activeCaptionText);
		btnCourses_1_2.setBounds(680, 588, 267, 94);
		panel_2.add(btnCourses_1_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(22, 58, 936, 520);
		panel_2.add(panel_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		textField.setColumns(10);
		textField.setBounds(150, 10, 754, 59);
		panel_2_1.add(textField);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 120, 894, 390);
		AdminTasks.updateTableModules(table);
		panel_2_1.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(914, 0, 22, 394);
		panel_2_1.add(scrollPane);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setForeground(SystemColor.textHighlight);
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblSearch.setBounds(10, 15, 130, 43);
		panel_2_1.add(lblSearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 87, 894, 36);
		panel_2_1.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Course ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(199, 0, 98, 26);
		panel_3.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Module Name");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(374, 0, 142, 26);
		panel_3.add(lblCourseName);
		
		JLabel lblAvailability = new JLabel("Level");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability.setBounds(587, 0, 52, 26);
		panel_3.add(lblAvailability);
		
		JLabel lblModuleId = new JLabel("Module ID");
		lblModuleId.setForeground(Color.WHITE);
		lblModuleId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModuleId.setBounds(29, 0, 137, 26);
		panel_3.add(lblModuleId);
		
		JLabel lblAvailability_2 = new JLabel("Optional");
		lblAvailability_2.setForeground(Color.WHITE);
		lblAvailability_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability_2.setBounds(771, 0, 113, 26);
		panel_3.add(lblAvailability_2);
		
		JLabel lblModulessManagementWindow = new JLabel("Modules Management Window");
		lblModulessManagementWindow.setIcon(new ImageIcon(AdminModules.class.getResource("/assessment_2329760/pngImages/modulesIcon.png")));
		lblModulessManagementWindow.setBounds(215, 5, 541, 43);
		panel_2.add(lblModulessManagementWindow);
		lblModulessManagementWindow.setForeground(SystemColor.textHighlight);
		lblModulessManagementWindow.setFont(new Font("Times New Roman", Font.BOLD, 36));
		
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	searchModule(table, textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	searchModule(table, textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text fields
            }
        });
	}

}
