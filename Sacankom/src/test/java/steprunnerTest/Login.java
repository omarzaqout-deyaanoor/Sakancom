package steprunnerTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	 private static final Logger logger = Logger.getLogger(Login.class.getName());
	String user_name,password;
    loginpage login;
    public Login() {
    	login=new loginpage("zaqout","123");
    	
    	}
	
	@Given("the user_name is {string}")
	public void the_user_name_is(String string) {
	    this.user_name = string;
	}
///
	@Given("the password is {string}")
	public void the_password_is(String string) {
	    this.password = string;
	}
	@When("accept")
	public void accept() {
		try {
			login.validateCredentials(user_name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("login success")
	public void login_success() {
	    
			assertEquals(true,login.isLogged());
	

	}

	@Then("Done")
	public void done() {
	     assertEquals(true,login.isLogged());

	}

	@Then("Welcome")
	public void welcome() {
		logger.log(Level.INFO,"Welcome");


	}
	@When("dont accept")
	public void dont_accept() {
	    // Write code here that turns the phrase above into concrete actions
		user_name="deyaa";
	     password="321";
        
			try {
				login.validateCredentials(user_name, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Then("login faild")
	public void login_faild() {
	     
			assertEquals(false,login.isLogged());
			
	     

	}

	@Then("sorry, try again")
	public void sorry_try_again() {
	    assertEquals(false,login.isLogged());
	    logger.log(Level.INFO,"fail");

	}
	
}
