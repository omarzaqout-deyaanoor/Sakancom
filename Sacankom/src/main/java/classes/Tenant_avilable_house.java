package classes;

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
		String num_house="SELECT COUNT(*) FROM `houses` WHERE `availability`=1;";
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
		String select_house="SELECT `id`, `name`, `image`, `location`, `available_services`, `price`, `information` FROM `houses` WHERE `availability`=1;";
		con.func();
		
		try(Statement stmt = con.getConnection().createStatement()) {
			if(login.isLoggedTenant()) {
			
			ResultSet rs=stmt.executeQuery(select_house);
			if(this.is_found()) {
			while(rs.next()){
				int id_house = rs.getInt("id");
				 String name = rs.getString("name");
				 String image = rs.getString("image");
				 String location = rs.getString("location");
				 String available_services = rs.getString("available_services");
			     int price = rs.getInt("price");
			     String information = rs.getString("information");
			        logger.log(Level.INFO,id_house + ", " + name + ", " + image +
	                           ", " + location + ", " + available_services+"," + price + ", " + information);
			       
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
