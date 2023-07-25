package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import conn.connect;

public class tenant_add_furniture{
	protected String name;
	protected String name_tenant;
	protected int price;
	private static final Logger logger = Logger.getLogger(Owner_add_houses.class.getName());
	protected boolean add_f;
	
	
	public tenant_add_furniture() {
		this.add_f=false;
	}
	
	public tenant_add_furniture(String name,String name_tenant,int price) {
		
		this.name=name;
		this.name_tenant=name_tenant;
		this.price=price;
	}
	
	public boolean add_furniture(loginpage login) throws SQLException {
		connect con =new connect();
		con.func();
		String insert_furniture="INSERT INTO `furniture` ( `name`,`price`,`num_tenants`) VALUES (?,?,?);";
		
		
		//this.add = false;
		if(login.isLoggedTenant())
		{	
			logger.log(Level.INFO,"the tenant loggin");
			try(PreparedStatement statement = con.getConnection().prepareStatement(insert_furniture)) {
				
				statement.setString(1,this.name);
				statement.setInt(2, this.price);
				statement.setString(3, this.name_tenant);
				
				statement.executeUpdate();
				this.add_f=true;
				logger.log(Level.INFO,"the tenant is loggin");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			logger.log(Level.INFO,"the tenant not loggin");
		}
			return add_f;
			
		}
	
public boolean added_furniture() {
		
		return this.add_f;
	}
	
}