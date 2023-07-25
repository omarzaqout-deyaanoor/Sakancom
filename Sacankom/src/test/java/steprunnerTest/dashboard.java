package steprunnerTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Dashboard;
import classes.Owner_add_houses;
import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dashboard {
    private static final Logger logger = Logger.getLogger(owner_add_house.class.getName());
	loginpage loginO;
	Dashboard owner_add ;
	
	public dashboard(Dashboard owner_add) {
		this.loginO=new loginpage("omar","321");
		this.owner_add=owner_add;
	}
	
	@Given("The owner is log")
	public void the_owner_is_log() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			loginO.validateCredentials("omar","321");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("i want to add")
	public void i_want_to_add() {
	    // Write code here that turns the phrase above into concrete actions
		String A[]= {"aaaa","bbbb","cccc","ddd","eee","fff"};
		owner_add=new Dashboard(16,3,3,0,A);
	}

	@When("adding floor and apartments")
	public void Adding_floor_and_apartments() throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		owner_add.add(loginO);
	}

	@Then("add Done")
	public void add_done() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(true,owner_add.added());
	}

	@Given("The owner is not login")
	public void the_owner_is_not_login() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			loginO.validateCredentials("omar", "311");
			loginO.logout_owner();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("i want to adding the floor and apartments")
	public void i_want_to_adding_the_floor_and_apartments() {
	    // Write code here that turns the phrase above into concrete actions
		String A[]= {"sdf","hj","bbb","hhgg","ujhgf","kjhgf"};
		owner_add=new Dashboard(5,2,2,0,A);}

	@When("Adding floor and apartments")
	public void adding_floor_and_apartments() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(false,owner_add.added());	}

	@Then("error messages DB {string}")
	public void error_messages_db(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(Level.INFO,"error "+string);
	}

	
}