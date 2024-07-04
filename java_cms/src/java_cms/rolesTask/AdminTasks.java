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

public class AdminTasks extends Users{
	private static final String selectAllCourses = "SELECT * FROM coursestable";
	private static final String addNewCourse = "INSERT INTO coursestable (courseId, courseName, availability) VALUES (?,?,?)";
	private static final String editCourse = "UPDATE coursestable SET courseName =?, availability = ? WHERE courseId = ?";
	private static final String deleteCourse = "DELETE FROM coursestable WHERE courseID = ?";
	
	// queries for module
	private static final String selectAllModules = "SELECT * FROM modulestable";
	private static final String addNewModule = "INSERT INTO modulestable (moduleId,courseId,moduleName,level, optional) VALUES (?,?,?,?, ?)";
	private static final String editModule = "UPDATE modulestable SET moduleName = ? , level = ?, optional = ? WHERE moduleId = ?";
	private static final String deleteModule = "DELETE FROM modulestable WHERE moduleId = ?";
	
	// Queries for teacher
	private static final String selectTeacherEntry = "SELECT name, email FROM logins WHERE role = 'teacher'";
	private static final String assignTeacherModule = "INSERT INTO teachersmoduletable (email, moduleId, moduleName, name) VALUES (?, ?, ?, ?)";
	private static final String deleteTeacherEntry = "DELETE FROM logins WHERE email = ?";
	private static final String allTeachingTeachers = "SELECT * FROM teachersmoduletable";
	private static final String deleteEnrolledTeacher = "DELETE FROM teachersmoduletable WHERE email =? AND moduleId = ?";
	
	
	// Queries for Student
	private static final String selectStudentEntry = "SELECT name, email, studentCourseId, role FROM logins WHERE role = 'student'";
	private static final String confirmStudent = "INSERT INTO learningstudents (email, name, courseId, semester, level) VALUES (?, ?, ?, ?, ?)";
	private static final String deleteEntryStudent = "DELETE from logins WHERE email = ?";
	private static final String selectRegisteredStudents = "SELECT * FROM learningstudents";
	private static final String deleteEnrolledStudent = "DELETE from learningstudents WHERE email = ?";
	
	private static final String updateLvl = "UPDATE learningstudents SET level = ? WHERE email = ?";
	private static final String updateSem = "UPDATE learningstudents SET semester = ? WHERE email =?";
	private static final String studentModuleEntry = "INSERT INTO studentsresults (email,name, moduleId, moduleName, level, marks) "
			+ "SELECT l.email,l.name, m.moduleId, m.moduleName, '4', '-' "
			+ "FROM logins l "
			+ "JOIN modulestable m ON l.studentCourseId = ? "
			+ "WHERE l.email = ? AND m.level = 4 AND m.courseId = ?";
	
	private static final String studentLvlUp5 = "INSERT INTO studentsresults (email,name, moduleId, moduleName, level, marks) "
			+ "SELECT l.email,l.name, m.moduleId, m.moduleName, '5', '-' "
			+ "FROM logins l "
			+ "JOIN modulestable m ON l.studentCourseId = ? "
			+ "WHERE l.email = ? AND m.level = 5 AND m.courseId = ?";
	
	private static final String studentLvlUp6 = "INSERT INTO studentsresults (email,name, moduleId, moduleName, level, marks) "
			+ "SELECT l.email,l.name, m.moduleId, m.moduleName, '6', '-' "
			+ "FROM logins l "
			+ "JOIN modulestable m ON l.studentCourseId = ? "
			+ "WHERE l.email = ? AND m.level = 6 AND m.courseId = ?";
	
	
	private static Connection conn;
	
	public AdminTasks(String username) {
		super(username,"admin");
	}
	
	

	public static void connectToDatabase() {
        try { 
            conn= DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	public static int getCourseCount(){
		int totalCount = 0;
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
         		PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) AS courses_count FROM coursestable")) {
         		ResultSet resultSet = st.executeQuery();
         		
         		if(resultSet.next()) {
         			totalCount = resultSet.getInt("courses_count");
         			
         		}
         } catch (SQLException e) {
             e.printStackTrace();
         }
		 return totalCount;
		
	}
	
	public static int getModulesCount(){
		int totalCount = 0;
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
         		PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) AS modules_count FROM modulestable")) {
         		ResultSet resultSet = st.executeQuery();
         		
