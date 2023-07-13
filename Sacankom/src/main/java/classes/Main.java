package classes;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import conn.connect;

public class Main {

	public static void main(String[] args) throws SQLException  {
		
		//connect connection =new connect();
		//connection.func();
		//connection.executeStatement("SELECT COUNT(*) AS total_rows FROM houses" );
		
		
		
		 final Logger logger = Logger.getLogger(Main.class.getName());
		

		
		
		
		
		// TODO Auto-generated method stub
//		admin_add_advertising admin=new admin_add_advertising();
////		
		//Scanner scan = new Scanner(System.in);
////		
		//String user=scan.next();
	//	String pass=scan.next();
	
/////		
//		
	loginpage login=new loginpage();
	login.validateCredentials("ali","123456");
///		//login.login("deyaa", "123");
//		
////		
//		System.out.print(login.flag_login_admin);
//		System.out.print(login.flag_login_owner);
//		System.out.print(login.flag_login_tenant);
////		
		

	//	Owner_add_houses add_house=new Owner_add_houses("beit_wazann","hellooo","ttt","t",500,"aaa");
	//	add_house.add(login);
	
	  //    admin_advertisement admin =new admin_advertisement();
	 //    admin.Select_houses(login);
	 //    int id =scan.nextInt();
	 //    admin.req_houses(id);
	
	Tenant_avilable_house t=new Tenant_avilable_house();
	System.out.println(t.is_found());
	t.Select_houses(login);

	    
	
	     
		
	     
		
		
		
	}

}
