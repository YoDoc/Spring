package poe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.Trajet;
import poe.spring.repository.TrajetRepository;

@Service
public class TrajetManagerService {

	@Autowired
	private TrajetRepository trajetRepository;

	public Trajet creation(String villeDepart, String villeArrivee, String dateDepart, int prixTrajet, int nbPlaces) {
		Trajet trajet = new Trajet();

		trajet.setVilleDepart(villeDepart);
		trajet.setVilleArrivee(villeArrivee);
		trajet.setDateDepart(dateDepart);
		trajet.setPrixTrajet(prixTrajet);
		trajet.setNbPlaces(nbPlaces);

		trajetRepository.save(trajet);

		return trajet;
	}

	public List<Trajet> lister() {
		List<Trajet> trajets = (List<Trajet>) trajetRepository.findAll();
		return trajets;
	}

}
