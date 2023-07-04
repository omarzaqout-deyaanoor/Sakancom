package classes;

public class loginpage {

	protected boolean flag_login;
	protected String username;
	protected String password;
	

	
	public loginpage(String username,String password) {
		
		this.flag_login = false;
		this.username = username;
		this.password=password;
	}
	
	public loginpage(){
		this.username = "adham";
        this.password = "123";
	}

	public boolean login(String userName, String password) {
		this.flag_login = this.username.equals(userName);
		this.flag_login = this.password.equals(password);
		return this.flag_login;
	}
	
	public boolean isLogged() {
		return this.flag_login;
	}
}