         		if(resultSet.next()) {
         			totalCount = resultSet.getInt("modules_count");
         			
         		}
         } catch (SQLException e) {
             e.printStackTrace();
         }
		 return totalCount;
		
	}
	

	public static int getTeacherCount(){
		int totalCount = 0;
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
         		PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) AS teacher_count FROM logins WHERE role = 'Teacher'")) {
         		ResultSet resultSet = st.executeQuery();
         		
         		if(resultSet.next()) {
         			totalCount = resultSet.getInt("teacher_count");
         			
         			
         		}
         } catch (SQLException e) {
             e.printStackTrace();
         }
		 return totalCount;
		
	}
	
	public static int getStudentCount(){
		int totalCount = 0;
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
         		PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) AS student_count FROM learningstudents")) {
         		ResultSet resultSet = st.executeQuery();
         		
         		if(resultSet.next()) {
         			totalCount = resultSet.getInt("student_count");
         			
         		}
         } catch (SQLException e) {
             e.printStackTrace();
         }
		 return totalCount;
		
	}

	
	public static void updateTableCourse(JTable tbl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(selectAllCourses)) {

	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Course ID");
	            tableModel.addColumn("Course Name");
	            tableModel.addColumn("Availibality");

	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("courseID"));
	                row.add(resultSet.getString("courseName"));
	                row.add(resultSet.getString("availability"));
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	public static void addCourse() {
        String courseId = JOptionPane.showInputDialog("Enter the course id:");
        String courseName = JOptionPane.showInputDialog("Enter the course name:");
        String courseAvailable = JOptionPane.showInputDialog("Enter course Availability:");
        if (courseId != null && !courseId.isEmpty() && courseName != null && !courseName.isEmpty() && courseAvailable!= null && !courseAvailable.isEmpty()){
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
            		PreparedStatement st = conn.prepareStatement(addNewCourse)) {
            	st.setString(1, courseId);
                st.setString(2, courseName);
                st.setString(3, courseAvailable );
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
    }
	
	public static void editingCourse(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
        if (selectedRow != -1) {
        	String courseId = (String) tbl.getValueAt(selectedRow, 0);
            String newCourseName = JOptionPane.showInputDialog("Enter the course name:");
            String newCourseAvailable = JOptionPane.showInputDialog("Enter course Availability:");
            

            if (newCourseName != null && !newCourseName.isEmpty() && newCourseAvailable != null && !newCourseAvailable.isEmpty()) {
                try (Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
                		PreparedStatement st = conn.prepareStatement(editCourse)) {
       
                	st.setString(1, newCourseName);
                	st.setString(2, newCourseAvailable);
                	st.setString(3, courseId);
                    st.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}
	
	public static void deleteCourse(JTable tbl) {
		 int selectedRow = tbl.getSelectedRow();
	        if (selectedRow != -1) {
	            String courseId = (String) tbl.getValueAt(selectedRow, 0);
	            int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this course?");
	            if (confirmResult == JOptionPane.YES_OPTION) {
	                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	                		PreparedStatement st = conn.prepareStatement(deleteCourse)) {
	                    st.setString(1, courseId);
	                    st.executeUpdate();
	                } catch (SQLException e) {
	                	JOptionPane.showMessageDialog(null, "Error Deleting Course! Delete all the modules associated to this course prior Deleting.");
	                    e.printStackTrace();
	                }
	            }
	        }
	}
	
	
public static void updateTableModules(JTable tbl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(selectAllModules)) {

	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Module Id");
	            tableModel.addColumn("Course Id");
	            tableModel.addColumn("Module Name");
	            tableModel.addColumn("level");
	            tableModel.addColumn("Optional");
	            
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("courseId"));
	                row.add(resultSet.getString("moduleName"));
	                row.add(resultSet.getString("level"));
	                row.add(resultSet.getString("optional"));
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	public static void addModules() {
		String moduleId = JOptionPane.showInputDialog("Enter the Module id:");
        String courseId = JOptionPane.showInputDialog("Enter the course id:");
        String moduleName = JOptionPane.showInputDialog("Enter the module name:");
        String level = JOptionPane.showInputDialog("Enter course level:");
        String optional = JOptionPane.showInputDialog("Optional Module (yes / no):");
        if (courseId != null && !courseId.isEmpty() && moduleId!= null && !moduleId.isEmpty() && moduleName!= null && !moduleName.isEmpty() && level != null && !level.isEmpty()){
            try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
            		PreparedStatement st = conn.prepareStatement(addNewModule)) {
            	st.setString(1, moduleId);
                st.setString(2, courseId);
                st.setString(3, moduleName);
                st.setString(4, level);
                st.setString(5, optional);
                st.executeUpdate();
            } catch (SQLException e) {
            	JOptionPane.showMessageDialog(null, "Invalid or null input. Please Reenter.");
                e.printStackTrace();
            }
        } 
    }
	
	public static void editingModules(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
        if (selectedRow != -1) {
        	String moduleId = (String) tbl.getValueAt(selectedRow, 0);
            String newModuleName = JOptionPane.showInputDialog("Enter new Module name:");
            String newLvl = JOptionPane.showInputDialog("Change level:");
            String optional = JOptionPane.showInputDialog("Module optional (yes / no):");
            

            if (newModuleName != null && !newModuleName.isEmpty() && newLvl != null && !newLvl.isEmpty()) {
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
                		PreparedStatement st = conn.prepareStatement(editModule)) {
       
                	st.setString(1, newModuleName);
                	st.setString(2, newLvl);
                	st.setString(3, optional);
                	st.setString(4, moduleId);
                    st.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}
	
	public static void deleteModule(JTable tbl) {
		 int selectedRow = tbl.getSelectedRow();
	        if (selectedRow != -1) {
	            String moduleId = (String) tbl.getValueAt(selectedRow, 0);
	            int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Module?");
	            if (confirmResult == JOptionPane.YES_OPTION) {
	                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	                		PreparedStatement st = conn.prepareStatement(deleteModule)) {
	                    st.setString(1, moduleId);
	                    st.executeUpdate();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	}
	
	// Teachers
	
	public static void updateTableTeacherEntry(JTable tbl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(selectTeacherEntry)) {
			
	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Name");
	            tableModel.addColumn("Email");

	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("name"));
	                row.add(resultSet.getString("email"));
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	public static void deleteEntryTeacher(JTable tbl) {
		 int selectedRow = tbl.getSelectedRow();
	       if (selectedRow != -1) {
	           String email = (String) tbl.getValueAt(selectedRow, 1);
	           int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Teacher?");
	           if (confirmResult == JOptionPane.YES_OPTION) {
	               try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		   PreparedStatement st = conn.prepareStatement(deleteTeacherEntry)) {
	                   st.setString(1, email);
	                   st.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	}
	
	public static void confirmModuleAssign(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
	    if (selectedRow != -1) {
	    	String name= (String) tbl.getValueAt(selectedRow, 0);
	        String email = (String) tbl.getValueAt(selectedRow,1);
	        String moduleId = JOptionPane.showInputDialog("Enter Assigned Module Id:");
	        String moduleName = JOptionPane.showInputDialog("Enter module Name:");
	        
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st = conn.prepareStatement(assignTeacherModule)) {
	   
	            	st.setString(1, email );
	            	st.setString(2, moduleId);
	            	st.setString(3, moduleName);
	            	st.setString(4, name);
	                st.executeUpdate();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	    }
		
	}
	
	public static void updateTableTeachingTeachers(JTable tbl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(allTeachingTeachers)) {
		
            	// Fetch data from the result set and add it to the table model
            	DefaultTableModel tableModel = new DefaultTableModel();
            	
            	tableModel.addColumn("Email");
            	tableModel.addColumn("Module ID");
	            tableModel.addColumn("Modulw Name");
	            tableModel.addColumn("Teacher");

	            while (resultSet.next()) {
	            	Vector<Object> row = new Vector<>();
	            	row.add(resultSet.getString("email"));
	            	row.add(resultSet.getString("moduleId"));
	                row.add(resultSet.getString("moduleName"));
	                row.add(resultSet.getString("name")); 
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
	
	}
	
	public static void deleteTeacherAssigned(JTable tbl) {
		 int selectedRow = tbl.getSelectedRow();
	       if (selectedRow != -1) {
	           String email = (String) tbl.getValueAt(selectedRow, 0);
	           String moduleId = (String) tbl.getValueAt(selectedRow, 1);
	           int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Student?");
	           if (confirmResult == JOptionPane.YES_OPTION) {
	               try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		   PreparedStatement st = conn.prepareStatement(deleteEnrolledTeacher)) {
	                   st.setString(1, email);
	                   st.setString(2,  moduleId);
	                   st.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	}
	

	// Students
	
	
public static void updateTableStudentEntry(JTable tbl){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(selectStudentEntry)) {
			
	            // Fetch data from the result set and add it to the table model
	            DefaultTableModel tableModel = new DefaultTableModel();
	            tableModel.addColumn("Name");
	            tableModel.addColumn("Email");
	            tableModel.addColumn("Course");

	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(resultSet.getString("name"));
	                row.add(resultSet.getString("email"));
	                row.add(resultSet.getString("studentCourseId"));
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	public static void confirmEntryStudent(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
	    if (selectedRow != -1) {
	    	String name= (String) tbl.getValueAt(selectedRow, 0);
	        String email = (String) tbl.getValueAt(selectedRow,1);
	        String courseId = (String) tbl.getValueAt(selectedRow, 2);
	        
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st = conn.prepareStatement(confirmStudent)) {
	   
	            	st.setString(1, email );
	            	st.setString(2, name);
	            	st.setString(3, courseId);
	            	st.setString(4, "1");
	            	st.setString(5, "4");
	                st.executeUpdate();
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st2 = conn.prepareStatement(studentModuleEntry)) {
	            	st2.setString(1, courseId);
	            	st2.setString(2, email );
	            	st2.setString(3, courseId);
	            	
	                st2.executeUpdate();
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            
	    }
		
	}
	
	public static void upgradeLvl5(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
	    if (selectedRow != -1) {
	        String email = (String) tbl.getValueAt(selectedRow,0);
	        String courseId = (String) tbl.getValueAt(selectedRow, 2);
	        
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st = conn.prepareStatement(updateLvl)) {
	   
	            	st.setString(2, email );
	            	st.setString(1, "5");
	                st.executeUpdate();
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st2 = conn.prepareStatement(studentLvlUp5)) {
	            	st2.setString(1, courseId);
	            	st2.setString(2, email );
	            	st2.setString(3, courseId);
	            	
	                st2.executeUpdate();
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		   PreparedStatement st = conn.prepareStatement(updateSem)) {
	                   st.setString(1, "1");
	                   st.setString(2, email);
	                   st.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	            
	            
	    }
		
	}
	
	public static void upgradeLvl6(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
	    if (selectedRow != -1) {
	        String email = (String) tbl.getValueAt(selectedRow,0);
	        String courseId = (String) tbl.getValueAt(selectedRow, 2);
	        
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st = conn.prepareStatement(updateLvl)) {
	   
	            	st.setString(2, email );
	            	st.setString(1, "6");
	                st.executeUpdate();
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		PreparedStatement st2 = conn.prepareStatement(studentLvlUp6)) {
	            	st2.setString(1, courseId);
	            	st2.setString(2, email );
	            	st2.setString(3, courseId);
	            	
	                st2.executeUpdate();
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		   PreparedStatement st = conn.prepareStatement(updateSem)) {
	                   st.setString(1, "1");
	                   st.setString(2, email);
	                   st.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	            
	            
	    }
		
	}
	
	public static void updateSem(JTable tbl) {
		 int selectedRow = tbl.getSelectedRow();
	       if (selectedRow != -1) {
	           String email = (String) tbl.getValueAt(selectedRow, 0);
	               try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		   PreparedStatement st = conn.prepareStatement(updateSem)) {
	                   st.setString(1, "2");
	                   st.setString(2, email);
	                   st.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	       }
	}
 
	
	
	public static void deleteEntryStudent(JTable tbl) {
		 int selectedRow = tbl.getSelectedRow();
	       if (selectedRow != -1) {
	           String email = (String) tbl.getValueAt(selectedRow, 1);
	           int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Student?");
	           if (confirmResult == JOptionPane.YES_OPTION) {
	               try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		   PreparedStatement st = conn.prepareStatement(deleteEntryStudent)) {
	                   st.setString(1, email);
	                   st.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	}


	public static void updateTableEnrolledStudents(JTable tbl){
	
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(selectRegisteredStudents)) {
		
            	// Fetch data from the result set and add it to the table model
            	DefaultTableModel tableModel = new DefaultTableModel();
            	
            	tableModel.addColumn("Email");
            	tableModel.addColumn("Name");
	            tableModel.addColumn("Course Id");
	            tableModel.addColumn("Semester");
	            tableModel.addColumn("Level");

	            while (resultSet.next()) {
	            	Vector<Object> row = new Vector<>();
	            	row.add(resultSet.getString("email"));
	            	row.add(resultSet.getString("name"));
	                row.add(resultSet.getString("courseId"));
	                row.add(resultSet.getString("semester"));
	                row.add(resultSet.getString("level"));
	                tableModel.addRow(row);
	            }

	            tbl.setModel(tableModel);

        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
	
	}
	
	
	
	
	public static void deleteEnrolledStudent(JTable tbl) {
		 int selectedRow = tbl.getSelectedRow();
	       if (selectedRow != -1) {
	           String email = (String) tbl.getValueAt(selectedRow, 0);
	           int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Student?");
	           if (confirmResult == JOptionPane.YES_OPTION) {
	               try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacms","root","");
	            		   PreparedStatement st = conn.prepareStatement(deleteEnrolledStudent)){
	                   st.setString(1, email);
	                   st.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	}

}
