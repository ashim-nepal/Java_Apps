package assessment_2329760.rolesTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentsTasks {
	
private static Connection conn;
	
	public StudentsTasks(String username) {
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
         		PreparedStatement st = conn.prepareStatement("SELECT name FROM learningstudents WHERE email = ?")) {
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
	
	
	public static String getCurrentLvl(String email) {
		String lvl = null;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
         		PreparedStatement st = conn.prepareStatement("SELECT level FROM learningstudents WHERE email = ?")) {
         		st.setString(1, email);
         		ResultSet resultSet = st.executeQuery();
         		
         		if(resultSet.next()) {
         			lvl = resultSet.getString("level");
         			
         		}
         } catch (SQLException e) {
             e.printStackTrace();
         }
		
		
		return lvl;
		
	}
	
	
public static void updateTableMyTutorss(JTable tbl, String email, String lvl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT tut.email, tut.name, tut.moduleName, tut.moduleId "
	             		+ "FROM studentsresults st "
	             		+ "JOIN teachersmoduletable tut ON st.moduleId = tut.moduleId "
	             		+ "WHERE st.email = '"+email+"' AND st.level = '"+lvl+"'")) {
			
	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Name");
	            tableModel.addColumn("Email");
	            tableModel.addColumn("Module Name");
	            tableModel.addColumn("Module Id");

	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("name"));
	                row.add(resultSet.getString("email"));
	                row.add(resultSet.getString("moduleName"));
	                row.add(resultSet.getString("moduleId"));
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	

	public static void updateTableCurrentModules(JTable tbl, String email, String lvl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM studentsresults WHERE email ='"+email+"' AND level = '"+lvl+"'")) {
			
	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Module Id");
	            tableModel.addColumn("Module Name");
	            tableModel.addColumn("Marks");
	
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("moduleName"));
	                row.add(resultSet.getString("marks"));
	                tableModel.addRow(row);
	            }
	
	            tbl.setModel(tableModel);
	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
public static void updateTableModulesOptional(JTable tbl, String lvl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM modulestable WHERE optional = 'yes' AND level = '"+lvl+"'")) {
			
	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Module Id");
	            tableModel.addColumn("Course Id");
	            tableModel.addColumn("Module Name");
	
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("courseId"));
	                row.add(resultSet.getString("moduleName"));
	                tableModel.addRow(row);
	            }
	
	            tbl.setModel(tableModel);
	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

//UPDATE learningstudents SET level = ? WHERE email = ?

	public static void enrollOptionalModule(JTable tbl, String email, String name) {
		int selectedRow = tbl.getSelectedRow();
	    if (selectedRow != -1) {
	    	String moduleId= (String) tbl.getValueAt(selectedRow, 0);
	        String moduleName = (String) tbl.getValueAt(selectedRow, 2);
	        
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st = conn.prepareStatement("INSERT INTO studentsresults (email, name, moduleId, moduleName, level, marks) VALUES ('"+email+"', '"+name+"', '"+moduleId+"', '"+moduleName+"', '6', '-')")) {
	                st.executeUpdate();
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	
	    }
	}
		

}
