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

@GetMapping("/creerReservation/{id}")
public String creerReservation(@PathVariable("id") long id,Model model,Principal principal) {
	 String name = principal.getName();
	 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);
	try {
		Topos topos=toposMetier.getToposById(id);
		Utilisateur utilisateurP = utilisateurMetier.getNom(topos.getUtilisateur().getNom());
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
		
		


			/* reservationMetier.deleteReservation(reservation); */
		
		
	
		
	  
	  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user.get());
	  model.addAttribute("listReservationTopos",listReservationTopos);
	  
	  List<Topos>listTopos=toposMetier.getAllTopos();
		model.addAttribute("listTopos",listTopos);
		
			
			  List<Topos>listToposPossede=toposMetier.getUtilisateurTopos(user.get());
			  model.addAttribute("listToposPossede",listToposPossede);
	  
			  
			  
	
	  return "toposList";
}




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



@PostMapping("/ajouterTopos")
public String AjouterUnTopos(Model model,@Valid Topos topos, BindingResult result) {
	
	List<Utilisateur>listUtilisateur = utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	
		List<Region>listRegion = regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
	
	
	if (result.hasErrors()) {
        return "formulaireTopos";
    }else {
     
 try {
	toposMetier.createTopos(topos);
	 model.addAttribute("topos",topos );
	   
} catch (Exception e) {
	// TODO Auto-generated catch block
	model.addAttribute("exception",e);
}
	return "home";
	}
}





}
