package sig.org.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sig.org.classe.Reservation;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.metier.IReservation;
import sig.org.metier.Itopos;
import sig.org.metier.Iutilisateur;
@Controller
public class ReservationController {
	private static Logger LOG = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	private Iutilisateur utilisateurMetier;
	@Autowired
	private IReservation reservationMetier;
	@Autowired
	private Itopos toposMetier;
	
	@GetMapping("/consulterReservation")
	public String consulterReservation(Model model, Principal principal) {
		 String name = principal.getName();
		 Utilisateur user;

		 try {
		 	user = utilisateurMetier.findByEmail(name);
		 	String nom=user.getNom();
		 	  model.addAttribute("nom",nom);
		 	 
		
		 		 
		 		  
		 		  List<Reservation>listReservationTopos=reservationMetier.listReservationUnUtilisateur(user);
		 		  model.addAttribute("listReservationTopos",listReservationTopos);
		 		  
		 		  
		 		  List<Reservation>listReservationDeUtilisateur=reservationMetier.listReservationUtilisateurTopos(user);
		 		  model.addAttribute("listReservationDeUtilisateur",listReservationDeUtilisateur);
		 		  
		 		  
		 		  
		 } catch (Exception e) {
		 	// TODO Auto-generated catch block
		 	e.printStackTrace();
		 }
		return "reservation";
	}
	
	
	
	
	@GetMapping("/deleteReservation1/{id}")
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
			  
	 		  List<Reservation>listReservationDeUtilisateur=reservationMetier.listReservationUtilisateurTopos(user);
	 		  model.addAttribute("listReservationDeUtilisateur",listReservationDeUtilisateur);  
		
			  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("error",e);
			
		}

		
		  return "reservation";
	}
	
	@GetMapping("/updateToposAndReservation1/{id}")
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
			
				  
				  
		 		  List<Reservation>listReservationDeUtilisateur=reservationMetier.listReservationUtilisateurTopos(user);
		 		  model.addAttribute("listReservationDeUtilisateur",listReservationDeUtilisateur);  
			
				  
						  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		 
		
		  return "reservation";
	}
	
	
	
	
}
