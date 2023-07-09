package steprunnerTest;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import classes.admin_add_advertising;
import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Admin_add_advertising {
	 private static final Logger logger = Logger.getLogger(admin_add_advertising.class.getName());
	loginpage admin;
	admin_add_advertising add_house;
	
	public Admin_add_advertising(admin_add_advertising add_house)
	{
		this.admin =new loginpage("abood","abood@123");
		this.add_house = add_house;
	}
	
	
@Given("the admin is log")
public void the_admin_is_log() {
    // Write code here that turns the phrase above into concrete actions
	admin.login("abood", "abood@123");
	
 
}

@Given("i want to add the house")
public void i_want_to_add_the_house() {
    // Write code here that turns the phrase above into concrete actions
 
	
}

@When("add house")
public void add_house() {
    // Write code here that turns the phrase above into concrete actions
	add_house.add(admin);
 
}

@Then("add done")
public void add_done() {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(true,add_house.added());
	
 
}

@Given("the admin is not login")
public void the_admin_is_not_login() {
    // Write code here that turns the phrase above into concrete actions
	admin.logout();
}

@Then("error message {string}")
public void error_message(String string) {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(false,add_house.add(admin));
	logger.log(Level.INFO,"can not add becouse the admin is not login");
}


}
