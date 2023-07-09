package classes;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class admin_add_advertising {
	protected static ArrayList<String[]> houses=new ArrayList<String[]>(); 
	protected String name_House;
	protected String picture_House;
	protected String location_House;
	protected String available_services_House;
	protected String price_House;
	protected String information_House;
	protected boolean determine_unit_availability_House;
	protected boolean add;
    private static final Logger logger = Logger.getLogger(admin_add_advertising.class.getName());
    protected String available;

	public static ArrayList<String[]> getHouses() {
		return houses;
	}
	public static void setHouses(ArrayList<String[]> houses) {
		admin_add_advertising.houses = houses;
	}
	public String getName_House() {
		return name_House;
	}
	public void setName_House(String name_House) {
		this.name_House = name_House;
	}
	public String getPicture_House() {
		return picture_House;
	}
	public void setPicture_House(String picture_House) {
		this.picture_House = picture_House;
	}
	public String getLocation_House() {
		return location_House;
	}
	public void setLocation_House(String location_House) {
		this.location_House = location_House;
	}
	public String getAvailable_services_House() {
		return available_services_House;
	}
	public void setAvailable_services_House(String available_services_House) {
		this.available_services_House = available_services_House;
	}
	public String getPrice_House() {
		return price_House;
	}
	public void setPrice_House(String price_House) {
		this.price_House = price_House;
	}
	public String getInformation_House() {
		return information_House;
	}
	public void setInformation_House(String information_House) {
		this.information_House = information_House;
	}
	public boolean getDetermine_unit_availability_House() {
		return determine_unit_availability_House;
	}
	public void setDetermine_unit_availability_House(boolean determine_unit_availability_House) {
		this.determine_unit_availability_House = determine_unit_availability_House;
	}
	public boolean isAdd() {
		return add;
	}
	public void setAdd(boolean add) {
		this.add = add;
	}

	
	
	
	
	
	
	///add
	public admin_add_advertising() {
		
		this.determine_unit_availability_House = true;
		this.add = false;
	}
	public boolean add(loginpage Admin) {
		add = false;
		if(Admin.isLogged())
		{
			available=String.valueOf(this.determine_unit_availability_House);
			String [] housee = {this.name_House,this.picture_House,this.location_House,this.available_services_House,this.price_House,this.information_House,available};
			if(admin_add_advertising.houses.add(housee))
				add=true;
		}
		else
		{
			logger.log(Level.INFO,"the admin not loggin");
		}
			return add;
			
		}
	public boolean added() {
		
		return this.add;
	}
	////End Add
	
	

	
	
	
	
	

}
