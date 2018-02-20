package poe.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceTests {

	@Autowired
	UserManagerService userManagerService;

	@Test
	public void checkUserCreation() {

		User newUser = userManagerService.signup("John", "ea3sy");
		assertThat(newUser).isNotNull();
		System.out.println("User crée: \n id: "+newUser.getId()+"\n login: "+ newUser.getLogin() +"\n password: "+newUser.getPwd()+"\n  ");
		
		userManagerService.visualiserUser(1l);
		System.out.println(userManagerService.visualiserUser(1l));
		
		userManagerService.delete(1l);
		System.out.println("test de delete:");
		
		assertThat(userManagerService.visualiserUser(1l)).isNull();
		
	}

}
