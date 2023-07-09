package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    public void func() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            		Connection con;
            		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakancom","root","");
            	
            		System.out.print("success conected");
            	

            

            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Other methods and code for your database connection
}