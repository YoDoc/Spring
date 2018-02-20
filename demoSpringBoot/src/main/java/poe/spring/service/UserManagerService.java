package poe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	public User signup(String login, String pwd) {
		System.out.println("Entree signup de Service");
		
		User user = new User();
		user.setLogin(login);
		user.setPwd(pwd);

		userRepository.save(user);
		
		System.out.println("sortie SignUp Service");
		return user;
	}

	public List<User> creerListe() {
		List<User> liste = (List<User>) userRepository.findAll();
		return liste;
	}

	public User visualiserUser (Long id) {
		//System.out.println("Entree methode visualiserUser Service");
		User user = userRepository.findOne(id);
		//System.out.println("Sortie methode visualiserUser Service");

		return user;
		
			
	}

	public void delete(Long userId) {
		//System.out.println("Delete in Service");
		userRepository.delete(userId);
	}

	public long count() {
		return userRepository.count();
		 
	}
}
