package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import conn.connect;

public class Tenant_avilable_house {

	loginpage login =new loginpage();
	connect con=new connect();
	private static final Logger logger = Logger.getLogger(Tenant_avilable_house.class.getName());
	protected boolean flag_found=false;
	

	
	
	public boolean is_found() throws SQLException {
		String num_house="SELECT COUNT(*) FROM `apartments` WHERE `avilable`=1;";
		con.func();
		Statement stmt = con.getConnection().createStatement();
		ResultSet rs=stmt.executeQuery(num_house);
		if(rs.next()) {
			int rowCount=rs.getInt(1);

			flag_found=rowCount>0;
		}
		
		
		
		return flag_found;
		
		
	}
	
	public void Select_houses(loginpage login) throws SQLException{
		String select_house="SELECT `name`, `image`, `location`, `available_services`, `price` FROM `houses` WHERE `id`=?;";
		String select_apart_avalabel="SELECT `id_apartment`, `id_floor`, `id_house` FROM `apartments` WHERE`avilable`='1';";
		con.func();
		
		try(Statement stmt = con.getConnection().createStatement()) {
			if(login.isLoggedTenant()) {
			
			ResultSet rs=stmt.executeQuery(select_apart_avalabel);
			if(this.is_found()) {
			while(rs.next()){
				int id_apartment = rs.getInt("id_apartment");
				int id_floor = rs.getInt("id_floor");
				int id_house = rs.getInt("id_house");
				
				
			   
			       
			        try (PreparedStatement preparedStatement = con.getConnection().prepareStatement(select_house)) {
			            preparedStatement.setInt(1,id_house);

			            try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                if (resultSet.next()) {
			                	String name = resultSet.getString("name");
			                	 String image = resultSet.getString("image");
			    				 String location = resultSet.getString("location");
			    				 String available_services = resultSet.getString("available_services");
			    			     int price = resultSet.getInt("price");

			    			     logger.log(Level.INFO,id_house + ", " +name+ ", "+id_floor + ", " + id_apartment +
				                           ", " + location + ", " + available_services+"," + price + ", ");
			                }
			            }
			        } 
				catch (SQLException e) {
			        e.printStackTrace();
			    }
					}
				}
			else {
				  logger.log(Level.INFO,"doesnt found any houses avilable ");
				  
				}		
			}
			else {
				logger.log(Level.INFO,"the Tenant is doesnt login");
			}
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean isFlag_found() {
		return flag_found;
	}

	public void setFlag_found(boolean flag_found) {
		this.flag_found = flag_found;
	}
	

	
	
	
	//control panel
	
	
	
}
