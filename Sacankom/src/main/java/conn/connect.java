package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class connect {
	protected Connection connection;
	
    public void func() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakancom","root","");
            		
            		System.out.print("success conected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeStatement(String sqlStatement) {
    	 try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery(sqlStatement);

                if (resultSet.next()) {
                    int totalRows = resultSet.getInt("total_rows");
                    System.out.println("Total rows in the users table: " + totalRows);
                }
                else {
                    System.out.println("Connection is not established. Please call establishConnection() first.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
   

    
    
}
    // Other methods and code for your database connection
