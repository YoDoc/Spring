package poe.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.User;
import poe.spring.service.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	UserManagerService userManagerService;

	@PostMapping
	public User save(@RequestBody User user) {
		System.out.println("entree Save Controller");
		User savedUser = userManagerService.signup(user.getLogin(), user.getPwd());
		System.out.println("Sortie Save controller");
		return savedUser;
	}

	@GetMapping
	public List<User> lister (){
		List<User> liste = userManagerService.creerListe();
		return liste;
	}
	
	@GetMapping("/{userId}"){
	public User visualiser (@RequestParam(value = "id", defaultValue = "World") String name)){
		System.out.println("entree Controller");
		User existsUser = userManagerService.visualiserUser(id);
		System.out.println("Sortie Controller");

		return existsUser;
	}
	
	
}

