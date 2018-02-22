package poe.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.domain.User;

@Controller
@RequestMapping("/index")
public class TrajetControlleur {

	@GetMapping("/nouveauTrajet")
	public String formulaire(Model model) {
		return "nouveauTrajet";
	}
	
	@PostMapping("/nouveauTrajet") 
	public String proposerTrajet() {
		
		return "nouveauTrajet" ;

	}
}
