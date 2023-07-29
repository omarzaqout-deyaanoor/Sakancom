package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import conn.connect;
public class Dashboard{

	protected int id_House;	
	protected int num_floor;
	protected int num_apartment;
	protected int num_bathroom[];
	protected int num_bedroom[];
	protected boolean balcony[];
	protected int available;
	protected String name_apart[];
	protected boolean adding;
	int x;
	private static final Logger logger = Logger.getLogger(Owner_add_houses.class.getName());
	
	

	
	

	public Dashboard() {
		this.adding=false;
		
	}



	public Dashboard(int id_House, int num_floor, int num_apartment,
			 int bath[],int bed[],boolean balcony[]) {
		
		this.id_House = id_House;
		this.num_floor = num_floor;
		this.num_apartment = num_apartment;
		
		this.num_bathroom=bath;
		this.num_bedroom=bed;
		this.balcony=balcony;
		
		
		
		
	}
	
	
	
	public boolean add(loginpage loginO) throws SQLException {
		connect con =new connect();
		con.func();
		int num_floor=this.num_floor;
		
		int num_apart=this.num_apartment;
		adding = false;
		
		if(loginO.isLoggedOwner()) {
		for(int i=1;i<=num_floor;i++) {
			
			String insert_floor="INSERT INTO `floor`(`num_floor`,`id_house`,`num_apart`) VALUES (?,?,?);";

			logger.log(Level.INFO,"the owner loggin");
			try(PreparedStatement statement = con.getConnection().prepareStatement(insert_floor)) {
				statement.setInt(3, this.num_apartment);
				statement.setInt(2, this.id_House);
				statement.setInt(1,i);

				statement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j=1;j<=num_apart;j++) {
				
				String insert_apartment="INSERT INTO `apartments`( `id_house`,`id_floor`,`num_bathroom`,`num_bedroom`,`balcony`) VALUES (?,?,?,?,?);";
				String max_floor="SELECT MAX(id_floor) FROM `floor`;";
				logger.log(Level.INFO,"the owner loggin");
				try(PreparedStatement statement = con.getConnection().prepareStatement(insert_apartment)) {
	                 ResultSet resultSet = statement.executeQuery(max_floor);
	                if (resultSet.next()) {
	                    x = resultSet.getInt(1);
	                  //  x++;
	                    logger.info("X="+x);
	                }
					statement.setInt(1, this.id_House);
					statement.setInt(2, x);
					statement.setInt(3, this.num_bathroom[j]);
					statement.setInt(4, this.num_bedroom[j]);
					statement.setBoolean(5, this.balcony[j]);

					statement.executeUpdate();
					
					this.adding=true;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		}
		
		
		else
		{
			logger.log(Level.INFO,"the owner not loggin");
		}
			return this.adding;
			
		}
	
public boolean added() {
		
		return this.adding;
	}
	
}

