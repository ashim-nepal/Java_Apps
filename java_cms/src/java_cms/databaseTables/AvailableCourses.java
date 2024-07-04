package assessment_2329760.databaseTables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AvailableCourses extends JFrame {

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
					AvailableCourses frame = new AvailableCourses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
public static void availableCourses(JTable tbl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery("Select * From coursestable WHERE availability = 'yes'")) {

	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Course Id");
	            tableModel.addColumn("Course Name");
	            
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("courseId"));
	                row.add(resultSet.getString("courseName"));
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
	public AvailableCourses() {
		setTitle("Available Courses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 205, 593, 36);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(10, 0, 98, 26);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(379, 0, 128, 26);
		panel_3.add(lblCourseName);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 240, 593, 391);
		availableCourses(table);
		contentPane.add(table);
		
		JLabel lblAllAvailableCourses = new JLabel("All Available Courses");
		lblAllAvailableCourses.setForeground(SystemColor.textHighlight);
		lblAllAvailableCourses.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblAllAvailableCourses.setBounds(147, 10, 334, 43);
		contentPane.add(lblAllAvailableCourses);
		
		JLabel lblMakeSureTo = new JLabel("Note*: Make Sure to  insert  CourseId during Signup, else Your");
		lblMakeSureTo.setForeground(Color.RED);
		lblMakeSureTo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMakeSureTo.setBounds(10, 63, 583, 43);
		contentPane.add(lblMakeSureTo);
		
		JLabel lblRegistrationWillBe = new JLabel("registration will be terminated and tour registered account  will get");
		lblRegistrationWillBe.setForeground(Color.RED);
		lblRegistrationWillBe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRegistrationWillBe.setBounds(10, 96, 583, 43);
		contentPane.add(lblRegistrationWillBe);
		
		JLabel lblDeleted = new JLabel("deleted .");
		lblDeleted.setForeground(Color.RED);
		lblDeleted.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDeleted.setBounds(10, 132, 583, 43);
		contentPane.add(lblDeleted);
		
		JButton btnAddNew_1_1_1 = new JButton("Close");
		btnAddNew_1_1_1.setIcon(new ImageIcon(AvailableCourses.class.getResource("/assessment_2329760/pngImages/exitIcon.png")));
		btnAddNew_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAddNew_1_1_1.setForeground(SystemColor.text);
		btnAddNew_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1_1.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1_1.setBounds(463, 166, 130, 29);
		contentPane.add(btnAddNew_1_1_1);
	}

}
