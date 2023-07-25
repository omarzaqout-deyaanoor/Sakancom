package classes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import conn.connect;


public class Tenante_Book_Accommodation{
	
	protected int id_user;
	protected int id_house;
	protected int id_floor;
	protected int id_apart;
	 private static final Logger logger = Logger.getLogger(Owner_add_houses.class.getName());
	
	loginpage login =new loginpage();
	connect con=new connect();
	
	protected boolean flag_book=false;
	public  Tenante_Book_Accommodation(int id_house,int id_floor,int id_apart) {
		this.id_house=id_house;
		this.id_floor=id_floor;
		this.id_apart=id_apart;

		
	}
	public void reservations(loginpage login) throws SQLException{
		String select_id="SELECT `id` FROM `users` WHERE`username`"+login.username+";";
		con.func();
		
		try(Statement stmt = con.getConnection().createStatement()) {
		
			
			ResultSet rs=stmt.executeQuery(select_id);
			if(rs.next()) {
			while(rs.next()){
				this. id_user = rs.getInt("id");
				
			
			}
			
		}
			
		}
String insert="INSERT INTO `reservations`( `id_user`, `id_house`, `id_floor`, `id_apart`) VALUES (?,?,?,?);";
		
		
flag_book = false;
		if(login.isLogged())
		{	
			logger.log(Level.INFO,"the owner logginnnnnn");
			try(PreparedStatement statement = con.getConnection().prepareStatement(insert)) {
				
				statement.setInt(1,this.id_user);
				statement.setInt(2,this.id_house);
				statement.setInt(3,this.id_floor);
				statement.setInt(4,this.id_apart);
				statement.executeUpdate();
				this.flag_book=true;
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			logger.log(Level.INFO,"the owner not loggin");
		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
//	//update
//		public void book_accommodation(int id) throws SQLException {
//			int idd=id;
//			int aval=1;
//			String ubd_aval="UPDATE `apartments` SET `available`="+aval+" WHERE`id`="+idd+" ;";
//			con.func();
//			Statement stmt = con.getConnection().createStatement();
//			stmt.executeUpdate(ubd_aval);
//			this.flag_book=true;
//		}
//
//		public boolean isFlag_book() {
//			return flag_book;
//		}
//	
	public boolean inserted() {
		return this.flag_book;
	}
	
}