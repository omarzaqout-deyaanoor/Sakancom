package classes;

import java.sql.SQLException;
//import java.util.Scanner;
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
	loginpage login=new loginpage("omar","321");
	//login.validateCredentials("ali","123456");
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
	
	//Tenant_avilable_house t=new Tenant_avilable_house();
	//System.out.println(t.is_found());
	//t.Select_houses(login);
	login.validateCredentials("omar", "321");
	/*int bath[]= {1,1,3,4,2};
	int bed[]= {2,3,2,2,2,2};
	boolean bal[]= {true,true,true,true};
	Dashboard dashe=new Dashboard(16, 2, 1, bath, bed, bal);
	dashe.add(login);*/
	//tenant_add_furniture tn=new tenant_add_furniture("bag",200);
//	tn.add_furniture(login);
	Control_Panel cn=new Control_Panel();
//	cn.Select_houses(login);
//	cn.count_tanents(89);
//	cn.num_floor(88);
//	cn.num_apartment(50);
	cn.num_details(71);
	//book_accommodation B=new book_accommodation(89,57,71);
	//B.insert_book(login);
	    	
	
	     
		
	     
		
		
		
	}

}
