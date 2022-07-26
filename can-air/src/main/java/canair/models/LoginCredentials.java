package canair.models;

/**
 * Model for a client-side login attempt.
 */
public class LoginCredentials {
	
	private String username;
	private String password;
	
	public LoginCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LoginCredentials() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
