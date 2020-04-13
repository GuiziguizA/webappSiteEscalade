package sig.org.controller;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sig.org.classe.Region;
import sig.org.classe.Reservation;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.dao.ReservationRepository;
import sig.org.dao.UtilisateurRepository;
import sig.org.metier.IReservation;
import sig.org.metier.Iregion;
import sig.org.metier.Itopos;
import sig.org.metier.Iutilisateur;
import sig.org.metier.ReservationMetier;


@Controller
public class ToposController {
@Autowired
private Itopos toposMetier;	
@Autowired
private Iutilisateur utilisateurMetier;
@Autowired
private Iregion regionMetier;
@Autowired
private IReservation reservationMetier;

/**
 * controller affichant la listes des topos , ses topos et les demande de reservations
 * @param model
 * @param principal
 * @return
 */
@GetMapping("/consulterTopos")
public String consulterTopos(Model model,Principal principal) {
	 String name = principal.getName();
	 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);
	 
	List<Topos>listTopos=toposMetier.getAllTopos();
	model.addAttribute("listTopos",listTopos);
	
		
		  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user.get());
		  model.addAttribute("listToposPossede",listToposPossede);
		 
		  
		  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user.get());
		  model.addAttribute("listReservationTopos",listReservationTopos);
			 
    return "toposList";
}
/**
 * supprime reservation
 * @param id_reservation
 * @param model
 * @param principal
 * @return
 */
@GetMapping("/deleteReservation/{id}")
public String supprimerReservation(@PathVariable("id") long id,Model model,Principal principal) {
	 String name = principal.getName();
	 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);
	Reservation reservation;
	try {
		reservation = reservationMetier.getReservationById(id);
		reservationMetier.deleteReservation(reservation);
		  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user.get());
		  model.addAttribute("listReservationTopos",listReservationTopos);
		  
		  List<Topos>listTopos=toposMetier.getAllTopos();
			model.addAttribute("listTopos",listTopos);
			
				
				  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user.get());
				  model.addAttribute("listToposPossede",listToposPossede);
		  
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		model.addAttribute("error",e);
		
	}

	
	  return "toposList";
}
/**
 * creer reservation
 * @param id
 * @param model
 * @param principal
 * @return
 */
@GetMapping("/creerReservation/{id}")
public String creerReservation(@PathVariable("id") long id,Model model,Principal principal) {
	 String name = principal.getName();
	 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);
	try {
		Topos topos=toposMetier.getToposById(id);
		Utilisateur utilisateurP = utilisateurMetier.getByNom(topos.getUtilisateur().getNom());
		Reservation reservation=new Reservation(topos, user.get(), "demande", utilisateurP);
		reservationMetier.createReservation(reservation);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user.get());
	  model.addAttribute("listReservationTopos",listReservationTopos);
	  
	  List<Topos>listTopos=toposMetier.getAllTopos();
		model.addAttribute("listTopos",listTopos);
		
			
			  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user.get());
			  model.addAttribute("listToposPossede",listToposPossede);
	  
	
	return "toposList";
	
}
/**
 * modifie reservation statut(validé) et topos status(reservé)
 * @param id
 * @param model
 * @param principal
 * @return
 */
@GetMapping("/updateToposAndDeleteReservation/{id}")
public String updateToposAndDeleteReservation(@PathVariable("id") long id,Model model,Principal principal) {
	 String name = principal.getName();
	 
	 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);
	Reservation reservation;
	
		try {
			reservation = reservationMetier.getReservationById(id);
			  Topos topos=toposMetier.getNomTopos(reservation.getTopos().getNom());
			  reservationMetier.updateReservationTopos(reservation, topos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user.get());
	  model.addAttribute("listReservationTopos",listReservationTopos);
	  
	  List<Topos>listTopos=toposMetier.getAllTopos();
		model.addAttribute("listTopos",listTopos);
		
			
			  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user.get());
			  model.addAttribute("listToposPossede",listToposPossede);
	  
			  
			  
	
	  return "toposList";
}


/**
 * affiche formulaire reservation
 * @param topos
 * @param model
 * @return
 */

@GetMapping("/consulterFormulaireTopos")
public String voirFormulaire(Topos topos,Model model) {
	List<Utilisateur>listUtilisateur = utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	List<Region> listRegion;
	try {
		listRegion = regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 return "formulaireTopos";
}

/**
 * ajoute un topos a la DB
 * @param model
 * @param topos
 * @param result
 * @param principal
 * @return
 */

@PostMapping("/ajouterTopos")
public String AjouterUnTopos(Model model,@Valid Topos topos, BindingResult result,Principal principal) {
	 String name = principal.getName();
	 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);
	List<Utilisateur>listUtilisateur = utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	
		List<Region>listRegion = regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
	
	
	if (result.hasErrors()) {
        return "formulaireTopos";
    }else {
     
 try {
	 String name1 = principal.getName();
	 Optional<Utilisateur> user1 = utilisateurMetier.findByEmail(name);
	 topos.setUtilisateur(user1.get());
	toposMetier.createTopos(topos);
	 model.addAttribute("topos",topos );
	   
} catch (Exception e) {
	// TODO Auto-generated catch block
	model.addAttribute("exception",e);
	
}
 

 
List<Topos>listTopos=toposMetier.getAllTopos();
model.addAttribute("listTopos",listTopos);

	
	  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user.get());
	  model.addAttribute("listToposPossede",listToposPossede);
	 
	  
	  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user.get());
	  model.addAttribute("listReservationTopos",listReservationTopos);
	return "toposList";
	}
}

/**
 * change le statut du topos pour le rendre disponible
 * @param id
 * @param model
 * @param principal
 * @return
 */
@GetMapping("/updateTopos/{id}")
public String updateTopos(@PathVariable("id") long id,Model model,Principal principal) {
	String name = principal.getName();
	 
	 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);	
	try {
		Topos topos=toposMetier.getToposByCodeTopos(id);
		toposMetier.updateStatutTopos(topos);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	  
	  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user.get());
	  model.addAttribute("listReservationTopos",listReservationTopos);
	  
	  List<Topos>listTopos=toposMetier.getAllTopos();
		model.addAttribute("listTopos",listTopos);
		
			
			  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user.get());
			  model.addAttribute("listToposPossede",listToposPossede);
	  
	return  "toposList";
	
}



}
