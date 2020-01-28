package beans;

public class Client {

	private String last_name;
	private String first_name;
	private String job_title;
	private String login;
	private String password;
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	
	/**
	 * Changement de mot de passe
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Client() {
		
	}
	
	public Client(String last_name, String first_name, String job_title, String login, String password) {
		super();
		this.last_name = last_name;
		this.first_name = first_name;
		this.job_title = job_title;
		this.login = login;
		this.password = password;
	}
	
}
