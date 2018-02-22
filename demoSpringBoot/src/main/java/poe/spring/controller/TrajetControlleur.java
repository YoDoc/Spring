package poe.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.domain.Trajet;
import poe.spring.domain.User;
import poe.spring.service.TrajetManagerService;

@Controller
@RequestMapping("/index")
public class TrajetControlleur {

	@Autowired
	TrajetManagerService trajetManagerService;
	
	@GetMapping("/nouveauTrajet")
	public String formulaire(Model model) {
		return "nouveauTrajet";
	}
	
	@PostMapping("/nouveauTrajet") 
	public String proposerTrajet(@Valid Trajet trajet, BindingResult bindRes, RedirectAttributes attr) {

		Trajet nouveauTrajet = trajetManagerService.creation(trajet.getVilleDepart(), trajet.getVilleArrivee(), 
				trajet.getDateDepart(), trajet.getPrixTrajet(), trajet.getNbPlaces());
		
		System.out.println("Trajet enregistré: \n Ville départ: " + nouveauTrajet.getVilleDepart() +"\n ville arrivée: "+ nouveauTrajet.getVilleArrivee());
		return "trajetValide" ;

	}
	
	@GetMapping("/trajetValide")
	public String validation() {
		return "trajetValide";

	}
}















