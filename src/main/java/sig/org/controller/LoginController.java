package sig.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import sig.org.classe.Utilisateur;
import sig.org.metier.Iutilisateur;
@Controller
public class LoginController {
@Autowired
	private Iutilisateur utilisateurMetier;
	
	
	@GetMapping("/consulterFormulaireUtilisateur")
	public String formulaireSite( Utilisateur utilisateur) {
		
		
		
		
		return "formulaireUtilisateur";
	}



@PostMapping("/ajouterUtilisateur")
public String ajoutSite(@Valid Utilisateur utilisateur, BindingResult result) {
	if (result.hasErrors()) {
		return "formulaireUtilisateur";
	}else {
 
		try {
		utilisateurMetier.createUtilisateur(utilisateur.getNom(),utilisateur.getMail(), utilisateur.getPassword());
	
   
		} catch (Exception e) {
			e.printStackTrace();
			 
		}
		return "login";
		
		
	}
}




@GetMapping("/consulterListUtilisateur")
public String consulterListUtilisateur( Model model) {
	
	List<Utilisateur>listUtilisateur=utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	
	return "utilisateur";
}






}