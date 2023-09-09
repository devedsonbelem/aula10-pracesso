package br.com.arq.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

import org.springframework.stereotype.Service;

import br.com.arq.entity.Users;

@Service
public class UsersService {

	String secretWord = "profedsonbelem@gmail.comwww.arq.com.br=1=1+123;www.edsonbelemtreinamento.com.br";

	public String criptografia(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		Users user = new Users();
		user.setPassword(password);
		md.update((user.getPassword() + secretWord).getBytes()); // 123456profedsonbelem@gmail.comwww.arq.com.br=1=1+123;www.edsonbelemtreinamento.com.br
		BigInteger hash = new BigInteger(1, md.digest());
		String resposta1 = hash.toString(16);
		user.setPassword(resposta1);
		return user.getPassword();
	}

	public String tokenAcesso(String email) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		Users user = new Users();
		user.setEmail(email);
		md.update((user.getEmail() + secretWord).getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String resposta1 = hash.toString(16);
		user.setToken(resposta1); //
		return user.getToken();
	}

	public String chave = "minha_palavra_secreta_edson_beçem_de_souza_junior";

	public String encrypt(final String senha) {
		try {

			String texto1 = Base64.getEncoder().encodeToString((senha + chave).getBytes());
			LocalDateTime dataAtual = LocalDateTime.now();
			LocalDateTime dataDaquiA45Dias = dataAtual.plus(45, ChronoUnit.DAYS);

			String texto2 = Base64.getEncoder().encodeToString(dataDaquiA45Dias.toString().getBytes());

			return texto1 + "." + texto2;
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	/// pirataria ...

	public Boolean decrypt(String senhaCriptagrada) {
		try {
			System.out.println("nao chega");
			String partes[] = new String[2];
			partes = senhaCriptagrada.split("\\.");
			System.out.println(partes[1]);
			byte[] decodedBytes = Base64.getDecoder().decode(partes[1]);
			String resposta = new String(decodedBytes);

			System.err.println(resposta);
			String formatoData = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
			DateTimeFormatter padraoData = DateTimeFormatter.ofPattern(formatoData);
			LocalDateTime dataHoraConvertido = LocalDateTime.parse(resposta, padraoData);

			if (dataHoraConvertido.compareTo(LocalDateTime.of(2024, 1, 10, 10, 10, 0)) == 1) {

				System.out.println("Data está no Prazo");
				return true;
			} else {
				System.out.println(
						"Data Expirada" + (dataHoraConvertido.compareTo(LocalDateTime.of(2024, 1, 10, 10, 10, 0))));
				return false;
			}

		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
			return false;
		}

	}
}
