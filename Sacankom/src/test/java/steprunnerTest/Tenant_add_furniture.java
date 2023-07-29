package steprunnerTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.tenant_add_furniture;

import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Tenant_add_furniture {
    private static final Logger logger = Logger.getLogger(owner_add_house.class.getName());
	loginpage login;
	tenant_add_furniture tenant_add ;
	
	public Tenant_add_furniture(tenant_add_furniture tenant_add) {
		this.login=new loginpage("ali","123456");
		this.tenant_add=tenant_add;
	}
	
	
	@Given("the tenant is log")
	public void the_tenant_is_log() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("ali","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("i want to adding the furniture")
	public void i_want_to_adding_the_furniture() {
	    // Write code here that turns the phrase above into concrete actions
		tenant_add=new tenant_add_furniture("chi",390);
	}

	@When("adding furniture")
	public void adding_furniture() throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		tenant_add.add_furniture(login);
	}

	@Then("Adding done")
	public void adding_done() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(true,tenant_add.added_furniture());
	}

	@Given("the tenant is not login")
	public void the_tenant_is_not_login() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("ali", "3254");
			login.logout_tenant();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@Then("error Messages {string}")
	public void error_messages(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(Level.INFO,"error "+string);
	}
}
