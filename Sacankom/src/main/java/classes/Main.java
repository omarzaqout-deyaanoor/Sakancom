package classes;

import java.sql.SQLException;
import java.util.Scanner;
//import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import conn.connect;


public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static final Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) throws SQLException  {
		
		while(true) {
			
		

		
		Scanner scan = new Scanner(System.in);
		logger.info("Enter Username ");
		String username=scan.next();
		logger.info("Enter Password ");
	 	String password=scan.next();
	
	 	
		
	loginpage login=new loginpage(username,password);
	login.validateCredentials(username,password);
///ADMIN
if(login.isLoggedAdmin()) {
	
	admin_advertisement admin_adv=new admin_advertisement();
	admin_watching_res admin_Watch=new admin_watching_res();
	logger.info("login AS Admin ");


	boolean flag_admin=true;
	while(flag_admin) {
		logger.info("1- Show add requests \n"+"2-  Watching reservations \n 3- Logout Admin \n choise option");
		int S_swith=scan.nextInt();
		switch(S_swith) {
	case 1 : Admin_switch1(admin_adv,login); 
    break;
	case 2 : Admin_switch2(admin_Watch,login);
	break;
	case 3 : Admin_switch3(login);
	flag_admin=false;
	break;
	default:logger.info("The number is not exist ");
	
	}
	
	
	}
	
		
}
//OWNER
else if(login.isLoggedOwner()) {
	
	Owner_add_houses ownir_add=new Owner_add_houses();
	Dashboard Db=new Dashboard();
	Control_Panel CP=new Control_Panel();
	logger.info("login AS Owner ");
	
	boolean flag_Owner=true;
	while(flag_Owner) {
		
		logger.info("1- Adding house \n"+"2-  Dashboard \n 3-  Control Panel \n 4- Logout Admin \n choise option");
		int S_swith2=scan.nextInt();
		switch(S_swith2) {
	case 1 : Owner_switch1(ownir_add,login); 
break;
	case 2 : Owner_switch2(Db,login);
	break;
	case 3 : Owner_switch3(CP,login);
	break;
	case 4 : Owner_switch4(login);
	flag_Owner=false;
	break;
	default:logger.info("The number is not exist ");
	
	}
	
	
	}	
	
}

///Tenant
else if(login.isLoggedTenant()) {
	
	Tenant_avilable_house tenant_aval=new Tenant_avilable_house();
	book_accommodation tenant_book=new book_accommodation();
	tenant_add_furniture tenant_furniture=new tenant_add_furniture();
	tenant_control_panel tenant_CP =new tenant_control_panel();
	logger.info("login AS Tenant ");

	
	boolean flag_tenant=true;
	while(flag_tenant) {
		logger.info("1- Show available housing \n"+"2-  book accommodation \n 3- Adding furniture \n 4-  The presence of a tenant control panel \n 5- Logout Tenant \n choise option");
		int S_swith=scan.nextInt();
		switch(S_swith) {
	case 1 : Tenant_switch1(tenant_aval,login); 
    break;
	case 2 : Tenant_switch2(tenant_book,login);
	break;
	case 3 : Tenant_switch3(tenant_furniture,login);
	break;
	case 4 : Tenant_switch4(tenant_CP,login);
	break;
	case 5 : Tenant_switch5(login);
	flag_tenant=false;
	break;
	default:logger.info("The number is not exist ");
	
	}
	
	
	}
	
		
}


		}
	}
	//Admin
	public static void Admin_switch1(admin_advertisement admin_adv,loginpage login) throws SQLException {
			
		admin_adv.Select_houses(login);
			logger.info("Enter the id house ");
			int id_house=scan.nextInt();
			admin_adv.req_houses(id_house);
			
		}
	public static void Admin_switch2(admin_watching_res admin_Watch,loginpage login) throws SQLException {
		
		admin_Watch.watching(login);
		
	}
	public static void Admin_switch3(loginpage login) throws SQLException {
		
		login.logout_admin();
		logger.info("Admin IS Logged out ");
		
	}
