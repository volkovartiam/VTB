package examples.ten_10.postgresHomemade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;

public class PostgresSavepointApp {

	private static Connection conn;
	private static Statement statement;
//	private static PreparedStatement prepStatementStudents;
	
	public static void main(String[] args) {
		
		try {
			
			connect();
	        Statement deleteStmt = conn.createStatement(); 

	        conn.setAutoCommit(false); 
	        Savepoint beforeDeleteSavepoint = conn.setSavepoint(); 

	        String deleteQuery = "DELETE FROM ave.students WHERE id > 15;\n"; 
	        
	        deleteStmt.executeUpdate(deleteQuery); 
			showAllStudents();
			
	        conn.rollback(beforeDeleteSavepoint); 
			showAllStudents();
	        
	        conn.commit(); 
			
			showAllStudents();
			
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			disconnect();
		}
	}


	
	public static void connect() throws SQLException{
		try {
			// jar file postgresSQL must be included
			Class.forName("org.postgresql.Driver");
			
			try {	
				Properties authProperties = new Properties();
				authProperties.put("user", "postgres"); 					
				authProperties.put("password", "129fghSQL"); 				
				
				String url = "jdbc:postgresql://localhost:5432/avecoder";	
				
				conn = DriverManager.getConnection(url, authProperties);
				statement = conn.createStatement();
				
			} catch (SQLException e) {
				throw new SQLException("Unable to connect");
			} 
		} catch (ClassNotFoundException e) {
		    System.out.println("JDBC Driver is not found");
		    e.printStackTrace();
		}
	}

	
	public static void disconnect() {
		try {
			if(statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

	
	private static void insertStudents() throws SQLException {
        PreparedStatement prepStatementStudents = conn.prepareStatement("insert INTO ave.students " +
                "(id, name, pass_series, pass_number) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		for(int i = 0; i < 9_000; i++ ) {
			prepStatementStudents.setInt(1,  i )   ;
			prepStatementStudents.setString(2, "Student");
			prepStatementStudents.setString(3, Integer.toString(1000 + i) );
			prepStatementStudents.setString(4, Integer.toString(1000_0000 + i) );
			prepStatementStudents.executeUpdate();
		}
		System.out.println("Stundents was inserted in table");
		
		
		/*
		● Создайте таблицу студенты (students): id, имя, серия паспорта, номер паспорта;		// +
		DROP TABLE IF EXISTS ave.students;

		CREATE TABLE ave.students (
				id serial NOT NULL,
				name text NOT NULL,
				pass_series CHAR(4) NOT NULL,
				pass_number CHAR(8) NOT NULL,
				PRIMARY KEY (id)
			);
			
		DELETE FROM ave.students;
		*/
	}

	
	private static void insertStudentsAutoCommitFalse() throws SQLException {
        PreparedStatement prepStatementStudents = conn.prepareStatement("insert INTO ave.students " +
                "(id, name, pass_series, pass_number) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		conn.setAutoCommit(false);
		for(int i = 0; i < 9_000; i++ ) {
			prepStatementStudents.setInt(1,  i )   ;
			prepStatementStudents.setString(2, "Student");
			prepStatementStudents.setString(3, Integer.toString(1000 + i) );
			prepStatementStudents.setString(4, Integer.toString(1000_0000 + i) );
			//prepStatementStudents.executeUpdate();
			prepStatementStudents.addBatch();
		}
		prepStatementStudents.executeBatch() ;
		conn.commit();
		System.out.println("Stundents was inserted in table");
	}
	
	
	
    private static void showAllStudents() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM ave.students ORDER BY ID ASC;");
        while (rs.next()) {
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	String pass_series = rs.getString("pass_series");
        	String pass_number = rs.getString("pass_number");

        	System.out.printf("%d %s %s %s\n", id, name, pass_series, pass_number);
        }
        System.out.println();
    }
	
	
}
