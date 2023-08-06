package steprunnerTest;



import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Tenant_avilable_house;
import classes.admin_advertisement;
import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tenant_avilable_house {
	loginpage login;
	Tenant_avilable_house tenant_avl_house;
	 private static final Logger logger = Logger.getLogger(admin_advertisement.class.getName());

	
	public tenant_avilable_house(Tenant_avilable_house tenant_avl_house) {
		login=new loginpage("ali","123456");
		this.tenant_avl_house=tenant_avl_house;
		
	}
	
	
	@Given("login using tenant")
	public void login_using_tenant() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("ali", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@When("found house avilable")
	public void found_house_avilable() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			tenant_avl_house.is_found();
		//	assertEquals(true,tenant_avl_house.isFlag_found());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("show houses avilability")
	public void show_houses_avilability() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			tenant_avl_house.Select_houses(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("doesnt found house avilable")
	public void doesnt_found_house_avilable() throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		tenant_avl_house.is_found();
		logger.log(Level.INFO,"flag is "+tenant_avl_house.is_found());
	//	assertEquals(false,tenant_avl_house.isFlag_found());
	}

	@Then("null message")
	public void null_message() {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(Level.INFO,"doesn't found any house avilabile ");

	}

	@Given("doesnt login using tenant")
	public void doesnt_login_using_tenant() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("ale", "123457");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@When("i have to show house")
	public void i_have_to_show_house() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			tenant_avl_house.Select_houses(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("error message")
	public void error_message() {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(Level.INFO,"the user doesn't login ");

	}
}
