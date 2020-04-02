package sig.org.classe;




public class UtilisateurLogin {
	
	
	
	private String mail;
	private String password;
	
	
	public UtilisateurLogin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UtilisateurLogin(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
