package steprunnerTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Owner_add_houses;
import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class owner_add_house {
    private static final Logger logger = Logger.getLogger(owner_add_house.class.getName());
	loginpage login;
	Owner_add_houses owner_add ;
	
	public owner_add_house(Owner_add_houses owner_add) {
		this.login=new loginpage("omar","321");
		this.owner_add=owner_add;
	}
	
	
	@Given("the owner is log")
	public void the_owner_is_log() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("omar", "321");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Given("i want to adding the house")
	public void i_want_to_adding_the_house() {
	    // Write code here that turns the phrase above into concrete actions
		owner_add=new Owner_add_houses("beit_wazann","hellooo","ttt","t",500,"aaa");

	}

	@When("adding houses")
	public void adding_houses() throws SQLException {
	   //  Write code here that turns the phrase above into concrete actions
		owner_add.add(login);
		
	}

	@Then("adding done")
	public void adding_done() {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(true,owner_add.added());
	}

	@Given("the owner is not login")
	public void the_owner_is_not_login() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("omar", "311");
			login.logout_owner();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Then("error messages {string}")
	public void error_messages(String message) {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(Level.INFO,"error "+message);
	}
	
	
}
