package br.com.arq.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.arq.dtorequest.UsersRequest;
import br.com.arq.entity.Users;
import br.com.arq.repository.UsersRepository;
import br.com.arq.service.UsersService;

@ResponseBody
@RestController
@RequestMapping("/api/users")
public class UsersControl {

	@Autowired
	private UsersRepository usersRespository;

	@Autowired
	private UsersService service;

	@GetMapping("/listAll")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(200).body(usersRespository.findAll());
	}

 
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody @Validated UsersRequest request) {
		try {
			Users users = new Users();
			users.setName(request.getName());
			users.setEmail(request.getEmail());
			users.setPassword(service.criptografia(request.getPassword()));
			users.setToken(service.tokenAcesso(users.getEmail()));
			users.setStatus("created");

			Users resp = usersRespository.save(users);
			if (resp == null) {
				throw new IllegalArgumentException("error encontrado");
			}
			return ResponseEntity.status(200).body("chave: " + users.getToken());
		} catch (Exception ex) {
			return ResponseEntity.status(500).body("error:   " + ex.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsersRequest request,
			@RequestHeader("chave") String chaveBruta) {
		try {
			Users users = new Users();
			users.setEmail(request.getEmail());
			users.setPassword(service.criptografia(request.getPassword()));
			Users resp = usersRespository.findByEmailAndPassword(users.getEmail(), 
					users.getPassword());
		
			if (resp.getToken().equals(chaveBruta)) {
				return ResponseEntity.status(200).body("logado : " + resp);
			} else {
				return ResponseEntity.status(500).body("Nao logado : " + request.getName());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body("Error " + ex.getMessage());
		}

	}
}
