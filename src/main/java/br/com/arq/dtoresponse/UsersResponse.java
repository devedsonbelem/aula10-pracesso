package br.com.arq.dtoresponse;

public class UsersResponse {

	 private String email; // fechado 
	 
	 private String token;
	 
	 private String message;
	 
	 
	 public UsersResponse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UsersResponse [email=" + email + ", token=" + token + ", message=" + message + "]";
	}
 
	public UsersResponse(String email, String token, String message) {
		super();
		this.email = email;
		this.token = token;
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	 ///users.getEmail() .... buscar ....
	/// users.getEmail() + "," + users.getToken();



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	
	 
}
