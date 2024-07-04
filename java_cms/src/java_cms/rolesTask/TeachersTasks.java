package assessment_2329760.rolesTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TeachersTasks {
	
	
	// Queries
	private static final String allTeachingStudents = "SELECT stres.* "
			+ "FROM studentsresults stres "
			+ "JOIN teachersmoduletable ths ON stres.moduleId == ths.moduleId "
			+ "WHERE ths.email = ?";
	
	
	private static Connection conn;
	public TeachersTasks(String teacher) {
		super();
	}
	public static void connectToDatabase() {
        try { 
			conn= DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static String getEmailsName(String email){
		String name = null;
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
         		PreparedStatement st = conn.prepareStatement("SELECT name FROM teachersmoduletable WHERE email = ?")) {
         		st.setString(1, email);
         		ResultSet resultSet = st.executeQuery();
         		
         		if(resultSet.next()) {
         			name = resultSet.getString("name");
         			
         		}
         } catch (SQLException e) {
             e.printStackTrace();
         }
		 return name;
		
	}
	
	
public static void updateTableMyModules(JTable tbl, String email){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT moduleId, moduleName FROM teachersmoduletable WHERE email = '"+email+"'")) {
			
	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Module ID");
	            tableModel.addColumn("Module Name");

	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("moduleName"));
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}



	public static void updateTableSubjects(JTable tbl, String email){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT moduleId, moduleName FROM teachersmoduletable WHERE email = '"+email+"'")){
	
	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Module ID");
	            tableModel.addColumn("Module Name");
	
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("moduleName"));
	                tableModel.addRow(row);
	            }
	
	            tbl.setModel(tableModel);
	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	/*
	 * "SELECT stres.* "
		         			+ "FROM studentsresults stres "
		        			+ "JOIN teachersmoduletable ths ON stres.moduleId == ths.moduleId "
		        			+ "WHERE ths.email = '"+email+"'"
	 */
	
	
	public static void updateTableTutStudents(JTable tbl, String email){
			
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
					Statement statement = conn.createStatement();
		             ResultSet resultSet = statement.executeQuery("SELECT * FROM studentsresults WHERE moduleId IN ("
		             		+ "SELECT moduleId "
		             		+ "FROM teachersmoduletable "
		             		+ "WHERE email = '"
		             		+email
		             		+"'"
		             		+ ")")){
		
		            // Fetch data from the result set and add it to the table model
		            DefaultTableModel tableModel = new DefaultTableModel();
		            tableModel.addColumn("Email");
		            tableModel.addColumn("name");
		            tableModel.addColumn("Module ID");
		            tableModel.addColumn("Module Name");
		            tableModel.addColumn("Level");
		            tableModel.addColumn("Marks");
		
		            while (resultSet.next()) {
		                Vector<Object> row = new Vector<>();
		                row.add(resultSet.getString("email"));
		                row.add(resultSet.getString("name"));
		                row.add(resultSet.getString("moduleId"));
		                row.add(resultSet.getString("moduleName"));
		                row.add(resultSet.getString("level"));
		                row.add(resultSet.getString("marks"));
		                tableModel.addRow(row);
		            }
		
		            tbl.setModel(tableModel);
		
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
		}
	
	
	public static void gradeMarks(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
        if (selectedRow != -1) {
        	String stEmail = (String) tbl.getValueAt(selectedRow, 0);
        	String module = (String) tbl.getValueAt(selectedRow, 2);
            String grade = JOptionPane.showInputDialog("Enter Students Grade:");
            

            if (grade != null && !grade.isEmpty()) {
                try (Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
                		PreparedStatement st = conn.prepareStatement("UPDATE studentsresults SET marks = ? WHERE email = ? AND moduleId = ?")) {
                	
                	st.setString(1, grade);
                	st.setString(2, stEmail);
                	st.setString(3, module);
                    st.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}
			
	
	
	
	

}
