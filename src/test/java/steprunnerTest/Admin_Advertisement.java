package steprunnerTest;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import classes.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Admin_Advertisement {

	loginpage login;
	admin_advertisement admin_adv;
	
	
	public Admin_Advertisement(admin_advertisement admin_adv) {
		this.login=new loginpage("deyaa","123");
		this.admin_adv=admin_adv;
	}	
	@Given("admin is login")
	public void admin_is_login() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("deyaa", "123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("the administrator reviews the request")
	public void the_administrator_reviews_the_request() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			admin_adv.Select_houses(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("the request is Accept")
	public void the_request_is_accept() {
	    // Write code here that turns the phrase above into concrete actions
			try {
				admin_adv.req_houses(5);
				assertEquals(true,admin_adv.isAccept());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		

	}

	@Then("the advertisement for the housing property should be published")
	public void the_advertisement_for_the_housing_property_should_be_published() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(true,admin_adv.isAccept());
	}

	@When("the requests is reject")
	public void the_requests_is_reject() throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		admin_adv.req_houses(6);
		assertEquals(true,admin_adv.isReject());
	}

	@Then("the advertisement for the housing property should not be published")
	public void the_advertisement_for_the_housing_property_should_not_be_published() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(true,admin_adv.isReject());
	}
}
