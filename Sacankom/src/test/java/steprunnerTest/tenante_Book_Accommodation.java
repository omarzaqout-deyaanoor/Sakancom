package steprunnerTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Owner_add_houses;
import classes.Tenante_Book_Accommodation;
import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tenante_Book_Accommodation{
	
	 private static final Logger logger = Logger.getLogger(owner_add_house.class.getName());
		loginpage login;
		Tenante_Book_Accommodation book ;
		
		public tenante_Book_Accommodation(Tenante_Book_Accommodation owner_add) {
			this.login=new loginpage("ali","123456");
			this.book=owner_add;
		}
		
		
		
		@Given("login Using tenant")
		public void login_using_tenant() {
		    // Write code here that turns the phrase above into concrete actions
			try {
				login.validateCredentials("ali","123456");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@When("Found house to avilable")
		public void found_house_to_avilable() {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
		}

		@When("i have to Book Accommodation")
		public void i_have_to_book_accommodation() {
		    // Write code here that turns the phrase above into concrete actions
			book=new Tenante_Book_Accommodation(16,1,1);
		}

		@Then("I Book Accommodation")
		public void i_book_accommodation() throws SQLException {
		    // Write code here that turns the phrase above into concrete actions
			book.reservations(login);
		}

		@When("Doesnt found house avilable")
		public void doesnt_found_house_avilable() {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
		}

		@Then("Null message")
		public void null_message() {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
		}

		@Given("doesnt login Using tenant")
		public void doesnt_login_using_tenant() {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
		}

		@Then("Error Message")
		public void error_message() {
		    // Write code here that turns the phrase above into concrete actions
		//    throw new io.cucumber.java.PendingException();
		}
	
}