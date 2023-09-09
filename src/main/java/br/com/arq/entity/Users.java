package br.com.arq.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class Users implements Serializable {

 
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private String status;
	private String token;
	@Indexed(unique=true)
	private String email;
	private String password;
	
	public Users() {
	 
	}
 
	public Users(String id, String name, String status, String token, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.token = token;
		this.email = email;
		this.password = password;
	}


   


	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", status=" + status + ", token=" + token + ", email=" + email
				+ ", password=" + password + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	

}