//owner
	
	public static void Owner_switch1(Owner_add_houses owner_adv,loginpage login) throws SQLException {
		logger.info("Enter name_House ");
		String name_House=scan.next();
		logger.info("Enter picture_House ");
		String picture_House=scan.next();
		logger.info("Enter location_House ");
		String location_House=scan.next();
		logger.info("Enter available_services_House ");
		String available_services_House=scan.next();
		logger.info("Enter price_House ");
		int price_Housescan=scan.nextInt();
		logger.info("Enter information_contact ");
		String information_contact=scan.next();
		
		
		owner_adv=new Owner_add_houses(name_House,picture_House,location_House,available_services_House,price_Housescan,information_contact);
		
		owner_adv.add(login);
			
		}
	public static void Owner_switch2(Dashboard Db,loginpage login) throws SQLException {
		
		
		logger.info("Enter id_House ");
		int id_House=scan.nextInt();
		logger.info("Enter num_floor ");
		int num_floor=scan.nextInt();
		logger.info("Enter is_student ");
		int is_student=scan.nextInt();
		logger.info("Enter num_apartment ");
		int num_apartment=scan.nextInt();
		int[] bath = new int[num_apartment];
		int[] bed = new int[num_apartment];
		boolean[] bal = new boolean[num_apartment];
		
		for(int i=0,j=1;i<num_apartment;i++,j++) {
			logger.info("Enter num of bathroom for the apartment ("+j+")");			
			 bath[i]=scan.nextInt();
			 logger.info("Enter num of bedroom for the apartment ("+j+")");
			 bed[i]=scan.nextInt();
			 logger.info("Enter true or false of balcony for the apartment ("+j+")");
			 bal[i]=scan.nextBoolean();
		}
			Db=new Dashboard(id_House,num_floor, num_apartment,is_student, bath, bed, bal);
			Db.add(login);
	}
	public static void Owner_switch3(Control_Panel CP,loginpage login) throws SQLException {
		
		 CP.Select_houses(login);
		 logger.info("Enter id_House ");
			int id_House=scan.nextInt();
		 CP.count_tanents(id_House);
		 CP.num_floor(id_House);
			logger.info("Enter num_floor ");
			int num_floor=scan.nextInt();
		 CP.num_apartment(num_floor);
		 logger.info("Enter num_apartment ");
			int num_apartment=scan.nextInt();
		 CP.num_details(num_apartment);
		
	}
	
public static void Owner_switch4(loginpage login) throws SQLException {
		
		login.logout_owner();
		logger.info("Owner IS Logged out ");
		
	}
//Tenant
public static void Tenant_switch1(Tenant_avilable_house tenant_aval,loginpage login) throws SQLException {
	
	tenant_aval.Select_houses(login);
		
	}
public static void Tenant_switch2(book_accommodation tenant_book,loginpage login) throws SQLException {
	logger.info("Enter id_house ");
	int id_house=scan.nextInt();
	logger.info("Enter id_floor ");
	int id_floor=scan.nextInt();
	logger.info("Enter id_apart ");
	int id_apart=scan.nextInt();
	
	
	tenant_book=new book_accommodation(id_house,id_floor,id_apart);
	tenant_book.insert_book(login);
	
}
public static void Tenant_switch3(tenant_add_furniture tenant_furniture,loginpage login) throws SQLException {
	
	logger.info("Enter name ");
	String name=scan.next();	
	logger.info("Enter price ");
	int price=scan.nextInt();
	
	tenant_furniture=new tenant_add_furniture(name,price);
	tenant_furniture.add_furniture(login);
	
}
public static void Tenant_switch4(tenant_control_panel tenant_CP,loginpage login) throws SQLException {
	
	tenant_CP.personal_data(login);
	
}
public static void Tenant_switch5(loginpage login) throws SQLException {
	
	login.logout_tenant();
	logger.info("Tenant IS Logged out ");
}

}
