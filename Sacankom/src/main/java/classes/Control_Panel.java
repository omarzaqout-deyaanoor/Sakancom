package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import conn.connect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Control_Panel {
	protected int owner_id;
	connect con=new connect();
	protected int count_tenants;
	protected boolean has_find;
	protected int num_floor;
	 private static final Logger logger = Logger.getLogger(admin_advertisement.class.getName());

	public Control_Panel() {
		
	}

	public void Select_houses(loginpage login) throws SQLException{
		con.func();
		String select_id="SELECT `id` FROM `users` WHERE `type_user`='owner' And `username`=?;";
		try (PreparedStatement preparedStatement = con.getConnection().prepareStatement(select_id)) {
            preparedStatement.setString(1, login.username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    this.owner_id = resultSet.getInt("id");
                }
            }
        } 
	catch (SQLException e) {
        e.printStackTrace();
    }
		String select_house="SELECT `id`, `name`, `image`, `location`, `available_services`, `price`, `information` FROM `houses` WHERE id_user=? And isAccept=1;";
		try (PreparedStatement preparedStatement = con.getConnection().prepareStatement(select_house)) {
            preparedStatement.setInt(1,this.owner_id);
            if(login.isLoggedOwner()) {
    		has_find=false;
            try (ResultSet rs = preparedStatement.executeQuery()) {
                
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
        			       this.has_find=true; 
        			}
                if(has_find==false) {
                	logger.info("doesnt have any house");
                }
               
            }
            }
            else {
				logger.log(Level.INFO,"the Owner is doesnt login");
			}   
        } 
	catch (SQLException e) {
        e.printStackTrace();
    }
		
			
		}
	
	public void count_tanents(int house_id) throws SQLException {
		con.func();
		String select_tan="SELECT COUNT(*) AS num_of_tenants FROM tanents WHERE id_house = ?;";
		try (PreparedStatement preparedStatement = con.getConnection().prepareStatement(select_tan)) {
            preparedStatement.setInt(1,house_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    this.count_tenants = resultSet.getInt("num_of_tenants");
                }
            }
            logger.info("count_tenants = "+this.count_tenants );
        } 
	catch (SQLException e) {
        e.printStackTrace();
    }
	}
	
	public void num_floor(int house_id) throws SQLException {
		con.func();
		String select_floor="SELECT COUNT(*) as floor FROM `floor` WHERE id_house= ?;";
		try (PreparedStatement preparedStatement = con.getConnection().prepareStatement(select_floor)) {
            preparedStatement.setInt(1,house_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    this.num_floor = resultSet.getInt("floor");
                }
            }
            logger.info("num_floor = "+this.num_floor );
        } 
	catch (SQLException e) {
        e.printStackTrace();
    }
	}
	}
	

	


