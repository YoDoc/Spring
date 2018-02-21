package poe.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/index")
public class InscriptionController {
	
	@GetMapping("/inscription")
	public String inscription (Model model) {
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String save (String login, RedirectAttributes attr) {
		System.out.println("Hello "+ login);
		// TODO faire la sauvegarde de l'utilisateur
		attr.addAttribute("login", login);
		return "redirect:/index/hello"; // Le return me REDIRIGE vers la page index/hello suivie du nom du login entré
	}
	
	
	@GetMapping("/hello")
	public String hello (String login, Model model) {
		model.addAttribute("name", login);
		return "hello";
	}
	
}
