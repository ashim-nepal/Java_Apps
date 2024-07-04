package assessment_2329760.databaseTables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ReportSlip extends JFrame {
	static String stEmail;

	static String stName;

	static String stLevel;

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
					ReportSlip frame = new ReportSlip(stEmail, stName, stLevel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void updateRemark() {
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement()){
					statement.executeUpdate("UPDATE studentsresults SET remark = "
			         		+ "CASE "
			         		+ "WHEN marks NOT REGEXP '^[0-9]+$' THEN '-' "
			         		+ "WHEN CAST(marks AS SIGNED) <40 THEN 'FAIL' "
			         		+ "WHEN CAST(marks AS SIGNED) >=40 THEN 'PASS' "
			         		+ "ELSE '-' "
			         		+ "END");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	}
	
public static void generateReport(JTable tbl, String email, String level){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery("Select * From studentsresults WHERE email ='"+email+"' AND level ='"+level+"'")) {

	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Module Id");
	            tableModel.addColumn("Module Name");
	            tableModel.addColumn("Marks");
	            tableModel.addColumn("Remarks");
	            
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("moduleName"));
	                row.add(resultSet.getString("marks"));
	                row.add(resultSet.getString("remark"));
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
	public ReportSlip(String stEmail,String stName,String stLevel) {
		setResizable(false);
		setTitle("Report Slip | "+stEmail);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModules = new JLabel("Report of ");
		lblModules.setIcon(new ImageIcon(ReportSlip.class.getResource("/assessment_2329760/pngImages/reportImage.png")));
		lblModules.setBounds(10, 0, 198, 43);
		lblModules.setForeground(SystemColor.textHighlight);
		lblModules.setFont(new Font("Times New Roman", Font.BOLD, 36));
		contentPane.add(lblModules);
		
		JLabel lblSt = new JLabel(stName);
		lblSt.setForeground(SystemColor.textHighlight);
		lblSt.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblSt.setBounds(197, 0, 339, 43);
		contentPane.add(lblSt);
		
		JLabel lblModules_1_1 = new JLabel("Level:");
		lblModules_1_1.setForeground(SystemColor.textHighlight);
		lblModules_1_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblModules_1_1.setBounds(10, 45, 96, 43);
		contentPane.add(lblModules_1_1);
		
		JLabel lblModules_1_1_1 = new JLabel(stLevel);
		lblModules_1_1_1.setForeground(SystemColor.textHighlight);
		lblModules_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblModules_1_1_1.setBounds(116, 45, 96, 43);
		contentPane.add(lblModules_1_1_1);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBounds(10, 187, 692, 317);
		generateReport(table, stEmail, stLevel);
		contentPane.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 151, 692, 36);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Module Id");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(23, 0, 100, 26);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblCourseName = new JLabel("Module Name");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCourseName.setBounds(191, 0, 134, 26);
		panel_3.add(lblCourseName);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability.setBounds(771, 0, 113, 26);
		panel_3.add(lblAvailability);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setForeground(Color.WHITE);
		lblMarks.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblMarks.setBounds(409, 0, 73, 26);
		panel_3.add(lblMarks);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setForeground(Color.WHITE);
		lblRemarks.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblRemarks.setBounds(574, 0, 85, 26);
		panel_3.add(lblRemarks);
		
		JButton btnAddNew_1_1_1 = new JButton("Close");
		btnAddNew_1_1_1.setIcon(new ImageIcon(ReportSlip.class.getResource("/assessment_2329760/pngImages/exitIcon.png")));
		btnAddNew_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAddNew_1_1_1.setForeground(SystemColor.text);
		btnAddNew_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddNew_1_1_1.setBackground(SystemColor.activeCaptionText);
		btnAddNew_1_1_1.setBounds(586, 117, 116, 29);
		contentPane.add(btnAddNew_1_1_1);
	}
}
