package poe.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.api.dto.ProposerUnTrajetDTO;
import poe.spring.domain.Trajet;
import poe.spring.service.TrajetManagerService;

@RestController
@RequestMapping("/api/trajet") // je crée/déclare cette url qui sera affiché à l'appel
public class TrajetRestControlleur {

	
	@Autowired
	TrajetManagerService trajetManagerService;
	
	@PostMapping
	public Trajet save(@RequestBody ProposerUnTrajetDTO trajet) {
		Trajet nouveauTrajet = trajetManagerService.creation (trajet.getConducteurId(), trajet.getVilleDepart(), trajet.getVilleArrivee(), 
				trajet.getDateDepart(), trajet.getPrixTrajet(), trajet.getNbPlaces());
			return nouveauTrajet;
		}
	@GetMapping
	public List<Trajet> lister(){
		List<Trajet> listeTrajet = trajetManagerService.lister();
		return listeTrajet;
	}
	}

