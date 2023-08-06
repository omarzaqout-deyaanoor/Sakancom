package steprunnerTest;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import classes.book_accommodation;
import classes.loginpage;
import classes.tenant_control_panel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tenant_Control_Panel {

	private static final Logger logger = Logger.getLogger(Tenant_Control_Panel.class.getName());
	loginpage login;
	tenant_control_panel tenCON;
	book_accommodation book;
	
	
	public Tenant_Control_Panel(tenant_control_panel tenCON,book_accommodation book) {
		this.login=new loginpage("ali","123456");
		this.tenCON=tenCON;
		this.book=book;
	}
	
	@Given("The Tenant is login")
	public void the_tenant_is_login() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("ali", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("i want  tenant control panel")
	public void i_want_tenant_control_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    tenCON=new tenant_control_panel();
	}
	

@When("booking accommodation to after")
public void booking_accommodation_to_after() throws SQLException {
    // Write code here that turns the phrase above into concrete actions
	book=new book_accommodation(89,56,71);
	book.insert_book(login);
  assertEquals(true,book.Booking());
  tenCON.personal_data(login);
}

	@Then("doneee")
	public void doneee() {
	    // Write code here that turns the phrase above into concrete actions
	   assertEquals(true,tenCON.doneee());
	}

	@When("not booking accommodation to after")
	public void not_booking_accommodation_to_after() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(false,book.Booking());
	}

	@Then("error messages not donee {string}")
	public void error_messages_not_donee(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(Level.INFO,"error "+string);
	}

	@Given("The Tenant is not loginnn")
	public void the_tenant_is_not_loginnn() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			login.validateCredentials("ali", "2334");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("error messages not done not login {string}")
	public void error_messages_not_done_not_login(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(Level.INFO,"error "+string);
	}
	
}
