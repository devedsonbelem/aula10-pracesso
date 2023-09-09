package br.com.arq.dtorequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UsersRequest { 
 
	 @NotBlank(message = "nome nao Digitado") 
	 @NotEmpty(message="Digite letras") 
	 @Pattern(regexp ="[a-zA-Z ]{2,70}" , message="Fora do Padrao da Validacao Nome" )
	 private String name;
	 
	 @NotBlank(message = "Email nao Digitado")  
	 @NotEmpty(message="Digite letras") 
	 @Email(message="Fora do padrão do Email")
	 private String email;
	 
	 @NotBlank(message = "Senha nao Digitada") 
	 @NotEmpty(message="Digite letras")  
	 @Pattern(regexp ="[a-zA-Z0-9@!/.]{6,32}" , message="Fora do Padrao da Validacao Senha" )
	 private String password;
	 
	 private String token;
 
	 public UsersRequest() {
		 
	 }
	 
	 

	public UsersRequest(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}



	@Override
	public String toString() {
		return "UsersRequest [name=" + name + ", email=" + email + ", password=" + password + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}
	 
	
	 
}
