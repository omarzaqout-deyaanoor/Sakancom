package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import conn.connect;

public class Dashboard{

	protected int id_House;	
	protected int num_floor;
	protected int num_apartment;
	
	protected int available;
	protected String name_apart[];
	protected boolean adding;
	private static final Logger logger = Logger.getLogger(Owner_add_houses.class.getName());
	
	
	public Dashboard() {
		this.adding = false;
	}
	
	

	public Dashboard(int id_House, int num_floor, int num_apartment,
			int available, String A[]) {
		
		this.id_House = id_House;
		this.num_floor = num_floor;
		this.num_apartment = num_apartment;
		this.available = available;
		this.name_apart = A;
		
		
		
	}
	
	
	
	public boolean add(loginpage loginO) throws SQLException {
		connect con =new connect();
		con.func();
		int num_floor=this.num_floor;
		int num_apart=this.num_apartment;
		adding = false;
		if(loginO.isLoggedOwner()) {
		for(int i=1;i<=num_floor;i++) {
		
			String insert_floor="INSERT INTO `floors`( `id_houses`,`number_floor`) VALUES (?,?);";

			logger.log(Level.INFO,"the owner loggin");
			try(PreparedStatement statement = con.getConnection().prepareStatement(insert_floor)) {
				
				statement.setInt(1, this.id_House);
				statement.setInt(2,i);

				statement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j=1;j<=num_apart;j++) {
			
				String insert_apartment="INSERT INTO `apartments`( `id_houses`, `available`, `name`, `id_floors`,`number_apart`) VALUES (?,?,?,?,?);";

				logger.log(Level.INFO,"the owner loggin");
				try(PreparedStatement statement = con.getConnection().prepareStatement(insert_apartment)) {
					
					
					statement.setInt(1, this.id_House);
					statement.setInt(2, this.available);
					statement.setString(3, this.name_apart[j]);
					statement.setInt(4, i);

					statement.setInt(5, j);

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

