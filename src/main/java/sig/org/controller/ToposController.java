package sig.org.controller;


import java.security.Principal;
import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

import sig.org.metier.IReservation;
import sig.org.metier.Iregion;
import sig.org.metier.Itopos;
import sig.org.metier.Iutilisateur;



@Controller
public class ToposController {
	private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

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
Utilisateur user;

try {
	user = utilisateurMetier.findByEmail(name);
	String nom=user.getNom();
	  model.addAttribute("nom",nom);
	 
	List<Topos>listTopos=toposMetier.getAllTopos();
	model.addAttribute("listTopos",listTopos);
	
		
		  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user);
		  model.addAttribute("listToposPossede",listToposPossede);
		 
		  
		  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user);
		  model.addAttribute("listReservationTopos",listReservationTopos);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
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
	  LOG.info("delete Reservation ");
	try {
	 String name = principal.getName();
	 Utilisateur user = utilisateurMetier.findByEmail(name);
	 String nom=user.getNom();
	  model.addAttribute("nom",nom);
	Reservation reservation;
	
		reservation = reservationMetier.getReservationById(id);
		reservationMetier.deleteReservation(reservation);
		  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user);
		  model.addAttribute("listReservationTopos",listReservationTopos);
		  
		  List<Topos>listTopos=toposMetier.getAllTopos();
			model.addAttribute("listTopos",listTopos);
			
				
				  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user);
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
	  LOG.info("create Reservation ");
	try {
	 String name = principal.getName();
	 Utilisateur  user = utilisateurMetier.findByEmail(name);
	 String nom=user.getNom();
	  model.addAttribute("nom",nom);
	
		Topos topos=toposMetier.getToposById(id);
		Utilisateur utilisateurP = utilisateurMetier.getByNom(topos.getUtilisateur().getNom());
		Reservation reservation=new Reservation(topos, user, "demande", utilisateurP);
		reservationMetier.createReservation(reservation);
		
		
		 List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user);
		  model.addAttribute("listReservationTopos",listReservationTopos);
		  
		  List<Topos>listTopos=toposMetier.getAllTopos();
			model.addAttribute("listTopos",listTopos);
			
				
				  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user);
				  model.addAttribute("listToposPossede",listToposPossede);
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return "toposList";
	
}
/**
 * modifie reservation statut(validé) et topos status(reservé)
 * @param id
 * @param model
 * @param principal
 * @return
 */
@GetMapping("/updateToposAndReservation/{id}")
public String updateToposAndReservation(@PathVariable("id") long id,Model model,Principal principal) {
	
	  LOG.info("update Reservation and Topos ");
		try {
			
			 String name = principal.getName();
			 
			 Utilisateur user = utilisateurMetier.findByEmail(name);
			 String nom=user.getNom();
			  model.addAttribute("nom",nom);
			Reservation reservation;
			reservation = reservationMetier.getReservationById(id);
			  Topos topos=toposMetier.getNomTopos(reservation.getTopos().getNom());
			  reservationMetier.updateReservationTopos(reservation, topos);
			  
			  
			  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user);
			  model.addAttribute("listReservationTopos",listReservationTopos);
			  
			  List<Topos>listTopos=toposMetier.getAllTopos();
				model.addAttribute("listTopos",listTopos);
				
					
					  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user);
					  model.addAttribute("listToposPossede",listToposPossede);
			  
					  
					  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	 
	
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
	  LOG.info("create Topos");
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	List<Utilisateur>listUtilisateur = utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	
		List<Region>listRegion = regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
	
	
	if (result.hasErrors()) {
        return "formulaireTopos";
    }else {
     
 try {
	 String name1 = principal.getName();
	 Utilisateur user1 = utilisateurMetier.findByEmail(name1);
	 String nom=user1.getNom();
	  model.addAttribute("nom",nom);
	 topos.setUtilisateur(user1);
	toposMetier.createTopos(topos);
	 model.addAttribute("topos",topos );
	   
	 List<Topos>listTopos=toposMetier.getAllTopos();
	 model.addAttribute("listTopos",listTopos);

	 	
	 	  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user1);
	 	  model.addAttribute("listToposPossede",listToposPossede);
	 	 
	 	  
	 	  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user1);
	 	  model.addAttribute("listReservationTopos",listReservationTopos);	 
	 
} catch (Exception e) {
	// TODO Auto-generated catch block
	model.addAttribute("exception",e);
	
}
 

 

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
	  LOG.info("Topos est disponible ");
	try {
		String name = principal.getName();
		 
		 Utilisateur user = utilisateurMetier.findByEmail(name);	
		 String nom=user.getNom();
		  model.addAttribute("nom",nom);
		Topos topos=toposMetier.getToposByCodeTopos(id);
		toposMetier.updateStatutTopos(topos);
		
		
		 
		  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user);
		  model.addAttribute("listReservationTopos",listReservationTopos);
		  
		  List<Topos>listTopos=toposMetier.getAllTopos();
			model.addAttribute("listTopos",listTopos);
			
				
				  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user);
				  model.addAttribute("listToposPossede",listToposPossede);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	 
	  
	return  "toposList";
	
}



}
