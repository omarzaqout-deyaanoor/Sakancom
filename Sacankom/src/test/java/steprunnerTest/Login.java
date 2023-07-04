package steprunnerTest;

import static org.junit.Assert.assertEquals;

import classes.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {

	String user_name,password;
    loginpage admin;
    public Login() {
    	admin=new loginpage("adham_12028277","123456789@adham");
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

	@Then("login success")
	public void login_success() {
	     assertEquals(true,admin.login(user_name,password));

	}

	@Then("Done")
	public void done() {
	     assertEquals(true,admin.isLogged());

	}

	@Then("Welcome")
	public void welcome() {
	     assertEquals(true,admin.isLogged());


	}

	@Then("login faild")
	public void login_faild() {
	     user_name="moheeb_12028277";
	     password="123456@adham";
             ;
	     assertEquals(false,admin.login(user_name, password));

	}

	@Then("sorry, try again")
	public void sorry_try_again() {
	    assertEquals(false,admin.isLogged());

	}
	
}
