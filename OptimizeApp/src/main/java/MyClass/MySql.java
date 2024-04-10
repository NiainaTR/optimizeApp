package MyClass;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringJoiner;

public class MySql {
	
	private Connection con; 
	
	
	public MySql() {}
	
	public void connectToDB() throws ClassNotFoundException {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			 String url = "jdbc:mariadb://localhost:3306/optiprice";
		     String username = "tsanta";
		      String pwd = "Azertyuiop123!";
			con = DriverManager.getConnection(url , username , pwd);
			System.out.println("Connect successfully to database");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet selectAll(String table) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + table;
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
	
	   // Méthode pour insérer des données dans une table
    public void insert(String table, String[] columns, String[] values) {
        try {
        	StringJoiner columnsJoiner = new StringJoiner(", ");
        	StringJoiner valuesJoiner = new StringJoiner(", ");
        	for (String column : columns) {
        	    columnsJoiner.add(column);
        	}
        	for (String value : values) {
        	    valuesJoiner.add("'" + value + "'");
        	}
        	String query = "INSERT INTO " + table + "(" + columnsJoiner.toString() + ") VALUES (" + valuesJoiner.toString() + ")";
        	System.out.println(query);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Inserted data successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
