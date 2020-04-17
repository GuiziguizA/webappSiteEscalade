package sig.org.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import sig.org.classe.Roles;
import sig.org.classe.Utilisateur;
import sig.org.dao.RoleRepository;
import sig.org.metier.IRole;
import sig.org.metier.Iutilisateur;
import sig.org.metier.RoleMetier;
@Controller

public class LoginController {
@Autowired
	private Iutilisateur utilisateurMetier;
@Autowired
	private IRole roleMetier;
	
private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

/**
 * afficher le formulaire Utilisateur pour l'incription
 * @param utilisateur
 * @return "formulaireUtilisateur"
 */	

	@GetMapping("/consulterFormulaireUtilisateur")
	  @Secured(value= {"ROLE_admin"})
	public String formulaireSite( Utilisateur utilisateur) {
		
		
		
		
		return "formulaireUtilisateur";
	}


/**
 * inscription d'un utilisateur et affiche la page login pour se connecter
 * @param utilisateur
 * @param result
 * @return  "login"
 */
@PostMapping("/ajouterUtilisateur")
@Secured(value= {"ROLE_admin"})
public String ajoutSite(@Valid Utilisateur utilisateur, BindingResult result,Model model) {
	if (result.hasErrors()) {
		 LOG.info("create user failed");
		return "formulaireUtilisateur";
	
	}else {
		 LOG.info("create user ");
		try {
			Optional<Roles> role=roleMetier.getbyNom("utilisateur");
		utilisateurMetier.createUtilisateur(utilisateur.getNom(),utilisateur.getMail(), utilisateur.getPassword(),role.get());
		return "login";
		
   
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e);
			return "formulaireUtilisateur";
			
		}
		
		
	}
}

/**
 * retourne la liste des utilisateur sur la page utilisateurs
 * @param model
 * @return
 */


@GetMapping("/consulterListeUtilisateur")
public String consulterListUtilisateur( Model model) {
	
	List<Utilisateur>listUtilisateur=utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	
	return "utilisateur";
}



@GetMapping("/modifierStatutUtilisateur/{id}")
public String  modifierStatutUtilisateur (@PathVariable("id")Long id,String mail,Model model) {
	
	try {
		
		utilisateurMetier.ModifierStatut(id);
		
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	List<Utilisateur>listUtilisateur=utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	return "utilisateur";
}


}