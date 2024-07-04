
package assessment_2329760.databaseTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
	

public class DBconn {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost/javacms";
	
	
	public static void main(String[] args) {
		// Database is created in phpmy admin as javacms
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
					Statement stmnt = conn.createStatement();)
			{
				// Creating db
				String createDB = "CREATE DATABASE IF NOT EXISTS javacms";
				stmnt.executeUpdate(createDB);
				
				// login table
				String loginTable = "CREATE TABLE IF NOT EXISTS logins (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
						+ "name VARCHAR(100) NOT NULL,"
						+ "email VARCHAR(100) NOT NULL,"
						+ "password VARCHAR(100) NOT NULL,"
						+ "studentCourseId VARCHAR(10),"
						+ "role VARCHAR(10) NOT NULL)";
				stmnt.executeUpdate(loginTable);
				
				
				String coursesTable = "CREATE TABLE IF NOT EXISTS coursesTable ("
		                    + "courseId VARCHAR(10) PRIMARY KEY,"
		                    + "courseName VARCHAR(255) NOT NULL,"
		                    + "availability VARCHAR(5) NOT NULL"
		                    + ")";
		        stmnt.executeUpdate(coursesTable);
		        	

		            // Create modulesTable
		        String modulesTable = "CREATE TABLE IF NOT EXISTS modulesTable ("
		                    + "moduleId VARCHAR(10) PRIMARY KEY,"
		                    + "courseId VARCHAR(10),"
		                    + "moduleName VARCHAR(255) NOT NULL,"
		                    + "level INT NOT NULL,"
		                    + "optional VARCHAR(10),"
		                    + "FOREIGN KEY (courseId) REFERENCES coursesTable(courseId)"
		                    + ")";
		        stmnt.executeUpdate(modulesTable);
		        
		            
		        String learningStudentsTable = "CREATE TABLE IF NOT EXISTS learningStudents ("
		                    + "email VARCHAR(255),"
		                    + "name VARCHAR(255),"
		                    + "courseId VARCHAR(10),"
		                    + "semester VARCHAR(1) NOT NULL,"
		                    + "level  VARCHAR(1) NOT NULL,"
		                    + "FOREIGN KEY (courseId) REFERENCES coursesTable(courseId)"
		                    + ")";
		        stmnt.executeUpdate(learningStudentsTable);

		        
		        String studentResultsTable = "CREATE TABLE IF NOT EXISTS studentsResults ("
		                    + "email VARCHAR(255),"
		                    + "name VARCHAR(255),"
		                    + "moduleId VARCHAR(10),"
		                    + "moduleName VARCHAR(255),"
		                    + "level VARCHAR(1) NOT NULL,"
		                    + "marks VARCHAR(3) NOT NULL,"
		                    + "remark VARCHAR(10),"
		                    + "FOREIGN KEY (moduleId) REFERENCES modulesTable(moduleId)"
		                    + ")";
		            
		        stmnt.executeUpdate(studentResultsTable);
		        
		        

	            String teachersModuleTable = "CREATE TABLE IF NOT EXISTS teachersModuleTable("
		        		+ "email VARCHAR(255), "
		        		+ "moduleId VARCHAR(10) NOT NULL, "
		        		+ "moduleName VARCHAR(255) NOT NULL, "
		        		+ "name VARCHAR(255), "
		        		+ "FOREIGN KEY (moduleId) REFERENCES modulesTable(moduleId) "
		        		+ ")";
		
		        stmnt.executeUpdate(teachersModuleTable);
		        
		        
		        String createTriggerQuery = "CREATE TRIGGER IF NOT EXISTS MaxFourModules "
		        		+ "BEFORE INSERT ON teachersModuleTable FOR EACH ROW "
		        		+ "BEGIN "
		        		+ "DECLARE modules_count INTEGER; " 
		        		+ "SET modules_count =("
		        		+ "SELECT COUNT(*) FROM teachersModuleTable "
		        		+ "WHERE email = NEW.email "
		        		+ ");"
		        		+ "IF modules_count >= 4 THEN "
		        		+ "SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No more than 4 modules'; "
	                    + "END IF; "
	                    + "END";
	            stmnt.executeUpdate(createTriggerQuery);
	            
	            // Creating admin
	            String createAdmin = "INSERT INTO logins (name, email, password, role) VALUES ('Admin HCK','adm01@hck.com','Admin001!','admin') ON DUPLICATE KEY UPDATE email=email";
	            stmnt.executeUpdate(createAdmin);
		        
		        
		        
		        
		        System.out.println("Database and all Tables CREATED along with admin!");
		            
			    }
			catch(SQLException e) {
				e.printStackTrace();
				}
		
	}

}
